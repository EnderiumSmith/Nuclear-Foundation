package NuclearFoundation.crafting;

import NuclearFoundation.items.ItemManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ItemCrafting {
	
	public static void ItemRecipe(ItemStack dust,ItemStack ingot,ItemStack nugget,String type){
		GameRegistry.addSmelting(dust, ingot, 0F);
		GameRegistry.addRecipe(new ShapelessOreRecipe(ingot, new Object[]{
				"nugget"+type,"nugget"+type,"nugget"+type,
				"nugget"+type,"nugget"+type,"nugget"+type,
				"nugget"+type,"nugget"+type,"nugget"+type
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(nugget, new Object[]{"ingot"+type}));
	}
	public static void init(){
		for(int i=0;i<ItemManager.Types.size();i++){
			ItemRecipe(
					new ItemStack(ItemManager.Dust, 1, ItemManager.Dust.getMetaForMetal(ItemManager.Types.get(i))),
					new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal(ItemManager.Types.get(i))),
					new ItemStack(ItemManager.Nugget, 9, ItemManager.Nugget.getMetaForMetal(ItemManager.Types.get(i))),
					ItemManager.Types.get(i));
		}
	}
}
