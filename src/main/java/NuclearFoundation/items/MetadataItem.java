package NuclearFoundation.items;

import NuclearFoundation.blocks.BlockMeta;
import NuclearFoundation.core.Constants;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MetadataItem extends ItemBlock{

	public MetadataItem(Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		for(int i=0;i<16;i++)
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(Constants.MODID+":"+((BlockMeta)this.block).getUnlocalizedNameWithMeta(new ItemStack(this.block, 1, i)).toLowerCase(), "inventory"));
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(this.getBlock() instanceof BlockMeta)
			return ((BlockMeta)this.block).getUnlocalizedNameWithMeta(stack);
		return this.block.getUnlocalizedName();
	}

}
