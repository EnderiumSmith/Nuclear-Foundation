package NuclearFoundation.tile_entity;

import NuclearFoundation.capabilities.CryoTank;
import NuclearFoundation.capabilities.DualEnergyStorage;
import NuclearFoundation.capabilities.ItemHandlerIn;
import NuclearFoundation.core.RedstoneMode;
import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;

public class TileCryogenicCompressor extends TileEntity implements ITickable{
	
	public static int EnergyPerTick=40;
	public RedstoneMode redstoneMode;
	public boolean reverse;
	public DualEnergyStorage buffer;
	public int powerType;
	public ItemHandlerIn component;
	public CryoTank tanks;
	@CapabilityInject(IEnergyStorage.class)
	public static Capability<IEnergyStorage> ENDEGY_RF=null;
	@CapabilityInject(ITeslaConsumer.class)
	public static Capability<ITeslaConsumer> IN_T=null;
	@CapabilityInject(ITeslaHolder.class)
	public static Capability<ITeslaHolder> ENERGY_T=null;
	@CapabilityInject(IItemHandler.class)
	public static Capability<IItemHandler> ITEM=null;
	@CapabilityInject(IFluidHandler.class)
	public static Capability<IFluidHandler> FLUID=null;
	public TileCryogenicCompressor() {
		redstoneMode=RedstoneMode.MODE;
		reverse=false;
		buffer=new DualEnergyStorage(32000, 80, 0);
		powerType=3;
		component=new ItemHandlerIn(1);
		tanks=new CryoTank(Fluid.BUCKET_VOLUME*80, Fluid.BUCKET_VOLUME*8);
	}
	@Override
	public void update() {
		if(!this.worldObj.isRemote){
			if(canWork()){
				if(!reverse){
					if(buffer.getEnergyStored()>=EnergyPerTick){
						if(tanks.tanks.cryoCool(1)>0){
							buffer.takePower(EnergyPerTick, false);
						}
					}
				}else{
					if(buffer.getEnergyStored()>=EnergyPerTick/2){
						if(tanks.tanks.vaporizeOrsublimate(1)>0){
							buffer.takePower(EnergyPerTick/2, false);
						}
					}
				}
			}
		}
		sync();
		
	}
	public boolean reverse(){
		if(redstoneMode==RedstoneMode.MODE){
			return false;
		}else{
			tanks.reverse=reverse=!reverse;
			return true;
		}
	}
	public boolean canWork(){
		if(redstoneMode==RedstoneMode.MODE){
			boolean red=this.worldObj.isBlockPowered(this.pos);
			tanks.reverse=reverse=!red;
			return true;
		}
		if(redstoneMode==RedstoneMode.OFF){
			return false;
		}
		if(redstoneMode==RedstoneMode.ON){
			return true;
		}
		if(redstoneMode==RedstoneMode.SIGNALOFF){
			return !this.worldObj.isBlockPowered(this.pos);
		}
		if(redstoneMode==RedstoneMode.SIGNALON){
			return this.worldObj.isBlockPowered(this.pos);
		}
		return false;
	}
	public void sync(){
		this.markDirty();
		this.worldObj.notifyBlockUpdate(pos, this.worldObj.getBlockState(pos), this.worldObj.getBlockState(pos), 3);
	}
	public void dropinventory(){
		if(component.getStackInSlot(0)!=null){
			InventoryHelper.spawnItemStack(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ(), component.getStackInSlot(0));
		}
		if(tanks.tanks.iceSlot.getStackInSlot(0)!=null){
			InventoryHelper.spawnItemStack(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ(), tanks.tanks.iceSlot.getStackInSlot(0));
		}
	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability==ITEM){
			return true;
		}
		if(capability==FLUID){
			return true;
		}
		if(capability==ENDEGY_RF&&(powerType==1||powerType==3)){
			return true;
		}
		if(capability==ENERGY_T&&(powerType==2||powerType==3)){
			return true;
		}
		if(capability==IN_T&&(powerType==2||powerType==3)){
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability==ITEM){
			return (T)tanks.tanks.iceSlot;
		}
		if(capability==FLUID){
			return (T)tanks;
		}
		if(capability==ENDEGY_RF&&(powerType==1||powerType==3)){
			return (T)buffer;
		}
		if(capability==ENERGY_T&&(powerType==2||powerType==3)){
			return (T)buffer;
		}
		if(capability==IN_T&&(powerType==2||powerType==3)){
			return (T)buffer;
		}
		return super.getCapability(capability, facing);
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("redstone", redstoneMode.getId());
		compound.setBoolean("mode", reverse);
		compound.setTag("energy", buffer.serializeNBT());
		compound.setInteger("type", powerType);
		compound.setTag("component", component.serializeNBT());
		compound.setTag("tanks", tanks.tanks.writeToNBT(new NBTTagCompound()));
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		redstoneMode=RedstoneMode.getModeWithId(compound.getInteger("redstone"));
		reverse=compound.getBoolean("mode");
		buffer.deserializeNBT(compound.getCompoundTag("energy"));
		powerType=compound.getInteger("type");
		component.deserializeNBT(compound.getCompoundTag("component"));
		tanks.tanks.readFromNBT(compound.getCompoundTag("tanks"));
		tanks.reverse=compound.getBoolean("mode");
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
