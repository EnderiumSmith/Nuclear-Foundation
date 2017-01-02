package NuclearFoundation.GUI;

import NuclearFoundation.tile_entity.TileMetalworker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
	public final static int METALWORKER_GUI=0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID==METALWORKER_GUI){
			return new ContainerMetalworker(player.inventory, (TileMetalworker)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID==METALWORKER_GUI){
			return new GuiMetalworker(new ContainerMetalworker(player.inventory, (TileMetalworker)world.getTileEntity(new BlockPos(x, y, z))));
		}
		return null;
	}
}
