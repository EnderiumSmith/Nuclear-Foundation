package NuclearFoundation.fluids;

import java.util.ArrayList;

import NuclearFoundation.core.Config;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class AirManager {
	
	public static ArrayList<CryoMap> cryoMap=new ArrayList<>();
	
	public static FluidStack getAirForDimension(World world){
		return getAirForDimension(world.provider.getDimension());
	}
	public static FluidStack getAirForDimension(int id){
		switch(id){
		case(0):{
			return FluidManager.airTerra.copy();
		}
		case(-1):{
			return FluidManager.airVenus.copy();
		}
		case(1):{
			return null;
		}
		default:{
			if(Config.TreatUnknownAsOverwold){
				return FluidManager.airTerra.copy();
			}
			return null;
		}
		}
	}
	public static void initCryoMap(){
		cryoMap.add(createStandardMap("oxygen", 80));
		cryoMap.add(createStandardMap("nitrogen", 64));
		cryoMap.add(new CryoMap("carbon_dioxide", null, "dryice", 80));
		cryoMap.add(createStandardMap("argon", 80));
		cryoMap.add(createStandardMap("neon", 128));
		cryoMap.add(createStandardMap("helium", 72));
		cryoMap.add(createStandardMap("krypton", 64));
		cryoMap.add(createStandardMap("xenon", 48));
		cryoMap.add(createStandardMap("hydrogen", 80));
		cryoMap.add(createStandardMap("methane", 64));
		cryoMap.add(createStandardMap("fluorine", 88));
		cryoMap.add(createStandardMap("chlorine", 40));
		cryoMap.add(createStandardMap("sulfur_dioxide", 48));
		cryoMap.add(createStandardMap("carbon_monoxide", 64));
		cryoMap.add(createStandardMap("hydrogen_chloride", 80));
		cryoMap.add(createStandardMap("hydrogen_fluoride", 80));
		cryoMap.add(createStandardMap("hydrogen_sulfide", 64));
		cryoMap.add(createStandardMap("ammonia", 88));
		cryoMap.add(createStandardMap("air", 64));
	}
	public static CryoMap createStandardMap(String gas,int ratio){
		return new CryoMap(gas, "liquid_"+gas, null, ratio);
	}
	public static CryoMap getCryoStatsForGas(String gasName){
		for(int i=0;i<cryoMap.size();i++){
			if(cryoMap.get(i).getGasFluidName().equals(gasName)){
				return cryoMap.get(i);
			}
		}
		return null;
	}
	public static CryoMap getCryoStatsForLiquid(String liquidName){
		for(int i=0;i<cryoMap.size();i++){
			if(cryoMap.get(i).getCryoFluidName()!=null&&cryoMap.get(i).getCryoFluidName().equals(liquidName)){
				return cryoMap.get(i);
			}
		}
		return null;
	}
	public static CryoMap getCryoStatsForSolid(String iceName){
		for(int i=0;i<cryoMap.size();i++){
			if(cryoMap.get(i).getIceName()!=null&&cryoMap.get(i).getIceName().equals(iceName)){
				return cryoMap.get(i);
			}
		}
		return null;
	}
	
}
