
public abstract class Being {
	protected String name;
	protected int hp;
	protected String emojiIcon;
	private int idNum; // akin  to ssn. Only accessible in the BEING class
	
	private static int COUNTER = 1;
	
	public Being(String name, int hp, String emojiIcon) {
		this(name, hp, emojiIcon, COUNTER);
		COUNTER++;
		
	}
	
	public Being(String name, int hp, String emojiIcon, int idNum) {
		this.name = name;
		this.hp = hp;
		this.emojiIcon = emojiIcon;
		this.idNum = idNum;
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emojiIcon == null) ? 0 : emojiIcon.hashCode());
		result = prime * result + hp;
		result = prime * result + idNum;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public  boolean equals(Object obj) {
		if (this == obj) // STRICTEST definition of equals, both references point to the same memory location
			return true;
		if (obj == null) // can't compare something to nothing
			return false;
		if (getClass() != obj.getClass()) // if i'm (this) is a vampire and obj is not a vampire
			return false;
	//	if (!(obj instanceof Being)) { // a vampire and any other object of type Being COULD be equal
	//		return false;
	//	}

		Being other = (Being) obj; // need the typecast to access to the more specific data 
		
		// comparing two objects of type Being
		return this.name.equalsIgnoreCase(other.name)
				&& this.emojiIcon.equals(other.emojiIcon)
				&& this.hp == other.hp;
				//&& this.idNum == other.idNum;
	}

	@Override
	public String toString() {
		return  "Being [name=" + name + ", hp=" + hp + ", emojiIcon=" + emojiIcon + ", idNum=" + idNum + "]";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the emojiIcon
	 */
	public String getEmojiIcon() {
		return emojiIcon;
	}

	/**
	 * @return the idNum
	 */
	public int getIdNum() {
		return idNum;
	}
	
	public void print() {
		System.out.println("BEING: " + emojiIcon + this.getName());
		
	}
	
	
}
