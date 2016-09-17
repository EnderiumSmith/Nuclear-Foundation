package NuclearFoundation;

import NuclearFoundation.items.ItemBasicArmor;
import NuclearFoundation.items.ItemBasicAxe;
import NuclearFoundation.items.ItemBasicHoe;
import NuclearFoundation.items.ItemBasicPick;
import NuclearFoundation.items.ItemBasicShears;
import NuclearFoundation.items.ItemBasicShovel;
import NuclearFoundation.items.ItemBasicSword;
import NuclearFoundation.items.ItemComplexComponent;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class Test {
	
	public static ItemBasicPick testpick=new ItemBasicPick(ToolMaterial.IRON, "Test");
	public static ItemBasicShovel testshovel=new ItemBasicShovel(ToolMaterial.IRON, "Test");
	public static ItemBasicAxe testaxe=new ItemBasicAxe(ToolMaterial.IRON, "Test");
	public static ItemBasicSword testsword=new ItemBasicSword(ToolMaterial.IRON, "Test");
	public static ItemBasicHoe testhoe=new ItemBasicHoe(ToolMaterial.IRON, "Test");
	public static ItemBasicShears testshears=new ItemBasicShears(ToolMaterial.GOLD,"Test");
	public static ItemBasicArmor head=new ItemBasicArmor(ArmorMaterial.CHAIN, 0, EntityEquipmentSlot.HEAD, "Test");
	public static ItemBasicArmor chest=new ItemBasicArmor(ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.CHEST, "Test");
	public static ItemBasicArmor legs=new ItemBasicArmor(ArmorMaterial.CHAIN, 2, EntityEquipmentSlot.LEGS, "Test");
	public static ItemBasicArmor feet=new ItemBasicArmor(ArmorMaterial.CHAIN, 3, EntityEquipmentSlot.FEET, "Test");
	public static ItemComplexComponent ingot=new ItemComplexComponent("ingot");
	public static void init(){
		testpick.initModel();
		GameRegistry.register(testpick);
		testshovel.initModel();
		GameRegistry.register(testshovel);
		testaxe.initModel();
		GameRegistry.register(testaxe);
		testsword.initModel();
		GameRegistry.register(testsword);
		testhoe.initModel();
		GameRegistry.register(testhoe);
		testshears.initModel();
		GameRegistry.register(testshears);
		head.initModel();
		GameRegistry.register(head);
		chest.initModel();
		GameRegistry.register(chest);
		legs.initModel();
		GameRegistry.register(legs);
		feet.initModel();
		GameRegistry.register(feet);
		//
		ingot.Metal.add("Iron");
		ingot.Metal.add("Gold");
		ingot.Metal.add("Test");
		for(int i=0;i<ingot.Metal.size();i++)
			OreDictionary.registerOre(ingot.Type+ingot.Metal.get(i), new ItemStack(ingot, 1, i));
		ingot.initModel();
		GameRegistry.register(ingot);
	}
 	
}
