package NuclearFoundation.items;

import NuclearFoundation.core.ArmorMaterials;
import NuclearFoundation.core.Config;
import NuclearFoundation.core.ToolMaterials;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRegistry {
	
	public static void initItems(){
		//real metals{
			//5-B
			ItemManager.addMaterial("Boron", null, null);
			//6-Carbon TODO
			//13-Al
			ItemManager.addMaterial("Aluminium", null, null);
			//22-Ti
			ItemManager.addMaterial("Titanium", ToolMaterials.Titanium, ArmorMaterials.Titanium,true);
			//24-Cr
			ItemManager.addMaterial("Cromium", null, null);
			//26-Fe
			ItemManager.addMaterial("Iron", null, null);
			//27-Co
			ItemManager.addMaterial("Cobalt", null, null);
			//28-Ni
			ItemManager.addMaterial("Nickel", null, null);
			//29-Cu
			ItemManager.addMaterial("Copper", ToolMaterials.Copper, ArmorMaterials.Copper,true);
			//30-Zi
			ItemManager.addMaterial("Zinc", null, null);
			//33-Ar
			ItemManager.addMaterial("Arsenic", null, null);
			//40-Zr
			ItemManager.addMaterial("Zirconium", null, null);
			//47-Ag
			ItemManager.addMaterial("Silver", ToolMaterials.Silver, ArmorMaterials.Silver);
			//50-Sn
			ItemManager.addMaterial("Tin", null, null);
			//74-W
			ItemManager.addMaterial("Wolfram", null, null);
			//76-Os TODO
			ItemManager.addMaterial("Osmium", null, null);
			//77-Ir
			//78-Pl
			ItemManager.addMaterial("Platinum", ToolMaterials.Platinum, ArmorMaterials.Platinum);
			//79-Au
			ItemManager.addMaterial("Gold", null, null);
			//82-Pb
			ItemManager.addMaterial("Lead", null, null);
			//83-Bi
			ItemManager.addMaterial("Bismuth", null, null);
			//90-Th
			ItemManager.addMaterial("Thorium", null, null);
			//92-U
			ItemManager.addMaterial("Uranium", ToolMaterials.Uranium, null);
		//}
		//fantasy metals{
			ItemManager.addMaterial("Mithril", ToolMaterials.Mithril, ArmorMaterials.Mithril,true);
			ItemManager.addMaterial("Adamantine", ToolMaterials.Adamantine, ArmorMaterials.Adamantine,true);
			ItemManager.addMaterial("Prometheum", ToolMaterials.Prometheum, ArmorMaterials.Prometheum);
			ItemManager.addMaterial("Orichalcum", ToolMaterials.Orichalcum, ArmorMaterials.Orichalcum,true);
			ItemManager.addMaterial("Blazonium", ToolMaterials.Blazonium, null);
			ItemManager.addMaterial("Terminium", ToolMaterials.Terminium, ArmorMaterials.Terminium);
			ItemManager.addMaterial("Unobtainium", null, null);
		//}
		//alloys{
			//Al
			ItemManager.addMaterial("Duraluminium", null, null);
			ItemManager.addMaterial("Alumite", ToolMaterials.Alumite, ArmorMaterials.Alumite,true);
			//Cr
			ItemManager.addMaterial("Nichrome", null, null);
			//Fe
			ItemManager.addMaterial("PigIron", null, null);
			ItemManager.addMaterial("Steel", ToolMaterials.Steel, ArmorMaterials.Steel,true);
			ItemManager.addMaterial("StainlessSteel", ToolMaterials.StainlessSteel, ArmorMaterials.StainlessSteel,true);
			ItemManager.addMaterial("DamascusSteel", ToolMaterials.DamascusSteel, ArmorMaterials.DamascusSteel);
			ItemManager.addMaterial("BlackSteel", ToolMaterials.BlackSteel, ArmorMaterials.BlackSteel,true);
			ItemManager.addMaterial("TearSteel", ToolMaterials.TearSteel, ArmorMaterials.TearSteel);
			ItemManager.addMaterial("BlueSteel", ToolMaterials.BlueSteel, ArmorMaterials.BlueSteel,true);
			ItemManager.addMaterial("RedSteel", ToolMaterials.RedSteel, ArmorMaterials.RedSteel,true);
			//Co
			ItemManager.addMaterial("Stellite", ToolMaterials.Stellite, null,true);
			//Ni
			ItemManager.addMaterial("Hastelloy", null, null);
			//ItemManager.addMaterial("Cupronickel", null, null);
			ItemManager.addMaterial("Alnico", null, null);
			ItemManager.addMaterial("Invar", ToolMaterials.Invar, ArmorMaterials.Invar,true);
			//Cu
			ItemManager.addMaterial("Brass", null, null);
			ItemManager.addMaterial("AluminiumBrass", null, null);
			ItemManager.addMaterial("BismuthBrass", ToolMaterials.BismuthBrass, ArmorMaterials.BismuthBrass);
			ItemManager.addMaterial("Bronze", ToolMaterials.Bronze, ArmorMaterials.Bronze);
			ItemManager.addMaterial("BlackBronze", ToolMaterials.BlackBronze, ArmorMaterials.BlackBronze);
			ItemManager.addMaterial("MithrilBronze", ToolMaterials.MithrilBronze, ArmorMaterials.MithrilBronze);
			ItemManager.addMaterial("Signalum", ToolMaterials.Signalum, ArmorMaterials.Signalum,true);
			ItemManager.addMaterial("Vibranium", null, ArmorMaterials.Vibranium);
			//Ag
			ItemManager.addMaterial("Electrum", ToolMaterials.Electrum, ArmorMaterials.Electrum);
			ItemManager.addMaterial("SterlingSilver", null, null);
			ItemManager.addMaterial("Lumium", null, ArmorMaterials.Lumium);
			ItemManager.addMaterial("Enderium", ToolMaterials.Enderium, ArmorMaterials.Enderium,true);
			ItemManager.addMaterial("Teslium", ToolMaterials.Teslium, ArmorMaterials.Teslium);
			//W
			ItemManager.addMaterial("TungstenSteel", ToolMaterials.TungstenSteel, ArmorMaterials.TungstenSteel,true);
			//Au
			ItemManager.addMaterial("RoseGold", null, null);
			
		//}
	}
	
	public static Item Trident=new ItemSpecialWeapon(ToolMaterials.Orichalcum, "Trident", 13F, -3.2F);
	public static Item Elucidator=new ItemSpecialWeapon(ToolMaterials.BlackSteel, "Elucidator", 15F, -3.2F);
	public static Item Claws=new ItemSpecialWeapon(ToolMaterials.Adamantine, "Claws", 10F, -0.8F);
	//Grindstone
	public static Item GrindStone=new ItemGrindstone(63, "grindstone");
	public static Item ObsidianGrindStone=new ItemGrindstone(1023, "obsidiangrindstone");
	public static Item WoodCrank=new ItemCrank((int)(480*Config.GrindStoneTime), "woodencrank");
	public static Item IronCrank=new ItemCrank((int)(3840*Config.GrindStoneTime), "ironcrank");
		
	public static void registerItems(){
		ItemManager.registerItems();
		if(Config.IsToolsEnabled){
			GameRegistry.register(Trident);
			GameRegistry.register(Elucidator);
			GameRegistry.register(Claws);
		}
		GameRegistry.register(GrindStone);
		GameRegistry.register(ObsidianGrindStone);
		GameRegistry.register(WoodCrank);
		GameRegistry.register(IronCrank);
	}
	@SideOnly(Side.CLIENT)
	public static void initItemModels(){
		ItemManager.initModel();
	}
	public static void initOreDict(){
		ItemManager.registerOreDict();
	}
}
