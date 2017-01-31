package NuclearFoundation.capabilities;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class LiquidTank extends FluidTank{
	
	public LiquidTank(int capacity) {
		super(capacity);
	}
	@Override
	public boolean canDrainFluidType(FluidStack fluid) {
		if(fluid!=null&&!fluid.getFluid().isGaseous()){
			return canDrain;
		}
		return false;
	}
	@Override
	public boolean canFillFluidType(FluidStack fluid) {
		if(fluid!=null&&!fluid.getFluid().isGaseous()){
			return canFill;
		}
		return false;
	}
}
