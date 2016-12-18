package NuclearFoundation.items;

import NuclearFoundation.blocks.MetalBlock;
import NuclearFoundation.core.Constants;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MetalItemBlock extends ItemBlock{

	public MetalItemBlock(Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName().substring(0, getUnlocalizedName().indexOf(":"))+":"+((MetalBlock)this.block).getOreName(stack.getMetadata())+"Block";
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		for(int i=0;i<16;i++)
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(Constants.MODID+":"+((MetalBlock)this.block).getOreName(i).toLowerCase(), "inventory"));
	}

}
