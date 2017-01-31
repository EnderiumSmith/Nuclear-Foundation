package NuclearFoundation.core;

public enum RedstoneMode {
	
	ON(0,"always_on"),
	OFF(1,"always_off"),
	SIGNALON(2,"active_with_signal"),
	SIGNALOFF(3,"active_without_signal"),
	MODE(4,"mode");
	
	final int id;
	final String name;
	RedstoneMode(int id,String name){
		this.id=id;
		this.name=name;
	}
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public static RedstoneMode getModeWithId(int id){
		for(RedstoneMode e:RedstoneMode.values()){
			if(e.getId()==id){
				return e;
			}
		}
		return null;
	}
}
