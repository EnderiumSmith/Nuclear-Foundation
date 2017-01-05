package NuclearFoundation.core;

import java.util.List;
import java.util.Random;

import NuclearFoundation.items.ItemSpecialWeapon;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
	Random rand=new Random();
	@SubscribeEvent
	public void LivingHurtEvent(net.minecraftforge.event.entity.living.LivingHurtEvent event) {
		//armor
		if(Config.IsArmorEnebled&&event.getEntity()instanceof EntityPlayer){
			if(event.getSource().equals(DamageSource.lightningBolt))
				event.setAmount(event.getAmount()*getElectricMultiplier((EntityPlayer)event.getEntity()));
			if(event.getSource().isFireDamage())
				event.setAmount(event.getAmount()*getFireMultiplier((EntityPlayer)event.getEntity()));
			if(event.getSource().isMagicDamage())
				event.setAmount(event.getAmount()*getTearMultiplier((EntityPlayer)event.getEntity()));
			if(!event.getSource().isExplosion()&&!event.getSource().isFireDamage()&&!event.getSource().isMagicDamage()&&!event.getSource().isProjectile()){
				if(event.getSource().getSourceOfDamage()instanceof EntityLivingBase&&getSapphireSet((EntityPlayer)event.getEntity())>0){
					EntityLivingBase attacker=(EntityLivingBase)event.getSource().getSourceOfDamage();
					attacker.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 101));
					int i=attacker.hurtResistantTime;
					attacker.hurtResistantTime=0;
					attacker.attackEntityFrom(DamageSource.causeThornsDamage(event.getEntity()), getSapphireSet((EntityPlayer)event.getEntity()));
					attacker.hurtResistantTime=i;
				}
				if(event.getSource().getSourceOfDamage()instanceof EntityLivingBase&&(event.getSource().getSourceOfDamage()instanceof EntityShulker||
						event.getSource().getSourceOfDamage()instanceof EntityDragon||isBiomeMob((EntityLivingBase)event.getSource().getSourceOfDamage(), "sky"))){
					float i=getPsychicMultiplier((EntityPlayer)event.getEntity());
					event.setAmount(event.getAmount()*i);
					EntityLivingBase attacker=(EntityLivingBase)event.getSource().getSourceOfDamage();
					int j=attacker.hurtResistantTime;
					attacker.hurtResistantTime=0;
					attacker.attackEntityFrom(DamageSource.causeMobDamage(attacker), event.getAmount()*(1F-i));
					attacker.hurtResistantTime=j;
				}
			}
			if(event.getSource().isExplosion()&&event.getSource().getSourceOfDamage()instanceof EntityCreeper){
				event.setAmount(event.getAmount()*getCreeperMultiplier((EntityPlayer)event.getEntity()));
			}
		}
		//weapon
		if(Config.IsToolsEnabled&&event.getSource().getSourceOfDamage()instanceof EntityPlayer&&
				event.getSource().isProjectile()==false){
			//2x vs guardian
			if(event.getEntity()instanceof EntityGuardian){
				ItemStack item=((EntityPlayer)(event.getSource().getSourceOfDamage())).getHeldItemMainhand();
				if(item!=null){
					if(item.getItem()instanceof ItemTool){
						if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.Orichalcum)
							event.setAmount(event.getAmount()*2F);
					}
					if(item.getItem()instanceof ItemSword){
						if(((ItemSword)(item.getItem())).getToolMaterialName().equals("Orichalcum"))
							event.setAmount(event.getAmount()*2F);
					}
					if(item.getItem()instanceof ItemSpecialWeapon){
						if(((ItemSpecialWeapon)(item.getItem())).toolMaterial==ToolMaterials.Orichalcum)
							event.setAmount(event.getAmount()*2F);
					}
					if(item.getItem()instanceof ItemHoe){
						if(((ItemHoe)(item.getItem())).getMaterialName().equals("Orichalcum"))
							event.setAmount(event.getAmount()*2F);
					}
				}
			}
			//poison
			if(event.getEntityLiving()!=null){
				ItemStack item=((EntityPlayer)(event.getSource().getSourceOfDamage())).getHeldItemMainhand();
				if(item!=null){
					if(item.getItem()instanceof ItemTool){
						if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.MithrilBronze)
							event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.POISON, 101));
					}
					if(item.getItem()instanceof ItemSword){
						if(((ItemSword)(item.getItem())).getToolMaterialName().equals("MithrilBronze"))
							event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.POISON, 101));
					}
					if(item.getItem()instanceof ItemHoe){
						if(((ItemHoe)(item.getItem())).getMaterialName().equals("MithrilBronze"))
							event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.POISON, 101));
					}
				}
			}
			//tear steel
			{
				ItemStack item=((EntityPlayer)(event.getSource().getSourceOfDamage())).getHeldItemMainhand();
				if(item!=null){
					if(item.getItem()instanceof ItemTool){
						if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.TearSteel)
							event.getSource().setDamageIsAbsolute();
					}
					if(item.getItem()instanceof ItemSword){
						if(((ItemSword)(item.getItem())).getToolMaterialName().equals("TearSteel"))
							event.getSource().setDamageIsAbsolute();
					}
					if(item.getItem()instanceof ItemHoe){
						if(((ItemHoe)(item.getItem())).getMaterialName().equals("TearSteel"))
							event.getSource().setDamageIsAbsolute();
					}
				}
			}
			//uranium radiation
			if(event.getEntityLiving()!=null){
				ItemStack item=((EntityPlayer)(event.getSource().getSourceOfDamage())).getHeldItemMainhand();
				if(item!=null){
					if(item.getItem()instanceof ItemTool){
						if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.Uranium)
							if(rand.nextFloat()<0.10F)
								event.getEntityLiving().addPotionEffect(new PotionEffect(PotionRegistry.Radiation, 101));
					}
					if(item.getItem()instanceof ItemSword){
						if(((ItemSword)(item.getItem())).getToolMaterialName().equals("Uranium"))
							if(rand.nextFloat()<0.10F)
								event.getEntityLiving().addPotionEffect(new PotionEffect(PotionRegistry.Radiation, 101));
					}
					if(item.getItem()instanceof ItemHoe){
						if(((ItemHoe)(item.getItem())).getMaterialName().equals("Uranium"))
							if(rand.nextFloat()<0.10F)
								event.getEntityLiving().addPotionEffect(new PotionEffect(PotionRegistry.Radiation, 101));
					}
				}
			}
			//blazonium
			if(event.getEntityLiving()!=null){
				ItemStack item=((EntityPlayer)(event.getSource().getSourceOfDamage())).getHeldItemMainhand();
				if(item!=null){
					if(item.getItem()instanceof ItemTool){
						if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.Blazonium){
								event.getEntityLiving().addPotionEffect(new PotionEffect(PotionRegistry.Radiation, 101));
								event.getEntityLiving().setFire(12);
						}
					}
					if(item.getItem()instanceof ItemSword){
						if(((ItemSword)(item.getItem())).getToolMaterialName().equals("Blazonium")){
								event.getEntityLiving().addPotionEffect(new PotionEffect(PotionRegistry.Radiation, 101));
								event.getEntityLiving().setFire(12);
						}
					}
					if(item.getItem()instanceof ItemHoe){
						if(((ItemHoe)(item.getItem())).getMaterialName().equals("Blazonium")){
								event.getEntityLiving().addPotionEffect(new PotionEffect(PotionRegistry.Radiation, 101));
								event.getEntityLiving().setFire(12);
						}
					}
				}
			}
			//tiger eye
			if(event.getEntity()instanceof EntityCreeper){
				ItemStack item=((EntityPlayer)(event.getSource().getSourceOfDamage())).getHeldItemMainhand();
				if(item!=null){
					if(item.getItem()instanceof ItemTool){
						if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.TigerEye)
							event.setAmount(event.getAmount()*2F);
					}
					if(item.getItem()instanceof ItemSword){
						if(((ItemSword)(item.getItem())).getToolMaterialName().equals("TigerEye"))
							event.setAmount(event.getAmount()*2F);
					}
					if(item.getItem()instanceof ItemHoe){
						if(((ItemHoe)(item.getItem())).getMaterialName().equals("TigerEye"))
							event.setAmount(event.getAmount()*2F);
					}
				}
			}
			//sapphire
			if(event.getEntityLiving()!=null){
				ItemStack item=((EntityPlayer)(event.getSource().getSourceOfDamage())).getHeldItemMainhand();
				if(item!=null){
					if(item.getItem()instanceof ItemTool){
						if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.Sapphire){
							event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 101));
							if(isBiomeMob(event.getEntityLiving(), "hell")){
								event.setAmount(event.getAmount()*1.5F);
							}
						}
					}
					if(item.getItem()instanceof ItemSword){
						if(((ItemSword)(item.getItem())).getToolMaterialName().equals("Sapphire")){
							event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 101));
							if(isBiomeMob(event.getEntityLiving(), "hell")){
								event.setAmount(event.getAmount()*1.5F);
							}
						}
					}
					if(item.getItem()instanceof ItemHoe){
						if(((ItemHoe)(item.getItem())).getMaterialName().equals("Sapphire")){
							event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 101));
							if(isBiomeMob(event.getEntityLiving(), "hell")){
								event.setAmount(event.getAmount()*1.5F);
							}
						}
					}
				}
			}
			//amethist
			if(event.getEntityLiving()!=null){
				ItemStack item=((EntityPlayer)(event.getSource().getSourceOfDamage())).getHeldItemMainhand();
				if(item!=null){
					if(item.getItem()instanceof ItemTool){
						if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.Amethyst){
							if(event.getEntityLiving()instanceof EntityShulker||event.getEntityLiving()instanceof EntityDragon||isBiomeMob(event.getEntityLiving(), "sky")){
								event.setAmount(event.getAmount()*1.5F);
							}
						}
					}
					if(item.getItem()instanceof ItemSword){
						if(((ItemSword)(item.getItem())).getToolMaterialName().equals("Amethyst")){
							if(event.getEntityLiving()instanceof EntityShulker||event.getEntityLiving()instanceof EntityDragon||isBiomeMob(event.getEntityLiving(), "sky")){
								event.setAmount(event.getAmount()*1.5F);
							}
						}
					}
					if(item.getItem()instanceof ItemHoe){
						if(((ItemHoe)(item.getItem())).getMaterialName().equals("Amethyst")){
							if(event.getEntityLiving()instanceof EntityShulker||event.getEntityLiving()instanceof EntityDragon||isBiomeMob(event.getEntityLiving(), "sky")){
								event.setAmount(event.getAmount()*1.5F);
							}
						}
					}
				}
			}
			//ruby
			if(event.getEntityLiving()!=null){
				ItemStack item=((EntityPlayer)(event.getSource().getSourceOfDamage())).getHeldItemMainhand();
				if(item!=null){
					if(item.getItem()instanceof ItemTool){
						if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.Ruby){
							int f=EnchantmentHelper.getFireAspectModifier((EntityLivingBase)event.getSource().getSourceOfDamage());
							event.getEntityLiving().setFire(4*(f+1));
						}
					}
					if(item.getItem()instanceof ItemSword){
						if(((ItemSword)(item.getItem())).getToolMaterialName().equals("Ruby")){
							int f=EnchantmentHelper.getFireAspectModifier((EntityLivingBase)event.getSource().getSourceOfDamage());
							event.getEntityLiving().setFire(4*(f+1));
						}
					}
					if(item.getItem()instanceof ItemHoe){
						if(((ItemHoe)(item.getItem())).getMaterialName().equals("Ruby")){
							int f=EnchantmentHelper.getFireAspectModifier((EntityLivingBase)event.getSource().getSourceOfDamage());
							event.getEntityLiving().setFire(4*(f+1));
						}
					}
				}
			}
		}

	}
	public float getTearMultiplier(EntityPlayer player){
		float tear=1F;
		for(byte i=0;i<4;i++){
			ItemStack armor=player.inventory.armorInventory[i];
			if(armor!=null&&armor.getItem() instanceof ItemArmor&&((ItemArmor) armor.getItem()).getArmorMaterial()==ArmorMaterials.TearSteel)
				tear-=0.2F;
		}
		return tear;
	}
	public float getElectricMultiplier(EntityPlayer player){
		float electric=1F;
		for(byte i=0;i<4;i++){
			ItemStack armor=player.inventory.armorInventory[i];
			if(armor!=null&&armor.getItem() instanceof ItemArmor&&((ItemArmor) armor.getItem()).getArmorMaterial()==ArmorMaterials.Electrum)
				electric-=0.25F;
		}
		return electric;
	}
	public float getFireMultiplier(EntityPlayer player){
		float fire=1F;
		for(byte i=0;i<4;i++){
			ItemStack armor=player.inventory.armorInventory[i];
			if(armor!=null&&armor.getItem() instanceof ItemArmor&&(((ItemArmor)armor.getItem()).getArmorMaterial()==ArmorMaterials.Enderium||((ItemArmor)armor.getItem()).getArmorMaterial()==ArmorMaterials.TungstenSteel))
				fire-=0.1F;
			if(armor!=null&&armor.getItem() instanceof ItemArmor&&(((ItemArmor)armor.getItem()).getArmorMaterial()==ArmorMaterials.Ruby))
				fire-=0.15F;
		}
		return fire;
	}
	public int getSapphireSet(EntityPlayer player){
		int j=0;
		for(byte i=0;i<4;i++){
			ItemStack armor=player.inventory.armorInventory[i];
			if(armor!=null&&armor.getItem() instanceof ItemArmor&&(((ItemArmor)armor.getItem()).getArmorMaterial()==ArmorMaterials.Sapphire))
				j++;
		}
		return j;
	}
	public float getPsychicMultiplier(EntityPlayer player){
		float psychic=1F;
		for(byte i=0;i<4;i++){
			ItemStack armor=player.inventory.armorInventory[i];
			if(armor!=null&&armor.getItem() instanceof ItemArmor&&((ItemArmor) armor.getItem()).getArmorMaterial()==ArmorMaterials.Amethyst)
				psychic-=0.1F;
		}
		return psychic;
	}
	public float getCreeperMultiplier(EntityPlayer player){
		float creep=1F;
		for(byte i=0;i<4;i++){
			ItemStack armor=player.inventory.armorInventory[i];
			if(armor!=null&&armor.getItem() instanceof ItemArmor&&((ItemArmor) armor.getItem()).getArmorMaterial()==ArmorMaterials.TigerEye)
				creep-=0.2F;
		}
		return creep;
	}
	public boolean isBiomeMob(EntityLivingBase e,String b){
		for(EnumCreatureType creatureType : EnumCreatureType.values()) {
			for(Biome.SpawnListEntry spawnListEntry : Biome.REGISTRY.getObject(new ResourceLocation(b)).getSpawnableList(creatureType)) {
				if(spawnListEntry.entityClass.equals(e.getClass())){
					return true;
				}
			}
		}
		return false;
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event){
		if(event.getEntityLiving().getActivePotionEffect(PotionRegistry.Arsenic)!=null){
			PotionEffect Arsenic=event.getEntityLiving().getActivePotionEffect(PotionRegistry.Arsenic);
			if(event.getEntityLiving().isPotionActive(MobEffects.SLOWNESS)==false){
				event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, Arsenic.getDuration()*Math.max(2-Arsenic.getAmplifier(), 1), Arsenic.getAmplifier()));
			}
			if(event.getEntityLiving().isPotionActive(MobEffects.MINING_FATIGUE)==false){
				event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, Arsenic.getDuration()*Math.max(2-Arsenic.getAmplifier(), 1), Arsenic.getAmplifier()));
			}
			if(event.getEntityLiving().isPotionActive(MobEffects.NAUSEA)==false){
				event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.NAUSEA, Arsenic.getDuration()*Math.max(2-Arsenic.getAmplifier(), 1), Arsenic.getAmplifier()));
			}
			if(event.getEntityLiving().isPotionActive(MobEffects.HUNGER)==false){
				event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.HUNGER, Arsenic.getDuration()*Math.max(2-Arsenic.getAmplifier(), 1), Arsenic.getAmplifier()));
			}
			if(event.getEntityLiving().isPotionActive(MobEffects.WEAKNESS)==false){
				event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, Arsenic.getDuration()*Math.max(2-Arsenic.getAmplifier(), 1), Arsenic.getAmplifier()));
			}
		}
		if(event.getEntityLiving().getActivePotionEffect(PotionRegistry.Hydrargyrum)!=null){
			PotionEffect Mercury=event.getEntityLiving().getActivePotionEffect(PotionRegistry.Hydrargyrum);
			if(event.getEntityLiving().isPotionActive(MobEffects.BLINDNESS)==false){
				event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, Mercury.getDuration()*Math.max(2-Mercury.getAmplifier(), 1), 0));
			}
			if(event.getEntityLiving().isPotionActive(MobEffects.UNLUCK)==false){
				event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.UNLUCK, Mercury.getDuration()*Math.max(2-Mercury.getAmplifier(), 1), Mercury.getAmplifier()));
			}
		}
	}
	@SubscribeEvent
	public void onDrop(HarvestDropsEvent event){
		if(Config.IsToolsEnabled&&!event.getWorld().isRemote&&event.getHarvester()!=null&&isBlazonium(event.getHarvester())){
			for(int i=0;i<event.getDrops().size();i++){
				if(event.getDrops().get(i)!=null){
					if(FurnaceRecipes.instance().getSmeltingResult(event.getDrops().get(i))!=null){
						event.getDrops().set(i, FurnaceRecipes.instance().getSmeltingResult(event.getDrops().get(i)).copy());
					}
				}
			}
		}
		if(Config.IsToolsEnabled&&!event.getWorld().isRemote&&event.getHarvester()!=null&&isEmerald(event.getHarvester())){
			if(event.isSilkTouching()==false&&event.getFortuneLevel()<=Config.MaxGreed){
				List<ItemStack> list=event.getDrops();
				list.clear();
				List<ItemStack> newlist=event.getState().getBlock().getDrops(event.getWorld(), event.getPos(), event.getState(), event.getFortuneLevel()+1);
				for(int i=0;i<newlist.size();i++){
					list.add(newlist.get(i).copy());
				}
			}
		}
	}
	public boolean isBlazonium(EntityPlayer player){
		ItemStack item=player.getHeldItemMainhand();
		if(item==null)
			return false;
		if(item.getItem()instanceof ItemTool){
			if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.Blazonium)
					return true;
		}
		if(item.getItem()instanceof ItemSword){
			if(((ItemSword)(item.getItem())).getToolMaterialName().equals("Blazonium"))
					return true;
		}
		if(item.getItem()instanceof ItemHoe){
			if(((ItemHoe)(item.getItem())).getMaterialName().equals("Blazonium"))
					return true;
		}
		return false;
	}
	public boolean isEmerald(EntityPlayer player){
		ItemStack item=player.getHeldItemMainhand();
		if(item==null)
			return false;
		if(item.getItem()instanceof ItemTool){
			if(((ItemTool)(item.getItem())).getToolMaterial()==ToolMaterials.Emerald)
					return true;
		}
		if(item.getItem()instanceof ItemSword){
			if(((ItemSword)(item.getItem())).getToolMaterialName().equals("Emerald"))
					return true;
		}
		if(item.getItem()instanceof ItemHoe){
			if(((ItemHoe)(item.getItem())).getMaterialName().equals("Emerald"))
					return true;
		}
		return false;
	}
}
