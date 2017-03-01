package grain.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskTchCenterList {
	private List<TaskTchCenterInf> taskInf;

	public TaskTchCenterList() {
		this.taskInf = new ArrayList<TaskTchCenterInf>();
	}
	
	public void addTaskInf(TaskTchCenterInf tCenterInf){
		taskInf.add(tCenterInf);
	}

	public List<TaskTchCenterInf> getTaskInf() {
		return taskInf;
	}

	public void setTaskInf(List<TaskTchCenterInf> taskInf) {
		this.taskInf = taskInf;
	}

	@Override
	public String toString() {
		return "TaskTchCenterList [taskInf=" + taskInf + "]";
	}
	
}
