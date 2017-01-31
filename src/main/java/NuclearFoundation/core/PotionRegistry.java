package NuclearFoundation.core;

import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PotionRegistry {
	
	public static <T extends Potion>T registerPotions(T potion){
		potion.setRegistryName(potion.getName());
		GameRegistry.register(potion);
		return potion;
	}
	
	public static CustomPotion Radiation;
	public static CustomPotion Arsenic;
	public static CustomPotion Hydrargyrum;
	public static CustomPotion CarbonMonoxyde;
	public static CustomPotion Poison;
	
	public static void init(){
		Radiation=registerPotions(new CustomPotion(true, 0x006400, "potion.radiation"));
		Arsenic=registerPotions(new CustomPotion(true, 0x93A1AC, "potion.arsenic"));
		Hydrargyrum=registerPotions(new CustomPotion(true, 0x990000, "potion.mercury"));
		CarbonMonoxyde=registerPotions(new CustomPotion(true, 0x000000, "potion.carbon_monoxyde"));
		Poison=registerPotions(new CustomPotion(true, 0x4E9331, "potion.chemical_poison"));
	}
}
