
public class Player extends Being {
	private int level;
	public Player(String name, int hp, String emojiIcon, int level) {
		super(name, hp, emojiIcon); // FIRST THING is call to super
		this.level = level;
	}
	// overloaded constructor
	public Player(String name, int hp, String emojiIcon) {
		this(name, hp, emojiIcon, 0); //call this is first
	}
	
	public String toString() {
		//this.emojiIcon, super.emojiIcon and emojiIcon alll work to access
		// the protected variable in the Being class
		return emojiIcon + "Player " + this.name + " with hp = " + hp + " level = " + level;
	}
}