package NuclearFoundation.capabilities;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class ItemStackHandlerAlert extends ItemStackHandler{
	
	public boolean hasChanged;
	public ItemStackHandlerAlert()
    {
        super(1);
        hasChanged=false;
    }

    public ItemStackHandlerAlert(int size)
    {
        super(size);
        hasChanged=false;
    }

    public ItemStackHandlerAlert(ItemStack[] stacks)
    {
        super(stacks);
        hasChanged=false;
    }
    @Override
    protected void onContentsChanged(int slot) {
    	hasChanged=true;
    }
}
