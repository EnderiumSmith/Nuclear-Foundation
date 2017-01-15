package NuclearFoundation.GUI;

import NuclearFoundation.tile_entity.TileStirlingGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerStirling extends Container{

	public TileStirlingGenerator Tile;
	@CapabilityInject(IItemHandler.class)
	public static Capability<IItemHandler> ITEM_HANDLER_CAPABILITY=null;
	public ContainerStirling(IInventory player,TileStirlingGenerator tile) {
		Tile=tile;
		IItemHandler handler=tile.getCapability(ITEM_HANDLER_CAPABILITY, null);
		this.addSlotToContainer(new SlotItemHandler(handler, 0, 71, 44));
		// Player Inventory, Slot 9-35, Slot IDs 9-35
	    for (int y = 0; y < 3; ++y) {
	        for (int x = 0; x < 9; ++x) {
	            this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
	        }
	    }

	    // Player Inventory, Slot 0-8, Slot IDs 36-44
	    for (int x = 0; x < 9; ++x) {
	        this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
	    }
	}
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
