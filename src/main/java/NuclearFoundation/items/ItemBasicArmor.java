package NuclearFoundation.items;

import NuclearFoundation.core.Constants;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasicArmor extends ItemArmor{

	public final String Type;
	public ItemBasicArmor(ArmorMaterial materialIn, int renderIndexIn,
			EntityEquipmentSlot Slot,String type) {
		super(materialIn, renderIndexIn, Slot);
		this.Type=type;
		if (Slot == EntityEquipmentSlot.HEAD){
			this.setRegistryName("helm"+this.Type);
			this.setUnlocalizedName(this.getRegistryName().toString());
		}
		if (Slot == EntityEquipmentSlot.CHEST){
			this.setRegistryName("chest"+this.Type);
			this.setUnlocalizedName(this.getRegistryName().toString());
		}
		if (Slot == EntityEquipmentSlot.LEGS){
			this.setRegistryName("legs"+this.Type);
			this.setUnlocalizedName(this.getRegistryName().toString());
		}
		if (Slot == EntityEquipmentSlot.FEET){
			this.setRegistryName("boots"+this.Type);
			this.setUnlocalizedName(this.getRegistryName().toString());
		}
		this.setCreativeTab(CustomCreativeTabs.TabArmor);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type){
		if(this.armorType==EntityEquipmentSlot.LEGS)
			return Constants.MODID+":textures/items/material/"+this.Type+"/tool/armor"+this.Type+"_layer_2.png";
		return Constants.MODID+":textures/items/material/"+this.Type+"/tool/armor"+this.Type+"_layer_1.png";
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(Constants.MODID+":material/"+this.Type+"/tool/"+this.getRegistryName().toString().substring(Constants.MODID.length()+1), "inventory"));
	}
}
