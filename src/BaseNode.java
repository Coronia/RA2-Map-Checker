public class BaseNode {
	private String type;
	private int[] coord = {0, 0};
	
	public BaseNode(String type, int x, int y) {
		this.type = type;
		coord[0] = x;
		coord[1] = y;
	}
	
	public String getType() { return type; }
	public int[] getCoord() { return coord; }
}