
public enum Planet {
	// a class with a set number of objects (whatever is below) crossed with an array
NEPTUNE(0),   // ONE OBJECT
EARTH(1),
SATURN(82),
VENUS(2),
MARS(3), 
MERCURY(2),
JUPITER(0),
URANUS(0),
PLUTO(0);
	
	// .values() --> gives the ARRAY of each of the enumerated (listed out) objects
	private int numMoons;
	
	private Planet(int num) {
		numMoons = num;
	}
	
	public String toString() {
		return this.name() + " has " + numMoons + " moons";
	}
	
	public int getNumMoons() {
		return numMoons;
	}
	
	public static String toMenu() {
		String s = "Here are the planets: ";
		for (int i = 0; i < getNumPlanets(); i++) {
			s += i + " : " + Planet.values()[i] +"\n";
		}
		return s;
	}
	public static Planet getPlanetNumber(int num) {
		return Planet.values()[num];
	}
	public static int getNumPlanets() {
		return Planet.values().length;
		
	}
}
