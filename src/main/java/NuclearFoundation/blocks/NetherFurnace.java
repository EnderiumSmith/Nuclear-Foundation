package NuclearFoundation.blocks;

import java.util.Random;

import net.minecraft.block.BlockFurnace;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetherFurnace extends BlockFurnace{

	protected NetherFurnace(boolean isBurning) {
		super(isBurning);
		if(isBurning){
			setRegistryName("NetherFurnaceLit");
		}
		else
			setRegistryName("NetherFurnace");
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		// TODO Auto-generated method stub
		return super.getItemDropped(state, rand, fortune);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return super.createNewTileEntity(worldIn, meta);
	}
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		super.breakBlock(worldIn, pos, state);
	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		return super.getItem(worldIn, pos, state);
	}
	
	

}
