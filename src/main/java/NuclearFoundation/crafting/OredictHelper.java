package NuclearFoundation.crafting;

public class OredictHelper {
	
	public static String[] getOredictForIngot(String name){
		switch(name){
		case("Aluminium"):{
			return new String[]{"Aluminium","Aluminum"};
		}
		case("Wolfram"):{
			return new String[]{"Wolfram","Tungsten"};
		}
		case("Duraluminium"):{
			return new String[]{"Duraluminium","Duraluminum"};
		}
		case("Brass"):{
			return new String[]{"Brass","AnyBrass"};
		}
		case("AluminiumBrass"):{
			return new String[]{"AluminiumBrass","AluminumBrass","AnyBrass"};
		}
		case("BismuthBrass"):{
			return new String[]{"BismuthBrass","BismuthBronze","AnyBrass","AnyBronze"};
		}
		case("Bronze"):{
			return new String[]{"Bronze","AnyBronze"};
		}
		case("BlackBronze"):{
			return new String[]{"BlackBronze","AnyBronze","Hepatizon"};
		}
		case("MithrilBronze"):{
			return new String[]{"MithrilBronze","AnyBronze","ArsenicalBronze"};
		}
		default:{
			return new String[]{name};
		}
		}
	}
	public static String[] getOredictForOre(String name){
		switch(name){
		case("Bauxite"):{
			return new String[]{"Bauxite","Alumina"};
		}
		case("Ilmenite"):{
			return new String[]{"Ilmenite","Titanium"};
		}
		case("Chromite"):{
			return new String[]{"Chromite","Chromium"};
		}
		case("Hematite"):{
			return new String[]{"Hematite","Iron"};
		}
		case("Magnetite"):{
			return new String[]{"Magnetite","Iron"};
		}
		case("Limonite"):{
			return new String[]{"Limonite","Iron"};
		}
		case("Pyrite"):{
			return new String[]{"Pyrite","Iron","FoolsGold"};
		}
		case("Cobaltite"):{
			return new String[]{"Cobaltite","Cobalt"};
		}
		case("Garnierite"):{
			return new String[]{"Garnierite","Nickel"};
		}
		case("Malachite"):{
			return new String[]{"Malachite","Copper"};
		}
		case("Sphalerite"):{
			return new String[]{"Sphalerite","Zinc"};
		}
		case("Arsenopyrite"):{
			return new String[]{"Arsenopyrite","Arsenic"};
		}
		case("Zircon"):{
			return new String[]{"Zircon","Zirconium"};
		}
		case("Cassiterite"):{
			return new String[]{"Cassiterite","Tin"};
		}
		case("Wolframite"):{
			return new String[]{"Wolframite","Wolfram","Tungsten"};
		}
		case("Cinnabar"):{
			return new String[]{"Cinnabar","Mercury"};
		}
		case("Galena"):{
			return new String[]{"Galena","Lead"};
		}
		case("Bismuthinite"):{
			return new String[]{"Bismuthinite","Bismuth"};
		}
		case("Lignite"):{
			return new String[]{"Lignite","Coal"};
		}
		case("BituminousCoal"):{
			return new String[]{"Bituminouscoal","Coal"};
		}
		case("Anthracite"):{
			return new String[]{"Anthracite","Coal"};
		}
		case("LapisLazuli"):{
			return new String[]{"Lapis"};
		}
		case("Kimberlite"):{
			return new String[]{"Kimberlite","Diamond"};
		}
		case("TigerEye"):{
			return new String[]{"Tigereye"};
		}
		case("NetherPyrite"):{
			return new String[]{"NetherPyrite","NetherIron"};
		}
		case("NetherArsenopyrite"):{
			return new String[]{"NetherArsenopyrite","NetherArsenic"};
		}
		case("NetherCinnabar"):{
			return new String[]{"NetherCinnabar","NetherMercury"};
		}
		case("EndTerminium"):{
			return new String[]{"EndTerminium","Terminium","Einsteinium"};
		}
		default:{
			return new String[]{name};
		}
		}
	}
	
}
