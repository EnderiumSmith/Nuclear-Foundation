package NuclearFoundation.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class FluidRedstone extends BlockFluidClassic{

	public FluidRedstone() {
		super(FluidManager.DestabilizedRedstone, FluidMaterials.Redstone);
		setRegistryName("destabilized_redstone");
	}
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(entityIn instanceof EntityLivingBase){
			if(((EntityLivingBase)entityIn).getActivePotionEffect(MobEffects.POISON)==null)
				((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, 100));
		}
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	}
	@Override
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return (int)(15F*(float)this.getQuantaPercentage(blockAccess, pos));
	}
	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return true;
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
