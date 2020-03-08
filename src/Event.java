public class Event {
	private int[] param = {0, 0, 0};
	private String exParam;
	
	public void setParam(int p1, int p2, int p3) {
		param[0] = p1;
		param[1] = p2;
		param[2] = p3;
	}
	public void setEX(String exParam) { this.exParam = exParam; }
	
	public int[] getParam() { return param; }
	public String getEX() { return exParam; }
}