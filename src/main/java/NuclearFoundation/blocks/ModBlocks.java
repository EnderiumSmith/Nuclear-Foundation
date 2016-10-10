package NuclearFoundation.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block nether_furnace=new NetherFurnace(false);
	public static Block nether_furnace_lit=new NetherFurnace(true);
	
	public static void init(){
		GameRegistry.register(nether_furnace);
		GameRegistry.register(nether_furnace_lit);
	}
}
