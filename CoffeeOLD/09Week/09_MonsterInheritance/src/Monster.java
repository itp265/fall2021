
public class Monster extends Being {
	
	protected boolean isFriendly;

	public Monster(String name, int hp, String emojiIcon, boolean isFriendly) {
		super(name, hp, emojiIcon);
		this.isFriendly = isFriendly;

		
	}
	

	public Monster(String name, int hp, String emojiIcon, boolean isFriendly, int idNum) {
		super(name, hp, emojiIcon, idNum);
		this.isFriendly = isFriendly;

		
	}
	
	//OVERRIDE of the method from being
	@Override
	public void print() {
		if(isFriendly)
			System.out.println("friendly monster " + emojiIcon);
		else
			System.out.println("mean monster " + emojiIcon);
	}

}
