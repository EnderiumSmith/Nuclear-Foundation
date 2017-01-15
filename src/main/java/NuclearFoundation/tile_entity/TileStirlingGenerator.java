package NuclearFoundation.tile_entity;

import NuclearFoundation.capabilities.EnergyStorageOut;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileStirlingGenerator extends TileEntity implements ITickable{
	
	public int burnTime,lastFuelValue;
	public boolean shouldSync;
	private final EnergyStorageOut buffer;
	private final ItemStackHandler fuel;
	@CapabilityInject(IItemHandler.class)
	private static Capability<IItemHandler> ITEM_HANDLER_CAPABILITY=null;
	@CapabilityInject(IEnergyStorage.class)
	private static Capability<IEnergyStorage> ENERGY=null;
	
	public TileStirlingGenerator() {
		burnTime=0;
		lastFuelValue=0;
		buffer=new EnergyStorageOut(64000, 0, 80);
		fuel=new ItemStackHandler(1);
		shouldSync=false;
	}
	@Override
	public void update() {
		if(!this.worldObj.isRemote){
			if(burnTime>1){
				burnTime-=2;
				buffer.addEnergy(40);
				shouldSync=true;
			}
			else{
				if(buffer.getEnergyStored()<=32000&&TileEntityFurnace.getItemBurnTime(fuel.getStackInSlot(0))>0){
					lastFuelValue=burnTime=TileEntityFurnace.getItemBurnTime(fuel.getStackInSlot(0));
					fuel.extractItem(0, 1, false);
					shouldSync=true;
				}
			}
			if(buffer.getEnergyStored()>0){
				EnumFacing[] neighbors=EnumFacing.VALUES;
				for(int i=0;i<neighbors.length;i++){
					TileEntity tile=this.worldObj.getTileEntity(this.pos.offset(neighbors[i]));
					if(tile!=null){
						if(tile.hasCapability(ENERGY, neighbors[i].getOpposite())){
							IEnergyStorage capability=tile.getCapability(ENERGY, neighbors[i].getOpposite());
							int ext=buffer.extractEnergy(capability.receiveEnergy(Math.min(80, buffer.getEnergyStored()), false), false);
							if(ext>0){
								shouldSync=true;
							}
						}
					}
				}
			}
			if(shouldSync){
				sync();
			}
		}
		
	}
	public void sync(){
		this.markDirty();
		this.worldObj.notifyBlockUpdate(pos, this.worldObj.getBlockState(pos), this.worldObj.getBlockState(pos), 3);
	}
	public void dropInventory(){
		if(fuel.getStackInSlot(0)!=null){
			InventoryHelper.spawnItemStack(this.worldObj, this.pos.getX(), this.getPos().getY(), this.getPos().getZ(), fuel.getStackInSlot(0));
		}
	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability==ITEM_HANDLER_CAPABILITY){
			return true;
		}
		if(capability==ENERGY){
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability==ITEM_HANDLER_CAPABILITY){
			return (T)fuel;
		}
		if(capability==ENERGY){
			return (T)buffer;
		}
		return super.getCapability(capability, facing);
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("burn", burnTime);
		compound.setInteger("maxburn", lastFuelValue);
		compound.setTag("buffer", buffer.serializeNBT());
		compound.setTag("fuel", fuel.serializeNBT());
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {		
		super.readFromNBT(compound);
		burnTime=compound.getInteger("burn");
		lastFuelValue=compound.getInteger("maxburn");
		buffer.deserializeNBT(compound.getCompoundTag("buffer"));
		fuel.deserializeNBT(compound.getCompoundTag("fuel"));
	}
	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(this.pos, 1, writeToNBT(new NBTTagCompound()));
	}
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}
}
