package NuclearFoundation.GUI;

import NuclearFoundation.tile_entity.magma_crucible.TileCrucibleController;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCrucible extends Container{

	public TileCrucibleController tile;
	@CapabilityInject(IItemHandler.class)
	public static Capability<IItemHandler> ITEM=null;
	public ContainerCrucible(IInventory player,TileCrucibleController tile) {
		this.tile=tile;
		this.addSlotToContainer(new SlotItemHandler(tile.getCapability(ITEM, null), 0, 80, 26));
		if(tile.energyType==0){
			this.addSlotToContainer(new SlotItemHandler(tile.fuel, 0, 62, 44));
			this.addSlotToContainer(new SlotItemHandler(tile.fuel, 1, 98, 44));
		}
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
