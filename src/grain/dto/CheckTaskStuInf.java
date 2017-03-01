package grain.dto;

public class CheckTaskStuInf {
	private int msg;
	private TaskStuInf taskInfo;
	
	public CheckTaskStuInf() {}
	
	public CheckTaskStuInf(int msg, TaskStuInf taskInfo) {
		super();
		this.msg = msg;
		this.taskInfo = taskInfo;
	}

	public int getMsg() {
		return msg;
	}
	public void setMsg(int msg) {
		this.msg = msg;
	}
	public TaskStuInf getTaskInfo() {
		return taskInfo;
	}
	public void setTaskInfo(TaskStuInf taskInfo) {
		this.taskInfo = taskInfo;
	}
	
}
