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
	public static BlockMetalworker MetalWoker=new BlockMetalworker();
	public static BlockOre OreBlock0=new BlockOre("ore", 0);
	public static BlockOre OreBlock1=new BlockOre("ore", 1);
	public static BlockOre OreBlock2=new BlockOre("ore", 2);
	public static BlockNetherOre NetherOreBlock0=new BlockNetherOre("NetherOre", 0);
	public static BlockNetherOre NetherOreBlock1=new BlockNetherOre("NetherOre", 1);
	public static BlockGlowOre UraniumOre=new BlockGlowOre("Pitchblende");
	
	public static void registerBlocks(){
		AlStructure.register();
		WallOfMexic.register();
		MetalBlock0.register();
		MetalBlock1.register();
		MetalBlock2.register();
		MetalBlock3.register();
		GrindStone.register();
		MetalWoker.register();
		OreBlock0.register();
		OreBlock1.register();
		OreBlock2.register();
		NetherOreBlock0.register();
		NetherOreBlock1.register();
		UraniumOre.register();
	}
	public static void initModel(){
		AlStructure.initModel();
		WallOfMexic.initModel();
		//MetalBlock0.initModel();
		//MetalBlock1.initModel();
		//MetalBlock2.initModel();
		//MetalBlock3.initModel();
		//OreBlock0.initModel();
		//OreBlock1.initModel();
		//OreBlock2.initModel();
		//NetherOreBlock0.initModel();
		//NetherOreBlock1.initModel();
		GrindStone.initModel();
		//MetalWoker.initModel();
		UraniumOre.initModel();
	}
	public static void initOredict(){
		MetalBlock0.initOredict();
		MetalBlock1.initOredict();
		MetalBlock2.initOredict();
		MetalBlock3.initOredict();
		OreBlock0.initOredict();
		OreBlock1.initOredict();
		OreBlock2.initOredict();
		NetherOreBlock0.initOredict();
		NetherOreBlock1.initOredict();
	}
}
