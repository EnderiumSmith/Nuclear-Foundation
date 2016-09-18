package NuclearFoundation.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemRegistry {
	
	public static void initItems(){
		ItemManager.addMaterial("Test", ToolMaterial.IRON, ArmorMaterial.CHAIN);
		ItemManager.addMaterial("Iron", null, null);
	}
	public static void registerItems(){
		ItemManager.registerItems();
	}
	@SideOnly(Side.CLIENT)
	public static void initItemModels(){
		ItemManager.initModel();
	}
	public static void initOreDict(){
		int i;
		for(i=0;i<ItemManager.Ingot.Metal.size();i++){
			OreDictionary.registerOre(ItemManager.Ingot.Type+ItemManager.Ingot.Metal.get(i), new ItemStack(ItemManager.Ingot, 1, i));
		}
	}
}
