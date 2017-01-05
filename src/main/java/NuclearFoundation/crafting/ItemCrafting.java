package NuclearFoundation.crafting;

import NuclearFoundation.blocks.BlockRegistry;
import NuclearFoundation.blocks.MetalBlock;
import NuclearFoundation.blocks.MetalBlock.EnumType;
import NuclearFoundation.items.ItemComplexComponent;
import NuclearFoundation.items.ItemManager;
import NuclearFoundation.items.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ItemCrafting {
	
	public static void ItemRecipe(ItemStack dust,ItemStack ingot,ItemStack nugget,String type){
		GameRegistry.addSmelting(dust, ingot, 0F);
		GameRegistry.addRecipe(new ShapelessOreRecipe(ingot, new Object[]{
				"nugget"+type,"nugget"+type,"nugget"+type,
				"nugget"+type,"nugget"+type,"nugget"+type,
				"nugget"+type,"nugget"+type,"nugget"+type
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(nugget, new Object[]{"ingot"+type}));
	}
	public static void BlockRecipe(ItemStack block,ItemStack ingot, String type){
		GameRegistry.addRecipe(new ShapelessOreRecipe(block, new Object[]{
				"ingot"+type,"ingot"+type,"ingot"+type,
				"ingot"+type,"ingot"+type,"ingot"+type,
				"ingot"+type,"ingot"+type,"ingot"+type
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(ingot, new Object[]{
				"block"+type
		}));
	}
	public static void OreRecipe(ItemStack in, ItemStack out, float xp){
		GameRegistry.addSmelting(in, out, xp);
	}
	public static void initOreSmelting(){
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 0), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Aluminium")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 1), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Titanium")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 2), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Chromium")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 3), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Iron")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 4), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Iron")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 5), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Iron")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 6), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Iron")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 7), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Cobalt")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 8), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Nickel")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 9), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Copper")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 10), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Copper")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 11), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Zinc")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 12), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Arsenic")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 13), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Zirconium")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 14), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Silver")), 1.0F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock0, 1, 15), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Tin")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock1, 1, 0), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Wolfram")), 1F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock1, 1, 1), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Platinum")), 1F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock1, 1, 2), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Gold")), 1F);
		//OreRecipe(new ItemStack(BlockRegistry.OreBlock1, 1, 3), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock1, 1, 4), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Lead")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock1, 1, 5), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Bismuth")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.OreBlock1, 1, 6), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Orichalcum")), 0.7F);
		//nether
		OreRecipe(new ItemStack(BlockRegistry.NetherOreBlock0, 1, 0), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Iron")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.NetherOreBlock0, 1, 1), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Arsenic")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.NetherOreBlock0, 1, 2), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Silver")), 1F);
		OreRecipe(new ItemStack(BlockRegistry.NetherOreBlock0, 1, 3), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Gold")), 1F);
		//OreRecipe(new ItemStack(BlockRegistry.NetherOreBlock0, 1, 4), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.NetherOreBlock0, 1, 5), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Prometheum")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.NetherOreBlock0, 1, 6), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Mithril")), 0.7F);
		OreRecipe(new ItemStack(BlockRegistry.NetherOreBlock0, 1, 7), new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal("Blazonium")), 0.7F);
		
	}
	public static void init(){
		for(int i=0;i<ItemManager.Types.size();i++){
			ItemRecipe(
					new ItemStack(ItemManager.Dust, 1, ItemManager.Dust.getMetaForMetal(ItemManager.Types.get(i))),
					new ItemStack(ItemManager.Ingot, 1, ItemManager.Ingot.getMetaForMetal(ItemManager.Types.get(i))),
					new ItemStack(ItemManager.Nugget, 9, ItemManager.Nugget.getMetaForMetal(ItemManager.Types.get(i))),
					ItemManager.Types.get(i));
		}
		for(int i=0;i<16;i++){
			if(BlockRegistry.MetalBlock0.getStateFromMeta(i).getValue(MetalBlock.TYPE)!=EnumType.MISSINGNO){
				BlockRecipe(new ItemStack(BlockRegistry.MetalBlock0, 1, i),
						new ItemStack(ItemManager.Ingot, 9, ItemManager.Ingot.getMetaForMetal(BlockRegistry.MetalBlock0.getStateFromMeta(i).getValue(MetalBlock.TYPE).getOreName())),
						BlockRegistry.MetalBlock0.getStateFromMeta(i).getValue(MetalBlock.TYPE).getOreName());
			}
			if(BlockRegistry.MetalBlock1.getStateFromMeta(i).getValue(MetalBlock.TYPE)!=EnumType.MISSINGNO){
				BlockRecipe(new ItemStack(BlockRegistry.MetalBlock1, 1, i),
						new ItemStack(ItemManager.Ingot, 9, ItemManager.Ingot.getMetaForMetal(BlockRegistry.MetalBlock1.getStateFromMeta(i).getValue(MetalBlock.TYPE).getOreName())),
						BlockRegistry.MetalBlock1.getStateFromMeta(i).getValue(MetalBlock.TYPE).getOreName());
			}
			if(BlockRegistry.MetalBlock2.getStateFromMeta(i).getValue(MetalBlock.TYPE)!=EnumType.MISSINGNO){
				BlockRecipe(new ItemStack(BlockRegistry.MetalBlock2, 1, i),
						new ItemStack(ItemManager.Ingot, 9, ItemManager.Ingot.getMetaForMetal(BlockRegistry.MetalBlock2.getStateFromMeta(i).getValue(MetalBlock.TYPE).getOreName())),
						BlockRegistry.MetalBlock2.getStateFromMeta(i).getValue(MetalBlock.TYPE).getOreName());
			}
			if(BlockRegistry.MetalBlock3.getStateFromMeta(i).getValue(MetalBlock.TYPE)!=EnumType.MISSINGNO){
				BlockRecipe(new ItemStack(BlockRegistry.MetalBlock3, 1, i),
						new ItemStack(ItemManager.Ingot, 9, ItemManager.Ingot.getMetaForMetal(BlockRegistry.MetalBlock3.getStateFromMeta(i).getValue(MetalBlock.TYPE).getOreName())),
						BlockRegistry.MetalBlock3.getStateFromMeta(i).getValue(MetalBlock.TYPE).getOreName());
			}
		}
		initOreSmelting();
		regRecipes();
	}
	//manually added
	public static void regRecipes(){
		//crank
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemRegistry.WoodCrank, new Object[]{
				"  S",
				"SSS",
				"S  ",
				'S', "stickWood"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemRegistry.IronCrank, new Object[]{
				"  I",
				"III",
				"I  ",
				'I', "rodIron"
		}));
		//grindstone
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemRegistry.GrindStone, new Object[]{
				"  G",
				"SSS",
				'G',"gearWood",
				'S',new ItemStack(Blocks.STONE, 1, 0)
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemRegistry.GrindStone, new Object[]{
				"  G",
				"SSS",
				'G',"gearWood",
				'S',new ItemStack(Blocks.STONE, 1, 1)
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemRegistry.GrindStone, new Object[]{
				"  G",
				"SSS",
				'G',"gearWood",
				'S',new ItemStack(Blocks.STONE, 1, 3)
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemRegistry.GrindStone, new Object[]{
				"  G",
				"SSS",
				'G',"gearWood",
				'S',new ItemStack(Blocks.STONE, 1, 5)
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemRegistry.ObsidianGrindStone, new Object[]{
				"  G",
				"SSS",
				'G',"gearIron",
				'S',"obsidian"
		}));
		//grindstone-machine
		GameRegistry.addRecipe(new ShapedOreRecipe(BlockRegistry.GrindStone, new Object[]{
			"CGC",
			"SSS",
			"CCC",
			'C',"cobblestone",
			'G',"gearWood",
			'S',new ItemStack(Blocks.STONEBRICK, 1, 0)
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlockRegistry.GrindStone, new Object[]{
				"CGC",
				"SSS",
				"CCC",
				'C',"cobblestone",
				'G',"gearWood",
				'S',new ItemStack(Blocks.STONE, 1, 2)
			}));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlockRegistry.GrindStone, new Object[]{
				"CGC",
				"SSS",
				"CCC",
				'C',"cobblestone",
				'G',"gearWood",
				'S',new ItemStack(Blocks.STONE, 1, 4)
			}));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlockRegistry.GrindStone, new Object[]{
				"CGC",
				"SSS",
				"CCC",
				'C',"cobblestone",
				'G',"gearWood",
				'S',new ItemStack(Blocks.STONE, 1, 6)
			}));
		//metalworker
		GameRegistry.addRecipe(new ShapedOreRecipe(BlockRegistry.MetalWoker, new Object[]{
				"IPI",
				"IAI",
				"ICI",
				'I',"ingotIron",
				'P',Blocks.PISTON,
				'C',"workbench",
				'A',Blocks.ANVIL
		}));
		//dust
		ItemComplexComponent dust=ItemManager.Dust;
		String[] string=OredictHelper.getOredictForIngot("Aluminium");
		for(int i=0;i<string.length;i++){
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 5, dust.getMetaForMetal("Duraluminium")), new Object[]{
					"dustCopper","dust"+string[i],"dust"+string[i],"dust"+string[i],"dust"+string[i]
			}));
		}
		string=OredictHelper.getOredictForIngot("Duraluminium");
		for(int i=0;i<string.length;i++){
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 4, dust.getMetaForMetal("WeakAlumite")), new Object[]{
					"dust"+string[i],"dust"+string[i],"dust"+string[i],"dustPigIron","dustObsidian"
			}));
		}
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 5, dust.getMetaForMetal("Nichrome")), new Object[]{
				"dustChromium","dustNickel","dustNickel","dustNickel","dustNickel"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 5, dust.getMetaForMetal("WeakStainlessSteel")), new Object[]{
				"dustChromium","dustSteel","dustSteel","dustSteel","dustSteel"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 6, dust.getMetaForMetal("WeakBlackSteel")), new Object[]{
				"dustSteel","dustSteel","dustSteel","dustSteel","dustNickel","dustBlackBronze"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 6, dust.getMetaForMetal("WeakBlackSteel")), new Object[]{
				"dustSteel","dustSteel","dustSteel","dustSteel","dustNickel","dustHepatizon"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 8, dust.getMetaForMetal("WeakBlueSteel")), new Object[]{
				"dustBlackSteel","dustBlackSteel","dustSteel","dustBlackSteel","dustBlackSteel","dustSteel","dustBismuthBrass","dustSterlingSilver"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 8, dust.getMetaForMetal("WeakRedSteel")), new Object[]{
				"dustBlackSteel","dustBlackSteel","dustSteel","dustBlackSteel","dustBlackSteel","dustSteel","dustRoseGold","dustBrass"
		}));
		string=OredictHelper.getOredictForIngot("Wolfram");
		for(int i=0;i<string.length;i++){
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 7, dust.getMetaForMetal("WeakStellite")), new Object[]{
					"dustCobalt","dustCobalt","dustCobalt","dustChromium","dustChromium","dustChromium","dust"+string[i],"dustCoal"
			}));
		}
		for(int i=0;i<string.length;i++){
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 7, dust.getMetaForMetal("WeakStellite")), new Object[]{
					"dustCobalt","dustCobalt","dustCobalt","dustChromium","dustChromium","dustChromium","dust"+string[i],"dustCharcoal"
			}));
		}
		for(int i=0;i<string.length;i++){
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 7, dust.getMetaForMetal("WeakStellite")), new Object[]{
					"dustCobalt","dustCobalt","dustCobalt","dustChromium","dustChromium","dustChromium","dust"+string[i],"dustCarbon"
			}));
		}
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 3, dust.getMetaForMetal("Invar")), new Object[]{
				"dustIron","dustIron","dustNickel"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 5, dust.getMetaForMetal("Brass")), new Object[]{
				"dustZinc","dustCopper","dustCopper","dustCopper","dustCopper"
		}));
		string=OredictHelper.getOredictForIngot("Aluminium");
		for(int i=0;i<string.length;i++){
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 5, dust.getMetaForMetal("AluminiumBrass")), new Object[]{
					"dust"+string[i],"dustCopper","dustCopper","dustCopper","dustCopper"
			}));
		}
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 5, dust.getMetaForMetal("BismuthBrass")), new Object[]{
				"dustCopper","dustCopper","dustCopper","dustZinc","dustBismuth"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 5, dust.getMetaForMetal("Bronze")), new Object[]{
				"dustTin","dustCopper","dustCopper","dustCopper","dustCopper"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 5, dust.getMetaForMetal("BlackBronze")), new Object[]{
				"dustCopper","dustCopper","dustCopper","dustSilver","dustGold"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 5, dust.getMetaForMetal("MithrilBronze")), new Object[]{
				"dustArsenic","dustCopper","dustCopper","dustCopper","dustCopper"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 3, dust.getMetaForMetal("WeakVibranium")), new Object[]{
				"dustTerminium","dustTerminium","dustSignalum"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 2, dust.getMetaForMetal("Electrum")), new Object[]{
				"dustSilver","dustGold"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 4, dust.getMetaForMetal("SterlingSilver")), new Object[]{
				"dustSilver","dustSilver","dustSilver","dustCopper"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 4, dust.getMetaForMetal("RoseGold")), new Object[]{
				"dustGold","dustGold","dustGold","dustCopper"
		}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemManager.Dust, 2, dust.getMetaForMetal("RedNik")), new Object[]{
				"dustSignalum","dustTeslium"
		}));
	}
}
