package NuclearFoundation.blocks;

import NuclearFoundation.items.CustomCreativeTabs;
import NuclearFoundation.items.ItemCrank;
import NuclearFoundation.items.ItemGrindstone;
import NuclearFoundation.tile_entity.TileGrindstone;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
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

public class BlockGrindstone extends BlockContainer{

	public static final PropertyDirection FACING=PropertyDirection.create("facing");
	public static final PropertyBool HAS_STONE=PropertyBool.create("has_stone");
	
	public BlockGrindstone() {
		super(Material.ROCK);
		setRegistryName("BlockGrindstone");
		setUnlocalizedName(this.getRegistryName().toString());
		setHardness(3.5F);
		setHarvestLevel("pickaxe", 0);
		setCreativeTab(CustomCreativeTabs.TabBlocks);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(HAS_STONE, false));
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
		if(worldIn.getTileEntity(pos)instanceof TileGrindstone)
			((TileGrindstone)(worldIn.getTileEntity(pos))).dropInventory();
		super.breakBlock(worldIn, pos, state);
	}
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this,new IProperty[]{FACING,HAS_STONE});
	}
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta%4)).withProperty(HAS_STONE, meta>3);
	}
	@Override
	public int getMetaFromState(IBlockState state) {
		int i=0;
		if(state.getValue(HAS_STONE).booleanValue()==true)
			i=4;
		int dir=state.getValue(FACING).getHorizontalIndex();
		if(dir==-1)
			dir=2;
		return dir+i;
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileGrindstone();
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote){
			TileGrindstone tile=(TileGrindstone)worldIn.getTileEntity(pos);
			if(heldItem!=null&&heldItem.getItem() instanceof ItemCrank&&tile.inventory[0]!=null){
				heldItem.damageItem(1, playerIn);
				tile.crank(playerIn);
				return true;
			}
			if(heldItem!=null&&heldItem.getItem() instanceof ItemGrindstone){
				if(tile.inventory[0]==null){
					tile.inventory[0]=heldItem.copy();
					tile.markDirty();
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(HAS_STONE, true));
					playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, null);
					playerIn.openContainer.detectAndSendChanges();
					return true;
				}
			}
			if(heldItem==null&&tile.inventory[0]!=null){
				playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, tile.inventory[0].copy());
				tile.inventory[0]=null;
				tile.progress=0;
				tile.markDirty();
				worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(HAS_STONE, false));
				playerIn.openContainer.detectAndSendChanges();
				return true;
			}
		}
		return true;
	}

}
