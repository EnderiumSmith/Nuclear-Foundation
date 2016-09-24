package NuclearFoundation.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRegistry {
	
	public static ItemBasicShears gold;
	public static void initItems(){
		//real metals{
			//5-B
			ItemManager.addMaterial("Boron", ToolMaterial.DIAMOND, ArmorMaterial.DIAMOND);
			//6-Carbon TODO
			//13-Al
			ItemManager.addMaterial("Aluminium", null, null);
			//22-Ti
			ItemManager.addMaterial("Titanium", null, null);
			//24-Cr
			ItemManager.addMaterial("Cromium", null, null);
			//26-Fe
			ItemManager.addMaterial("Iron", null, null);
			//27-Co
			ItemManager.addMaterial("Cobalt", null, null);
			//28-Ni
			ItemManager.addMaterial("Nickel", null, null);
			//29-Cu
			ItemManager.addMaterial("Copper", null, null);
			//30-Zi
			ItemManager.addMaterial("Zinc", null, null);
			//40-Zr
			ItemManager.addMaterial("Zirconium", null, null);
			//47-Ag
			ItemManager.addMaterial("Silver", null, null);
			//50-Sn
			ItemManager.addMaterial("Tin", null, null);
			//74-W
			ItemManager.addMaterial("Wolfram", null, null);
			//76-Os
			ItemManager.addMaterial("Osmium", null, null);
			//77-Ir
			//78-Pl
			ItemManager.addMaterial("Platinum", null, null);
			//79-Au
			ItemManager.addMaterial("Gold", null, null);
			gold=new ItemBasicShears(ToolMaterial.GOLD, "Gold");
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
			ItemManager.addMaterial("Mithril", null, null);
			ItemManager.addMaterial("Adamantine", null, null);
			ItemManager.addMaterial("Prometheum", null, null);
			ItemManager.addMaterial("Vibranium", null, null);
			ItemManager.addMaterial("Blazonium", null, null);
			ItemManager.addMaterial("Terminium", null, null);
			ItemManager.addMaterial("Unobtainium", null, null);
		//}
		//alloys{
			//Al
			ItemManager.addMaterial("Duraluminium", null, null);
			ItemManager.addMaterial("Alumite", null, null);
			//Cr
			ItemManager.addMaterial("Nichrome", null, null);
			//Fe
			ItemManager.addMaterial("PigIron", null, null);
			ItemManager.addMaterial("Steel", null, null);
			ItemManager.addMaterial("StainlessSteel", null, null);
			ItemManager.addMaterial("DamascusSteel", null, null);
			ItemManager.addMaterial("BlackSteel", null, null);
			ItemManager.addMaterial("TearSteel", null, null);
			ItemManager.addMaterial("BlueSteel", null, null);
			ItemManager.addMaterial("RedSteel", null, null);
			//Co
			ItemManager.addMaterial("Stellite", null, null);
			//Ni
			ItemManager.addMaterial("Hastelloy", null, null);
			ItemManager.addMaterial("Cupronickel", null, null);
			ItemManager.addMaterial("Alnico", null, null);
			ItemManager.addMaterial("Invar", null, null);
			//Cu
			ItemManager.addMaterial("Brass", null, null);
			ItemManager.addMaterial("AluminiumBrass", null, null);
			ItemManager.addMaterial("BismuthBrass", null, null);
			ItemManager.addMaterial("Bronze", null, null);
			ItemManager.addMaterial("BlackBronze", null, null);
			ItemManager.addMaterial("MithrilBronze", null, null);
			ItemManager.addMaterial("Signalum", null, null);
			//Ag
			ItemManager.addMaterial("Electrum", null, null);
			ItemManager.addMaterial("SterlingSilver", null, null);
			ItemManager.addMaterial("Lumium", null, null);
			ItemManager.addMaterial("Enderium", null, null);
			ItemManager.addMaterial("BlueAlloy", null, null);
			//W
			ItemManager.addMaterial("TungstenSteel", null, null);
			//Au
			ItemManager.addMaterial("RoseGold", null, null);
			
		//}
	}
	public static void registerItems(){
		GameRegistry.register(gold);
		ItemManager.registerItems();
	}
	@SideOnly(Side.CLIENT)
	public static void initItemModels(){
		gold.initModel();
		ItemManager.initModel();
	}
	public static void initOreDict(){
		ItemManager.registerOreDict();
	}
}
