package NuclearFoundation.items;

import java.util.ArrayList;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemManager {
	
	public static final ItemComplexComponent Ingot=new ItemComplexComponent("ingot");
	public static final ArrayList<SetTools> Tools=new ArrayList<SetTools>();
	public static final ArrayList<SetArmor> Armor=new ArrayList<SetArmor>();
	
	public static void addMaterial(String type,ToolMaterial toolMat,ArmorMaterial armorMat){
		Ingot.Metal.add(type);
		if(toolMat!=null){
			Tools.add(new SetTools(type, toolMat));
		}
		if(armorMat!=null){
			Armor.add(new SetArmor(type, armorMat));
		}
	}
	@SideOnly(Side.CLIENT)
	public static void initModel(){
		Ingot.initModel();
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
		int i;
		for(i=0;i<Tools.size();i++){
			Tools.get(i).registerItems();
		}
		for(i=0;i<Armor.size();i++){
			Armor.get(i).registerItems();
		}
	}
}
