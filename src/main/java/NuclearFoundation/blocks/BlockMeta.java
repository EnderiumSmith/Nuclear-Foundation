package NuclearFoundation.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public abstract class BlockMeta extends Block{

	public BlockMeta(Material materialIn) {
		super(materialIn);
	}
	public abstract String getUnlocalizedNameWithMeta(ItemStack stack);

}
