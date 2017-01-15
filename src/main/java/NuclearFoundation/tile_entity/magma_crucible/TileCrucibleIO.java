package NuclearFoundation.tile_entity.magma_crucible;

import NuclearFoundation.blocks.magma_crucible.IMagmaCrucibleStructureBlock;
import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;

public class TileCrucibleIO extends TileEntity implements IMagmaCrucibleStructureBlock,ITickable{

	public int type;
	public BlockPos master;
	@CapabilityInject(IItemHandler.class)
	private static Capability<IItemHandler> ITEM_CAPABILITY=null;
	@CapabilityInject(IEnergyStorage.class)
	private static Capability<IEnergyStorage> ENERGY_RF=null;
	@CapabilityInject(IFluidHandler.class)
	private static Capability<IFluidHandler> FLUID=null;
	@CapabilityInject(ITeslaConsumer.class)
	private static Capability<ITeslaConsumer> TESLA_IN=null;
	@CapabilityInject(ITeslaHolder.class)
	private static Capability<ITeslaHolder> ENERGY_T=null;
	public TileCrucibleIO() {
		this.type=-1;
		master=null;
	}
	public TileCrucibleIO(int type){
		this.type=type;
		master=null;
	}
	@Override
	public void update() {
		if(!this.worldObj.isRemote){
			if(type==0&&master.getY()==this.pos.getY()){
				TileCrucibleController tile=(TileCrucibleController)this.worldObj.getTileEntity(master);
				if(tile.isFormed){
					EnumFacing[] neighbors=EnumFacing.VALUES;
					for(int i=0;i<neighbors.length;i++){
						TileEntity tile2=this.worldObj.getTileEntity(this.pos.offset(neighbors[i]));
						if(tile2!=null&&!(tile2 instanceof IMagmaCrucibleStructureBlock||tile2 instanceof TileCrucibleController)){
							if(tile2.hasCapability(FLUID, neighbors[i].getOpposite())){
								IFluidHandler capability=tile2.getCapability(FLUID, neighbors[i].getOpposite());
								IFluidHandler source=tile.getCapability(FLUID, null);
								source.drain(capability.fill(tile.output.getFluid(), true), true);
							}
						}
					}
				}
			}
		}
		
	}
	@Override
	public void setMaster(BlockPos pos, World world, BlockPos master) {
		this.master=master;
	}
	@Override
	public boolean hasMaster(BlockPos pos, World world) {
		return this.master!=null;
	}
	@Override
	public void clearMaster(BlockPos pos, World world) {
		this.master=null;
	}
	@Override
	public BlockPos getMaster(BlockPos pos, World world) {
		return this.master;
	}
	@Override
	public int getType(BlockPos pos, World world) {
		return this.type;
	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(master!=null&&this.worldObj.getTileEntity(master)instanceof TileCrucibleController){
			if(type==0&&(capability==ITEM_CAPABILITY||capability==FLUID))
				return this.worldObj.getTileEntity(master).hasCapability(capability, null);
			if((type==1||type==3)&&capability==ENERGY_RF)
				return this.worldObj.getTileEntity(master).hasCapability(capability, null);;
			if((type==2||type==3)&&(capability==ENERGY_T||capability==TESLA_IN))
				return this.worldObj.getTileEntity(master).hasCapability(capability, null);;
		}
		return super.hasCapability(capability, facing);
	}
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(type==0&&capability==ITEM_CAPABILITY){
			return (T)this.worldObj.getTileEntity(master).getCapability(capability, null);
		}
		if(type==0&&capability==FLUID){
			return (T)this.worldObj.getTileEntity(master).getCapability(capability, null);
		}
		if((type==1||type==3)&&capability==ENERGY_RF){
			return (T)this.worldObj.getTileEntity(master).getCapability(capability, null);
		}
		if((type==2||type==3)&&capability==ENERGY_T){
			return (T)this.worldObj.getTileEntity(master).getCapability(capability, null);
		}
		if((type==2||type==3)&&capability==TESLA_IN){
			return (T)this.worldObj.getTileEntity(master).getCapability(capability, null);
		}
		return super.getCapability(capability, facing);
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("type", type);
		if(master!=null){
			compound.setLong("master", master.toLong());
		}
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		type=compound.getInteger("type");
		if(compound.hasKey("master")){
			master=BlockPos.fromLong(compound.getLong("master"));
		}
	}
	
	
}
