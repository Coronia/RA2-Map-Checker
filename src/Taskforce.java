import java.util.HashMap;

public class Taskforce {
	private String taskID;
	private String name;
	private HashMap<String, Integer> units = new HashMap<>();
	private int group= -1;
	
	public void setID(String taskID) { this.taskID = taskID; }	
	public void setName(String name) { this.name = name; }	
	public void addUnits(String type, int num) { units.put(type, num); }	
	public void clearUnits() { units.clear(); }	
	public void setGroup(int group) { this.group = group; }
	
	@Override
	public String toString() { return taskID + " " + name; }	
	public String getID() { return taskID; }	
	public String getName() { return name; }	
	public HashMap<String, Integer> getUnits() { return units; }
	public int getGroup() { return group; }
}