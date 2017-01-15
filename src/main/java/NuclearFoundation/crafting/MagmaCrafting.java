package NuclearFoundation.crafting;

import java.util.ArrayList;

import NuclearFoundation.fluids.FluidManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class MagmaCrafting {
	
	public static ArrayList<MagmaCrafting> recipes=new ArrayList<>();
	
	public Object in;
	public int energy;
	public FluidStack out;
	public MagmaCrafting(Object i,int en,FluidStack o){
		in=i;
		energy=en;
		out=o;
	}
	public boolean isItemEqual(ItemStack stack){
		if(stack!=null){
			if(in instanceof String){
				int[] ids=OreDictionary.getOreIDs(stack);
				for(int i=0;i<ids.length;i++){
					if(OreDictionary.getOreName(ids[i]).equals((String)in)){
						return true;
					}
				}
			}
			if(in instanceof ItemStack){
				if(stack.isItemEqual((ItemStack)in)){
					return true;
				}
			}
		}
		return false;
	}
	public static MagmaCrafting getRecipe(ItemStack stack){
		for(int i=0;i<recipes.size();i++){
			if(recipes.get(i).isItemEqual(stack)){
				return recipes.get(i);
			}
		}
		return null;
	}
	public static int getIndex(MagmaCrafting recipe){
		for(int i=0;i<recipes.size();i++){
			if(recipes.get(i)==recipe){
				return i;
			}
		}
		return -1;
	}
	public static void initMagmaRecipes(){
		recipes.add(new MagmaCrafting("dustRedstone", 16000, new FluidStack(FluidManager.DestabilizedRedstone, 100)));
		recipes.add(new MagmaCrafting("blockRedstone", 144000, new FluidStack(FluidManager.DestabilizedRedstone, 900)));
		recipes.add(new MagmaCrafting("dustNikolite", 16000, new FluidStack(FluidManager.IonizedNikolite, 100)));
		recipes.add(new MagmaCrafting("blockNikolite", 144000, new FluidStack(FluidManager.IonizedNikolite, 900)));
		recipes.add(new MagmaCrafting("dustGlowstone", 40000, new FluidStack(FluidManager.EnergizedGlowstone, 250)));
		recipes.add(new MagmaCrafting("blockGlowstone", 160000, new FluidStack(FluidManager.EnergizedGlowstone, 1000)));
		recipes.add(new MagmaCrafting("enderpearl", 40000, new FluidStack(FluidManager.ResonantEnder, 250)));
		recipes.add(new MagmaCrafting("stone", 640000, new FluidStack(FluidRegistry.LAVA, 1000)));
		recipes.add(new MagmaCrafting("cobblestone", 640000, new FluidStack(FluidRegistry.LAVA, 1000)));
	}
}
