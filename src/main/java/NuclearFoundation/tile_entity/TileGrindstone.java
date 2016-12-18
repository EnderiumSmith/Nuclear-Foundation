package NuclearFoundation.tile_entity;

import java.util.ArrayList;

import NuclearFoundation.blocks.BlockGrindstone;
import NuclearFoundation.core.Config;
import NuclearFoundation.crafting.GrindStoneCrafting;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.items.IItemHandler;

public class TileGrindstone extends TileEntity{
	
	public ItemStack[] inventory=new ItemStack[2];
	public int progress;
	private int maxProgress=(int)(20*Config.GrindStoneTime);
	private final IBehaviorDispenseItem dropBehavior = new BehaviorDefaultDispenseItem();
	@CapabilityInject(IItemHandler.class)
	static Capability<IItemHandler> ITEM_HANDLER_CAPABILITY=null;
	private final IItemHandler invhandler=new invHandler();
	
	public TileGrindstone() {
		progress=0;
	}
	
	public void crank(EntityLivingBase player){
		if(inventory[1]!=null){
			progress++;
			if(progress>=maxProgress){
				ArrayList<ItemStack> list=GrindStoneCrafting.getGrindingResult(inventory[1]);
				if(list!=null){
					progress=0;
					inventory[1]=null;
					inventory[0].damageItem(1, player);
					if(inventory[0]==null||inventory[0].stackSize<1){
						inventory[0]=null;
						IBlockState state=this.worldObj.getBlockState(this.pos);
						this.worldObj.setBlockState(this.pos, state.getBlock().getDefaultState().withProperty(BlockGrindstone.FACING, state.getValue(BlockGrindstone.FACING)).withProperty(BlockGrindstone.HAS_STONE, false), 2);
					}
					outPutItems(list);
				}
			}
			this.markDirty();
		}
	}
	public void outPutItems(ArrayList<ItemStack> list){
		EnumFacing facing=this.worldObj.getBlockState(this.pos).getValue(BlockGrindstone.FACING);
		TileEntity tile=this.worldObj.getTileEntity(this.pos.offset(facing));
		if(tile!=null){
			if(tile.hasCapability(ITEM_HANDLER_CAPABILITY, facing.getOpposite())){
				IItemHandler capability=tile.getCapability(ITEM_HANDLER_CAPABILITY, facing.getOpposite());
				for(int i=0;i<list.size();i++){
					int j=capability.getSlots();
					for(int k=0;k<j;k++){
						ItemStack stack=list.get(i);
						stack=capability.insertItem(k, stack, false);
						if(stack==null||stack.stackSize<1){
							list.remove(i);
							i--;
							this.worldObj.playEvent(1000, pos, 0);
							break;
						}
						else{
							list.set(i, stack);
						}
					}
				}
			}
		}
		for(int i=0;i<list.size();i++){
			if(list.get(i)!=null||list.get(i).stackSize>0){
				ItemStack stack=list.get(i);
				while(stack!=null&&stack.stackSize>0)
					stack=dropBehavior.dispense(new BlockSourceImpl(this.worldObj, this.pos), stack);
			}
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("progress", this.progress);
		NBTTagList nbttaglist=new NBTTagList();
		for(int i=0;i<this.inventory.length;i++){
			if(this.inventory[i]!=null){
				NBTTagCompound tagcompound=new NBTTagCompound();
				tagcompound.setByte("slot", (byte)i);
				this.inventory[i].writeToNBT(tagcompound);
				nbttaglist.appendTag(tagcompound);
			}
		}
		compound.setTag("inventory", nbttaglist);
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList nbttaglist=compound.getTagList("inventory", 10);
		this.inventory=new ItemStack[2];
		for(int i=0;i<nbttaglist.tagCount();i++){
			NBTTagCompound tagcompound=nbttaglist.getCompoundTagAt(i);
			int j=tagcompound.getByte("slot");
			this.inventory[j]= ItemStack.loadItemStackFromNBT(tagcompound);
		}
		this.progress=compound.getInteger("progress");
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability==ITEM_HANDLER_CAPABILITY&&(facing==EnumFacing.UP||facing==null))
			return true;
		return super.hasCapability(capability, facing);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability==ITEM_HANDLER_CAPABILITY&&(facing==EnumFacing.UP||facing==null))
			return (T) invhandler;
		return super.getCapability(capability, facing);
	}
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		if(oldState.getBlock()==newSate.getBlock())
			return false;
		return super.shouldRefresh(world, pos, oldState, newSate);
	}
	private class invHandler implements IItemHandler{
		
		public invHandler() {
		}
		
		@Override
		public int getSlots() {
			return 1;
		}

		@Override
		public ItemStack getStackInSlot(int slot) {
			if(slot!=0)
				return null;
			return
				inventory[1];
		}

		@Override
		public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
			if(stack==null||stack.stackSize<1)
				return null;
			if(inventory[1]!=null||slot!=0){
				return stack;
			}
			else{
				ItemStack newstack=stack.copy();
				if(simulate){
					newstack.splitStack(1);
					if(newstack.stackSize!=0)
						return newstack;
					else
						return null;
				}
				else{
					inventory[1]=newstack.splitStack(1);
					if(newstack.stackSize!=0)
						return newstack;
					else
						return null;
				}
			}
		}

		@Override
		public ItemStack extractItem(int slot, int amount, boolean simulate) {
			return null;
		}
		
		
		
	}
}
