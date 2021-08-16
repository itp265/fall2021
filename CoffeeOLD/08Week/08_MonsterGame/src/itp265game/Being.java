package itp265game;

public abstract class Being {
	//3/4 access levels: public protected private (no identifier)
	
	protected String name;  //open memory to future sub classes
	protected int hp;
	protected String emojiIcon;
	private int idNum;
	
	private static int COUNTER = 1;

	public Being(String name, int hp, String emojiIcon) {
		this.name = name;
		this.hp = hp;
		this.emojiIcon = emojiIcon;
		idNum = COUNTER;
		COUNTER++;
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
	 * @param emojiIcon the emojiIcon to set
	 */
	public void setEmojiIcon(String emojiIcon) {
		this.emojiIcon = emojiIcon;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the idNum
	 */
	public int getIdNum() {
		return idNum;
	}

	@Override
	public String toString() {
		return "Being [name=" + name + ", hp=" + hp + ", emojiIcon=" + emojiIcon + ", idNum=" + idNum + "]";
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Being other = (Being) obj;
		if (emojiIcon == null) {
			if (other.emojiIcon != null)
				return false;
		} else if (!emojiIcon.equals(other.emojiIcon))
			return false;
		if (hp != other.hp)
			return false;
		if (idNum != other.idNum)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
