import java.util.ArrayList;

public class Game {

	private Player p;
	private ArrayList<Monster> monsters;

	
	public Game() {
		p = new Player("Robert", 10, "🐕");
		monsters = new ArrayList<>();
		monsters.add(new Ghost("Casper", 10));
		monsters.add(new Ghost ("Boogeyman", 10));
		monsters.add( new Vampire("Edward", 20, true));
		
	}
	
	public void run() {
		
		System.out.println("Starting game. Out main player is: ...");
		System.out.println(p );
		printMonsters();
		Being tester = new Vampire("Edward", 20, false); // it's not actually a vampire
		Being tester2 = new Vampire("Edward", 20, true);
		/*System.out.println("Looking for Edward as a nonshiny, answer is: ");
		findBeingInMonsterList(tester);
		System.out.println("Looking for Edward as a vampire, answer is: ");
		findBeingInMonsterList(tester2);
		*/
		System.out.println("second time on printing....");
		printMonsters();
		
		String s = "Hello";
		if(p.equals(s)) {
			System.out.println("A string and a player are not equal, so this will never happen");
		}
		else {
			System.out.println("A string and a player are not equal");
		}
		
		System.out.println("M contains s: " + monsters.contains(s));
		System.out.println("M contains s: " + monsters.contains(tester));
	}
	
	public void findBeingInMonsterList(Being b) {
		boolean found = false;
		for(Monster m: monsters) {
		//	System.out.println("Looking to match being: " + b);
		//	System.out.println("with the current monster " + m);
			if(b.equals(m)) {
				System.out.println("FOUND A MATCH");
				found = true;
			}
		}
		if (found == false) System.out.println("No match found");
	}
	
	private void printMonsters() {
		System.out.println("here are all the monsters");
		for(int i = 0; i< monsters.size(); i++) {
			Monster m = monsters.get(i);
			if (m instanceof Vampire) {
				Vampire v = (Vampire)m; //typecast in order to access the vampire things
				System.out.println("This is a vampire who is " + v.toString());
				m = new Ghost(v.getName(), v.getHp());
				System.out.println("I turned my vampire into a ghost");
				monsters.set(i, m); //update the list item as well
			}
			else {
				System.out.println(m);
			}
		}
		
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.run();

	}

}
