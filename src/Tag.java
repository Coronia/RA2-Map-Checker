public class Tag {
	private String tagID;
	private String name;
	private int repeat = 0;
	private Trigger trigger;
	
	public void setID(String tagID) { this.tagID = tagID; }
	public void setName(String name) { this.name = name; }
	public void setRepeat(int repeat) { this.repeat = repeat; }
	public void setTrigger(Trigger trigger) { this.trigger = trigger; }
	
	@Override
	public String toString() { return tagID + " " + name; }
	public String getID() { return tagID; }
	public String getName() {return name; }
	public int getRepeat() { return repeat; }
	public Trigger getTrigger() { return trigger; }
}