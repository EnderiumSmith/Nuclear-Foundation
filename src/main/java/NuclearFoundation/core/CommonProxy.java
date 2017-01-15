package NuclearFoundation.core;

import java.io.File;

import NuclearFoundation.NuclearFoundation;
import NuclearFoundation.GUI.GuiHandler;
import NuclearFoundation.blocks.BlockRegistry;
import NuclearFoundation.crafting.GrindStoneCrafting;
import NuclearFoundation.crafting.ItemCrafting;
import NuclearFoundation.crafting.MagmaCrafting;
import NuclearFoundation.crafting.ToolCrafting;
import NuclearFoundation.fluids.FluidManager;
import NuclearFoundation.items.ItemRegistry;
import NuclearFoundation.networking.HandlerMetalWorker;
import NuclearFoundation.networking.MessageMetalWorker;
import NuclearFoundation.tile_entity.TileGrindstone;
import NuclearFoundation.tile_entity.TileMetalworker;
import NuclearFoundation.tile_entity.TileStirlingGenerator;
import NuclearFoundation.tile_entity.magma_crucible.TileCrucibleController;
import NuclearFoundation.tile_entity.magma_crucible.TileCrucibleIO;
import NuclearFoundation.world_gen.WorldGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy {
	
	public static Configuration config;
	
	public void preInit(FMLPreInitializationEvent e){
		File file=e.getModConfigurationDirectory();
		config=new Configuration(new File(file.getPath(),"nuclear_foundation.cfg"));
		Config.readCfg();
		NetworkRegistry.INSTANCE.registerGuiHandler(NuclearFoundation.instance, new GuiHandler());
		NuclearFoundation.netInstance.registerMessage(HandlerMetalWorker.class, MessageMetalWorker.class, 0, Side.SERVER);
		ItemRegistry.initItems();
		ItemRegistry.registerItems();
		ItemRegistry.initOreDict();
		BlockRegistry.registerBlocks();
		BlockRegistry.initOredict();
		FluidManager.registerFluids();
		PotionRegistry.init();
		//ModBlocks.init();
		GameRegistry.registerTileEntity(TileGrindstone.class, Constants.MODID+":TileGrindstone");
		GameRegistry.registerTileEntity(TileMetalworker.class, Constants.MODID+":TileMetalworker");
		GameRegistry.registerTileEntity(TileStirlingGenerator.class, Constants.MODID+":TileStirlingGenerator");
		GameRegistry.registerTileEntity(TileCrucibleController.class, Constants.MODID+":TileCrucibleController");
		GameRegistry.registerTileEntity(TileCrucibleIO.class, Constants.MODID+":TileCrucibleIO");
	}
	public void init(FMLInitializationEvent e){
		ToolCrafting.init();
		ItemCrafting.init();
		GrindStoneCrafting.INSTANCE.initRecipes();
		MagmaCrafting.initMagmaRecipes();
		GameRegistry.registerFuelHandler(new FuelRegistry());
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	public void postInit(FMLPostInitializationEvent e){
		if(config.hasChanged()){
			config.save();
		}
	}
	
}
