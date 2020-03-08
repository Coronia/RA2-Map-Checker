import java.util.ArrayList;
import java.util.List;

public class Trigger {
	private String triggerID;
	private String name;
	private House house;
	private int eventCount;
	private int actionCount;
	private List<Event> event = new ArrayList<>();
	private List<Action> action = new ArrayList<>();
	private int[] param = {0, 1, 1, 1, 0};
	
	public void setID(String triggerID) { this.triggerID = triggerID; }
	public void setName(String name) { this.name = name; }
	public void setHouse(House house) { this.house = house; }
	public void setEventCount(int eventCount) { this.eventCount = eventCount; }
	public void setActionCount(int actionCount) { this.actionCount = actionCount; }
	public void addEvent(Event event) { this.event.add(event); }
	public void addAction(Action action) { this.action.add(action); }
	public void setParam(int[] param) { this.param = param; }
	
	@Override
	public String toString() { return triggerID + " " + name; }
	public String getID() { return triggerID; }
	public String getName() { return name; }
	public House getHouse() { return house; }
	public boolean sameEvent() { return eventCount == event.size(); }
	public boolean sameAction() { return actionCount == action.size(); }
	public List<Event> getEvent() { return event; }
	public List<Action> getAction() { return action; }
	public int[] getParam() { return param; }
}