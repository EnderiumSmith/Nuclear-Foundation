package NuclearFoundation.fluids;

public class CryoMap {
	
	public final String gas,liquid,ice;
	public final int ratio;
	public CryoMap(String gas,String liquid,String ice,int ratio) {
		this.gas=gas;
		this.liquid=liquid;
		this.ice=ice;
		this.ratio=ratio;
	}
	public int getExpansionRatio(){
		return ratio;
	}
	public String getIceName(){
		return ice;
	}
	public String getCryoFluidName(){
		return liquid;
	}
	public String getGasFluidName(){
		return gas;
	}
}
