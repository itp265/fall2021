
public class Vampire extends Monster {
	private boolean isShiny;
	public Vampire(String name, int hp, boolean isShiny) {
		super(name, hp, "🧛", false);
		this.isShiny = isShiny;
		
	}
	public Vampire(String name, int hp, boolean isShiny, int idNum) {
		super(name, hp,  "🧛", false, idNum);
		this.isShiny = isShiny;
	}
		public String toString() {
		
		return "Vampire" + super.toString() + " isShiny: " + isShiny;
	}
		
		public boolean isShiny() {
			return isShiny;
		}
		
		public boolean equals(Object obj) {
			boolean same = super.equals(obj); // are they the same at the super level
			if(same) {
				// then check Vampire stuff
				Vampire v = (Vampire)obj;
				//same = this.isShiny == v.isShiny;
			}
			return same;
		}
}
