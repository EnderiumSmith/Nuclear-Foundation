package NuclearFoundation.core;

import java.io.File;

import NuclearFoundation.NuclearFoundation;
import NuclearFoundation.GUI.GuiHandler;
import NuclearFoundation.blocks.BlockRegistry;
import NuclearFoundation.crafting.GrindStoneCrafting;
import NuclearFoundation.crafting.ItemCrafting;
import NuclearFoundation.crafting.ToolCrafting;
import NuclearFoundation.items.ItemRegistry;
import NuclearFoundation.networking.HandlerMetalWorker;
import NuclearFoundation.networking.MessageMetalWorker;
import NuclearFoundation.tile_entity.TileGrindstone;
import NuclearFoundation.tile_entity.TileMetalworker;
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
		PotionRegistry.init();
		//ModBlocks.init();
		GameRegistry.registerTileEntity(TileGrindstone.class, Constants.MODID+":TileGrindstone");
		GameRegistry.registerTileEntity(TileMetalworker.class, Constants.MODID+":TileMetalworker");
	}
	public void init(FMLInitializationEvent e){
		ToolCrafting.init();
		ItemCrafting.init();
		GrindStoneCrafting.INSTANCE.initRecipes();
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	public void postInit(FMLPostInitializationEvent e){
		if(config.hasChanged()){
			config.save();
		}
	}
	
}
