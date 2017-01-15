package NuclearFoundation.blocks;

import NuclearFoundation.NuclearFoundation;
import NuclearFoundation.items.CustomCreativeTabs;
import NuclearFoundation.tile_entity.TileStirlingGenerator;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockSirlingGenerator extends BlockContainer{

	public static final PropertyDirection FACING=PropertyDirection.create("facing");
	protected BlockSirlingGenerator() {
		super(Material.ANVIL);
		setRegistryName("stirling_generator");
		setUnlocalizedName(getUnlocalizedName().toString());
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
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		((TileStirlingGenerator)worldIn.getTileEntity(pos)).dropInventory();
		super.breakBlock(worldIn, pos, state);
	}
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{FACING});
	}
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta%4));
	}
	@Override
	public int getMetaFromState(IBlockState state) {
		int dir=state.getValue(FACING).getHorizontalIndex();
		if(dir==-1)
			dir=2;
		return dir;
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileStirlingGenerator();
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote)
			playerIn.openGui(NuclearFoundation.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

}
