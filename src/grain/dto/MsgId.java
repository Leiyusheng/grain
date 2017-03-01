package grain.dto;

public class MsgId {
	
	private int msg;
	private String id;
	
	public MsgId() {}
	
	public MsgId(int msg, String id) {
		this.msg = msg;
		this.id = id;
	}

	public int getMsg() {
		return msg;
	}
	public void setMsg(int msg) {
		this.msg = msg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "MsgId [msg=" + msg + ", id=" + id + "]";
	}
	
}
