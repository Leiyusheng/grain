package grain.dto;

public class CheckStuInf {
	private int msg;
	private StudentInf stuInfo;
	
	public CheckStuInf() {}
	
	public CheckStuInf(int msg, StudentInf stuInfo) {
		this.msg = msg;
		this.stuInfo = stuInfo;
	}

	public int getMsg() {
		return msg;
	}
	public void setMsg(int msg) {
		this.msg = msg;
	}
	public StudentInf getStuInfo() {
		return stuInfo;
	}
	public void setStuInfo(StudentInf stuInfo) {
		this.stuInfo = stuInfo;
	}
	
}
