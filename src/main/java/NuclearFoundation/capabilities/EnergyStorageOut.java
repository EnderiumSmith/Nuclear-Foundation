package NuclearFoundation.capabilities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.EnergyStorage;

public class EnergyStorageOut extends EnergyStorage{

	public EnergyStorageOut(int capacity, int maxReceive, int maxExtract) {
		super(capacity, maxReceive, maxExtract);
	}
	@Override
	public boolean canReceive() {
		return false;
	}
	public void addEnergy(int in){
		energy+=in;
		if(energy>capacity)
			energy=capacity;
	}
	public NBTTagCompound serializeNBT() {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("energy", energy);
		compound.setInteger("capacity", capacity);
		compound.setInteger("maxReceive", maxReceive);
		compound.setInteger("maxExtract", maxExtract);
		return compound;
	}

	public void deserializeNBT(NBTTagCompound nbt) {
		energy = nbt.getInteger("energy");
		capacity = nbt.getInteger("capacity");
		maxReceive = nbt.getInteger("maxReceive");
		maxExtract = nbt.getInteger("maxExtract");
	}

}
