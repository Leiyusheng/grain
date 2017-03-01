package grain.dto;

public class CheckTaskResultInf {
	private int msg;
	private TaskResultInf resultInf;
	
	public CheckTaskResultInf(int msg, TaskResultInf resultInf) {
		this.msg = msg;
		this.resultInf = resultInf;
	}
	
	public int getMsg() {
		return msg;
	}
	public void setMsg(int msg) {
		this.msg = msg;
	}
	public TaskResultInf getResultInf() {
		return resultInf;
	}
	public void setResultInf(TaskResultInf resultInf) {
		this.resultInf = resultInf;
	}
	@Override
	public String toString() {
		return "CheckTaskResultInf [msg=" + msg + ", resultInf=" + resultInf + "]";
	}
	
}
