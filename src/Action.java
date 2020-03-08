public class Action {
	private int type;
	private int paramType;
	private String param;
	private int[] paramList = {0, 0, 0, 0};
	private String exParam;
	
	public void setType(int type) { this.type = type; }
	public void setParamType(int paramType) { this.paramType = paramType; }
	public void setParam(String param) { this.param = param; }
	public void setParamList(int p1, int p2, int p3, int p4) {
		paramList[0] = p1;
		paramList[1] = p2;
		paramList[2] = p3;
		paramList[3] = p4;
	}
	public void setEX(String exParam) { this.exParam = exParam; }
	
	public int getType() { return type; }
	public int paramType() { return paramType; }
	public String getParam() { return param; }
	public int[] getParamList() { return paramList; }
	public String exParam() { return exParam; }
}