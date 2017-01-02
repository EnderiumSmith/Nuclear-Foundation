package NuclearFoundation.core;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	private static final String CATEGORY_GENERAL="general";
	
	//values
	public static boolean IsToolsEnabled=true;
	public static boolean IsArmorEnebled=true;
	public static float GrindStoneTime=1F;
	public static float GrindstoneChance=0.2F;
	public static int IngotPerPlate=3;
	public static int PlatePerIngot=2;
	public static int IngotPerGear=2;
	public static int GearPerIngot=1;
	public static int IngotPerRod=2;
	public static int RodPerIngot=4;
	public static int IngotPerNugget=1;
	public static int NuggetPerIngot=9;
	
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
		PlatePerIngot=cfg.getInt("platePerIngot", CATEGORY_GENERAL, 2, 1, 64, "How many plates are produced for the amount of ingots above");
		GearPerIngot=cfg.getInt("gearPerIngot", CATEGORY_GENERAL, 1, 1, 64, "How many gears are produced for the amount of ingots above");
		RodPerIngot=cfg.getInt("rodPerIngot", CATEGORY_GENERAL, 4, 1, 64, "How many rods are produced for the amount of ingots above");
		NuggetPerIngot=cfg.getInt("nuggetPerIngot", CATEGORY_GENERAL, 9, 1, 64, "How many nuggets are produced for the amount of ingots above");
		IngotPerPlate=cfg.getInt("ingotPerPlate", CATEGORY_GENERAL, 3, 1, 64, "How many ingots are required to craft plates");
		IngotPerGear=cfg.getInt("ingotPerGear", CATEGORY_GENERAL, 2, 1, 64, "How many ingots are required to craft gears");
		IngotPerRod=cfg.getInt("ingotPerRod", CATEGORY_GENERAL, 2, 1, 64, "How many ingots are required to craft rods");
		IngotPerNugget=cfg.getInt("ingotPerPlate", CATEGORY_GENERAL, 1, 1, 64, "How many ingots are required to craft nuggets");
		GrindStoneTime=cfg.getFloat("grindStoneTime", CATEGORY_GENERAL, 1F, 0.1F, 100F, "How much time does it take for the grindstone to process an item. Crank durability scales too");
		GrindstoneChance=cfg.getFloat("grindStoneChance", CATEGORY_GENERAL, 0.2F, 0F, 1F, "Chance that the grindstone will double an ore");
		IsToolsEnabled=cfg.getBoolean("isToolsEnabled", CATEGORY_GENERAL, true, "Set to false to disable tools added by the mod");
		IsArmorEnebled=cfg.getBoolean("isArmorEnabled", CATEGORY_GENERAL, true, "Set to false to disable armor added by the mod");
	}
}
