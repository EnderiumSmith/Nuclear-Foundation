package NuclearFoundation.capabilities;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class ItemHandlerIn extends ItemStackHandler{
	
	public ItemHandlerIn(int size) {
		super(size);
	}
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		return null;
	}
}
