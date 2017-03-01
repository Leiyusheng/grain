package grain.dto;

public class CheckTchSearchInf {
	private int msg;
	private TchSearchInf tchInfo;
	
	public CheckTchSearchInf() {}
	
	public CheckTchSearchInf(int msg, TchSearchInf tchInfo) {
		this.msg = msg;
		this.tchInfo = tchInfo;
	}
	
	public int getMsg() {
		return msg;
	}
	public void setMsg(int msg) {
		this.msg = msg;
	}
	public TchSearchInf getTchInfo() {
		return tchInfo;
	}
	public void setTchInfo(TchSearchInf tchInfo) {
		this.tchInfo = tchInfo;
	}
	@Override
	public String toString() {
		return "CheckTchSearchInf [msg=" + msg + ", tchInfo=" + tchInfo + "]";
	}
	
}
