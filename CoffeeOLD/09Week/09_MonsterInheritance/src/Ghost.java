
public class Ghost extends Monster {

	public Ghost(String name, int hp) {
		super(name, hp, "👻", true); //Monster

	}
	
	public String toString() {
		return "Ghost" + super.toString();
	}

}
