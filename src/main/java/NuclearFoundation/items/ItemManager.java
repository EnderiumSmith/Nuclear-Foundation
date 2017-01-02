package NuclearFoundation.items;

import java.util.ArrayList;

import NuclearFoundation.core.Config;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemManager {
	
	public static final ItemComplexComponent Ingot=new ItemComplexComponent("ingot");
	public static final ItemComplexComponent Dust=new ItemComplexComponent("dust");
	public static final ItemComplexComponent Nugget=new ItemComplexComponent("nugget");
	public static final ItemComplexComponent Gear=new ItemComplexComponent("gear");
	public static final ItemComplexComponent Plate=new ItemComplexComponent("plate");
	public static final ItemComplexComponent Rod=new ItemComplexComponent("rod");
	public static final ArrayList<SetTools> Tools=new ArrayList<SetTools>();
	public static final ArrayList<SetArmor> Armor=new ArrayList<SetArmor>();
	public static final ArrayList<String> Types=new ArrayList<String>();
	
	public static void addMaterial(String type,ToolMaterial toolMat,ArmorMaterial armorMat){
		Ingot.Metal.add(type);
		Dust.Metal.add(type);
		Nugget.Metal.add(type);
		Gear.Metal.add(type);
		Plate.Metal.add(type);
		Rod.Metal.add(type);
		if(toolMat!=null&&Config.IsToolsEnabled){
			Tools.add(new SetTools(type, toolMat));
		}
		if(armorMat!=null&&Config.IsArmorEnebled){
			Armor.add(new SetArmor(type, armorMat));
		}
		Types.add(type);
	}
	public static void addMaterial(String type,ToolMaterial toolMat,ArmorMaterial armorMat,boolean shears){
		Ingot.Metal.add(type);
		Dust.Metal.add(type);
		Nugget.Metal.add(type);
		Gear.Metal.add(type);
		Plate.Metal.add(type);
		Rod.Metal.add(type);
		if(toolMat!=null&&Config.IsToolsEnabled){
			Tools.add(new SetTools(type, toolMat,true));
		}
		if(armorMat!=null&&Config.IsArmorEnebled){
			Armor.add(new SetArmor(type, armorMat));
		}
		Types.add(type);
	}
	public static void addSecondary(String type,ToolMaterial toolMat,ArmorMaterial armorMat,boolean shears){
		if(toolMat!=null&&Config.IsToolsEnabled){
			Tools.add(new SetTools(type, toolMat,shears));
		}
		if(armorMat!=null&&Config.IsArmorEnebled){
			Armor.add(new SetArmor(type, armorMat));
		}
	}
	public static void addIngot(String type){
		Ingot.Metal.add(type);
		Dust.Metal.add(type);
	}
	@SideOnly(Side.CLIENT)
	public static void initModel(){
		Ingot.initModel();
		Dust.initModel();
		Nugget.initModel();
		Gear.initModel();
		Plate.initModel();
		Rod.initModel();
		int i;
		for(i=0;i<Tools.size();i++){
			Tools.get(i).initModel();
		}
		for(i=0;i<Armor.size();i++){
			Armor.get(i).InitModel();
		}
	}
	public static void registerItems(){
		GameRegistry.register(Ingot);
		GameRegistry.register(Dust);
		GameRegistry.register(Nugget);
		GameRegistry.register(Gear);
		GameRegistry.register(Plate);
		GameRegistry.register(Rod);
		int i;
		for(i=0;i<Tools.size();i++){
			Tools.get(i).registerItems();
		}
		for(i=0;i<Armor.size();i++){
			Armor.get(i).registerItems();
		}
	}
	public static void registerOreDict(){
		Ingot.registerOreDict();
		Dust.registerOreDict();
		Nugget.registerOreDict();
		Gear.registerOreDict();
		Plate.registerOreDict();
		Rod.registerOreDict();
	}
}
