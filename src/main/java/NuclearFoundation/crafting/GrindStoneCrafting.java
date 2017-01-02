package NuclearFoundation.crafting;

import java.util.ArrayList;
import java.util.Random;

import NuclearFoundation.core.Config;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GrindStoneCrafting {
	
	private static Random rand=new Random();
	public static ArrayList<GrindStoneRecipe> recipes=new ArrayList<>();
	public static final GrindStoneCrafting INSTANCE=new GrindStoneCrafting();
	
	public static ArrayList<ItemStack> getGrindingResult(ItemStack in){
		if(in!=null){
			ArrayList<ItemStack> list=new ArrayList<>();
			int[] ids=OreDictionary.getOreIDs(in);
			for(int i=0;i<ids.length;i++){
				String name=OreDictionary.getOreName(ids[i]);
				if(name.startsWith("ingot")){
					String dustName="dust"+name.substring(5);
					if(OreDictionary.getOres(dustName)!=null&&OreDictionary.getOres(dustName).isEmpty()==false){
						list.add(OreDictionary.getOres(dustName).get(0).copy());
						return list;
					}
				}
			}
			for(int i=0;i<ids.length;i++){
				String name=OreDictionary.getOreName(ids[i]);
				if(name.startsWith("ore")){
					String dustName="dust"+name.substring(3);
					System.out.println(dustName);
					if(OreDictionary.getOres(dustName)!=null&&OreDictionary.getOres(dustName).isEmpty()==false){
						ItemStack stack=(OreDictionary.getOres(dustName).get(0).copy());
						System.out.println(stack.getUnlocalizedName());
						if(rand.nextFloat()<Config.GrindstoneChance){
							stack.stackSize++;
						}
						list.add(stack);
						return list;
					}
				}
			}
			for(int i=0;i<recipes.size();i++){
				if(recipes.get(i).isInputEqual(in)){
					recipes.get(i).getResult(rand, list);
					return list;
				}
			}
		}
		return null;
	}
	public void initRecipes(){
		recipes.add(new GrindStoneRecipe("obsidian", 2, new Object[]{"dustObsidian","dustObsidian"}, new float[]{1F,1F}));
		recipes.add(new GrindStoneRecipe("bone", 2, new Object[]{new ItemStack(Items.DYE,4,EnumDyeColor.WHITE.getDyeDamage()),new ItemStack(Items.DYE,1,EnumDyeColor.WHITE.getDyeDamage())}, new float[]{1F,0.3F}));
		recipes.add(new GrindStoneRecipe(new ItemStack(Items.BLAZE_ROD), 2, new Object[]{new ItemStack(Items.BLAZE_POWDER, 3),new ItemStack(Items.BLAZE_POWDER, 1)}, new float[]{1F,0.3F}));
		recipes.add(new GrindStoneRecipe("record", 1, new Object[]{new ItemStack(Items.RECORD_11)}, new float[]{0.9F}));
		recipes.add(new GrindStoneRecipe("sugarcane", 3, new Object[]{new ItemStack(Items.SUGAR),new ItemStack(Items.SUGAR),new ItemStack(Items.SUGAR)}, new float[]{1F,0.7F,0.1F}));
	}
	public class GrindStoneRecipe{
		
		public Object in;
		public int outSize;
		public Object[] out;
		public float[] outChance;
		public GrindStoneRecipe(Object input,int size,Object[] output,float[] chance) {
			in=input;
			outSize=size;
			out=output;
			outChance=chance;
		}
		public boolean isInputEqual(ItemStack In){
			if(in instanceof ItemStack){
				if(((ItemStack)in).isItemEqual(In)){
					return true;
				}
			}
			else{
				int[] ids=OreDictionary.getOreIDs(In);
				for(int i=0;i<ids.length;i++){
					String name=OreDictionary.getOreName(ids[i]);
					if(name.equals((String)in))
						return true;
				}
			}
			return false;
		}
		public void getResult(Random rand,ArrayList<ItemStack> list){
			for(int i=0;i<outSize;i++){
				if(rand.nextFloat()<outChance[i]){
					if(out[i]instanceof String){
						if((OreDictionary.getOres((String)out[i]).isEmpty()==false)){
							list.add(OreDictionary.getOres((String)out[i]).get(0).copy());
						}
					}
					else{
						list.add(((ItemStack)out[i]).copy());
					}
				}
			}
		}
	}
	
}
