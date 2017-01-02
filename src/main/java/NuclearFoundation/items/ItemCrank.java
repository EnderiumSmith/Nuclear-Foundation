package NuclearFoundation.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCrank extends Item{
	
	public ItemCrank(int maxDamage, String name){
		super();
		setRegistryName(name);
		setUnlocalizedName(getRegistryName().toString());
		setMaxDamage(maxDamage);
		setMaxStackSize(1);
		setCreativeTab(CustomCreativeTabs.TabItems);
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
