package NuclearFoundation.GUI;

import NuclearFoundation.tile_entity.TileMetalworker;
import NuclearFoundation.tile_entity.TileStirlingGenerator;
import NuclearFoundation.tile_entity.magma_crucible.TileCrucibleController;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
	public final static int METALWORKER_GUI=0;
	public final static int STIRLING_GUI=1;
	public final static int CRUCIBLE_GUI=2;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case(METALWORKER_GUI):{
			return new ContainerMetalworker(player.inventory, (TileMetalworker)world.getTileEntity(new BlockPos(x, y, z)));
		}
		case(STIRLING_GUI):{
			return new ContainerStirling(player.inventory, (TileStirlingGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		}
		case(CRUCIBLE_GUI):{
			return new ContainerCrucible(player.inventory, (TileCrucibleController)world.getTileEntity(new BlockPos(x, y, z)));
		}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case(METALWORKER_GUI):{
			return new GuiMetalworker(new ContainerMetalworker(player.inventory, (TileMetalworker)world.getTileEntity(new BlockPos(x, y, z))));
		}
		case(STIRLING_GUI):{
			return new GuiStirling(new ContainerStirling(player.inventory, (TileStirlingGenerator)world.getTileEntity(new BlockPos(x,y,z))));
		}
		case(CRUCIBLE_GUI):{
			return new GuiCrucible(new ContainerCrucible(player.inventory, (TileCrucibleController)world.getTileEntity(new BlockPos(x, y, z))));
		}
		}
		return null;
	}
}
