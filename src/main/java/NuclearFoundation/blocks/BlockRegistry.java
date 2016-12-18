package NuclearFoundation.blocks;

import net.minecraft.block.material.Material;

public class BlockRegistry {
	
	public static BlockBasic AlStructure=new BlockBasic(Material.IRON, "AluminiumStructure", 5, 10F, 1, "pickaxe");
	public static BlockBasic WallOfMexic=new BlockBasic(Material.IRON, "VibraniumWall", 500, 2000F, 4, "pickaxe");
	public static MetalBlock MetalBlock0=new MetalBlock("Block", 0);
	public static MetalBlock MetalBlock1=new MetalBlock("Block", 1);
	public static MetalBlock MetalBlock2=new MetalBlock("Block", 2);
	public static MetalBlock MetalBlock3=new MetalBlock("Block", 3);
	public static BlockGrindstone GrindStone=new BlockGrindstone();
	
	public static void registerBlocks(){
		AlStructure.register();
		WallOfMexic.register();
		MetalBlock0.register();
		MetalBlock1.register();
		MetalBlock2.register();
		MetalBlock3.register();
		GrindStone.register();
	}
	public static void initModel(){
		AlStructure.initModel();
		WallOfMexic.initModel();
		MetalBlock0.initModel();
		MetalBlock1.initModel();
		MetalBlock2.initModel();
		MetalBlock3.initModel();
		GrindStone.initModel();
	}
}
