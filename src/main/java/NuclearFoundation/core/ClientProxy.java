package NuclearFoundation.core;

import NuclearFoundation.items.ItemRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e){
		super.preInit(e);
		ItemRegistry.initItemModels();
	}
	public void init(FMLInitializationEvent e){
		super.init(e);
	}
	public void postInit(FMLPostInitializationEvent e){
		super.postInit(e);
	}
	
}
