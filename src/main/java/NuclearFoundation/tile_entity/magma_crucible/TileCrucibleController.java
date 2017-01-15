package NuclearFoundation.tile_entity.magma_crucible;

import NuclearFoundation.blocks.magma_crucible.BlockCrucibleController;
import NuclearFoundation.blocks.magma_crucible.IMagmaCrucibleStructureBlock;
import NuclearFoundation.capabilities.DualEnergyStorage;
import NuclearFoundation.capabilities.ItemStackHandlerAlert;
import NuclearFoundation.crafting.MagmaCrafting;
import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.oredict.OreDictionary;

public class TileCrucibleController extends TileEntity implements ITickable{
	
	public boolean isFormed;
	public int energyType;
	public int progress;
	public int[] burnTime;
	public DualEnergyStorage buffer;
	public ItemStackHandlerAlert input;
	public ItemStackHandler fuel;
	public FluidTank output;
	public MagmaCrafting recipe;
	@CapabilityInject(IItemHandler.class)
	public static Capability<IItemHandler> ITEM=null;
	@CapabilityInject(IFluidHandler.class)
	public static Capability<IFluidHandler> FLUID=null;
	@CapabilityInject(IEnergyStorage.class)
	public static Capability<IEnergyStorage> ENERGY_RF=null;
	@CapabilityInject(ITeslaHolder.class)
	public static Capability<ITeslaHolder> ENERGY_T=null;
	@CapabilityInject(ITeslaConsumer.class)
	public static Capability<ITeslaConsumer> T_IN=null;
	
