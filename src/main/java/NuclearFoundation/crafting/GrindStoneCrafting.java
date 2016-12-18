package NuclearFoundation.crafting;

import java.util.ArrayList;
import java.util.Random;

import NuclearFoundation.core.Config;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GrindStoneCrafting {
	
	private static Random rand=new Random();
	
	public static ArrayList<ItemStack> getGrindingResult(ItemStack in){
		if(in!=null){
			ArrayList<ItemStack> list=new ArrayList<>();
			int[] ids=OreDictionary.getOreIDs(in);
			for(int i=0;i<ids.length;i++){
				String name=OreDictionary.getOreName(ids[i]);
				if(name.startsWith("ingot")){
					String dustName="dust"+name.substring(5);
					if(OreDictionary.getOres(dustName)!=null){
						list.add(OreDictionary.getOres(dustName).get(0).copy());
						return list;
					}
				}
			}
			for(int i=0;i<ids.length;i++){
				String name=OreDictionary.getOreName(ids[i]);
				if(name.startsWith("ore")){
					String dustName="dust"+name.substring(3);
					if(OreDictionary.getOres(dustName)!=null){
						ItemStack stack=(OreDictionary.getOres(dustName).get(0).copy());
						if(rand.nextFloat()<Config.GrindstoneChance){
							stack.stackSize++;
						}
						list.add(stack);
						return list;
					}
				}
			}
		}
		return null;
	}
	
}
