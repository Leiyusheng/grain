package grain.dto;

public class CheckTchInf {
	private int msg;
	private TeacherInf tchInfo;
	
	public CheckTchInf() {}
	
	public CheckTchInf(int msg, TeacherInf tchInfo) {
		this.msg = msg;
		this.tchInfo = tchInfo;
	}

	public int getMsg() {
		return msg;
	}
	public void setMsg(int msg) {
		this.msg = msg;
	}
	public TeacherInf getTchInfo() {
		return tchInfo;
	}
	public void setTchInfo(TeacherInf tchInfo) {
		this.tchInfo = tchInfo;
	}
	
}
