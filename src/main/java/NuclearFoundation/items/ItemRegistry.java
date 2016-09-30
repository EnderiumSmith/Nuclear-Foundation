package NuclearFoundation.items;

import NuclearFoundation.core.ArmorMaterials;
import NuclearFoundation.core.ToolMaterials;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRegistry {
	
	public static void initItems(){
		//real metals{
			//5-B
			ItemManager.addMaterial("Boron", ToolMaterials.Boron, ArmorMaterials.Boron);
			//6-Carbon TODO
			//13-Al
			ItemManager.addMaterial("Aluminium", null, null);
			//22-Ti
			ItemManager.addMaterial("Titanium", ToolMaterials.Titanium, ArmorMaterials.Titanium);
			//24-Cr
			ItemManager.addMaterial("Cromium", null, null);
			//26-Fe
			ItemManager.addMaterial("Iron", ToolMaterials.Iron2, ArmorMaterials.Iron2);
			//27-Co
			ItemManager.addMaterial("Cobalt", null, null);
			//28-Ni
			ItemManager.addMaterial("Nickel", null, null);
			//29-Cu
			ItemManager.addMaterial("Copper", ToolMaterials.Copper, ArmorMaterials.Copper);
			//30-Zi
			ItemManager.addMaterial("Zinc", null, null);
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
			ItemManager.addMaterial("Gold", ToolMaterials.Gold2, ArmorMaterials.Gold2);
			//82-Pb
			ItemManager.addMaterial("Lead", null, null);
			//83-Bi
			ItemManager.addMaterial("Bismuth", null, null);
			//90-Th
			ItemManager.addMaterial("Thorium", null, null);
			//92-U
			ItemManager.addMaterial("Uranium", null, null);
		//}
		//fantasy metals{
			ItemManager.addMaterial("Mithril", ToolMaterials.Mithril, ArmorMaterials.Mithril);
			ItemManager.addMaterial("Adamantine", ToolMaterials.Adamantine, ArmorMaterials.Adamantine);
			ItemManager.addMaterial("Prometheum", ToolMaterials.Prometheum, ArmorMaterials.Prometheum);
			ItemManager.addMaterial("Orichalcum", ToolMaterials.Orichalcum, ArmorMaterials.Orichalcum);
			ItemManager.addMaterial("Blazonium", null, null);
			ItemManager.addMaterial("Terminium", null, null);
			ItemManager.addMaterial("Unobtainium", null, null);
		//}
		//alloys{
			//Al
			ItemManager.addMaterial("Duraluminium", null, null);
			ItemManager.addMaterial("Alumite", ToolMaterials.Alumite, ArmorMaterials.Alumite);
			//Cr
			ItemManager.addMaterial("Nichrome", null, null);
			//Fe
			ItemManager.addMaterial("PigIron", null, null);
			ItemManager.addMaterial("Steel", ToolMaterials.Steel, ArmorMaterials.Steel);
			ItemManager.addMaterial("StainlessSteel", ToolMaterials.StainlessSteel, ArmorMaterials.StainlessSteel);
			ItemManager.addMaterial("DamascusSteel", ToolMaterials.DamascusSteel, ArmorMaterials.DamascusSteel);
			ItemManager.addMaterial("BlackSteel", ToolMaterials.BlackSteel, ArmorMaterials.BlackSteel);
			ItemManager.addMaterial("TearSteel", ToolMaterials.TearSteel, ArmorMaterials.TearSteel);
			ItemManager.addMaterial("BlueSteel", ToolMaterials.BlueSteel, ArmorMaterials.BlueSteel);
			ItemManager.addMaterial("RedSteel", ToolMaterials.RedSteel, ArmorMaterials.RedSteel);
			//Co
			ItemManager.addMaterial("Stellite", ToolMaterials.Stellite, ArmorMaterials.Stellite);
			//Ni
			ItemManager.addMaterial("Hastelloy", null, null);
			ItemManager.addMaterial("Cupronickel", null, null);
			ItemManager.addMaterial("Alnico", null, null);
			ItemManager.addMaterial("Invar", ToolMaterials.Invar, ArmorMaterials.Invar);
			//Cu
			ItemManager.addMaterial("Brass", null, null);
			ItemManager.addMaterial("AluminiumBrass", null, null);
			ItemManager.addMaterial("BismuthBrass", ToolMaterials.BismuthBrass, ArmorMaterials.BismuthBrass);
			ItemManager.addMaterial("Bronze", ToolMaterials.Bronze, ArmorMaterials.Bronze);
			ItemManager.addMaterial("BlackBronze", ToolMaterials.BlackBronze, ArmorMaterials.BlackBronze);
			ItemManager.addMaterial("MithrilBronze", ToolMaterials.MithrilBronze, ArmorMaterials.MithrilBronze);
			ItemManager.addMaterial("Signalum", ToolMaterials.Signalum, ArmorMaterials.Signalum);
			ItemManager.addMaterial("Vibranium", ToolMaterials.Vibranium, ArmorMaterials.Vibranium);
			//Ag
			ItemManager.addMaterial("Electrum", ToolMaterials.Electrum, ArmorMaterials.Electrum);
			ItemManager.addMaterial("SterlingSilver", null, null);
			ItemManager.addMaterial("Lumium", ToolMaterials.Lumium, ArmorMaterials.Lumium);
			ItemManager.addMaterial("Enderium", ToolMaterials.Enderium, ArmorMaterials.Enderium);
			ItemManager.addMaterial("BlueAlloy", null, null);
			//W
			ItemManager.addMaterial("TungstenSteel", ToolMaterials.TungstenSteel, ArmorMaterials.TungstenSteel);
			//Au
			ItemManager.addMaterial("RoseGold", null, null);
			
		//}
	}
	public static void registerItems(){
		ItemManager.registerItems();
	}
	@SideOnly(Side.CLIENT)
	public static void initItemModels(){
		ItemManager.initModel();
	}
	public static void initOreDict(){
		ItemManager.registerOreDict();
	}
}
