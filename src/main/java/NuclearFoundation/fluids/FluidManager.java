package NuclearFoundation.fluids;

import net.minecraft.item.EnumRarity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FluidManager {
	
	//fluid
	public static Fluid DestabilizedRedstone=new Fluid("redstone", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setLuminosity(7).setDensity(1200).setViscosity(1500).setGaseous(false).setRarity(EnumRarity.UNCOMMON);
	public static Fluid IonizedNikolite=new Fluid("nikolite", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setLuminosity(7).setDensity(1200).setViscosity(1500).setGaseous(false).setRarity(EnumRarity.UNCOMMON);
	public static Fluid EnergizedGlowstone=new Fluid("glowstone", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setLuminosity(15).setDensity(-500).setViscosity(100).setGaseous(true).setRarity(EnumRarity.UNCOMMON);
	public static Fluid ResonantEnder=new Fluid("ender", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setLuminosity(3).setDensity(4000).setViscosity(3000).setGaseous(false).setRarity(EnumRarity.EPIC);
	//1-1700(1:160)
	public static Fluid Steam=new Fluid("steam", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(-2).setTemperature(373).setViscosity(10).setGaseous(true);
	//atmosphere
	//O2-1:861(1:80)
	public static Fluid Oxygen=new Fluid("oxygen", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(2).setViscosity(10).setGaseous(true);
	public static Fluid LiquidOxygen=new Fluid("liquid_oxygen", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(1140).setTemperature(90).setViscosity(500).setGaseous(false);
	//N2-1:694(1:64)
	public static Fluid Nitrogen=new Fluid("nitrogen", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(-1).setViscosity(10).setGaseous(true);
	public static Fluid LiquidNitrogen=new Fluid("liquid_nitrogen", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(800).setTemperature(77).setViscosity(500).setGaseous(false);
	//CO2-1:790(1:80)
	public static Fluid CO2=new Fluid("carbon_dioxide", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(2).setViscosity(10).setGaseous(true);
	//Ar-1:782(1:80)
	public static Fluid Argon=new Fluid("argon", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(2).setViscosity(10).setGaseous(true);
	public static Fluid LiquidArgon=new Fluid("liquid_argon", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(1400).setTemperature(87).setViscosity(500).setGaseous(false);
	//Ne-1:1340(1:128)
	public static Fluid Neon=new Fluid("neon", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(-1).setViscosity(10).setGaseous(true);
	public static Fluid LiquidNeon=new Fluid("liquid_neon", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(1200).setTemperature(27).setViscosity(500).setGaseous(false);
	//He-1:700(1:72)
	public static Fluid Helium=new Fluid("helium", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(-7).setViscosity(1).setGaseous(true);
	public static Fluid LiquidHelium=new Fluid("liquid_helium", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(125).setTemperature(4).setViscosity(10).setGaseous(false);
	//Kr-1:643(1:64)
	public static Fluid Krypton=new Fluid("krypton", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(4).setViscosity(10).setGaseous(true);
	public static Fluid LiquidKrypton=new Fluid("liquid_krypton", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(2400).setTemperature(120).setViscosity(1000).setGaseous(false);
	//Xe-1:500(1:48)
	public static Fluid Xenon=new Fluid("xenon", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(6).setViscosity(10).setGaseous(true);
	public static Fluid LiquidXenon=new Fluid("liquid_xenon", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(3000).setTemperature(165).setViscosity(1500).setGaseous(false);
	//H2-1:800(1:80)
	public static Fluid Hydrogen=new Fluid("hydrogen", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(-14).setViscosity(10).setGaseous(true);
	public static Fluid LiquidHydrogen=new Fluid("liquid_hydrogen", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(70).setTemperature(20).setViscosity(100).setGaseous(false);
	//CH4-1:590(1:64)
	public static Fluid CH4=new Fluid("methane", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(-1).setViscosity(10).setGaseous(true);
	public static Fluid LiquidCH4=new Fluid("liquid_methane", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(420).setTemperature(111).setViscosity(1000).setGaseous(false);
	//F-1:886(1:88)
	public static Fluid Fluorine=new Fluid("fluorine", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(2).setViscosity(10).setGaseous(true);
	public static Fluid LiquidFluoride=new Fluid("liquid_fluorine", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(1500).setTemperature(85).setViscosity(1000).setGaseous(false);
	//Cl-1:448(1:40)
	public static Fluid Chlorine=new Fluid("chlorine", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(2).setViscosity(10).setGaseous(true);
	public static Fluid LiquidChlorine=new Fluid("liquid_chlorine", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(1560).setTemperature(240).setViscosity(100).setGaseous(false);
	//SO2-1:500(1:48)
	public static Fluid SO2=new Fluid("sulfur_dioxide", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(3).setViscosity(10).setGaseous(true);
	public static Fluid LiquidSO2=new Fluid("liquid_sulphur_dioxide", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(1460).setTemperature(263).setViscosity(1000).setGaseous(false);
	//CO-1:634(1:64)
	public static Fluid CO=new Fluid("carbon_monoxide", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(-1).setViscosity(10).setGaseous(true);
	public static Fluid LiquidCO=new Fluid("liquid_carbon_monoxide", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(790).setTemperature(81).setViscosity(500).setGaseous(false);
	//HCl-1:800(1:80)
	public static Fluid HCl=new Fluid("hydrogen_chloride", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(1).setViscosity(10).setGaseous(true);
	public static Fluid LiquidHCl=new Fluid("liquid_hydrogen_chloride", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(1190).setTemperature(188).setViscosity(1000).setGaseous(false);
	//HF-1:860(1:80)
	public static Fluid HF=new Fluid("hydrogen_fluoride", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(-1).setViscosity(10).setGaseous(true);
	public static Fluid LiquidHF=new Fluid("liquid_hydrogen_fluoride", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(990).setTemperature(292).setViscosity(1000).setGaseous(false);
	//H2S-1:618(1:64)
	public static Fluid H2S=new Fluid("hydrogen_sulfide", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(1).setViscosity(10).setGaseous(true);
	public static Fluid LiquidH2S=new Fluid("liquid_hydrogen_sulfide", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(950).setTemperature(213).setViscosity(1000).setGaseous(false);
	//NH3-1:875(1:88)
	public static Fluid NH3=new Fluid("ammonia", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(-1).setViscosity(10).setGaseous(true);
	public static Fluid LiquidNH3=new Fluid("liquid_ammonia", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(680).setTemperature(240).setViscosity(1000).setGaseous(false);
	//air-1:675(1:64)
	public static Fluid Air=new Fluid("air", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(0).setViscosity(10).setGaseous(true);
	public static Fluid LiquidAir=new Fluid("liquid_air", FluidRegistry.WATER.getStill(), FluidRegistry.WATER.getFlowing()).setDensity(870).setTemperature(79);
	
	
	//blocks
	public static BlockFluidClassic Redstone;
	public static BlockFluidClassic Nikolite;
	public static BlockFluidClassic Ender;
	public static BlockFluidClassic Glowstone;
	//atmosphere
	public static FluidGas O2b;
	public static FluidCryo LO2b;
	public static FluidGas N2b;
	public static FluidCryo LN2b;
	public static FluidGas CO2b;
	public static FluidGas Arb;
	public static FluidCryo LArb;
	public static FluidGas Neb;
	public static FluidCryo LNeb;
	public static FluidGas Heb;
	public static FluidCryo LHeb;
	public static FluidGas Krb;
	public static FluidCryo LKrb;
	public static FluidGas Xeb;
	public static FluidCryo LXeb;
	public static FluidGas H2b;
	public static FluidCryo LH2b;
	public static FluidGas CH4b;
	public static FluidCryo LCH4b;
	public static FluidGas Fb;
	public static FluidCryo LFb;
	public static FluidGas Clb;
	public static FluidCryo LClb;
	public static FluidGas SO2b;
	public static FluidCryo LSO2b;
	public static FluidGas COb;
	public static FluidCryo LCOb;
	public static FluidGas HClb;
	public static FluidCryo LHClb;
	public static FluidGas HFb;
	public static FluidCryo LHFb;
	public static FluidGas H2Sb;
	public static FluidCryo LH2Sb;
	public static FluidGas NH3b;
	public static FluidCryo LNH3b;
	
	//air
	//amount==percentage 10mb=1%
	public static FluidStack airTerra;
	public static FluidStack airVenus;
	public static FluidStack airMars;
	
	//composition encoding:max 4 fluids,Air fluids are placed last,use the minimum amount of Air fluid per layer(better stacking deep than stacking wide)
	public static void registerAirComposition(){
		airTerra=new FluidStack(Air, 1000, new NBTTagCompound());
		airVenus=new FluidStack(Air, 1000, new NBTTagCompound());
		airMars=new FluidStack(Air, 1000, new NBTTagCompound());
		registerAirTerraComposition();
		registerAirVenusComposition();
		registerAirMarsComposition();
	}
	
	public static void registerAirTerraComposition(){
		NBTTagList composition=new NBTTagList();
		composition.appendTag(new FluidStack(Nitrogen, 780).writeToNBT(new NBTTagCompound()));
		composition.appendTag(new FluidStack(Oxygen, 209).writeToNBT(new NBTTagCompound()));
		composition.appendTag(new FluidStack(Argon, 9).writeToNBT(new NBTTagCompound()));
			FluidStack AirL2=new FluidStack(Air, 2, new NBTTagCompound());
			NBTTagList L2composition=new NBTTagList();
			//0,043391
			L2composition.appendTag(new FluidStack(CO2, 937).writeToNBT(new NBTTagCompound()));
			L2composition.appendTag(new FluidStack(Neon, 41).writeToNBT(new NBTTagCompound()));
			L2composition.appendTag(new FluidStack(Helium, 12).writeToNBT(new NBTTagCompound()));
				FluidStack AirL3=new FluidStack(Air, 10, new NBTTagCompound());
				NBTTagList L3composition=new NBTTagList();
				//0,000349
				L3composition.appendTag(new FluidStack(CH4, 515).writeToNBT(new NBTTagCompound()));
				L3composition.appendTag(new FluidStack(Krypton, 276).writeToNBT(new NBTTagCompound()));
				L3composition.appendTag(new FluidStack(Hydrogen, 157).writeToNBT(new NBTTagCompound()));
				L3composition.appendTag(new FluidStack(Xenon, 52).writeToNBT(new NBTTagCompound()));
				AirL3.tag.setTag("composition", L3composition);
			L2composition.appendTag(AirL3.writeToNBT(new NBTTagCompound()));
			AirL2.tag.setTag("composition", L2composition);
		composition.appendTag(AirL2.writeToNBT(new NBTTagCompound()));
		airTerra.tag.setTag("composition", composition);
	}
	//777000778 B=1bucket gas HF
	//62160062240 B=bucket fluid HF
	//65431644464 B=bucket fluid F?
	public static void registerAirVenusComposition(){
		NBTTagList composition=new NBTTagList();
		composition.appendTag(new FluidStack(CO2, 964).writeToNBT(new NBTTagCompound()));
		composition.appendTag(new FluidStack(Nitrogen, 35).writeToNBT(new NBTTagCompound()));
			FluidStack AirL2=new FluidStack(Air, 1, new NBTTagCompound());
			NBTTagList L2composition=new NBTTagList();
			//276
			L2composition.appendTag(new FluidStack(SO2, 543).writeToNBT(new NBTTagCompound()));
			L2composition.appendTag(new FluidStack(Argon, 253).writeToNBT(new NBTTagCompound()));
			L2composition.appendTag(new FluidStack(CO, 61).writeToNBT(new NBTTagCompound()));
				FluidStack AirL3=new FluidStack(Air, 143, new NBTTagCompound());
				NBTTagList L3composition=new NBTTagList();
				//19
				L3composition.appendTag(new FluidStack(Helium, 631).writeToNBT(new NBTTagCompound()));
				L3composition.appendTag(new FluidStack(Neon, 368).writeToNBT(new NBTTagCompound()));
					FluidStack AirL4=new FluidStack(Air, 1, new NBTTagCompound());
					NBTTagList L4composition=new NBTTagList();
					L4composition.appendTag(new FluidStack(HCl, 991).writeToNBT(new NBTTagCompound()));
					L4composition.appendTag(new FluidStack(HF, 9).writeToNBT(new NBTTagCompound()));
					AirL4.tag.setTag("composition", L4composition);
				L3composition.appendTag(AirL4.writeToNBT(new NBTTagCompound()));
				AirL3.tag.setTag("composition", L3composition);
			L2composition.appendTag(AirL3.writeToNBT(new NBTTagCompound()));
			AirL2.tag.setTag("composition", L2composition);
		composition.appendTag(AirL2.writeToNBT(new NBTTagCompound()));
		airVenus.tag.setTag("composition", composition);
	}
	public static void registerAirMarsComposition(){
		NBTTagList composition=new NBTTagList();
		composition.appendTag(new FluidStack(CO2, 959).writeToNBT(new NBTTagCompound()));
		composition.appendTag(new FluidStack(Argon, 19).writeToNBT(new NBTTagCompound()));
		composition.appendTag(new FluidStack(Nitrogen, 18).writeToNBT(new NBTTagCompound()));
			FluidStack AirL2=new FluidStack(Air, 4, new NBTTagCompound());
			NBTTagList L2composition=new NBTTagList();
			L2composition.appendTag(new FluidStack(Oxygen, 723).writeToNBT(new NBTTagCompound()));
			L2composition.appendTag(new FluidStack(CO, 276).writeToNBT(new NBTTagCompound()));
			L2composition.appendTag(new FluidStack(CH4, 1).writeToNBT(new NBTTagCompound()));
			AirL2.tag.setTag("composition", L2composition);
		airMars.tag.setTag("composition", composition);
	}
	
	public static void registerFluids(){
		FluidRegistry.registerFluid(DestabilizedRedstone);
		FluidRegistry.registerFluid(IonizedNikolite);
		FluidRegistry.registerFluid(EnergizedGlowstone);
		FluidRegistry.registerFluid(ResonantEnder);
		//atmosphere
		regFluid(Oxygen);
		regFluid(LiquidOxygen);
		regFluid(Nitrogen);
		regFluid(LiquidNitrogen);
		regFluid(CO2);
		regFluid(Argon);
		regFluid(LiquidArgon);
		regFluid(Neon);
		regFluid(LiquidNeon);
		regFluid(Helium);
		regFluid(LiquidHelium);
		regFluid(Krypton);
		regFluid(LiquidKrypton);
		regFluid(Xenon);
		regFluid(LiquidXenon);
		regFluid(Hydrogen);
		regFluid(LiquidHydrogen);
		regFluid(CH4);
		regFluid(LiquidCH4);
		regFluid(Fluorine);
		regFluid(LiquidFluoride);
		regFluid(Chlorine);
		regFluid(LiquidChlorine);
		regFluid(SO2);
		regFluid(LiquidSO2);
		regFluid(CO);
		regFluid(LiquidCO);
		regFluid(HCl);
		regFluid(LiquidHCl);
		regFluid(HF);
		regFluid(LiquidHF);
		regFluid(H2S);
		regFluid(LiquidH2S);
		regFluid(NH3);
		regFluid(LiquidNH3);
		//air
		regFluid(Air);
		regFluid(LiquidAir);
	}
	public static void registerBuckets(){
		regBucket(DestabilizedRedstone);
		regBucket(IonizedNikolite);
		regBucket(EnergizedGlowstone);
		regBucket(ResonantEnder);
		//gas
		regBucket(LiquidOxygen);
		regBucket(LiquidNitrogen);
		regBucket(LiquidArgon);
		regBucket(LiquidNeon);
		regBucket(LiquidHelium);
		regBucket(LiquidKrypton);
		regBucket(LiquidXenon);
		regBucket(LiquidHydrogen);
		regBucket(LiquidCH4);
		regBucket(LiquidFluoride);
		regBucket(LiquidChlorine);
		regBucket(LiquidSO2);
		regBucket(LiquidCO);
		regBucket(LiquidHCl);
		regBucket(LiquidHF);
		regBucket(LiquidH2S);
		regBucket(LiquidNH3);
	}
	public static void registerFluidBlocks(){
		Redstone=new FluidRedstone();
		DestabilizedRedstone.setBlock(Redstone);
		GameRegistry.register(Redstone);
		Nikolite=new FluidNikolite();
		IonizedNikolite.setBlock(Nikolite);
		GameRegistry.register(Nikolite);
		Ender=new FluidEnder();
		ResonantEnder.setBlock(Ender);
		GameRegistry.register(Ender);
		Glowstone=new FluidGlowstone(EnergizedGlowstone, "energized_glowstone", FluidMaterials.Glowstone);
		EnergizedGlowstone.setBlock(Glowstone);
		GameRegistry.register(Glowstone);
		//atmosphere
		O2b=new FluidGas(Oxygen, "oxygen", true);
		LO2b=new FluidCryo(LiquidOxygen, "liquid_oxygen");
		N2b=new FluidGas(Nitrogen, "nitrogen");
		LN2b=new FluidCryo(LiquidNitrogen, "liquid_nitrogen");
		CO2b=new FluidGas(CO2, "carbon_dioxide");
		Arb=new FluidGas(Argon, "argon");
		LArb=new FluidCryo(LiquidArgon, "liquid_argon");
		Neb=new FluidGas(Neon, "neon");
		LNeb=new FluidCryo(LiquidNeon, "liquid_neon");
		Heb=new FluidGas(Helium, "helium");
		LHeb=new FluidCryo(LiquidHelium, "liquid_helium");
		Krb=new FluidGas(Krypton, "krypton");
		LKrb=new FluidCryo(LiquidKrypton, "liquid_krypton");
		Xeb=new FluidGas(Xenon, "xenon");
		LXeb=new FluidCryo(LiquidXenon, "liquid_xenon");
		H2b=new FluidGas(Hydrogen, "hydrogen", 60, -1);
		LH2b=new FluidCryo(LiquidHydrogen, "liquid_hydrogen", 60, -1);
		CH4b=new FluidGas(CH4, "methane", 60, -2);
		LCH4b=new FluidCryo(LiquidCH4, "liquid_methane", 60, -2);
		Fb=new FluidGas(Fluorine, "fluorine", 0, 0, 1, 45*20);
		LFb=new FluidCryo(LiquidFluoride, "liquid_fluorine", 0, 0, 1);
		Clb=new FluidGas(Chlorine, "chlorine", 0, 0, 1, 35*20);
		LClb=new FluidCryo(LiquidChlorine, "liquid_chlorine", 0, 0, 1);
		SO2b=new FluidGas(SO2, "sulfur_dioxide", 0, 0, 0, 6*20);
		LSO2b=new FluidCryo(LiquidSO2, "liquid_sulfur_dioxide");
		COb=new FluidGas(CO, "carbon_monoxide", 60, 0, 0, -45*20);
		LCOb=new FluidCryo(LiquidCO, "liquid_carbon_monoxide", 60);
		HClb=new FluidGas(HCl, "hydrogen_chloride", 0, 0, 1);
		LHClb=new FluidCryo(LiquidHCl, "liquid_hydrogen_chloride", 0, 0, 2);
		HFb=new FluidGas(HF, "hydrogen_fluoride", 0, 0, 2);
		LHFb=new FluidCryo(LiquidHF, "liquid_hydrogen_fluoride", 0, 0, 3);
		H2Sb=new FluidGas(H2S, "hydrogen_sulfide", 60, 2, 0, 35*20);
		LH2Sb=new FluidCryo(LiquidH2S, "liquid_hydrogen_sulfide", 60, 4, 2);
		NH3b=new FluidGas(NH3, "ammonia");
		LNH3b=new FluidCryo(LiquidNH3, "liquid_ammonia");
		Oxygen.setBlock(O2b);
		LiquidOxygen.setBlock(LO2b);
		Nitrogen.setBlock(N2b);
		LiquidNitrogen.setBlock(LN2b);
		CO2.setBlock(CO2b);
		Argon.setBlock(Arb);
		LiquidArgon.setBlock(LArb);
		Neon.setBlock(Neb);
		LiquidNeon.setBlock(LNeb);
		Helium.setBlock(Heb);
		LiquidHelium.setBlock(LHeb);
		Krypton.setBlock(Krb);
		LiquidKrypton.setBlock(LKrb);
		Xenon.setBlock(Xeb);
		LiquidXenon.setBlock(LXeb);
		Hydrogen.setBlock(H2b);
		LiquidHydrogen.setBlock(LH2b);
		CH4.setBlock(CH4b);
		LiquidCH4.setBlock(LCH4b);
		Fluorine.setBlock(Fb);
		LiquidFluoride.setBlock(LFb);
		Chlorine.setBlock(Clb);
		LiquidChlorine.setBlock(LClb);
		SO2.setBlock(SO2b);
		LiquidSO2.setBlock(LSO2b);
		CO.setBlock(COb);
		LiquidCO.setBlock(LCOb);
		HCl.setBlock(HClb);
		LiquidHCl.setBlock(LHClb);
		HF.setBlock(HFb);
		LiquidHF.setBlock(LHFb);
		H2S.setBlock(H2Sb);
		LiquidH2S.setBlock(LH2Sb);
		NH3.setBlock(NH3b);
		LiquidNH3.setBlock(LNH3b);
		regFluidBlock(O2b);
		regFluidBlock(LO2b);
		regFluidBlock(N2b);
		regFluidBlock(LN2b);
		regFluidBlock(CO2b);
		regFluidBlock(Arb);
		regFluidBlock(LArb);
		regFluidBlock(Neb);
		regFluidBlock(LNeb);
		regFluidBlock(Heb);
		regFluidBlock(LHeb);
		regFluidBlock(Krb);
		regFluidBlock(LKrb);
		regFluidBlock(Xeb);
		regFluidBlock(LXeb);
		regFluidBlock(H2b);
		regFluidBlock(LH2b);
		regFluidBlock(CH4b);
		regFluidBlock(LCH4b);
		regFluidBlock(Fb);
		regFluidBlock(LFb);
		regFluidBlock(Clb);
		regFluidBlock(LClb);
		regFluidBlock(SO2b);
		regFluidBlock(LSO2b);
		regFluidBlock(COb);
		regFluidBlock(LCOb);
		regFluidBlock(HClb);
		regFluidBlock(LHClb);
		regFluidBlock(HFb);
		regFluidBlock(LHFb);
		regFluidBlock(H2Sb);
		regFluidBlock(LH2Sb);
		regFluidBlock(NH3b);
		regFluidBlock(LNH3b);
	}
	public static void regFluidBlock(BlockFluidBase fluid){
		GameRegistry.register(fluid);
	}
	public static void regFluid(Fluid fluid){
		FluidRegistry.registerFluid(fluid);
	}
	public static void regBucket(Fluid fluid){
		FluidRegistry.addBucketForFluid(fluid);
	}
	
}
