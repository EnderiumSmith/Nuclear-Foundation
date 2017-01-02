package NuclearFoundation.items;

import com.google.common.collect.Multimap;
import com.mojang.realmsclient.gui.ChatFormatting;

import NuclearFoundation.core.ArmorMaterials;
import NuclearFoundation.core.Constants;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
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
	public void addInformation(ItemStack stack, EntityPlayer playerIn, java.util.List<String> tooltip, boolean advanced) {
		if(((ItemArmor)stack.getItem()).getArmorMaterial()==ArmorMaterials.TearSteel){
			tooltip.add(ChatFormatting.LIGHT_PURPLE+"Azanor's Cage");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.LIGHT_PURPLE+"Blocks up to 80% of magic damage");
				tooltip.add(ChatFormatting.LIGHT_PURPLE+"Stacks with vanilla Protection enchantment");
			}
		}
		if(((ItemArmor)stack.getItem()).getArmorMaterial()==ArmorMaterials.Electrum){
			tooltip.add(ChatFormatting.BLUE+"Faraday's Cage");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.BLUE+"Blocks up to 100% of electric damage");
			}
		}
		if(((ItemArmor)stack.getItem()).getArmorMaterial()==ArmorMaterials.Enderium||
				((ItemArmor)stack.getItem()).getArmorMaterial()==ArmorMaterials.TungstenSteel){
			tooltip.add(ChatFormatting.RED+"Heat Resistant");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.RED+"Blocks up to 40% of environmental fire damage");
			}
		}
		if(((ItemArmor)stack.getItem()).getArmorMaterial()==ArmorMaterials.Ruby){
			tooltip.add(ChatFormatting.DARK_RED+"Fire Ward");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_RED+"Blocks up to 60% of fire damage");
			}
		}
		if(((ItemArmor)stack.getItem()).getArmorMaterial()==ArmorMaterials.TigerEye){
			tooltip.add(ChatFormatting.GOLD+"Feline Aura");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.GOLD+"Blocks up to 40% of creeper damage");
			}
		}
		if(((ItemArmor)stack.getItem()).getArmorMaterial()==ArmorMaterials.Emerald){
			tooltip.add(ChatFormatting.GREEN+"Mending");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.GREEN+"Vanilla Mending built it");
			}
		}
		if(((ItemArmor)stack.getItem()).getArmorMaterial()==ArmorMaterials.Sapphire){
			tooltip.add(ChatFormatting.DARK_BLUE+"Icy Spikes");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_BLUE+"Slows and hurts attacker");
			}
		}
		if(((ItemArmor)stack.getItem()).getArmorMaterial()==ArmorMaterials.Amethyst){
			tooltip.add(ChatFormatting.DARK_PURPLE+"Calm Mind");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_PURPLE+"Redirects up to 40% of psychic/ender damage");
			}
		}
	}
	/*@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
		if(equipmentSlot==this.armorType){
			if(this.Type=="Vibranium"){
				multimap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getAttributeUnlocalizedName(), new AttributeModifier(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getAttributeUnlocalizedName(), 0.5F, 0));
			}
			if(this.Type=="Lumium"){
				multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED.getAttributeUnlocalizedName(), 0.1F, 1));
			}
		}
		return multimap;
	}*/
	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type){
		if(this.armorType==EntityEquipmentSlot.LEGS)
			return Constants.MODID+":textures/models/armor/"+this.Type+"_layer_2.png";
		return Constants.MODID+":textures/models/armor/"+this.Type+"_layer_1.png";
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(Constants.MODID+":material/"+this.Type+"/tool/"+this.getRegistryName().toString().substring(Constants.MODID.length()+1), "inventory"));
	}
}
