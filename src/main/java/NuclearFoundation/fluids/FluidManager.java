package NuclearFoundation.fluids;

import net.minecraft.item.EnumRarity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidManager {
	
	public static Fluid DestabilizedRedstone=new Fluid("redstone", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setLuminosity(7).setDensity(1200).setViscosity(1500).setGaseous(false).setRarity(EnumRarity.UNCOMMON);
	public static Fluid IonizedNikolite=new Fluid("nikolite", null, null).setLuminosity(7).setDensity(1200).setViscosity(1500).setGaseous(false).setRarity(EnumRarity.UNCOMMON);
	public static Fluid EnergizedGlowstone=new Fluid("glowstone", null, null).setLuminosity(15).setDensity(-500).setViscosity(100).setGaseous(true).setRarity(EnumRarity.UNCOMMON);
	public static Fluid ResonantEnder=new Fluid("ender", null, null).setLuminosity(3).setDensity(4000).setViscosity(3000).setGaseous(false).setRarity(EnumRarity.RARE);
	//atmosphere
	
	public static void registerFluids(){
		FluidRegistry.registerFluid(DestabilizedRedstone);
		FluidRegistry.registerFluid(IonizedNikolite);
		FluidRegistry.registerFluid(EnergizedGlowstone);
		FluidRegistry.registerFluid(ResonantEnder);
	}
	
}
