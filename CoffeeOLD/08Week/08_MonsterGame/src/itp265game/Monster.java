package itp265game;

public class Monster extends Being {
	protected boolean isFriendly;
	public Monster(String name, int hp, String emojiIcon, boolean isNice) {
		super(name, hp, emojiIcon);
		isFriendly = isNice;
	}
	
	public void attack() {
		System.out.println("ATTACK");
	}
	
	@Override
	// when we have a method in a sub class that performs its own actions for a method also in a superclass
	public String toString() {
		return "Monster" + super.toString();
		
	}

}
