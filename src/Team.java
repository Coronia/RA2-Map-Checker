import java.util.HashMap;

public class Team {
	private String teamID;
	private String name;
	private House house;
	private Taskforce taskforce;
	private Script script;
	private Tag tag;
	private HashMap<String, Integer> paramInt = new HashMap<>();
	private HashMap<String, Waypoint> paramWP = new HashMap<>();
	private HashMap<String, Boolean> paramBool = new HashMap<>();
	
	public Team() {
		paramInt.put("Max", 5);
		paramInt.put("Group", -1);
		paramInt.put("Priority", 5);
		paramInt.put("TechLevel", 0);
		paramInt.put("VeteranLevel", 1);
		paramInt.put("MindControlDecision", 0);
		
		paramWP.put("Waypoint", new Waypoint(0, "A"));

		paramBool.put("Full", false);
		paramBool.put("Whiner", false);
		paramBool.put("Droppod", false);
		paramBool.put("Suicide", false);
		paramBool.put("Loadable", false);
		paramBool.put("Prebuild", false);
		paramBool.put("Annoyance", false);
		paramBool.put("IonImmune", false);
		paramBool.put("Recruiter", false);
		paramBool.put("Reinforce", false);
		paramBool.put("Aggressive", false);
		paramBool.put("Autocreate", false);
		paramBool.put("GuardSlower", false);
		paramBool.put("OnTransOnly", false);
		paramBool.put("AvoidThreats", false);
		paramBool.put("LooseRecruit", false);
		paramBool.put("IsBaseDefense", false);
		paramBool.put("UseTransportOrigin", false);
		paramBool.put("OnlyTargetHouseEnemy", false);
		paramBool.put("TransportsReturnOnUnload", false);
		paramBool.put("AreTeamMembersRecruitable", false);
	}
	
	public void setID(String teamID) { this.teamID = teamID; }	
	public void setName(String name) { this.name = name; }	
	public void setHouse(House house) { this.house = house; }
	public void setTF(Taskforce taskforce) { this.taskforce = taskforce; }
	public void setSCR(Script script) { this.script = script; }
	public void setTag(Tag tag) { this.tag = tag; }
	public void setParam(String key, Object value) {
		if (value instanceof Integer) { paramInt.put(key, (Integer) value); }
		else if (value instanceof Waypoint) { paramWP.put(key, (Waypoint) value); }
		else if (value instanceof Boolean) { paramBool.put(key, (Boolean) value); }
	}
	
	@Override
	public String toString() { return teamID + " " + name; }
	public String getID() { return teamID; }
	public String getName() { return name; }
	public House getHouse() { return house; }
	public Taskforce getTF() { return taskforce; }
	public Script getSCR() { return script; }
	public Tag getTag() { return tag; }
	public HashMap<String, Integer> getParamInt() { return paramInt; }
	public HashMap<String, Waypoint> getParamWP() { return paramWP; }
	public HashMap<String, Boolean> getParamBool() { return paramBool; }
}