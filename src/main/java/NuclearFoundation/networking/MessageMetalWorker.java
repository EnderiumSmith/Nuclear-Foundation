package NuclearFoundation.networking;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageMetalWorker implements IMessage{

	int x,y,z,id;
	public MessageMetalWorker() {
	}
	public MessageMetalWorker(int x,int y,int z,int id){
		this.x=x;
		this.y=y;
		this.z=z;
		this.id=id;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		x=buf.readInt();
		y=buf.readInt();
		z=buf.readInt();
		id=buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {	
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeInt(id);
	}
}
