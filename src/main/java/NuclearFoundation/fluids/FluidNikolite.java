package NuclearFoundation.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class FluidNikolite extends BlockFluidClassic{

	public FluidNikolite() {
		super(FluidManager.IonizedNikolite, FluidMaterials.Nikolite);
		setRegistryName("ionized_nikolite");
	}
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(entityIn instanceof EntityLivingBase){
			((EntityLivingBase)entityIn).attackEntityFrom(DamageSource.lightningBolt, 1);
		}
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	}
	@Override
	  public Boolean isEntityInsideMaterial(IBlockAccess world, BlockPos blockpos, IBlockState iblockstate, Entity entity, double yToTest, Material materialIn,
	      boolean testingHead) {
	    if ((materialIn == Material.WATER || materialIn == this.blockMaterial)) {
	      return Boolean.TRUE;
	    }
	    return super.isEntityInsideMaterial(world, blockpos, iblockstate, entity, yToTest, materialIn, testingHead);
	  }

}
