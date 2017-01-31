package NuclearFoundation.core;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	private static final String CATEGORY_GENERAL="general";
	private static final String CATEGOTY_OREGEN="oregen";
	
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
	public static int MaxGreed=4;
	public static boolean TreatUnknownAsOverwold=false;
	//ores
	public static int Bauxite=10;
	public static int Ilmenite=2;
	public static int Chromite=4;
	public static int Pyrite=2;
	public static int Cobaltite=4;
	public static int Copper=12;
	public static int Sphalerite=4;
	public static int Arsenopyrite=1;
	public static int Silver=3;
	public static int Cassiterite=6;
	public static int Wolframite=1;
	public static int Platinum=1;
	public static int Galena=6;
	public static int Cinnabar=3;
	public static int Bismuthinite=2;
	public static int Orichalcum=1;
	public static int Thorite=2;
	public static int Pitchblende=1;
	//nether
	public static int Npyrite=8;
	public static int Narsenopyrite=3;
	public static int Nsilver=8;
	public static int Ngold=8;
	public static int Ncinnabar=8;
	public static int Nprometheum=15;
	public static int Nmithril=8;
	public static int Nsulfur=20;
	public static int Ndiamond=3;
	public static int Nblazonium=2;
	//end
	public static int terminium=6;
	
	
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
		TreatUnknownAsOverwold=cfg.getBoolean("treatUnknownAsOverwold", CATEGORY_GENERAL, false, "Should unknown dimension provide overwold air?");
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
		MaxGreed=cfg.getInt("maxFortuneBoosting", CATEGORY_GENERAL, 4, 0, 100, "The maximum level the fortune enchanment can be for emerald tools to work. the default allows for fortune 5 with Quark");
		cfg.addCustomCategoryComment(CATEGOTY_OREGEN, "Oregen configuration");
		terminium=cfg.getInt("terminium", CATEGOTY_OREGEN, terminium, 1, 100, "Ore density. Increase for more ore");
		Nblazonium=cfg.getInt("blazonium", CATEGOTY_OREGEN, Nblazonium, 1, 100, "Ore density. Increase for more ore");
		Ndiamond=cfg.getInt("nether_diamond", CATEGOTY_OREGEN, Ndiamond, 1, 100, "Ore density. Increase for more ore");
		Nsulfur=cfg.getInt("nether_sulfur", CATEGOTY_OREGEN, Nsulfur, 1, 100, "Ore density. Increase for more ore");
		Nsilver=cfg.getInt("nether_silver", CATEGOTY_OREGEN, Nsilver, 1, 100, "Ore density. Increase for more ore");
		Npyrite=cfg.getInt("nether_pyrite", CATEGOTY_OREGEN, Npyrite, 1, 100, "Ore density. Increase for more ore");
		Nprometheum=cfg.getInt("prometheum", CATEGOTY_OREGEN, Nprometheum, 1, 100, "Ore density. Increase for more ore");
		Nmithril=cfg.getInt("mithril", CATEGOTY_OREGEN, Nmithril, 1, 100, "Ore density. Increase for more ore");
		Ngold=cfg.getInt("nether_gold", CATEGOTY_OREGEN, Ngold, 1, 100, "Ore density. Increase for more ore");
		Ncinnabar=cfg.getInt("nether_cinnabar", CATEGOTY_OREGEN, Ncinnabar, 1, 100, "Ore density. Increase for more ore");
		Narsenopyrite=cfg.getInt("nether_arsenopyrite", CATEGOTY_OREGEN, Narsenopyrite, 1, 100, "Ore density. Increase for more ore");
		Pitchblende=cfg.getInt("pitchblende", CATEGOTY_OREGEN, Pitchblende, 1, 100, "Ore density. Increase for more ore");
		Thorite=cfg.getInt("thorite", CATEGOTY_OREGEN, Thorite, 1, 100, "Ore density. Increase for more ore");
		Orichalcum=cfg.getInt("orichalcum", CATEGOTY_OREGEN, Orichalcum, 1, 100, "Ore density. Increase for more ore");
		Bismuthinite=cfg.getInt("bismuthinite", CATEGOTY_OREGEN, Bismuthinite, 1, 100, "Ore density. Increase for more ore");
		Cinnabar=cfg.getInt("cinnabar", CATEGOTY_OREGEN, Cinnabar, 1, 100, "Ore density. Increase for more ore");
		Galena=cfg.getInt("galena", CATEGOTY_OREGEN, Galena, 1, 100, "Ore density. Increase for more ore");
		Platinum=cfg.getInt("platinum", CATEGOTY_OREGEN, Platinum, 1, 100, "Ore density. Increase for more ore");
		Wolframite=cfg.getInt("wolframite", CATEGOTY_OREGEN, Wolframite, 1, 100, "Ore density. Increase for more ore");
		Cassiterite=cfg.getInt("cassiterite", CATEGOTY_OREGEN, Cassiterite, 1, 100, "Ore density. Increase for more ore");
		Silver=cfg.getInt("silver", CATEGOTY_OREGEN, Silver, 1, 100, "Ore density. Increase for more ore");
		Arsenopyrite=cfg.getInt("arsenopyrite", CATEGOTY_OREGEN, Arsenopyrite, 1, 100, "Ore density. Increase for more ore");
		Sphalerite=cfg.getInt("sphalerite", CATEGOTY_OREGEN, Sphalerite, 1, 100, "Ore density. Increase for more ore");
		Copper=cfg.getInt("copper", CATEGOTY_OREGEN, Copper, 1, 100, "Ore density. Increase for more ore");
		Cobaltite=cfg.getInt("cobaltite", CATEGOTY_OREGEN, Cobaltite, 1, 100, "Ore density. Increase for more ore");
		Pyrite=cfg.getInt("pyrite", CATEGOTY_OREGEN, Pyrite, 1, 100, "Ore density. Increase for more ore");
		Chromite=cfg.getInt("chromite", CATEGOTY_OREGEN, Chromite, 1, 100, "Ore density. Increase for more ore");
		Ilmenite=cfg.getInt("ilmenite", CATEGOTY_OREGEN, Ilmenite, 1, 100, "Ore density. Increase for more ore");
		Bauxite=cfg.getInt("bauxite", CATEGOTY_OREGEN, Bauxite, 1, 100, "Ore density. Increase for more ore");
	}
}
