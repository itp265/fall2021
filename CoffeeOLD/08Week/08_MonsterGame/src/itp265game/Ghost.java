package itp265game;

public class Ghost extends Monster{

	public Ghost(String name, int hp) {
		super(name, hp, "👻", true);
		
	}
	
	public String toString() {
		return "Ghost" + super.toString();
		
	}


}
