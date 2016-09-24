package NuclearFoundation.core;

import NuclearFoundation.items.ItemComplexComponent;
import NuclearFoundation.items.ItemManager;
import NuclearFoundation.items.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public static Minecraft minecraft=Minecraft.getMinecraft();
	
	public void preInit(FMLPreInitializationEvent e){
		super.preInit(e);
		ItemRegistry.initItemModels();
	}
	public void init(FMLInitializationEvent e){
		super.init(e);
		minecraft.getItemColors().registerItemColorHandler(new IItemColor() {
			
			@Override
			public int getColorFromItemstack(ItemStack stack, int tintIndex) {
				return MetalColorizer.getColorForMetal(((ItemComplexComponent)stack.getItem()).Metal.get(stack.getItemDamage()));
			}
		}, ItemManager.Ingot,ItemManager.Dust,ItemManager.Nugget,
				ItemManager.Gear,ItemManager.Plate,ItemManager.Rod);
	}
	public void postInit(FMLPostInitializationEvent e){
		super.postInit(e);
	}
	
}
