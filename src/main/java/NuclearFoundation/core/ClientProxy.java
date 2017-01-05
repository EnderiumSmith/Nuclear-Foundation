package NuclearFoundation.core;

import NuclearFoundation.blocks.BlockRegistry;
import NuclearFoundation.blocks.MetalBlock;
import NuclearFoundation.items.ItemComplexComponent;
import NuclearFoundation.items.ItemManager;
import NuclearFoundation.items.ItemRegistry;
import NuclearFoundation.rendering.GlowOreBakedModel;
//import NuclearFoundation.rendering.GlowOreModelLoader;

import com.google.common.base.Function;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {
	
	public static Minecraft minecraft=Minecraft.getMinecraft();
	
	public void preInit(FMLPreInitializationEvent e){
		super.preInit(e);
		ItemRegistry.initItemModels();
		BlockRegistry.initModel();
		MinecraftForge.EVENT_BUS.register(this);
	}

	public void init(FMLInitializationEvent e){
		super.init(e);
		minecraft.getItemColors().registerItemColorHandler(new IItemColor() {
			
			@Override
			public int getColorFromItemstack(ItemStack stack, int tintIndex) {
				return MetalColorizer.getColorForMetal(((ItemComplexComponent)stack.getItem()).Metal.get(stack.getItemDamage()));
			}
		}, ItemManager.Ingot,ItemManager.Dust,ItemManager.Nugget,
				ItemManager.Gear,ItemManager.Plate,ItemManager.Rod);
		minecraft.getBlockColors().registerBlockColorHandler(new IBlockColor() {
			
			@Override
			public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
				return MetalColorizer.getColorForMetal(state.getValue(MetalBlock.TYPE).getOreName());
			}
		}, BlockRegistry.MetalBlock0,BlockRegistry.MetalBlock1,BlockRegistry.MetalBlock2,BlockRegistry.MetalBlock3);
		minecraft.getItemColors().registerItemColorHandler(new IItemColor() {
			
			@Override
			public int getColorFromItemstack(ItemStack stack, int tintIndex) {
				if(stack.getItem()==BlockRegistry.MetalBlock0.itemblock){
					return MetalColorizer.getColorForMetal(BlockRegistry.MetalBlock0.getStateFromMeta(stack.getMetadata()).getValue(MetalBlock.TYPE).getOreName());
				}
				if(stack.getItem()==BlockRegistry.MetalBlock1.itemblock){
					return MetalColorizer.getColorForMetal(BlockRegistry.MetalBlock1.getStateFromMeta(stack.getMetadata()).getValue(MetalBlock.TYPE).getOreName());
				}
				if(stack.getItem()==BlockRegistry.MetalBlock2.itemblock){
					return MetalColorizer.getColorForMetal(BlockRegistry.MetalBlock2.getStateFromMeta(stack.getMetadata()).getValue(MetalBlock.TYPE).getOreName());
				}
				if(stack.getItem()==BlockRegistry.MetalBlock3.itemblock){
					return MetalColorizer.getColorForMetal(BlockRegistry.MetalBlock3.getStateFromMeta(stack.getMetadata()).getValue(MetalBlock.TYPE).getOreName());
				}
				return -1;
			}
		}, BlockRegistry.MetalBlock0.itemblock,BlockRegistry.MetalBlock1.itemblock,
				BlockRegistry.MetalBlock2.itemblock,BlockRegistry.MetalBlock3.itemblock);
	}
	public void postInit(FMLPostInitializationEvent e){
		super.postInit(e);
	}


    @SubscribeEvent
    public void onTextureStitchPre(TextureStitchEvent.Pre event) {
        // Register all of our sprites so that we can use them for the model
        event.getMap().registerSprite(new ResourceLocation(Constants.MODID, "blocks/uranium_bits"));
        event.getMap().registerSprite(new ResourceLocation(Constants.MODID, "blocks/thorium_bits"));
        event.getMap().registerSprite(new ResourceLocation(Constants.MODID, "blocks/blazonium_bits"));
        event.getMap().registerSprite(new ResourceLocation(Constants.MODID, "blocks/terminium_bits"));
    }
	

	@SubscribeEvent
    public void onModelBake(ModelBakeEvent event) {
        // bake and register our models here
        Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter = ModelLoader.defaultTextureGetter();

        // get all of the sprites that we will use
        TextureAtlasSprite stone = bakedTextureGetter.apply(new ResourceLocation("Minecraft:blocks/stone"));
        TextureAtlasSprite nether = bakedTextureGetter.apply(new ResourceLocation("Minecraft:blocks/netherrack"));
        TextureAtlasSprite end = bakedTextureGetter.apply(new ResourceLocation("Minecraft:blocks/end_stone"));
        TextureAtlasSprite uranium = bakedTextureGetter.apply(new ResourceLocation(Constants.MODID, "blocks/uranium_bits"));
        TextureAtlasSprite thorium = bakedTextureGetter.apply(new ResourceLocation(Constants.MODID, "blocks/thorium_bits"));
        TextureAtlasSprite blazonium = bakedTextureGetter.apply(new ResourceLocation(Constants.MODID, "blocks/blazonium_bits"));
        TextureAtlasSprite terminium = bakedTextureGetter.apply(new ResourceLocation(Constants.MODID, "blocks/terminium_bits"));

        // Add all of the models
        event.getModelRegistry().putObject(
                                           new ModelResourceLocation(Constants.MODID+":GlowOre_" + BlockRegistry.UraniumOre.Type),
                                           	new GlowOreBakedModel(stone, uranium));
        event.getModelRegistry().putObject(new ModelResourceLocation(Constants.MODID+":GlowOre_" + BlockRegistry.ThoriumOre.Type),
        									new GlowOreBakedModel(stone, thorium));
        event.getModelRegistry().putObject(new ModelResourceLocation(Constants.MODID+":GlowOre_" + BlockRegistry.BlazoniumOre.Type),
        									new GlowOreBakedModel(nether, blazonium));
        event.getModelRegistry().putObject(new ModelResourceLocation(Constants.MODID+":GlowOre_" + BlockRegistry.TerminiumOre.Type),
        									new GlowOreBakedModel(end, terminium));
    }
}
