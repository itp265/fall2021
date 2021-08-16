package itp265game;

public class Player extends Being {
	private int level;

	public Player(String name, int hp, String emojiIcon, int level) {
		super(name, hp, emojiIcon); // first thing call to super
		this.level = level;
	}

	//overload constructor
	public Player(String name, int hp, String emojiIcon) {
		this(name, hp, emojiIcon, 0); // still use THIS to call other versions of the constructor in SAME class
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {

		
		return "Player " +  this.name  + " " + emojiIcon + ", level=" + level + ", id num = " + this.getIdNum();
				
	}
	
}
