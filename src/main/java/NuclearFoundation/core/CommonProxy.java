package NuclearFoundation.core;

import NuclearFoundation.crafting.ToolCrafting;
import NuclearFoundation.items.ItemManager;
import NuclearFoundation.items.ItemRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e){
		ItemRegistry.initItems();
		ItemRegistry.registerItems();
		ItemRegistry.initOreDict();
	}
	public void init(FMLInitializationEvent e){
		ToolCrafting.init();
	}
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
}
