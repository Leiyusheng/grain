package grain.dto;

public class MsgUrl {
	
	private int msg;
	private String url;
	
	public MsgUrl() {}
	
	public MsgUrl(int msg, String url) {
		this.msg = msg;
		this.url = url;
	}

	public int getMsg() {
		return msg;
	}
	public void setMsg(int msg) {
		this.msg = msg;
	}
	public String geturl() {
		return url;
	}
	public void seturl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Msgurl [msg=" + msg + ", url=" + url + "]";
	}
	
}
