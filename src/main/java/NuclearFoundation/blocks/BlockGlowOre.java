package NuclearFoundation.blocks;

import NuclearFoundation.core.Constants;
import NuclearFoundation.items.CustomCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;

import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class BlockGlowOre extends Block{

	public final String Type;
	public BlockGlowOre(String name) {
		super(Material.ROCK);
		Type=name;
		setRegistryName("ore"+Type);
		setUnlocalizedName(getRegistryName().toString());
		setHardness(3);
		setResistance(5);
		setCreativeTab(CustomCreativeTabs.TabBlocks);
		setHarvestLevel("pickaxe", 2);
	}
	public void register(){
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}
	public void initModel(){
	    final ModelResourceLocation mrl = new ModelResourceLocation(Constants.MODID+":GlowOre_" + Type);
        StateMapperBase ignoreState = new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState iBlockState) {
                return mrl;
            }
        };
        ModelLoader.setCustomStateMapper(this, ignoreState);
	}
	public void initOreDict(){

		if(Type.equals("Pitchblende")){
			OreDictionary.registerOre("orePitchblende", this);
			OreDictionary.registerOre("oreUranium", this);
		} else if(Type.equals("Thorite")){
			OreDictionary.registerOre("oreThorite", this);
			OreDictionary.registerOre("oreThorium", this);
		} else if(Type.equals("Blazonium")){
			OreDictionary.registerOre("oreBlazonium", this);
		} else if(Type.equals("Terminium")){
			OreDictionary.registerOre("oreTerminium", this);
			OreDictionary.registerOre("oreEinsteinium", this);
		}

	}

	@Override
	public BlockRenderLayer getBlockLayer() {
	    // needed so that the model can render fully transparent pixels
	    return BlockRenderLayer.CUTOUT;
	}
}
