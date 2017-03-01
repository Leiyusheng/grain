package grain.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskStuCenterList {
	private List<TaskStuCenterInf> taskInf;
	
	public TaskStuCenterList() {
		taskInf=new ArrayList<TaskStuCenterInf>();
	}
	
	public void addTaskInf(TaskStuCenterInf tCenterInf) {
		taskInf.add(tCenterInf);
	}
	
	public List<TaskStuCenterInf> getTaskInf() {
		return taskInf;
	}
	public void setTaskInf(List<TaskStuCenterInf> taskInf) {
		this.taskInf = taskInf;
	}
	@Override
	public String toString() {
		return "TaskStuCenterList [taskInf=" + taskInf + "]";
	}
	
}
