package NuclearFoundation.items;

import NuclearFoundation.core.Constants;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasicPick extends ItemPickaxe{

	public final String Type;
	public ItemBasicPick(ToolMaterial material,String type) {
		super(material);
		this.Type=type;
		this.setRegistryName("pick"+type);
		this.setUnlocalizedName(this.getRegistryName().toString());
		this.setCreativeTab(CustomCreativeTabs.TabTools);
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(Constants.MODID+":material/"+this.Type+"/tool/pick", "inventory"));
	}
}
