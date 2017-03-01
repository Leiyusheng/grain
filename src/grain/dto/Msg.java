package grain.dto;

public class Msg {
	private int msg;

	public Msg(){}
	
	public Msg(int msg) {
		super();
		this.msg = msg;
	}

	public int getMsg() {
		return msg;
	}

	public void setMsg(int msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Msg [msg=" + msg + "]";
	}
	
}
