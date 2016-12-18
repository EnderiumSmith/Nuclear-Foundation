package NuclearFoundation.blocks;

import java.util.List;

import NuclearFoundation.items.MetalItemBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MetalBlock extends BlockBasic{

	public final int Meta;
	MetalItemBlock itemblock;
	public static final PropertyEnum<EnumType> TYPE=PropertyEnum.create("type", MetalBlock.EnumType.class);
	public MetalBlock(String name,int metadata) {
		super(Material.IRON, name+metadata, 5F, 3F, 2, "pickaxe");
		this.Meta=metadata;
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.MISSINGNO));
	}
	@Override
	public void initModel() {
		super.initModel();
		itemblock.initModel();
	}
	@Override
	public void register() {
		GameRegistry.register(this);
		itemblock=new MetalItemBlock(this);
		GameRegistry.register(itemblock, getRegistryName());
	}
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{TYPE});
	}
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(meta+16*this.Meta>53)
			return getDefaultState().withProperty(TYPE, EnumType.MISSINGNO);
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
		return getMetaFromState(state);
	}
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for(int i=0;i<16;i++)
			list.add(new ItemStack(itemIn, 1, i));
	}
	public String getOreName(int meta){
		if(meta+16*this.Meta<53)
			for(EnumType e:EnumType.values()){
				if(e.getMeta()==meta+16*this.Meta)
					return e.getOreName();
			}
		return EnumType.MISSINGNO.getOreName();
	}
	public enum EnumType implements IStringSerializable{
		BORON(0,"Boron"),
		ALUMINIUM(1,"Aluminium"),
		TITANIUM(2,"Titanium"),
		CROMIUM(3,"Cromium"),
		COBALT(4,"Cobalt"),
		NICKEl(5,"Nickel"),
		COPPER(6,"Copper"),
		ZINC(7,"Zinc"),
		ARSENIC(8,"Arsenic"),
		ZIRCONIUM(9,"Zirconium"),
		SILVER(10,"Silver"),
		TIN(11,"Tin"),
		WOLFRAM(12,"Wolfram"),
		OSMIUM(13,"Osmium"),
		PLATINUM(14,"Platinum"),
		LEAD(15,"Lead"),
		BISMUTH(16,"Bismuth"),
		THORIUM(17,"Thorium"),
		URANIUM(18,"Uranium"),
		MITHRIL(19,"Mithril"),
		ADAMANTINE(20,"Adamantine"),
		PROMETHEUM(21,"Prometheum"),
		ORICHALCUM(22,"Orichalcum"),
		BLAZONIUM(23,"Blazonium"),
		TERMINIUM(24,"Terminium"),
		DURALUMINIUM(25,"Duraluminium"),
		ALUMITE(26,"Alumite"),
		NICHROME(27,"Nichrome"),
		PIGIRON(28,"Pigiron"),
		STEEL(29,"Steel"),
		STAINLESSSTEEL(30,"StainlessSteel"),
		DAMASCUSSTEEL(31,"Damascussteel"),
		BLACKSTEEL(32,"Blacksteel"),
		TEARSTEEL(33,"TearSteel"),
		BLUESTEEL(34,"BlueSteel"),
		REDSTEEL(35,"RedSteel"),
		STELLITE(36,"Stellite"),
		INVAR(37,"Invar"),
		BRASS(38,"Brass"),
		ALUMINIUMBRASS(39,"AluminiumBrass"),
		BISMUTHBRASS(40,"BismuthBrass"),
		BRONZE(41,"Bronze"),
		BLACKBRONZE(42,"BlackBronze"),
		MITHRILBRONZE(43,"MithrilBronze"),
		SIGNALUM(44,"Signalum"),
		VIBRANIUM(45,"Vibranium"),
		ELECTRUM(46,"Electrum"),
		STERLINGSILVER(47,"SterlingSilver"),
		LUMIUM(48,"Lumium"),
		ENDERIUM(49,"Enderium"),
		TESLIUM(50,"Teslium"),
		TUNGSTEMSTEEL(51,"TungstenSteel"),
		ROSEGOLD(52,"RoseGold"),
		MISSINGNO(53,"MissingNo");
		
		
		private int Meta;
		private String Name;
		
		private EnumType(int meta,String name){
			this.Meta=meta;
			this.Name=name;
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
	}

}
