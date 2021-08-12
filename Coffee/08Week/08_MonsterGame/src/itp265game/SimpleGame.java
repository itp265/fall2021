package itp265game;

public class SimpleGame {
	
	private Player p;
	private Monster v; //polymorphism - having many forms
	// v is a Vampire, is a Monster, is a Being, is a Object
	private Monster g1, g2; // booo berry, flying dutchman could be other ghosts

	public SimpleGame() {
		// construct the game objects
		p = new Player("Deegan", 5, "🧍");
		v = new Vampire("Dracula", 5, false, false);
		g1 = new Ghost("Casper", 5);
		g2 = new Ghost("Ghost of christmas past", 5);
	}

	public void run() {
		System.out.println("Welcome to the monster game");
		System.out.println(p); // p.toString()
		System.out.println(v);
		System.out.println(g1);
		System.out.println(g2);
		
		v.attack();
		g1.attack();
		//v.attack(5);
	}
	
	public static void main(String[] args) {
		SimpleGame g = new SimpleGame();
		g.run();

	}

}
