package NuclearFoundation.items;

import NuclearFoundation.core.Constants;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemShears;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasicShears extends ItemShears{
	
	public final String Type;
	public ItemBasicShears(ToolMaterial material,String type) {
		super();
		this.setMaxDamage(material.getMaxUses()-12);
		this.Type=type;
		this.setRegistryName("shears"+type);
		this.setUnlocalizedName(this.getRegistryName().toString());
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(Constants.MODID+":material/"+this.Type+"/tool/shears", "inventory"));
	}
}
