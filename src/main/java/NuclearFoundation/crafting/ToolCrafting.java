package NuclearFoundation.crafting;

import NuclearFoundation.items.ItemManager;
import NuclearFoundation.items.SetArmor;
import NuclearFoundation.items.SetTools;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ToolCrafting {
	
	public static void PickRecipe(Item result,Object ing1,Object ing2){
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"###",
				" I ",
				" I ",
				'#',ing1,
				'I',ing2}));
	}
	public static void ShovelRecipe(Item result,Object ing1,Object ing2){
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"#",
				"I",
				"I",
				'#',ing1,
				'I',ing2}));
	}
	public static void AxeRecipe(Item result,Object ing1,Object ing2){
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"##",
				"#I",
				" I",
				'#',ing1,
				'I',ing2}));
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"##",
				"I#",
				"I ",
				'#',ing1,
				'I',ing2}));
	}
	public static void SwordRecipe(Item result,Object ing1,Object ing2){
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"#",
				"#",
				"I",
				'#',ing1,
				'I',ing2}));
	}
	public static void HoeRecipe(Item result,Object ing1,Object ing2){
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"##",
				" I",
				" I",
				'#',ing1,
				'I',ing2}));
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"##",
				"I ",
				"I ",
				'#',ing1,
				'I',ing2}));
	}
	public static void ShearsRecipe(Item result,Object ing1){
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				" #",
				"# ",
				'#',ing1,}));
	}
	public static void HelmRecipe(Item result,Object ing1){
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"###",
				"# #",
				'#',ing1,}));
	}
	public static void ChestRecipe(Item result,Object ing1){
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"# #",
				"###",
				"###",
				'#',ing1,}));
	}
	public static void LegsRecipe(Item result,Object ing1){
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"###",
				"# #",
				"# #",
				'#',ing1,}));
	}
	public static void BootsRecipe(Item result,Object ing1){
		GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[]{
				"# #",
				"# #",
				'#',ing1,}));
	}
	public static void ToolRecipe(SetTools tools,String ingot,Object ing2){
		if(tools!=null){
			PickRecipe(tools.Pick, ingot, ing2);
			ShovelRecipe(tools.Shovel, ingot, ing2);
			AxeRecipe(tools.Axe, ingot, ing2);
			SwordRecipe(tools.Sword, ingot, ing2);
			HoeRecipe(tools.Hoe, ingot, ing2);
			ShearsRecipe(tools.Shears, ingot);
		}
	}
	public static void ArmorRecipe(SetArmor armor,String ingot){
		if(armor!=null){
			HelmRecipe(armor.Helm, ingot);
			ChestRecipe(armor.Chest, ingot);
			LegsRecipe(armor.Legs, ingot);
			BootsRecipe(armor.Boots, ingot);
		}
	}
	public static void init(){
		final String[] materials=new String[]{"Boron","Titanium","Iron","Copper","Silver","Platinum","Gold",
				"Mithril","Adamantine","Prometheum","Orichalcum","Alumite",
				"Steel","StainlessSteel","DamascusSteel","BlackSteel","TearSteel","BlueSteel","RedSteel",
				"Stellite","Invar","Signalum","Vibranium","Lumium","Enderium","Electrum","TungstenSteel",
				"BismuthBrass","Bronze","BlackBronze","MithrilBronze"};
		for(int i=0;i<materials.length;i++){
			for(int j=0;j<ItemManager.Tools.size();j++){
				SetTools tools=ItemManager.Tools.get(j);
				if(tools.Type.equals(materials[i])){
					ToolRecipe(tools, "ingot"+materials[i], "stickWood");
					if(materials[i].equals("Prometheum")){
						ToolRecipe(tools, "ingotPrometheum", Items.BONE);
					}
					break;
				}
			}
			for(int j=0;j<ItemManager.Armor.size();j++){
				SetArmor armor=ItemManager.Armor.get(j);
				if(armor.Type.equals(materials[i])){
					ArmorRecipe(armor, "ingot"+materials[i]);
					break;
				}
			}
		}
	}
}
