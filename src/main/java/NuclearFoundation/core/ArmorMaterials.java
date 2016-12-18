package NuclearFoundation.core;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterials {
	
	/*
	 																				LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F),
        																			CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F),
        																			IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F),
        																			GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F),
        																			DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	 */
	//public static final ArmorMaterial Boron=EnumHelper.addArmorMaterial(			"Boron", "", 			22, new int[]{2,5,7,2}, 8, 	SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
	public static final ArmorMaterial Titanium=EnumHelper.addArmorMaterial(			"Titanium", "", 		30, new int[]{3,6,8,3}, 8, 	SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
	public static final ArmorMaterial Copper=EnumHelper.addArmorMaterial(			"Copper", "", 			9, 	new int[]{1,4,5,2}, 17, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial Silver=EnumHelper.addArmorMaterial(			"Silver", "", 			8, 	new int[]{1,3,5,2}, 19, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial Platinum=EnumHelper.addArmorMaterial(			"Platinum", "", 		8, 	new int[]{1,3,5,2}, 23, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial Mithril=EnumHelper.addArmorMaterial(			"Mithril", "", 			30, new int[]{3,5,7,3}, 35, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
	public static final ArmorMaterial Adamantine=EnumHelper.addArmorMaterial(		"Adamantine", "", 		256,new int[]{3,7,9,3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8F);
	public static final ArmorMaterial Prometheum=EnumHelper.addArmorMaterial(		"Prometheum", "", 		11, new int[]{2,5,5,2}, 19, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial Terminium=EnumHelper.addArmorMaterial(		"Terminium", "", 		23, new int[]{2,6,7,2}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
	public static final ArmorMaterial Alumite=EnumHelper.addArmorMaterial(			"Alumite", "", 			22, new int[]{2,6,7,2}, 7, 	SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
	public static final ArmorMaterial Steel=EnumHelper.addArmorMaterial(			"Steel", "", 			23, new int[]{2,5,7,2}, 7, 	SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
	public static final ArmorMaterial StainlessSteel=EnumHelper.addArmorMaterial(	"StainlessSteel", "", 	29, new int[]{2,5,7,2}, 5, 	SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.5F);
	public static final ArmorMaterial DamascusSteel=EnumHelper.addArmorMaterial(	"DamascusSteel", "", 	17, new int[]{2,5,6,2}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.5F);
	public static final ArmorMaterial BlackSteel=EnumHelper.addArmorMaterial(		"BlackSteel", "", 		32, new int[]{2,6,8,3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
	public static final ArmorMaterial TearSteel=EnumHelper.addArmorMaterial(		"TearSteel", "", 		23, new int[]{2,5,7,2}, 1, 	SoundEvents.ENTITY_GHAST_AMBIENT, 	  1F);
	public static final ArmorMaterial BlueSteel=EnumHelper.addArmorMaterial(		"BlueSteel", "", 		64, new int[]{3,7,8,4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
	public static final ArmorMaterial RedSteel=EnumHelper.addArmorMaterial(			"RedSteel", "", 		64, new int[]{3,7,8,4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
	public static final ArmorMaterial Invar=EnumHelper.addArmorMaterial(			"Invar", "", 			17, new int[]{2,5,6,2}, 7, 	SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial Electrum=EnumHelper.addArmorMaterial(			"Electrum", "", 		8, 	new int[]{1,3,5,2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial Bronze=EnumHelper.addArmorMaterial(			"Bronze", "", 			13, new int[]{2,5,6,2}, 9, 	SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial BlackBronze=EnumHelper.addArmorMaterial(		"BlackBronze", "", 		15, new int[]{2,5,6,2}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial BismuthBrass=EnumHelper.addArmorMaterial(		"BismuthBrass", "", 	11, new int[]{2,5,7,2}, 9, 	SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial MithrilBronze=EnumHelper.addArmorMaterial(	"MithrilBronze", "", 	16, new int[]{2,5,7,2}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial Orichalcum=EnumHelper.addArmorMaterial(		"Orichalcum", "", 		22, new int[]{3,6,7,3}, 19, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
	public static final ArmorMaterial Vibranium=EnumHelper.addArmorMaterial(		"Vibranium", "", 		48, new int[]{2,6,7,3}, 13, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
	public static final ArmorMaterial Signalum=EnumHelper.addArmorMaterial(			"Signalum", "", 		16, new int[]{2,5,7,2}, 23, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
	public static final ArmorMaterial Teslium=EnumHelper.addArmorMaterial(			"Teslium", "", 			16, new int[]{2,5,7,2}, 23, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
	public static final ArmorMaterial Lumium=EnumHelper.addArmorMaterial(			"Lumium", "", 			11, new int[]{1,3,5,2}, 27, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
	public static final ArmorMaterial Enderium=EnumHelper.addArmorMaterial(			"Enderium", "",			48, new int[]{3,7,8,4}, 23, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
	public static final ArmorMaterial TungstenSteel=EnumHelper.addArmorMaterial(	"TungstenSteel", "", 	40, new int[]{3,7,8,4}, 8, 	SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
	
	
}
