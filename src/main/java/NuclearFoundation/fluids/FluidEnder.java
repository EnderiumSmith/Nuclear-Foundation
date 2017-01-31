package NuclearFoundation.fluids;

import NuclearFoundation.core.MethodUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class FluidEnder extends BlockFluidClassic{

	public FluidEnder() {
		super(FluidManager.ResonantEnder, FluidMaterials.Ender);
		setRegistryName("resonant_ender");
	}
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(entityIn instanceof EntityLivingBase/*&&make ender creatures not teleport*/){
			MethodUtil.teleportEntityLivingRandomly((EntityLivingBase)entityIn, 64D, 32D);
		}
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	}
	@Override
	  public Boolean isEntityInsideMaterial(IBlockAccess world, BlockPos blockpos, IBlockState iblockstate, Entity entity, double yToTest, Material materialIn,
	      boolean testingHead) {
	    if (/*&&make ender creature not trigger*/(materialIn == Material.WATER || materialIn == this.blockMaterial)) {
	      return Boolean.TRUE;
	    }
	    return super.isEntityInsideMaterial(world, blockpos, iblockstate, entity, yToTest, materialIn, testingHead);
	  }

}
