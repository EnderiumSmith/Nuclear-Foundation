package NuclearFoundation.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SetTools {
	
	public final ItemBasicPick Pick;
	public final ItemBasicShovel Shovel;
	public final ItemBasicAxe Axe;
	public final ItemBasicSword Sword;
	public final ItemBasicHoe Hoe;
	public final ItemBasicShears Shears;
	public final String Type;
	public final ToolMaterial Material;
	
	public SetTools(String type, ToolMaterial material){
		this.Type=type;
		this.Material=material;
		this.Pick=new ItemBasicPick(material, type);
		this.Shovel=new ItemBasicShovel(material, type);
		this.Axe=new ItemBasicAxe(material, type);
		this.Sword=new ItemBasicSword(material, type);
		this.Hoe=new ItemBasicHoe(material, type);
		this.Shears=new ItemBasicShears(material, type);
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		this.Pick.initModel();
		this.Shovel.initModel();
		this.Axe.initModel();
		this.Sword.initModel();
		this.Hoe.initModel();
		this.Shears.initModel();
	}
	public void registerItems(){
		GameRegistry.register(this.Pick);
		GameRegistry.register(this.Shovel);
		GameRegistry.register(this.Axe);
		GameRegistry.register(this.Sword);
		GameRegistry.register(this.Hoe);
		GameRegistry.register(this.Shears);
	}
}
