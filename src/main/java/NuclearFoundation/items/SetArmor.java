package NuclearFoundation.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SetArmor {
	
	public final ItemBasicArmor Helm;
	public final ItemBasicArmor Chest;
	public final ItemBasicArmor Legs;
	public final ItemBasicArmor Boots;
	public final String Type;
	public final ArmorMaterial Material;
	
	public SetArmor(String type,ArmorMaterial material) {
		this.Type=type;
		this.Material=material;
		this.Helm=new ItemBasicArmor(material, 0, EntityEquipmentSlot.HEAD, type);
		this.Chest=new ItemBasicArmor(material, 1, EntityEquipmentSlot.CHEST, type);
		this.Legs=new ItemBasicArmor(material, 2, EntityEquipmentSlot.LEGS, type);
		this.Boots=new ItemBasicArmor(material, 3, EntityEquipmentSlot.FEET, type);
	}
	@SideOnly(Side.CLIENT)
	public void InitModel(){
		this.Helm.initModel();
		this.Chest.initModel();
		this.Legs.initModel();
		this.Boots.initModel();
	}
	public void registerItems(){
		GameRegistry.register(this.Helm);
		GameRegistry.register(this.Chest);
		GameRegistry.register(this.Legs);
		GameRegistry.register(this.Boots);
	}
}