	public TileCrucibleController() {
		isFormed=false;
		progress=-1;
		buffer=new DualEnergyStorage(80000, 800, 0);
		input=new ItemStackHandlerAlert(1);
		fuel=new ItemStackHandler(2);
		output=new FluidTank(Fluid.BUCKET_VOLUME*8);
		output.setCanFill(false);
		recipe=null;
		energyType=-1;
		burnTime=new int[]{0,0,0,0};
	}
	@Override
	public void update() {
		if(!this.worldObj.isRemote&&isFormed==true){
			//try assign recipe
			if(recipe==null){
				progress=-1;
				recipe=MagmaCrafting.getRecipe(input.getStackInSlot(0));
			}
			//start process
			if(recipe!=null&&progress==-1){
				//if input changed re-check recipe
				if(input.hasChanged){
					if(!recipe.isItemEqual(input.getStackInSlot(0))){
						recipe=null;
					}
				}
				input.hasChanged=false;
				//check if tank has space
				if(recipe!=null&&output.fillInternal(recipe.out, false)==recipe.out.amount){
					progress=recipe.energy;
				}
			}
			//burn fuel
			if(energyType==0){
				for(int f=0;f<2;f++){
					if(burnTime[f]>0){
						burnTime[f]-=5;
						if(progress>0){
							buffer.givePower(75, false);
						}
					}
				}
			}
			//recipe valid
			if(progress>0){
				//if input changed re-check recipe
				if(input.hasChanged){
					if(!recipe.isItemEqual(input.getStackInSlot(0))){
						progress=-1;
						recipe=null;
					}
					input.hasChanged=false;
				}
				//process
				if(progress>0){
					//burn fuel
					if(energyType==0){
						for(int f=0;f<2;f++){
							if(burnTime[f]<=0){
								if(fuel.getStackInSlot(f)!=null&&fuel.getStackInSlot(f).stackSize>0){
									int[] ids=OreDictionary.getOreIDs(fuel.getStackInSlot(f));
									for(int id=0;id<ids.length;id++){
										if(OreDictionary.getOreName(ids[id]).equals("dustPyrotheum")){
											burnTime[f+2]=burnTime[f]=TileEntityFurnace.getItemBurnTime(fuel.getStackInSlot(f));
											fuel.extractItem(f, 1, false);
										}
									}
								}
							}
						}
					}
					//check power level
					if(buffer.getEnergyStored()>=Math.min(400, progress)){
						//we have enough power
						progress-=buffer.takePower(Math.min(400, progress), false);
					}else{
						//not enough power: revert 1/4 of a step
						progress+=Math.min(100, recipe.energy-progress);
					}
				}
			}
			//check if finished
			if(progress==0){
				//try output
				if(output.fillInternal(recipe.out, false)==recipe.out.amount){
					output.fillInternal(recipe.out, true);
					input.extractItem(0, 1, false);
					progress=-1;
				}else if(input.hasChanged){
					if(!recipe.isItemEqual(input.getStackInSlot(0))){
						progress=-1;
						recipe=null;
					}
					input.hasChanged=false;
				}
			}
			sync();
		}
	}
	public void sync(){
		this.markDirty();
		this.worldObj.notifyBlockUpdate(pos, this.worldObj.getBlockState(pos), this.worldObj.getBlockState(pos), 3);
	}
	public boolean checkStructure(){
		EnumFacing blockFacing=this.worldObj.getBlockState(this.pos).getValue(BlockCrucibleController.FACING);
		if(blockFacing==EnumFacing.UP||blockFacing==EnumFacing.DOWN){
			breakStructure();
			System.out.println("magma crucile controller at "+this.pos.toString()+" has an invalid facing (up/down)");
			return false;
		}
		BlockPos controller=this.pos;
		BlockPos centerBase=this.pos.offset(blockFacing.getOpposite());
		//layer 4
		int y=centerBase.getY()+3;
		for(int x=centerBase.getX()-1;x<=centerBase.getX()+1;x++){
			for(int z=centerBase.getZ()-1;z<=centerBase.getZ()+1;z++){
				Block block=this.worldObj.getBlockState(new BlockPos(x, y, z)).getBlock();
				if(block instanceof IMagmaCrucibleStructureBlock){
					IMagmaCrucibleStructureBlock MGSB=(IMagmaCrucibleStructureBlock)block;
					if(MGSB.getType(new BlockPos(x, y, z),this.worldObj)==0){
						if(!MGSB.hasMaster(new BlockPos(x, y, z),this.worldObj)){
							MGSB.setMaster(new BlockPos(x, y, z),this.worldObj,controller);
						}else{
							if(MGSB.getMaster(new BlockPos(x, y, z),this.worldObj)!=null&&!MGSB.getMaster(new BlockPos(x, y, z),this.worldObj).equals(controller)){
								breakStructure();
								return false;
							}else{
								MGSB.setMaster(new BlockPos(x, y, z),this.worldObj,controller);
							}
						}
					}else{
						breakStructure();
						return false;
					}
				}else{
					breakStructure();
					return false;
				}
			}
		}
		//layer 2&&3
		int energyUsed=-1;
		for(y=centerBase.getY()+2;y>centerBase.getY();y--){
			for(int x=centerBase.getX()-1;x<=centerBase.getX()+1;x++){
				for(int z=centerBase.getZ()-1;z<=centerBase.getZ()+1;z++){
					if(x==centerBase.getX()&&z==centerBase.getZ()){
						if(!this.worldObj.getBlockState(new BlockPos(x, y, z)).getBlock().isAir(this.worldObj.getBlockState(new BlockPos(x, y, z)), this.worldObj, new BlockPos(x, y, z))){
							breakStructure();
							return false;
						}
					}else{
						Block block=this.worldObj.getBlockState(new BlockPos(x, y, z)).getBlock();
						if(block instanceof IMagmaCrucibleStructureBlock){
							IMagmaCrucibleStructureBlock MGSB=(IMagmaCrucibleStructureBlock)block;
							if(energyUsed==-1){
								energyUsed=MGSB.getType(new BlockPos(x, y, z),this.worldObj);
							}else{
								if(energyUsed!=-1){
									if(MGSB.getType(new BlockPos(x, y, z),this.worldObj)!=energyUsed){
										breakStructure();
										return false;
									}
								}
								if(!MGSB.hasMaster(new BlockPos(x, y, z),this.worldObj)){
									MGSB.setMaster(new BlockPos(x, y, z),this.worldObj,controller);
								}else{
									if(MGSB.getMaster(new BlockPos(x, y, z),this.worldObj)!=null&&!MGSB.getMaster(new BlockPos(x, y, z),this.worldObj).equals(controller)){
										breakStructure();
										return false;
									}else{
										MGSB.setMaster(new BlockPos(x, y, z),this.worldObj,controller);
									}
								}
							}
						}else{
							breakStructure();
							return false;
						}
					}
				}
			}
		}
		energyType=energyUsed;
		//layer 1
		y=centerBase.getY();
		for(int x=centerBase.getX()-1;x<=centerBase.getX()+1;x++){
			for(int z=centerBase.getZ()-1;z<=centerBase.getZ()+1;z++){
				if(controller.getX()==x&&controller.getZ()==z){
					Block block=this.worldObj.getBlockState(new BlockPos(x, y, z)).getBlock();
					if(!(block instanceof BlockCrucibleController)){
						breakStructure();
						return false;
					}
				}else{
					Block block=this.worldObj.getBlockState(new BlockPos(x, y, z)).getBlock();	
					if(block instanceof IMagmaCrucibleStructureBlock){
						IMagmaCrucibleStructureBlock MGSB=(IMagmaCrucibleStructureBlock)block;
						if(MGSB.getType(new BlockPos(x, y, z),this.worldObj)==0){
							if(!MGSB.hasMaster(new BlockPos(x, y, z),this.worldObj)){
								MGSB.setMaster(new BlockPos(x, y, z),this.worldObj,controller);
							}else{
								if(MGSB.getMaster(new BlockPos(x, y, z),this.worldObj)!=null&&!MGSB.getMaster(new BlockPos(x, y, z),this.worldObj).equals(controller)){
									breakStructure();
									return false;
								}else{
									MGSB.setMaster(new BlockPos(x, y, z),this.worldObj,controller);
								}
							}
						}else{
							breakStructure();
							return false;
						}
					}else{
						breakStructure();
						return false;
					}
				}
			}
		}
		isFormed=true;
		return true;
	}
	//do not call from BlockCrucibleController
	public void breakStructure(){
		breakStructure(null);
	}
	//call from BlockCrucibleController
	public void breakStructure(EnumFacing controllerFacing){
		this.isFormed=false;
		this.energyType=-1;
		this.progress=-1;
		this.burnTime[0]=burnTime[1]=0;
		this.recipe=null;
		EnumFacing blockFacing;
		if(controllerFacing==null){
			blockFacing=this.worldObj.getBlockState(this.pos).getValue(BlockCrucibleController.FACING);
		}else{
			blockFacing=controllerFacing;
		}
		if(blockFacing==EnumFacing.UP||blockFacing==EnumFacing.DOWN){
			isFormed=false;
			System.out.println("magma crucile controller at "+this.pos.toString()+" has an invalid facing (up/down)");
		}
		BlockPos centerBase=this.pos.offset(blockFacing.getOpposite());
		for(int y=centerBase.getY()+3;y>=centerBase.getY();y--){
			for(int x=centerBase.getX()-1;x<=centerBase.getX()+1;x++){
				for(int z=centerBase.getZ()-1;z<=centerBase.getZ()+1;z++){
					Block block=this.worldObj.getBlockState(this.pos).getBlock();
					if(block instanceof IMagmaCrucibleStructureBlock){
						if(((IMagmaCrucibleStructureBlock)block).hasMaster(new BlockPos(x, y, z), this.worldObj)&&((IMagmaCrucibleStructureBlock)block).getMaster(new BlockPos(x, y, z), this.worldObj).equals(this.pos)){
							((IMagmaCrucibleStructureBlock)block).clearMaster(new BlockPos(x, y, z), this.worldObj);
						}
					}
				}
			}
		}
	}
	public void dropInventory(){
		for(int i=0;i<fuel.getSlots();i++){
			if(fuel.getStackInSlot(i)!=null){
				InventoryHelper.spawnItemStack(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ(), fuel.getStackInSlot(i));
			}
		}
		if(input.getStackInSlot(0)!=null){
			InventoryHelper.spawnItemStack(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ(), input.getStackInSlot(0));
		}
	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(isFormed==true){
			if(capability==ITEM||capability==FLUID){
				return true;
			}
			if(capability==ENERGY_RF&&(energyType==1||energyType==3)){
				return true;
			}
			if((capability==ENERGY_T||capability==T_IN)&&(energyType==2||energyType==3)){
				return true;
			}
		}
		return super.hasCapability(capability, facing);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability==ITEM){
			return (T)input;
		}
		if(capability==FLUID){
			return (T)output;
		}
		if(capability==ENERGY_RF&&(energyType==1||energyType==3)){
			return (T)buffer;
		}
		if((capability==ENERGY_T||capability==T_IN)&&(energyType==2||energyType==3)){
			return (T)buffer;
		}
		return super.getCapability(capability, facing);
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("progress", progress);
		compound.setIntArray("burntime", burnTime);
		compound.setBoolean("formed", isFormed);
		compound.setInteger("type", energyType);
		compound.setTag("energy", buffer.serializeNBT());
		compound.setTag("item", input.serializeNBT());
		compound.setTag("fuel", fuel.serializeNBT());
		output.writeToNBT(compound);
		compound.setInteger("recipe", MagmaCrafting.getIndex(recipe));
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		progress=compound.getInteger("progress");
		burnTime=compound.getIntArray("burntime");
		isFormed=compound.getBoolean("formed");
		energyType=compound.getInteger("type");
		buffer.deserializeNBT(compound.getCompoundTag("energy"));
		input.deserializeNBT(compound.getCompoundTag("item"));
		fuel.deserializeNBT(compound.getCompoundTag("fuel"));
		output.readFromNBT(compound);
		int r=compound.getInteger("recipe");
		if(r!=-1){
			recipe=MagmaCrafting.recipes.get(r);
		}else
			recipe=null;
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
