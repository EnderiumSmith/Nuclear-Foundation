package NuclearFoundation.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CustomCreativeTabs {
	
	public static final CreativeTabs TabMaterials=new CreativeTabs("Materials") {
		
		@Override
		public Item getTabIconItem() {
			return Items.IRON_INGOT;
		}
	};
	public static final CreativeTabs TabTools=new CreativeTabs("Tools") {
		
		@Override
		public Item getTabIconItem() {
			return Items.IRON_PICKAXE;
		}
	};
	public static final CreativeTabs TabArmor=new CreativeTabs("Armor") {
		
		@Override
		public Item getTabIconItem() {
			return Items.IRON_CHESTPLATE;
		}
	};
}
