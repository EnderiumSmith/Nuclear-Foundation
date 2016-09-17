package NuclearFoundation.items;

import java.util.ArrayList;
import java.util.List;

import NuclearFoundation.core.Constants;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemComplexComponent extends Item{
	
	public final String Type;
	public ArrayList<String> Metal;
	public ItemComplexComponent(String type) {
		super();
		this.setHasSubtypes(true);
		this.Type=type;
		this.Metal=new ArrayList<String>();
		this.setRegistryName(this.Type);
		this.setUnlocalizedName(this.getRegistryName().toString());
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(this.Metal.isEmpty()||stack.getItemDamage()>=this.Metal.size()||stack.getItemDamage()<0)
			return this.getUnlocalizedName();
		return "item."+Constants.MODID+":"+this.Metal.get(stack.getItemDamage())+this.Type;
	}
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		for(int i=0;i<this.Metal.size();i++){
			subItems.add(new ItemStack(this, 1, i));
		}
	}
	public String getMetalFromMeta(int meta){
		if(meta<0||meta>=this.Metal.size())
			return null;
		return this.Metal.get(meta);
	}
	public int getMetaForMetal(String metal){
		for(int i=0;i<this.Metal.size();i++)
			if(this.Metal.get(i).equals(metal))
				return i;
		return -1;
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		for(int i=0;i<this.Metal.size();i++){
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(Constants.MODID+":material/"+this.Metal.get(i)+"/"+this.Type));
		}
	}
}
