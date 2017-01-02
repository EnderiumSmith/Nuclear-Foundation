package NuclearFoundation.rendering;

import java.util.Collection;
import java.util.Collections;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;

import NuclearFoundation.core.Constants;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

public class GlowOreModel implements IModel{

	@Override
	public Collection<ResourceLocation> getDependencies() {
		return Collections.emptySet();
	}

	@Override
	public Collection<ResourceLocation> getTextures() {
		return ImmutableSet.of(new ResourceLocation("Minecraft:blocks/stone"),new ResourceLocation("Minecraft:blocks/netherrack"),new ResourceLocation("Minecraft:blocks/endstone"),new ResourceLocation(Constants.MODID,"blocks/uranium_bits"),new ResourceLocation(Constants.MODID,"blocks/thorium_bits"),new ResourceLocation(Constants.MODID,"blocks/blazonium_bits"),new ResourceLocation(Constants.MODID,"blocks/terminium_bits"));
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format,
			Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		return new GlowOreBakedModel(state, format, bakedTextureGetter);
	}

	@Override
	public IModelState getDefaultState() {
		return TRSRTransformation.identity();
	}

}
