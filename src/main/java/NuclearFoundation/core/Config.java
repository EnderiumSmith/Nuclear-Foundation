package NuclearFoundation.core;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	private static final String CATEGORY_GENERAL="general";
	
	//values
	public static boolean IsToolsEnabled=true;
	public static boolean IsArmorEnebled=true;
	public static float GrindStoneTime=1F;
	public static float GrindstoneChance=0.2F;
	
	public static void readCfg(){
		Configuration cfg=CommonProxy.config;
		try{
			cfg.load();
			initGeneralConfig(cfg);
		} catch(Exception e){
			System.out.println("Nuclear Foundation had an exception loading the config");
		} finally{
			if(cfg.hasChanged()){
				cfg.save();
			}
		}
	}
	private static void initGeneralConfig(Configuration cfg){
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
		IsToolsEnabled=cfg.getBoolean("isToolsEnabled", CATEGORY_GENERAL, true, "Set to false to disable tools added by the mod");
		IsArmorEnebled=cfg.getBoolean("isArmorEnabled", CATEGORY_GENERAL, true, "Set to false to disable armor added by the mod");
		GrindStoneTime=cfg.getFloat("grindStoneTime", CATEGORY_GENERAL, 1F, 0.1F, 100F, "How much time does it take for the grindstone to process an item. Crank durability scales too");
		GrindstoneChance=cfg.getFloat("grindStoneChance", CATEGORY_GENERAL, 0.2F, 0F, 1F, "Chance that the grindstone will double an ore");
	}
}
