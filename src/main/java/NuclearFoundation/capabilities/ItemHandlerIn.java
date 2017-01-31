package NuclearFoundation.capabilities;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class ItemHandlerIn extends ItemStackHandler{
	
	public boolean hasChanged=false;
	public ItemHandlerIn(int size) {
		super(size);
	}
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		return null;
	}
	@Override
	protected void onContentsChanged(int slot) {
		hasChanged=true;
	}
	
}
