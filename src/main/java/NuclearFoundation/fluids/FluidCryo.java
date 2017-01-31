package NuclearFoundation.fluids;

import java.util.Random;

import NuclearFoundation.core.MethodUtil;
import NuclearFoundation.core.PotionRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class FluidCryo extends BlockFluidClassic{

	public final int flammability,explosionPower,acidity,poisonDuration;
	public FluidCryo(Fluid fluid,String name) {
		this(fluid,name,0,0,0,0);
	}
	public FluidCryo(Fluid fluid,String name,int flame){
		this(fluid,name,flame,0,0,0);
	}
	public FluidCryo(Fluid fluid,String name,int flame,int power){
		this(fluid,name,flame,power,0,0);
	}
	public FluidCryo(Fluid fluid,String name,int flame,int power,int acid){
		this(fluid,name,flame,power,acid,0);
	}
	/***
	 * 
	 * @param fluid
	 * @param name
	 * @param flame how fast it burns. max 300;
	 * @param power explosion power. negative if it only explodes from another explosion even if flammable
	 * @param acid damage from acid
	 * @param poison duration of poison
	 */
	public FluidCryo(Fluid fluid,String name,int flame,int power,int acid,int poison){
		super(fluid, Material.WATER);
		setRegistryName(name);
		flammability=flame;
		explosionPower=power;
		acidity=acid;
		poisonDuration=poison;
		if(flame>0){
			Blocks.FIRE.setFireInfo(this, 300, flame);
		}
	}
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(entityIn instanceof EntityLivingBase){
			EntityLivingBase entity=(EntityLivingBase)entityIn;
			int h=entity.hurtResistantTime;
			MethodUtil.dealFreezeDamage((EntityLivingBase)entityIn, 1);
			if(acidity>0&&h==0){
				entity.hurtResistantTime=0;
				entity.attackEntityFrom(DamageSource.onFire, acidity);
			}
			if(poisonDuration>0){
				if(entity.getActivePotionEffect(PotionRegistry.Poison)==null){
					entity.addPotionEffect(new PotionEffect(PotionRegistry.Poison, poisonDuration));
				}
			}
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
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return flammability>0;
	}
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return flammability;
	}
	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
		if(explosionPower!=0)
			worldIn.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), Math.abs(explosionPower), true, true);
	}
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(world, pos, state, rand);
		if(explosionPower>0&&flammability>0){
			EnumFacing[] neigbors=EnumFacing.VALUES;
			for(int i=0;i<neigbors.length;i++){
				if(world.getBlockState(pos.offset(neigbors[i])).getBlock()==Blocks.FIRE){
					world.setBlockState(pos, Blocks.FIRE.getDefaultState());
					world.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), Math.abs(explosionPower), true, true);
					break;
				}
			}
		}
	}

}
