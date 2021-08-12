package itp265game;

public class Vampire extends Monster {
	
	private boolean hasMagic;

	public Vampire(String name, int hp, boolean isNice, boolean hasMagic) {
		super(name, hp, "🧛", isNice);
		this.hasMagic = hasMagic;
	}
	
	@Override
	public void attack() {
		System.out.println("Sucking your blood");
	}
	
	//overload -- there is nothing in the super class that matches
	public void attack(int damge) {
		System.out.println("Sucking your blood with " + damge + " damage");
	}


}
