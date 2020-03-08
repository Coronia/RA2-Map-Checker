public class Waypoint {
	private int numWP;
	private String charWP;
	
	public Waypoint(int numWP, String charWP) {
		this.numWP = numWP;
		this.charWP = charWP;
	}
	
	@Override
	public String toString() { return "" + numWP; }
	public String getCharWP() { return charWP; }
}