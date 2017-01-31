package NuclearFoundation.items;

import com.mojang.realmsclient.gui.ChatFormatting;

import NuclearFoundation.core.Constants;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasicHoe extends ItemHoe{

	public final String Type;
	public ItemBasicHoe(ToolMaterial material,String type) {
		super(material);
		this.Type=type;
		this.setRegistryName("hoe"+type);
		this.setUnlocalizedName(this.getRegistryName().toString());
		this.setCreativeTab(CustomCreativeTabs.TabTools);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, java.util.List<String> tooltip, boolean advanced) {
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("Uranium")){
			tooltip.add(ChatFormatting.DARK_GREEN+"Radioactive");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_GREEN+"10% chance to inflict radiation poisoning on hit");
			}
		}
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("Orichalcum")){
			tooltip.add(ChatFormatting.AQUA+"Poseidon's Blessing");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.AQUA+"2x damage vs Guardians");
			}
		}
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("Blazonium")){
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
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("TearSteel")){
			tooltip.add(ChatFormatting.LIGHT_PURPLE+"help, im a nameless stat :(");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.LIGHT_PURPLE+"Ignores magic defense like potions and enchantments");
			}
		}
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("MithrilBronze")){
			tooltip.add(ChatFormatting.DARK_GREEN+"Poisonous");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_GREEN+"Poison on hit");
				tooltip.add(ChatFormatting.DARK_GREEN+"Applies vanilla poison");
			}
		}
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("Ruby")){
			tooltip.add(ChatFormatting.DARK_RED+"Fiery Wish");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_RED+"Increases Fire Aspect by 1 level");
			}
		}
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("TigerEye")){
			tooltip.add(ChatFormatting.GOLD+"Meow");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.GOLD+"2x damage to creepers");
			}
		}
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("Emerald")){
			tooltip.add(ChatFormatting.GREEN+"Pure Greed");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.GREEN+"Increases Fortune and Looting by 1 level");
			}
		}
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("Sapphire")){
			tooltip.add(ChatFormatting.DARK_BLUE+"Icy Touch");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_BLUE+"Slows targets");
				tooltip.add(ChatFormatting.DARK_BLUE+"Extra damage to fiery mobs");
			}
		}
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("Amethyst")){
			tooltip.add(ChatFormatting.DARK_PURPLE+"Psycho Cut");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_PURPLE+"Extra damage to psychic/ender creatures");
			}
		}
		if(((ItemHoe)stack.getItem()).getMaterialName().equals("Terminium")){
			tooltip.add(ChatFormatting.DARK_PURPLE+"Ender Pulse");
			if(GuiScreen.isShiftKeyDown()){
				tooltip.add(ChatFormatting.DARK_PURPLE+"Teleports hit entitys");
			}
		}
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(Constants.MODID+":material/"+this.Type+"/tool/hoe", "inventory"));
	}
}
