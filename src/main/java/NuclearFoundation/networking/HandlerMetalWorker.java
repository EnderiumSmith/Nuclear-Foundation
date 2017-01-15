package NuclearFoundation.networking;

import NuclearFoundation.tile_entity.TileMetalworker;
import NuclearFoundation.tile_entity.TileMetalworker.EnumMetalRecipe;
import NuclearFoundation.networking.MessageMetalWorker;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class HandlerMetalWorker implements IMessageHandler<MessageMetalWorker, IMessage>{
	
	public HandlerMetalWorker() {
		
	}
	@Override
	public IMessage onMessage(final MessageMetalWorker message, final MessageContext ctx) {
		IThreadListener mainThread=(WorldServer)ctx.getServerHandler().playerEntity.worldObj;
		mainThread.addScheduledTask(new Runnable() {
			public void run() {
				TileMetalworker tile=(TileMetalworker)ctx.getServerHandler().playerEntity.worldObj.getTileEntity(new BlockPos(message.x, message.y, message.z));
				if(tile!=null){
					switch(message.id){
					case(0):{
						tile.setRecipe(EnumMetalRecipe.PLATE);
						break;
					}
					case(1):{
						tile.setRecipe(EnumMetalRecipe.GEAR);
						break;
					}
					case(2):{
						tile.setRecipe(EnumMetalRecipe.ROD);
						break;
					}
					case(3):{
						tile.setRecipe(EnumMetalRecipe.NUGGET);
						break;
					}
					case(4):{
						tile.setRecipe(null);
						break;
					}
					default:{
						
					}
					}
					tile.markDirty();
					IBlockState state=ctx.getServerHandler().playerEntity.worldObj.getBlockState(tile.getPos());
					ctx.getServerHandler().playerEntity.worldObj.notifyBlockUpdate(tile.getPos(), state, state, 3);
				}
			}
		});
		return null;
	}
	
}
