package NuclearFoundation.core;

import NuclearFoundation.items.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelRegistry implements IFuelHandler{

	public FuelRegistry() {
	}
	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.isItemEqual(new ItemStack(ItemRegistry.Pyrotheum))){
			return 2400;
		}
		return 0;
	}

	

}
