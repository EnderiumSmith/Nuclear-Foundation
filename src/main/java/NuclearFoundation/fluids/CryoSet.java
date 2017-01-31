package NuclearFoundation.fluids;

import NuclearFoundation.capabilities.GasTank;
import NuclearFoundation.capabilities.LiquidTank;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.oredict.OreDictionary;

public class CryoSet {
	
	public GasTank gasTank;
	public LiquidTank liquidTank;
	public ItemStackHandler iceSlot;
	public String iceType;
	public int iceBuffer;
	public CryoSet(int liquidCap,int gasCap) {
		gasTank=new GasTank(gasCap);
		liquidTank=new LiquidTank(liquidCap);
		iceSlot=new ItemStackHandler(1);
		iceType="none";
		iceBuffer=0;
	}
	/**
	 * cools gas into fluid or solid
	 * @param runs how many mB of liquid/solid to try to produce 
	 * @return amount of successful runs
	 */
	public int cryoCool(int runs){
		int r;
		for(r=0;r<runs;r++){
			if(gasTank.getFluid()!=null){
				CryoMap stats=AirManager.getCryoStatsForGas(gasTank.getFluid().getFluid().getName());
				if(stats!=null){
					if(stats.getCryoFluidName()!=null){
						//gas condensates
						if(FluidRegistry.isFluidRegistered(stats.getCryoFluidName())){
							Fluid liquid=FluidRegistry.getFluid(stats.getCryoFluidName());
							FluidStack liquidStack=new FluidStack(liquid, 1, (gasTank.getFluid().tag!=null) ? gasTank.getFluid().tag.copy():null);
							if(gasTank.drainInternal(stats.getExpansionRatio(), false)!=null&&gasTank.drainInternal(stats.getExpansionRatio(), false).amount==stats.getExpansionRatio()){
								if(liquidTank.fillInternal(liquidStack, true)>0){
									gasTank.drainInternal(stats.getExpansionRatio(), true);
								}else{
									//tank too full->stop
									break;
								}
							}else{
								//not enough gas->stop
								break;
							}
						}else{
							//output invalid->stop
							break;
						}
					}else{
						if(stats.getIceName()!=null){
							//gas depositions
							if(!OreDictionary.getOres(stats.getIceName()).isEmpty()){
								if(iceBuffer==0){
									if(gasTank.drainInternal(stats.getExpansionRatio(), false)!=null&&gasTank.drainInternal(stats.getExpansionRatio(), false).amount==stats.getExpansionRatio()){
										iceType=stats.getIceName();
										iceBuffer++;
										gasTank.drainInternal(stats.getExpansionRatio(), true);
									}else{
										//not enough gas->stop
										break;
									}
								}else{
									if(iceBuffer>0&&iceBuffer<1000){
										//buffder has ice
										if(iceType.equals(stats.getIceName())){
											if(gasTank.drainInternal(stats.getExpansionRatio(), false)!=null&&gasTank.drainInternal(stats.getExpansionRatio(), false).amount==stats.getExpansionRatio()){
												iceBuffer++;
												gasTank.drainInternal(stats.getExpansionRatio(), true);
											}else{
												//not enough gas->stop
												break;
											}
										}else{
											//different ices->stop
										}
									}
									if(iceBuffer==1000){
										//try make block
										ItemStack ice=OreDictionary.getOres(stats.getIceName()).get(0).copy();
										if(iceSlot.insertItem(0, ice, false)==null){
											iceBuffer=0;
										}
									}
								}
							}else{
								//output invalid->stop
							}
						}else{
							//no output->stop
							break;
						}
					}
				}else{
					//fluid unknown->stop
					break;
				}
			}else{
				//tank empty->stop
				break;
			}
		}
		return r;
	}
	/**
	 * vaporize liquid into gas 
	 * @param runs how many mB of liquid to try to use
	 * @return amount of successful runs
	 */
	public int vaporize(int runs){
		int r;
		for(r=0;r<runs;r++){
			if(liquidTank.getFluid()!=null){
				CryoMap stats=AirManager.getCryoStatsForLiquid(liquidTank.getFluid().getFluid().getName());
				if(stats!=null){
					if(FluidRegistry.isFluidRegistered(stats.getGasFluidName())){
						Fluid gas=FluidRegistry.getFluid(stats.getGasFluidName());
						FluidStack gasStack=new FluidStack(gas, stats.getExpansionRatio(), (liquidTank.getFluid().tag!=null) ? liquidTank.getFluid().tag.copy():null);
						if(gasTank.fillInternal(gasStack, false)==stats.getExpansionRatio()){
							gasTank.fillInternal(gasStack, true);
							liquidTank.drainInternal(1, true);
						}else{
							//tank too full->stop
							break;
						}
					}else{
						//output invalid->stop
						break;
					}
				}else{
					//fluid unknown->stop
					break;
				}
			}else{
				//tank empty->stop
				break;
			}
		}
		return r;
	}
	/**
	 * sublimate solid into gas
	 * @param runs how many mB of solid to try to use
	 * @return amount of successful runs
	 */
	public int sublimate(int runs){
		int r;
		for(r=0;r<runs;r++){
			if(iceBuffer==0){
				//search for ice
				if(iceSlot.getStackInSlot(0)!=null){
					int[] ids=OreDictionary.getOreIDs(iceSlot.getStackInSlot(0));
					for(int i=0;i<ids.length;i++){
						String ice=OreDictionary.getOreName(ids[i]);
						CryoMap stats=AirManager.getCryoStatsForSolid(ice);
						if(stats!=null){
							if(FluidRegistry.isFluidRegistered(stats.getGasFluidName())){
								//ice valid
								iceSlot.extractItem(0, 1, false);
								iceBuffer=1000;
								iceType=ice;
								break;
							}
						}
					}
				}else{
					//no ice->stop
				}
			}
			if(iceBuffer>0){
				//buffer exists->ice must be valid
				CryoMap stats=AirManager.getCryoStatsForSolid(iceType);
				Fluid gas=FluidRegistry.getFluid(stats.getGasFluidName());
				FluidStack gasStack=new FluidStack(gas, stats.getExpansionRatio());
				if(gasTank.fillInternal(gasStack, false)==stats.getExpansionRatio()){
					gasTank.fillInternal(gasStack, true);
					iceBuffer--;
				}else{
					//tank too full->stop
					break;
				}
			}
		}
		return r;
	}
	/**
	 * if liquid cannot bee vaporized try sublimate solid
	 * @param runs how many mB of solid to try to use
	 * @return amount of successful runs
	 */
	public int vaporizeOrsublimate(int runs){
		int r=vaporize(runs);
		if(r==0){
			r=sublimate(runs);
		}
		return r;
	}
	public NBTTagCompound writeToNBT(NBTTagCompound tag){
		tag.setTag("gas", gasTank.writeToNBT(new NBTTagCompound()));
		tag.setTag("liquid", liquidTank.writeToNBT(new NBTTagCompound()));
		tag.setTag("ice", iceSlot.serializeNBT());
		tag.setString("type", iceType);
		tag.setInteger("buffer", iceBuffer);
		return tag;
	}
	public void readFromNBT(NBTTagCompound tag){
		gasTank.readFromNBT(tag.getCompoundTag("gas"));
		liquidTank.readFromNBT(tag.getCompoundTag("liquid"));
		iceSlot.deserializeNBT(tag.getCompoundTag("ice"));
		iceType=tag.getString("type");
		iceBuffer=tag.getInteger("buffer");
	}
}
