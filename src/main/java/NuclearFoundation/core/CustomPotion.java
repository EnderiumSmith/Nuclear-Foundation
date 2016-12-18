package NuclearFoundation.core;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class CustomPotion extends Potion{

	public CustomPotion(boolean isBadEffectIn, int liquidColorIn, String name) {
		super(isBadEffectIn, liquidColorIn);
		setPotionName(name);
	}
	
	@Override
	public Potion setIconIndex(int p_76399_1_, int p_76399_2_) {
		return super.setIconIndex(p_76399_1_, p_76399_2_);
	}
	
	@Override
	public boolean isReady(int duration, int amplifier) {
		if(this==PotionRegistry.Arsenic){
			int j = 25 >> amplifier;
            return j > 0 ? duration % j == 0 : true;
		}
		if(this==PotionRegistry.Hydrargyrum){
			int j = 25 >> amplifier+1;
            return j > 0 ? duration % j == 0 : true;
		}
		return true;
	}
	
	@Override
	public void performEffect(EntityLivingBase entity, int level) {
		if(this==PotionRegistry.Radiation){
			if(entity.isNonBoss()){
				entity.attackEntityFrom(Radiation, level+1);
			}
		}
		if(this==PotionRegistry.Arsenic){
			if(!entity.isEntityUndead()){
				entity.attackEntityFrom(Poison, 1);
			}
		}
		if(this==PotionRegistry.Hydrargyrum){
			if(!entity.isEntityUndead()){
				entity.attackEntityFrom(Poison, 1);
			}
		}
	}
	@Override
	public void applyAttributesModifiersToEntity(EntityLivingBase entity,
			AbstractAttributeMap attributeMapIn, int amplifier) {
		if(this==PotionRegistry.Radiation){
			entity.getActivePotionEffect(PotionRegistry.Radiation).getCurativeItems().clear();
		}
		if(this==PotionRegistry.Arsenic){
			entity.getActivePotionEffect(PotionRegistry.Arsenic).getCurativeItems().clear();
		}
		if(this==PotionRegistry.Hydrargyrum){
			entity.getActivePotionEffect(PotionRegistry.Hydrargyrum).getCurativeItems().clear();
		}
	}
	
	public static DamageSource Radiation=new DamageSource("radiation").setDamageBypassesArmor().setDamageIsAbsolute();
	public static DamageSource Poison=new DamageSource("poison").setDamageBypassesArmor();

}
