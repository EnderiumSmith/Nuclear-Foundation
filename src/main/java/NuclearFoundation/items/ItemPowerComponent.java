package NuclearFoundation.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPowerComponent extends Item{
	
	public ItemPowerComponent() {
		super();
		setRegistryName("power_component");
		setUnlocalizedName(getRegistryName().toString());
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		for(int i=0;i<3;i++)
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(getRegistryName()+"_"+i, "inventory"));
	}
	public void register(){
		GameRegistry.register(this);
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch(stack.getMetadata()){
		case(0):{
			return "redstone_components";
		}
		case(1):{
			return "tesla_components";
		}
		case(2):{
			return "rednik_components";
		}
		}
		return super.getUnlocalizedName(stack);
	}
	public boolean canHandlePower(String power,ItemStack stack){
		if(stack.getMetadata()==2){
			return true;
		}
		if(power.equals("RF")&&stack.getMetadata()==0){
			return true;
		}
		if(power.equals("T")&&stack.getMetadata()==1){
			return true;
		}
		return false;
	}
}
