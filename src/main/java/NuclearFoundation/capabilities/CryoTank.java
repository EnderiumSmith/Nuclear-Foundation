package NuclearFoundation.capabilities;

import NuclearFoundation.fluids.CryoSet;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

public class CryoTank implements IFluidHandler{
	
	public CryoSet tanks;
	public boolean reverse;
	public CryoTank(int gasCap,int liquidCap) {
		reverse=false;
		tanks=new CryoSet(liquidCap, gasCap);
	}
	public void setReverse(){
		if(reverse){
			tanks.gasTank.setCanDrain(true);
			tanks.gasTank.setCanFill(false);
			tanks.liquidTank.setCanDrain(false);
			tanks.liquidTank.setCanFill(true);
		}else{
			tanks.gasTank.setCanDrain(false);
			tanks.gasTank.setCanFill(true);
			tanks.liquidTank.setCanDrain(true);
			tanks.liquidTank.setCanFill(false);
		}
	}
	@Override
	public IFluidTankProperties[] getTankProperties() {
		setReverse();
		return new IFluidTankProperties[]{tanks.gasTank.getTankProperties()[0],tanks.liquidTank.getTankProperties()[0]};
	}
	@Override
	public int fill(FluidStack resource, boolean doFill) {
		setReverse();
		if(tanks.gasTank.canFill()){
			return tanks.gasTank.fill(resource, doFill);
		}else{
			return tanks.liquidTank.fill(resource, doFill);
		}
	}
	@Override
	public FluidStack drain(FluidStack resource, boolean doDrain) {
		setReverse();
		if(tanks.liquidTank.canDrain()){
			return tanks.liquidTank.drain(resource, doDrain);
		}else{
			return tanks.gasTank.drain(resource, doDrain);
		}
	}
	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		setReverse();
		if(tanks.liquidTank.canDrain()){
			return tanks.liquidTank.drain(maxDrain, doDrain);
		}else{
			return tanks.gasTank.drain(maxDrain, doDrain);
		}
	}
}
