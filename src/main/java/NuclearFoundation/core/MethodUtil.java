package NuclearFoundation.core;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.SkeletonType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class MethodUtil {
	
	public static Random rand=new Random();
	public static boolean teleportEntityLivingRandomly(EntityLivingBase entity,double range,double rangeV){
		double x = entity.posX + (rand.nextDouble() - 0.5D) * range;
        double y = entity.posY + (rand.nextDouble() - 0.5D) * rangeV;
        double z = entity.posZ + (rand.nextDouble() - 0.5D) * range;
        EnderTeleportEvent event=new EnderTeleportEvent(entity, x, y, z, 0);
        if(!MinecraftForge.EVENT_BUS.post(event)){
        	boolean didTeleport=entity.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ());
        	if(didTeleport){
        		entity.worldObj.playSound((EntityPlayer)null, entity.prevPosX, entity.prevPosY, entity.prevPosZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, entity.getSoundCategory(), 1.0F, 1.0F);
                entity.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                return true;
        	}
        	return false;
        }
        return false;
	}
	public static boolean isBiomeMob(EntityLivingBase e,String b){
		if(e==null){
			return false;
		}
		for(EnumCreatureType creatureType : EnumCreatureType.values()) {
			for(Biome.SpawnListEntry spawnListEntry : Biome.REGISTRY.getObject(new ResourceLocation(b)).getSpawnableList(creatureType)) {
				if(spawnListEntry.entityClass.equals(e.getClass())){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean isEndMob(EntityLivingBase e){
		if(e instanceof EntityShulker||e instanceof EntityDragon||isBiomeMob(e, "sky")){
			return true;
		}
		return false;
	}
	public static boolean isNetherMob(EntityLivingBase e){
		if(e instanceof EntityBlaze||(e instanceof EntitySkeleton&&((EntitySkeleton)e).getSkeletonType()==SkeletonType.WITHER)||isBiomeMob(e, "hell")){
			return true;
		}
		return false;
	}
	public static boolean isColdMob(EntityLivingBase e){
		if(e instanceof EntitySnowman||e instanceof EntityPolarBear||(e instanceof EntitySkeleton&&((EntitySkeleton)e).getSkeletonType()==SkeletonType.STRAY)||isEndMob(e)){
			return true;
		}
		return false;
	}
	public static boolean dealFreezeDamage(EntityLivingBase entity,float damage){
		if(isColdMob(entity)){
			return false;
		}
		if(isNetherMob(entity)){
			damage*=2;
		}
		entity.attackEntityFrom(CustomPotion.Freeze, damage);
		return true;
	}
}
