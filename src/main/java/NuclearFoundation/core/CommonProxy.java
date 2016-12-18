package NuclearFoundation.core;

import java.io.File;

import NuclearFoundation.blocks.BlockRegistry;
import NuclearFoundation.blocks.ModBlocks;
import NuclearFoundation.crafting.ItemCrafting;
import NuclearFoundation.crafting.ToolCrafting;
import NuclearFoundation.items.ItemManager;
import NuclearFoundation.items.ItemRegistry;
import NuclearFoundation.tile_entity.TileGrindstone;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public static Configuration config;
	
	public void preInit(FMLPreInitializationEvent e){
		File file=e.getModConfigurationDirectory();
		config=new Configuration(new File(file.getPath(),"nuclear_foundation.cfg"));
		Config.readCfg();
		ItemRegistry.initItems();
		ItemRegistry.registerItems();
		ItemRegistry.initOreDict();
		BlockRegistry.registerBlocks();
		PotionRegistry.init();
		//ModBlocks.init();
		GameRegistry.registerTileEntity(TileGrindstone.class, Constants.MODID+":TileGrindstone");
	}
	public void init(FMLInitializationEvent e){
		ToolCrafting.init();
		ItemCrafting.init();
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	public void postInit(FMLPostInitializationEvent e){
		if(config.hasChanged()){
			config.save();
		}
	}
	
}
