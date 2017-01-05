package NuclearFoundation.blocks;

import java.util.List;
import java.util.Random;

import NuclearFoundation.core.Constants;
import NuclearFoundation.crafting.OredictHelper;
import NuclearFoundation.items.CustomCreativeTabs;
import NuclearFoundation.items.ItemRegistry;
import NuclearFoundation.items.MetadataItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class BlockOre extends BlockMeta{
	
	public final int Meta;
	MetadataItem ItemBlock;
	public static final PropertyEnum<EnumType> TYPE=PropertyEnum.create("type", BlockOre.EnumType.class);
	public BlockOre(String name, int metadata) {
		super(Material.ROCK);
		Meta=metadata;
		setRegistryName(name+metadata);
		setUnlocalizedName(getRegistryName().toString());
		setHardness(3);
		setResistance(5);
		setMiningLvl();
		setCreativeTab(CustomCreativeTabs.TabBlocks);
	}
	public void register(){
		GameRegistry.register(this);
		ItemBlock=new MetadataItem(this);
		GameRegistry.register(ItemBlock, getRegistryName());
	}
	public void initModel(){
		ItemBlock.initModel();
	}
	public void initOredict(){
		for(int i=0;i<16;i++){
			IBlockState state=getStateFromMeta(i);
			if(state.getValue(TYPE)!=EnumType.MISSINGNO){
				String[] string=OredictHelper.getOredictForOre(state.getValue(TYPE).getOreName());
				for(int j=0;j<string.length;j++){
					OreDictionary.registerOre("ore"+string[j], new ItemStack(this,1,i));
				}
			}
		}
	}
	@Override
	public String getUnlocalizedNameWithMeta(ItemStack stack) {
		if(stack!=null)
			return "item."+Constants.MODID+":"+getOreName(stack.getMetadata())+"Ore.name";
		return getUnlocalizedName();
	}
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{TYPE});
	}
	@Override
	public IBlockState getStateFromMeta(int meta) {
		for(EnumType e:EnumType.values()){
			if(e.getMeta()==meta+16*this.Meta)
				return getDefaultState().withProperty(TYPE, e);
		}
		return getDefaultState().withProperty(TYPE, EnumType.MISSINGNO);
	}
	@Override
	public int getMetaFromState(IBlockState state) {
		EnumType type=(EnumType) state.getValue(TYPE);
		return type.getMeta()%16;
	}
	@Override
	public int damageDropped(IBlockState state) {
		if(state.getValue(TYPE)==EnumType.LAPISLAZULI){
			return EnumDyeColor.BLUE.getDyeDamage();
		}
		if(state.getValue(TYPE)==EnumType.LIGNITE||state.getValue(TYPE)==EnumType.BITUMINOUSCOAL||
				state.getValue(TYPE)==EnumType.ANTHRACITE||state.getValue(TYPE)==EnumType.KIMBERLITE||
				state.getValue(TYPE)==EnumType.EMERALD||state.getValue(TYPE)==EnumType.SAPPHIRE||
				state.getValue(TYPE)==EnumType.AMETHYST||state.getValue(TYPE)==EnumType.RUBY||
				state.getValue(TYPE)==EnumType.TIGEREYE){
			return 0;
		}
		return getMetaFromState(state);
	}
	public void setMiningLvl(){
		for(int i=0;i<16;i++){
			IBlockState state=this.getStateFromMeta(i);
			this.setHarvestLevel("pickaxe", state.getValue(TYPE).getMiningLvl(), state);
		}
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(state.getValue(TYPE)==EnumType.LIGNITE){
			return Items.COAL;
		}
		if(state.getValue(TYPE)==EnumType.BITUMINOUSCOAL){
			return Items.COAL;
		}
		if(state.getValue(TYPE)==EnumType.ANTHRACITE){
			return Items.COAL;
		}
		if(state.getValue(TYPE)==EnumType.SULFUR){
			return null;
		}
		if(state.getValue(TYPE)==EnumType.LAPISLAZULI){
			return Items.DYE;
		}
		if(state.getValue(TYPE)==EnumType.KIMBERLITE){
			return Items.DIAMOND;
		}
		if(state.getValue(TYPE)==EnumType.EMERALD){
			return Items.EMERALD;
		}
		if(state.getValue(TYPE)==EnumType.SAPPHIRE){
			return ItemRegistry.Sapphire;
		}
		if(state.getValue(TYPE)==EnumType.AMETHYST){
			return ItemRegistry.Amethyst;
		}
		if(state.getValue(TYPE)==EnumType.RUBY){
			return ItemRegistry.Ruby;
		}
		if(state.getValue(TYPE)==EnumType.TIGEREYE){
			return ItemRegistry.TigerEye;
		}
		return super.getItemDropped(state, rand, fortune);
	}
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		if(state.getValue(TYPE)==EnumType.LIGNITE||state.getValue(TYPE)==EnumType.BITUMINOUSCOAL||
				state.getValue(TYPE)==EnumType.ANTHRACITE||state.getValue(TYPE)==EnumType.SULFUR){
			return MathHelper.getRandomIntegerInRange(rand, 0, 2);
		}
		if(state.getValue(TYPE)==EnumType.LAPISLAZULI){
			return MathHelper.getRandomIntegerInRange(rand, 2, 5);
		}
		if(state.getValue(TYPE)==EnumType.KIMBERLITE||state.getValue(TYPE)==EnumType.RUBY||
				state.getValue(TYPE)==EnumType.TIGEREYE||state.getValue(TYPE)==EnumType.EMERALD||
				state.getValue(TYPE)==EnumType.AMETHYST||state.getValue(TYPE)==EnumType.SAPPHIRE){
			return MathHelper.getRandomIntegerInRange(rand, 3, 7);
		}
		return 0;
	}
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		if(fortune>0){
			if(state.getValue(TYPE)==EnumType.LIGNITE||state.getValue(TYPE)==EnumType.BITUMINOUSCOAL||
					state.getValue(TYPE)==EnumType.ANTHRACITE||state.getValue(TYPE)==EnumType.SULFUR||
					state.getValue(TYPE)==EnumType.LAPISLAZULI||state.getValue(TYPE)==EnumType.KIMBERLITE||
					state.getValue(TYPE)==EnumType.RUBY||state.getValue(TYPE)==EnumType.TIGEREYE||
					state.getValue(TYPE)==EnumType.EMERALD||state.getValue(TYPE)==EnumType.SAPPHIRE||
					state.getValue(TYPE)==EnumType.AMETHYST){
				int i = random.nextInt(fortune + 2) - 1;

	            if (i < 0)
	            {
	                i = 0;
	            }
	            if(state.getValue(TYPE)==EnumType.LAPISLAZULI){
	            	return ((i+1)*(4 + random.nextInt(5)));
	            }
	            if(state.getValue(TYPE)==EnumType.BITUMINOUSCOAL){
	            	return ((i+1)*(1+random.nextInt(2)));
	            }
	            if(state.getValue(TYPE)==EnumType.ANTHRACITE){
	            	return ((i+1)*(2+random.nextInt(2)));
	            }
	            	return i+1;
			}
		}else{
			if(state.getValue(TYPE)==EnumType.LAPISLAZULI){
				return 4 + random.nextInt(5);
			}
			if(state.getValue(TYPE)==EnumType.BITUMINOUSCOAL){
				return 1+random.nextInt(2);
			}
			if(state.getValue(TYPE)==EnumType.ANTHRACITE){
				return 2+random.nextInt(2);
			}
		}
		return 1;
	}
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for(int i=0;i<16;i++)
			if(getStateFromMeta(i).getValue(TYPE)!=EnumType.MISSINGNO)
				list.add(new ItemStack(itemIn, 1, i));
	}
	public String getOreName(int meta){
		for(EnumType e:EnumType.values()){
			if(e.getMeta()==meta+16*this.Meta)
				return e.getOreName();
		}
		return EnumType.MISSINGNO.getOreName();
	}
	public enum EnumType implements IStringSerializable{
		BAUXITE(0,"Bauxite",1),
		ILMENITE(1,"Ilmenite",2),
		CHROMITE(2,"Chromite",2),
		HEMATITE(3,"Hematite",1),
		MAGNETITE(4,"Magnetite",1),
		LIMONITE(5,"Limonite",1),
		PYRITE(6,"Pyrite",1),
		COBALTITE(7,"Cobaltite",2),
		GARNIERITE(8,"Garnierite",1),
		COPPER(9,"Copper",1),
		MALACHITE(10,"Malachite",1),
		SPHALERITE(11,"Sphalerite",1),
		ARSENOPYRITE(12,"Arsenopyrite",1),
		ZIRCON(13,"Zircon",2),
		SILVER(14,"Silver",2),
		CASSITERITE(15,"Cassiterite",1),
		WOLFRAMITE(16,"Wolframite",2),
		PLATINUM(17,"Platinum",2),
		GOLD(18,"Gold",2),
		CINNABAR(19,"Cinnabar",1),
		GALENA(20,"Galena",1),
		BISMUTHINITE(21,"Bismuthinite",1),
		ORICHALCUM(22,"Orichalcum",2),
		LIGNITE(32,"Lignite",0),
		BITUMINOUSCOAL(33,"BituminousCoal",0),
		ANTHRACITE(34,"Anthracite",0),
		SULFUR(35,"Sulfur",0),
		LAPISLAZULI(36,"LapisLazuli",1),
		KIMBERLITE(37,"Kimberlite",2),
		EMERALD(38,"Emerald",2),
		SAPPHIRE(39,"Sapphire",2),
		RUBY(40,"Ruby",2),
		AMETHYST(41,"Amethyst",2),
		TIGEREYE(42,"TigerEye",2),
		MISSINGNO(43,"MissingNo",0);
		
		private int Meta;
		private String Name;
		private int Lvl;
		
		private EnumType(int id,String name,int lvl) {
			this.Meta=id;
			this.Name=name;
			this.Lvl=lvl;
		}
		
		@Override
		public String getName() {
			return Name.toLowerCase();
		}
		public int getMeta(){
			return Meta;
		}
		@Override
		public String toString() {
			return Name.toLowerCase();
		}
		public String getOreName(){
			return Name;
		}
		public int getMiningLvl(){
			return Lvl;
		}
		
	}
	
	
}
