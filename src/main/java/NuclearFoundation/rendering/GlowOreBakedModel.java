package NuclearFoundation.rendering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Function;

import NuclearFoundation.core.Constants;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.model.IModelState;

public class GlowOreBakedModel implements IBakedModel{

	public static final ModelResourceLocation BAKED_GLOW_ORE=new ModelResourceLocation(Constants.MODID+":GlowOre");
	
	public VertexFormat format;
	public TextureAtlasSprite stone,nether,end,uranium,thorium,blazonium,terminium;
	
	public GlowOreBakedModel(IModelState state, VertexFormat format,
			Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		this.format=format;
		stone=bakedTextureGetter.apply(new ResourceLocation("Minecraft:blocks/stone"));
		nether=bakedTextureGetter.apply(new ResourceLocation("Minecraft:blocks/netherrack"));
		end=bakedTextureGetter.apply(new ResourceLocation("Minecraft:blocks/endstone"));
		uranium=bakedTextureGetter.apply(new ResourceLocation(Constants.MODID,"blocks/uranium_bits"));
		thorium=bakedTextureGetter.apply(new ResourceLocation(Constants.MODID,"blocks/thorium_bits"));
		blazonium=bakedTextureGetter.apply(new ResourceLocation(Constants.MODID,"blocks/blazonium_bits"));
		terminium=bakedTextureGetter.apply(new ResourceLocation(Constants.MODID,"blocks/terminium_bits"));
		
	}
    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {

        if (side != null) {
            return Collections.emptyList();
        }
        List<BakedQuad> quads = new ArrayList<>();
        int[] data=new int[28];
        for(int offset=0;offset<28;offset+=7){
        	int x,y;
        	if(offset<=14){
        		x=1;
        	}
        	else
        		x=0;
        	if(offset>=14&&offset<=21){
        		y=1;
        	}
        	else
        		y=0;
        	//pos
        	data[offset+0]=Float.floatToIntBits(x);
        	data[offset+1]=Float.floatToIntBits(0);
        	data[offset+2]=Float.floatToIntBits(y);
        	//color
        	data[offset+3]=-1;
        	//tex
        	data[offset + 4] = Float.floatToRawIntBits(0);
            data[offset + 5] = Float.floatToRawIntBits(0);
            //light
            data[offset + 6] = 15 << 4 + 2 << 20;
        }
        quads.add(new BakedQuad(data, -1, side, this.stone, true, format));
        return quads;
    }

	@Override
	public boolean isAmbientOcclusion() {
		// TODO Auto-generated method stub
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
		return null;
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
