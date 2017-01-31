package NuclearFoundation.blocks;

import NuclearFoundation.items.CustomCreativeTabs;
import NuclearFoundation.tile_entity.TileAtmosphericVent;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockAtmosphericVent extends BlockContainer{

	public final int type;
	protected BlockAtmosphericVent(int type) {
		super(Material.ANVIL);
		this.type=type;
		setRegistryName("atmospheric_vent_"+type);
		setUnlocalizedName(getRegistryName().toString());
		setHardness(5);
		setResistance(10);
		setHarvestLevel("pickaxe", 0);
		setCreativeTab(CustomCreativeTabs.TabBlocks);
	}
	public void register(){
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileAtmosphericVent(type);
	}

}
