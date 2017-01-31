package NuclearFoundation.tile_entity;

import NuclearFoundation.capabilities.DualEnergyStorage;
import NuclearFoundation.capabilities.GasTank;
import NuclearFoundation.fluids.AirManager;
import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class TileAtmosphericVent extends TileEntity implements ITickable{
	
	public int type;//0-none 1-RF 2-T 3-RF+T
	public DualEnergyStorage buffer;
	public GasTank input,output;
	public boolean isWorking;
	@CapabilityInject(IFluidHandler.class)
	private static Capability<IFluidHandler> FLUID=null;
	@CapabilityInject(IEnergyStorage.class)
	private static Capability<IEnergyStorage> ENDERGY_RF=null;
	@CapabilityInject(ITeslaConsumer.class)
	private static Capability<ITeslaConsumer> IN_T=null;
	@CapabilityInject(ITeslaHolder.class)
	private static Capability<ITeslaHolder> ENDERGY_T=null;
	public TileAtmosphericVent() {
		this(0);
	}
	public TileAtmosphericVent(int e){
		type=e;
		buffer=new DualEnergyStorage(32000, 80, 0);
		output=new GasTank(Fluid.BUCKET_VOLUME*8);
		output.setCanFill(false);
		input=new GasTank(Fluid.BUCKET_VOLUME*80);
		input.setCanDrain(false);
		isWorking=false;
	}
	@Override
	public void update() {
		if(!this.worldObj.isRemote){
			if(this.worldObj.isBlockPowered(this.pos)){
				isWorking=true;
				if(this.worldObj.isAirBlock(this.pos.offset(EnumFacing.UP))){
					if(AirManager.getAirForDimension(this.worldObj)!=null){
						if(buffer.getEnergyStored()>=40){
							if(output.getCapacity()-output.getFluidAmount()>=100){
								buffer.takePower(40, false);
								output.fillInternal(new FluidStack(AirManager.getAirForDimension(this.worldObj), 100), true);
							}
						}
					}
				}
				EnumFacing[] neighbors=EnumFacing.HORIZONTALS;
				for(int i=0;i<neighbors.length;i++){
					if(output.getFluid()!=null){
						TileEntity tile=this.worldObj.getTileEntity(this.pos.offset(neighbors[i]));
						if(tile!=null){
							if(tile.hasCapability(FLUID, neighbors[i].getOpposite())){
								IFluidHandler cap=tile.getCapability(FLUID, neighbors[i].getOpposite());
								output.drain(cap.fill(new FluidStack(output.getFluid(), Math.min(200, output.getFluidAmount())), true), true);
							}
						}
					}
				}
			}else{
				isWorking=false;
				input.drainInternal(200, true);
			}
		}
		
	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability==FLUID&&facing!=EnumFacing.DOWN&&facing!=EnumFacing.UP){
			return true;
		}
		if(capability==ENDERGY_RF&&(type==1||type==3)&&facing!=EnumFacing.UP){
			return true;
		}
		if(capability==ENDERGY_T&&(type==2||type==3)&&facing!=EnumFacing.UP){
			return true;
		}
		if(capability==IN_T&&(type==2||type==3)&&facing!=EnumFacing.UP){
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability==FLUID&&facing!=EnumFacing.DOWN&&facing!=EnumFacing.UP){
			if(isWorking){
				return (T)output;
			}else{
				return (T)input;
			}
		}
		if(capability==ENDERGY_RF&&(type==1||type==3)&&facing!=EnumFacing.UP){
			return (T)buffer;
		}
		if(capability==ENDERGY_T&&(type==2||type==3)&&facing!=EnumFacing.UP){
			return (T)buffer;
		}
		if(capability==IN_T&&(type==2||type==3)&&facing!=EnumFacing.UP){
			return (T)buffer;
		}
		return super.getCapability(capability, facing);
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("type", type);
		compound.setTag("energy", buffer.serializeNBT());
		compound.setTag("vent", input.writeToNBT(new NBTTagCompound()));
		compound.setTag("tank", output.writeToNBT(new NBTTagCompound()));
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		type=compound.getInteger("type");
		buffer.deserializeNBT(compound.getCompoundTag("energy"));
		input.readFromNBT(compound.getCompoundTag("vent"));
		output.readFromNBT(compound.getCompoundTag("tank"));
	}
}
