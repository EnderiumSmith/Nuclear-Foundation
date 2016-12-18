package NuclearFoundation.blocks;

import NuclearFoundation.items.CustomCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockBasic extends Block{

	public BlockBasic(Material materialIn,String name,float hardness,float blast,int level,String toolClass) {
		super(materialIn);
		setRegistryName(name);
		setUnlocalizedName(this.getRegistryName().toString());
		setHardness(hardness);
		setResistance(blast);
		setHarvestLevel(toolClass, level);
		setCreativeTab(CustomCreativeTabs.TabBlocks);
	}
	public void register(){
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}
}
