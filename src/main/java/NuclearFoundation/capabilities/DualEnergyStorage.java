package NuclearFoundation.capabilities;

import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.ITeslaProducer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.EnergyStorage;

public class DualEnergyStorage extends EnergyStorage implements ITeslaConsumer,ITeslaProducer,ITeslaHolder{

	public DualEnergyStorage(int capacity) {
		super(capacity);
	}
	public DualEnergyStorage(int capacity, int maxTransfer) {
		super(capacity, maxTransfer);
	}
	public DualEnergyStorage(int capacity, int maxReceive, int maxExtract) {
		super(capacity, maxReceive, maxExtract);
	}
	@Override
	public long getStoredPower() {
		return getEnergyStored();
	}
	@Override
	public long getCapacity() {
		return getMaxEnergyStored();
	}
	@Override
	public long takePower(long power, boolean simulated) {
        int energyExtracted = Math.min(energy, (int)power);
        if (!simulated)
            energy -= energyExtracted;
        return energyExtracted;
	}
	@Override
	public long givePower(long power, boolean simulated) {
        int energyReceived = Math.min(capacity - energy, (int)power);
        if (!simulated)
            energy += energyReceived;
        return energyReceived;
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
