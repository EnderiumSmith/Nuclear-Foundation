package NuclearFoundation.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class FluidGlowstone extends BlockFluidClassic{

	public FluidGlowstone(Fluid fluid, String name, Material material) {
		super(fluid, material);
		setRegistryName(name);
	}
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(entityIn instanceof EntityLivingBase){
			EntityLivingBase entity=(EntityLivingBase)entityIn;
			if (entity.motionY < -0.2) {
				entity.motionY *= 0.5;
				if (entity.fallDistance > 20) {
					entity.fallDistance = 20;
				} else {
					entity.fallDistance *= 0.95;
				}
			}
			entity.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 120));
			entity.addPotionEffect(new PotionEffect(MobEffects.SPEED, 120));
			entity.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 120));
		}
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	}

}
