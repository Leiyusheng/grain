package grain.dto;

public class CheckSearchInf {
	private int msg;
	private SearchInf info;
	
	public CheckSearchInf() {}
	
	public CheckSearchInf(int msg, SearchInf info) {
		this.msg = msg;
		this.info = info;
	}
	
	public int getMsg() {
		return msg;
	}
	public void setMsg(int msg) {
		this.msg = msg;
	}
	public SearchInf getInfo() {
		return info;
	}
	public void setInfo(SearchInf info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "CheckTchSearchInf [msg=" + msg + ", info=" + info + "]";
	}
	
}
