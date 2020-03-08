import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class House {
	private String name;
	private Country parent;
	private HashMap<String, String> param = new HashMap<>();
	private HashMap<String, Integer> paramInt = new HashMap<>();
	private List<House> allies = new ArrayList<>();
	private List<BaseNode> basenode = new ArrayList<>();
	
	public House() {
		param.put("Edge", "");
		param.put("Color", "");
		param.put("PlayerControl", "no");
		
		paramInt.put("IQ", 0);
		paramInt.put("Credits", 0);
		paramInt.put("NodeCount", 0);
		paramInt.put("TechLevel", 10);
		paramInt.put("PercentBuilt", 100);
	}
	
	public void setName(String name) { this.name = name; }
	public void setParent(Country parent) { this.parent = parent; }
	public void setParam(String type, Object value) {
		if (value instanceof Integer) { paramInt.put(type, (Integer) value); }
		else { param.put(type, (String) value); }
	}
	public void addAlly(House ally) { allies.add(ally); }
	public void addNode(BaseNode node) { basenode.add(node); }
	
	@Override
	public String toString() { return name; }
	public Country getParent() { return parent; }
	public HashMap<String, String> getParam() { return param; }
	public HashMap<String, Integer> getParamInt() { return paramInt; }
	public List<House> getAlly() { return allies; }
	public List<BaseNode> getNode() { return basenode; }
	public boolean sameNode() { return paramInt.get("NodeCount") == basenode.size(); }
}