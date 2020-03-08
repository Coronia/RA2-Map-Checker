import java.util.ArrayList;
import java.util.List;

public class Script {
	private String scrID;
	private String name;
	private List<List<Integer> > actions = new ArrayList<List<Integer> >();
	
	public void setID(String scrID) { this.scrID = scrID; }
	public void setName(String name) { this.name = name; }
	public void addActions(int action, int param) {
		List<Integer> tmp = new ArrayList<>();
		tmp.add(action);
		tmp.add(param);
		actions.add(tmp);
	}
	public void clearActions() { actions.clear(); }
	
	@Override
	public String toString() { return scrID + " " + name; }
	public String getID() { return scrID; }
	public String getName() { return name; }
	public List<List<Integer> > getActions() { return actions; }
}