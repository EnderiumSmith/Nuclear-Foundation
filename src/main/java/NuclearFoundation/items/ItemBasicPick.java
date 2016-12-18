package NuclearFoundation.items;

import com.mojang.realmsclient.gui.ChatFormatting;

import NuclearFoundation.core.Constants;
import NuclearFoundation.core.ToolMaterials;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
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
	public void addInformation(ItemStack stack, EntityPlayer playerIn, java.util.List<String> tooltip, boolean advanced) {
		if(((ItemTool)stack.getItem()).getToolMaterial()==ToolMaterials.Uranium){
			tooltip.add(ChatFormatting.DARK_GREEN+"Radioactive");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_GREEN+"10% chance to inflict radiation poisoning on hit");
			}
		}
		if(((ItemTool)stack.getItem()).getToolMaterial()==ToolMaterials.Orichalcum){
			tooltip.add(ChatFormatting.AQUA+"Poseidon's Blessing");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.AQUA+"2x damage vs Guardians");
			}
		}
		if(((ItemTool)stack.getItem()).getToolMaterial()==ToolMaterials.Blazonium){
			tooltip.add(ChatFormatting.GOLD+"Radioactive II");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.GOLD+"100% chance to inflict radiation poisoning on hit");
			}
			tooltip.add(ChatFormatting.DARK_RED+"Fiery Touch");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_RED+"Smelts mined blocks and sets targets ablaze");
				tooltip.add(ChatFormatting.DARK_RED+"Equivalent to Fire Aspect III");
			}
		}
		if(((ItemTool)stack.getItem()).getToolMaterial()==ToolMaterials.TearSteel){
			tooltip.add(ChatFormatting.LIGHT_PURPLE+"help, im a nameless stat :(");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.LIGHT_PURPLE+"Ignores magic defense like potions and enchantments");
			}
		}
		if(((ItemTool)stack.getItem()).getToolMaterial()==ToolMaterials.MithrilBronze){
			tooltip.add(ChatFormatting.DARK_GREEN+"Poisonous");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_GREEN+"Poison on hit");
				tooltip.add(ChatFormatting.DARK_GREEN+"Applies vanilla poison");
			}
		}
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(Constants.MODID+":material/"+this.Type+"/tool/pick", "inventory"));
	}
}
