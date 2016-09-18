package NuclearFoundation.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRegistry {
	
	public static ItemBasicShears gold;
	public static void initItems(){
		//real metals{
			//5-Boron TODO add tools-armor
			ItemManager.addMaterial("Boron", null, null);
			//6-Carbon TODO
			//13-Aluminium TODO crafting
			ItemManager.addMaterial("Aluminium", null, null);
			//22-Titanium TODO
			ItemManager.addMaterial("Titanium", null, null);
			//24-Cromium TODO
			ItemManager.addMaterial("Cromium", null, null);
			//26-Iron
			ItemManager.addMaterial("Iron", null, null);
			//27-Cobalt TODO
			ItemManager.addMaterial("Cobalt", null, null);
			//28-Nickel TODO
			ItemManager.addMaterial("Nickel", null, null);
			//29-Copper TODO
			ItemManager.addMaterial("Copper", null, null);
			//30-Zinc
			ItemManager.addMaterial("Zinc", null, null);
			//33-Arsenic TODO
			ItemManager.addMaterial("Arsenic", null, null);
			//40-Zirconium TODO
			ItemManager.addMaterial("Zirconium", null, null);
			//47-Silver TODO
			ItemManager.addMaterial("Silver", null, null);
			//50-Tin
			ItemManager.addMaterial("Tin", null, null);
			//74-Wolfram TODO
			ItemManager.addMaterial("Wolfram", null, null);
			//76-Osmium TODO
			ItemManager.addMaterial("Osmium", null, null);
			//77-Iridium TODO
			//78-Platinum TODO
			ItemManager.addMaterial("Platinum", null, null);
			//79-Gold
			ItemManager.addMaterial("Gold", null, null);
			gold=new ItemBasicShears(ToolMaterial.GOLD, "Gold");
			//82-Lead TODO
			ItemManager.addMaterial("Lead", null, null);
			//83-Bismuth TODO
			ItemManager.addMaterial("Bismuth", null, null);
			//90-Thorium TODO
			ItemManager.addMaterial("Thorium", null, null);
			//92-Uranium TODO
			ItemManager.addMaterial("Uranium", null, null);
		//}
		//fantasy metals{
			
		//}
		//alloys{
			
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
