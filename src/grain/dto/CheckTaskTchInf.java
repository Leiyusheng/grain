package grain.dto;

public class CheckTaskTchInf {
	private int msg;
	private TaskTchInf taskInfo;
	
	public CheckTaskTchInf() {}
	
	public CheckTaskTchInf(int msg, TaskTchInf taskInfo) {
		this.msg = msg;
		this.taskInfo = taskInfo;
	}

	public int getMsg() {
		return msg;
	}
	public void setMsg(int msg) {
		this.msg = msg;
	}
	public TaskTchInf getTaskInfo() {
		return taskInfo;
	}
	public void setTaskInfo(TaskTchInf taskInfo) {
		this.taskInfo = taskInfo;
	}
	
}
