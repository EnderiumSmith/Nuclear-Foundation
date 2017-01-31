package NuclearFoundation.blocks;

import NuclearFoundation.blocks.magma_crucible.BlockCrucibleController;
import NuclearFoundation.blocks.magma_crucible.MagmaCrucibleIOBlock;
import NuclearFoundation.blocks.magma_crucible.MagmaCrucibleStructureBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class BlockRegistry {
	
	public static BlockBasic AlStructure=new BlockBasic(Material.IRON, "AluminiumStructure", 5, 10F, 1, "pickaxe");
	public static BlockBasic WallOfMexic=new BlockBasic(Material.IRON, "VibraniumWall", 500, 2000F, 4, "pickaxe");
	public static MetalBlock MetalBlock0=new MetalBlock("Block", 0);
	public static MetalBlock MetalBlock1=new MetalBlock("Block", 1);
	public static MetalBlock MetalBlock2=new MetalBlock("Block", 2);
	public static MetalBlock MetalBlock3=new MetalBlock("Block", 3);
	public static BlockGrindstone GrindStone=new BlockGrindstone();
	public static BlockMetalworker MetalWoker=new BlockMetalworker();
	public static BlockSirlingGenerator Stirling=new BlockSirlingGenerator();
	public static BlockCryogenicCompressor Cryo=new BlockCryogenicCompressor();
	public static BlockOre OreBlock0=new BlockOre("ore", 0);
	public static BlockOre OreBlock1=new BlockOre("ore", 1);
	public static BlockOre OreBlock2=new BlockOre("ore", 2);
	public static BlockNetherOre NetherOreBlock0=new BlockNetherOre("NetherOre", 0);
	public static BlockNetherOre NetherOreBlock1=new BlockNetherOre("NetherOre", 1);
	public static BlockGlowOre UraniumOre=new BlockGlowOre("Pitchblende");
	public static BlockGlowOre ThoriumOre=new BlockGlowOre("Thorite");
	public static BlockGlowOre BlazoniumOre=new BlockGlowOre("Blazonium");
	public static BlockGlowOre TerminiumOre=new BlockGlowOre("Terminium");
	public static BlockDryIce DryIce=new BlockDryIce();
	//magma crucible
	public static BlockCrucibleController CrucibleController=new BlockCrucibleController();
	public static MagmaCrucibleStructureBlock CrucibleBase=new MagmaCrucibleStructureBlock("crucible_base", 0);
	public static MagmaCrucibleStructureBlock CrucibleRF=new MagmaCrucibleStructureBlock("crucible_rf", 1);
	public static MagmaCrucibleStructureBlock CrucibleT=new MagmaCrucibleStructureBlock("crucible_t", 2);
	public static MagmaCrucibleStructureBlock CrucibleRedNik=new MagmaCrucibleStructureBlock("crucible_rednik", 3);
	public static MagmaCrucibleIOBlock CrucibleIOBase=new MagmaCrucibleIOBlock("crucible_io_base", 0);
	public static MagmaCrucibleIOBlock CrucibleIORF=new MagmaCrucibleIOBlock("crucible_io_rf", 1);
	public static MagmaCrucibleIOBlock CrucibleIOT=new MagmaCrucibleIOBlock("crucible_io_t", 2);
	public static MagmaCrucibleIOBlock CrucibleIORedNik=new MagmaCrucibleIOBlock("crucible_io_rednik", 3);
	//vent
	public static BlockAtmosphericVent Vent=new BlockAtmosphericVent(0);
	public static BlockAtmosphericVent Vent_RF=new BlockAtmosphericVent(1);
	public static BlockAtmosphericVent Vent_T=new BlockAtmosphericVent(2);
	public static BlockAtmosphericVent Vent_RF_T=new BlockAtmosphericVent(3);
	
	public static void registerBlocks(){
		AlStructure.register();
		WallOfMexic.register();
		GrindStone.register();
		MetalWoker.register();
		Stirling.register();
		Cryo.register();
		Vent.register();
		Vent_RF.register();
		Vent_T.register();
		Vent_RF_T.register();
		//
		CrucibleController.register();
		CrucibleBase.register();
		CrucibleIOBase.register();
		CrucibleRF.register();
		CrucibleIORF.register();
		CrucibleT.register();
		CrucibleIOT.register();
		CrucibleRedNik.register();
		CrucibleIORedNik.register();
		//
		MetalBlock0.register();
		MetalBlock1.register();
		MetalBlock2.register();
		MetalBlock3.register();
		OreBlock0.register();
		OreBlock1.register();
		OreBlock2.register();
		NetherOreBlock0.register();
		NetherOreBlock1.register();
		UraniumOre.register();
		ThoriumOre.register();
		BlazoniumOre.register();
		TerminiumOre.register();
		DryIce.register();
	}
	public static void initModel(){
		AlStructure.initModel();
		WallOfMexic.initModel();
		GrindStone.initModel();
		MetalWoker.initModel();
		MetalBlock0.initModel();
		MetalBlock1.initModel();
		MetalBlock2.initModel();
		MetalBlock3.initModel();
		//OreBlock0.initModel();
		//OreBlock1.initModel();
		//OreBlock2.initModel();
		//NetherOreBlock0.initModel();
		//NetherOreBlock1.initModel();
		UraniumOre.initModel();
		ThoriumOre.initModel();
		BlazoniumOre.initModel();
		TerminiumOre.initModel();
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
		OreDictionary.registerOre("dryice", DryIce);
	}
}
