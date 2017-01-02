package NuclearFoundation.rendering;

import java.util.*;

import javax.vecmath.Point3f;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumFacing.AxisDirection;

import NuclearFoundation.core.Constants;

public class GlowOreBakedModel implements IBakedModel{

	public static final ModelResourceLocation BAKED_GLOW_ORE=new ModelResourceLocation(Constants.MODID+":GlowOre");

	private final Map<EnumFacing, List<BakedQuad>> quads = new EnumMap<>(EnumFacing.class);
	private final TextureAtlasSprite particle;

	public GlowOreBakedModel(TextureAtlasSprite base, TextureAtlasSprite glowing) {
		this.particle = base;
		for (EnumFacing side : EnumFacing.VALUES) {
			TextureAtlasSprite[] sprites = { base, glowing };

			/* "magic" uv co-ords. We pick the 4 corners of a sprite (ranging from 0-16 no matter the real size of the sprite)
			 and go around clockwise. It doesn't matter the order provided that it matches the position generator*/
			int[][] uvs = new int[4][2];
			uvs[0][0] = 0;
			uvs[0][1] = 0;

			uvs[1][0] = 0;
			uvs[1][1] = 16;

			uvs[2][0] = 16;
			uvs[2][1] = 16;

			uvs[3][0] = 16;
			uvs[3][1] = 0;

			List<BakedQuad> list = new ArrayList<>(2);
			for (int faceNum = 0; faceNum < 2; faceNum++) {
				float faceOffset = faceNum == 0 ? 0 : 0.001f;
				// some maths to work out all of the positions
				Point3f center = new Point3f(0.5f, 0.5f, 0.5f);
				Point3f radius = new Point3f(
					side.getAxis() == Axis.X ? (faceOffset + 0.5f) : (0.5f),
					side.getAxis() == Axis.Y ? (faceOffset + 0.5f) : (0.5f),
					side.getAxis() == Axis.Z ? (faceOffset + 0.5f) : (0.5f)
				);
				Point3f[] points = ModelUtil.getPointsForFace(side, center, radius);

				boolean flip = side.getAxisDirection() == AxisDirection.POSITIVE;
				if (side.getAxis() == Axis.Z) flip = !flip;
				if (flip) {
					Point3f[] rp = { points[3], points[2], points[1], points[0] };
					points = rp;
				}

				// create our vertex data array
				int[] data = new int[32];// 32 is 4 * ModelUtil.FORMAT_BLOCK_NORMAL.getNextOffset()
				int stride = data.length / 4;
				for (int i = 0; i < 4; i++) {
					int offset = i * stride;
					// pos
					data[offset + 0] = Float.floatToIntBits(points[i].x);
					data[offset + 1] = Float.floatToIntBits(points[i].y);
					data[offset + 2] = Float.floatToIntBits(points[i].z);
					// color
					data[offset + 3] = 0xFF_FF_FF_FF; // full alpha, full all other colours (white)
					// tex
					data[offset + 4] = Float.floatToRawIntBits(sprites[faceNum].getInterpolatedU(uvs[i][0]));
					data[offset + 5] = Float.floatToRawIntBits(sprites[faceNum].getInterpolatedV(uvs[i][1]));
					// light
					data[offset + 6] = (faceNum == 0) ? (0) : (15 << 4) + (0 << 20);
					// normal
					data[offset + 7] = ModelUtil.normalToPackedInt(side.getFrontOffsetX(), side.getFrontOffsetY(), side.getFrontOffsetZ());
				}
				list.add(new BakedQuad(data, -1, side, sprites[faceNum], true, ModelUtil.FORMAT_BLOCK_NORMAL));
			}
			quads.put(side, list);
		}
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		if (side == null) {
			return Collections.emptyList();
		} else {
			return quads.get(side);
		}
	}

	@Override
	public boolean isAmbientOcclusion() {
		return true;
	}

	@Override
	public boolean isGui3d() {
		return false;
	}

	@Override
	public boolean isBuiltInRenderer() {
		return false;
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		// TODO Auto-generated method stub
		return particle;
	}

	@Override
	public ItemCameraTransforms getItemCameraTransforms() {
		return ItemCameraTransforms.DEFAULT;
	}

	@Override
	public ItemOverrideList getOverrides() {
		return null;
	}
}
