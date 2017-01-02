package NuclearFoundation;

import NuclearFoundation.core.CommonProxy;
import NuclearFoundation.core.Constants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid=Constants.MODID, name=Constants.MODNAME, version=Constants.VERSION)
public class NuclearFoundation {
	
	@Mod.Instance
	public static NuclearFoundation instance;
	
	public static SimpleNetworkWrapper netInstance=new SimpleNetworkWrapper(Constants.MODID);
	
	@SidedProxy(clientSide="NuclearFoundation.core.ClientProxy",
			serverSide="NuclearFoundation.core.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		proxy.preInit(e);
	}
	@EventHandler
	public void init(FMLInitializationEvent e){
		proxy.init(e);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		proxy.postInit(e);
	}
}
