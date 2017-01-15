package NuclearFoundation.tile_entity;

import NuclearFoundation.core.Config;
import NuclearFoundation.items.ItemManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.oredict.OreDictionary;

public class TileMetalworker extends TileEntity{
	
	public ItemStack[] inventory=new ItemStack[2];
	public int Progress;
	public final int MaxProgress=18;
	public EnumMetalRecipe currentRecipe=null;
	@CapabilityInject(IItemHandler.class)
	public static Capability<IItemHandler> ITEM_HANDLER_CAPABILITY=null;
	public IItemHandler guiHandler=new MWIH(inventory);
	public IItemHandler invHandler=new MWIHEx(inventory);
	public TileMetalworker() {
		Progress=0;
	}
	public void Crank(EntityLivingBase player){
		if(this.currentRecipe!=null&&this.Progress>0&&isInputAmountValid()){
			((EntityPlayer)player).getHeldItemMainhand().damageItem(1, player);
			processRecipe();
		}
		else if(this.currentRecipe!=null&&isInputAmountValid()&&isInputItemValid()){
			((EntityPlayer)player).getHeldItemMainhand().damageItem(1, player);
			processRecipe();
		}
		else
			this.Progress=0;
	}
	public void processRecipe(){
		this.Progress++;
		if(this.Progress>=this.MaxProgress){
				int[] ids=OreDictionary.getOreIDs(this.inventory[0]);
				for(int i=0;i<ids.length;i++){
					String ore=OreDictionary.getOreName(ids[i]);
					if(ore.startsWith("ingot")){
						String result=getOutputPrefix()+ore.substring(5);
						if(!OreDictionary.getOres(result).isEmpty()){
							ItemStack out=OreDictionary.getOres(result).get(0).copy();
							if(this.currentRecipe==EnumMetalRecipe.PLATE){
								out.stackSize=Config.PlatePerIngot;
							}else if(this.currentRecipe==EnumMetalRecipe.GEAR){
								out.stackSize=Config.GearPerIngot;
							}else if(this.currentRecipe==EnumMetalRecipe.ROD){
								out.stackSize=Config.RodPerIngot;
							}else if(this.currentRecipe==EnumMetalRecipe.NUGGET){
								out.stackSize=Config.NuggetPerIngot;
							}
							if(inventory[1]==null||(inventory[1].isItemEqual(out)&&inventory[1].stackSize+out.stackSize<=inventory[1].getMaxStackSize())){
								if(inventory[1]==null){
									inventory[1]=out.copy();
								}
								else{
									inventory[1].stackSize+=out.stackSize;
								}
								this.Progress=0;
								if(this.currentRecipe==EnumMetalRecipe.PLATE){
									inventory[0].stackSize-=Config.IngotPerPlate;
								}else if(this.currentRecipe==EnumMetalRecipe.GEAR){
									inventory[0].stackSize-=Config.IngotPerGear;
								}else if(this.currentRecipe==EnumMetalRecipe.ROD){
									inventory[0].stackSize-=Config.IngotPerRod;
								}else if(this.currentRecipe==EnumMetalRecipe.NUGGET){
									inventory[0].stackSize-=Config.IngotPerNugget;
								}
								if(inventory[0].stackSize<=0){
									inventory[0]=null;
								}
							}
						}
						this.Progress=0;
				}
			}
		}
		this.markDirty();
		this.worldObj.notifyBlockUpdate(pos, this.worldObj.getBlockState(pos), this.worldObj.getBlockState(pos), 3);
	}
	public boolean isInputAmountValid(){
		if(this.currentRecipe==EnumMetalRecipe.PLATE){
			if(this.inventory[0]!=null&&this.inventory[0].stackSize>=Config.IngotPerPlate){
				return true;
			}
			return false;
		}
		if(this.currentRecipe==EnumMetalRecipe.GEAR){
			if(this.inventory[0]!=null&&this.inventory[0].stackSize>=Config.IngotPerGear){
				return true;
			}
			return false;
		}
		if(this.currentRecipe==EnumMetalRecipe.ROD){
			if(this.inventory[0]!=null&&this.inventory[0].stackSize>=Config.IngotPerRod){
				return true;
			}
			return false;
		}
		if(this.currentRecipe==EnumMetalRecipe.NUGGET){
			if(this.inventory[0]!=null&&this.inventory[0].stackSize>=Config.IngotPerNugget){
				return true;
			}
			return false;
		}
		return false;
	}
	public boolean isInputItemValid(){
		if(this.inventory[0]!=null&&this.currentRecipe!=null){
			int[] ids=OreDictionary.getOreIDs(this.inventory[0]);
			for(int i=0;i<ids.length;i++){
				String ore=OreDictionary.getOreName(ids[i]);
				if(ore.startsWith("ingot")){
					String result=getOutputPrefix()+ore.substring(5);
					if(!OreDictionary.getOres(result).isEmpty()){
						return true;
					}
				}
			}
		}
		return false;
	}
	public String getOutputPrefix(){
		if(this.currentRecipe==EnumMetalRecipe.PLATE){
			return "plate";
		}
		if(this.currentRecipe==EnumMetalRecipe.GEAR){
			return "gear";
		}
		if(this.currentRecipe==EnumMetalRecipe.ROD){
			return "rod";
		}
		if(this.currentRecipe==EnumMetalRecipe.NUGGET){
			return "nugget";
		}
		return null;
	}
	public boolean setRecipe(EnumMetalRecipe recipe){
		if(currentRecipe==recipe)
			return false;
		else{
			currentRecipe=recipe;
			Progress=0;
			return true;
		}
	}
	public void dropInventory(){
		for(int i=0;i<inventory.length;i++){
			if(inventory[i]!=null){
				InventoryHelper.spawnItemStack(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ(), inventory[i]);
			}
		}
	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability==ITEM_HANDLER_CAPABILITY){
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability==ITEM_HANDLER_CAPABILITY){
			if(facing==null){
				return (T)guiHandler;
			}
			return (T)invHandler;
		}
		return super.getCapability(capability, facing);
	}
	public class MWIH extends ItemStackHandler{
		
		public MWIH(ItemStack[] inv) {
			super(inv);
		}
		@Override
		public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
			if(slot==1)
				return stack;
			return super.insertItem(slot, stack, simulate);
		}
	}
	public class MWIHEx extends MWIH{
		
		public MWIHEx(ItemStack[] inv) {
			super(inv);
		}
		@Override
		public ItemStack extractItem(int slot, int amount, boolean simulate) {
			if(slot==0)
				return null;
			return super.extractItem(slot, amount, simulate);
		}
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("progress", Progress);
		if(currentRecipe!=null)
			compound.setByte("recipe", currentRecipe.getId());
		NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inventory.length; ++i)
        {
            if (this.inventory[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.inventory[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        compound.setTag("Items", nbttaglist);
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.Progress=compound.getInteger("progress");
		if(compound.hasKey("recipe")){
			for(EnumMetalRecipe e:EnumMetalRecipe.values()){
				if(e.getId()==compound.getByte("recipe")){
					this.currentRecipe=e;
					break;
				}
			}
		}
		else{
			currentRecipe=null;
		}
		NBTTagList nbttaglist = compound.getTagList("Items", 10);

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot") & 255;

            if (j >= 0 && j < this.inventory.length)
            {
                this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
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
	public enum EnumMetalRecipe{
		PLATE(0,new ItemStack(ItemManager.Plate,1,27)),
		GEAR(1,new ItemStack(ItemManager.Gear,1,27)),
		ROD(2,new ItemStack(ItemManager.Rod,1,27)),
		NUGGET(3,new ItemStack(ItemManager.Nugget,1,27));
		private ItemStack location;
		private byte id;
		private EnumMetalRecipe(int id,ItemStack loc) {
			location=loc;
			this.id=(byte)id;
		}
		public ItemStack getLocation(){
			return location;
		}
		public byte getId(){
			return id;
		}
	}
}
