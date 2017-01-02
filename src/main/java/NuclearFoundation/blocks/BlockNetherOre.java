package NuclearFoundation.blocks;

import java.util.List;
import java.util.Random;

import NuclearFoundation.core.Constants;
import NuclearFoundation.crafting.OredictHelper;
import NuclearFoundation.items.CustomCreativeTabs;
import NuclearFoundation.items.MetadataItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class BlockNetherOre extends BlockMeta{
	
	public final int Meta;
	MetadataItem ItemBlock;
	public static final PropertyEnum<EnumType> TYPE=PropertyEnum.create("type", BlockNetherOre.EnumType.class);
	public BlockNetherOre(String name,int meta) {
		super(Material.ROCK);
		this.Meta=meta;
		setRegistryName(name+meta);
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
		if(state.getValue(TYPE)==EnumType.NETHERQUARTZ||state.getValue(TYPE)==EnumType.NETHERDIAMOND){
			return 0;
		}
		return getMetaFromState(state);
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(state.getValue(TYPE)==EnumType.NETHERQUARTZ){
			return Items.QUARTZ;
		}
		if(state.getValue(TYPE)==EnumType.NETHERSULFUR){
			return null;
		}
		if(state.getValue(TYPE)==EnumType.NETHERDIAMOND){
			return Items.DIAMOND;
		}
		return super.getItemDropped(state, rand, fortune);
	}
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		if(state.getValue(TYPE)==EnumType.NETHERQUARTZ){
			return MathHelper.getRandomIntegerInRange(rand, 2, 5);
		}
		if(state.getValue(TYPE)==EnumType.NETHERDIAMOND){
			return MathHelper.getRandomIntegerInRange(rand, 3, 7);
		}
		return 0;
	}
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		if(fortune>0){
			if(state.getValue(TYPE)==EnumType.NETHERQUARTZ||state.getValue(TYPE)==EnumType.NETHERDIAMOND){
				int i = random.nextInt(fortune + 2) - 1;

	            if (i < 0)
	            {
	                i = 0;
	            }
	            if(state.getValue(TYPE)==EnumType.NETHERDIAMOND){
	            	return ((i+1)*(1+random.nextInt(2)));
	            }
	            return i+1;
			}
		}
		else{
			if(state.getValue(TYPE)==EnumType.NETHERDIAMOND){
            	return 1+random.nextInt(2);
            }
		}
		return 1;
	}
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te,
			ItemStack stack) {
		super.harvestBlock(worldIn, player, pos, state, te, stack);
		List<Entity> list=worldIn.getLoadedEntityList();
		for(int i=0;i<list.size();i++){
			if(list.get(i) instanceof EntityPigZombie){
				if(Math.abs(pos.getX()-list.get(i).posX)<=16D&&
						Math.abs(pos.getY()-list.get(i).posY)<=16D&&
						Math.abs(pos.getZ()-list.get(i).posZ)<=16D){
					list.get(i).attackEntityFrom(DamageSource.causePlayerDamage(player), 0F);
				}
			}
		}
	}
	public void setMiningLvl(){
		for(int i=0;i<16;i++){
			IBlockState state=this.getStateFromMeta(i);
			this.setHarvestLevel("pickaxe", state.getValue(TYPE).getMiningLvl(), state);
		}
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
	private enum EnumType implements IStringSerializable{
		NETHERPYRITE(0,"NetherPyrite",1),
		NETHERARSENOPYRITE(1,"NetherArsenopyrite",1),
		NETHERSILVER(2,"NetherSilver",2),
		NETHERGOLD(3,"NetherGold",2),
		NETHERCINNABAR(4,"NetherCinnabar",1),
		NETHERPROMETHEUM(5,"NetherPrometheum",0),
		NETHERMITHRIL(6,"NetherMithril",2),
		NETHERQUARTZ(16,"NetherQuartz",0),
		NETHERSULFUR(17,"NetherSulfur",0),
		NETHERDIAMOND(18,"NetherDiamond",3),
		MISSINGNO(19,"MissingNo",0);
		
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
