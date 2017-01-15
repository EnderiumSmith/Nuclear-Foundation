package NuclearFoundation.blocks.magma_crucible;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IMagmaCrucibleStructureBlock {
	
	public void setMaster(BlockPos pos, World world, BlockPos master);
	
	public boolean hasMaster(BlockPos pos, World world);
	
	public void clearMaster(BlockPos pos, World world);
	
	public BlockPos getMaster(BlockPos pos, World world);
	
	/**
	 * 
	 * @return 0=base, 1=RF, 2=T, 3=RF+T
	 */
	public int getType(BlockPos pos, World world);
}
