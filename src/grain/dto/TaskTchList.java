package grain.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskTchList {
	private List<TaskTchSimpleInf> taskInf;
	
	public TaskTchList() {
		taskInf=new ArrayList<TaskTchSimpleInf>();
	}

	public void addTaskInf(TaskTchSimpleInf tInf){
		taskInf.add(tInf);
	}
	
	public List<TaskTchSimpleInf> getTaskInf() {
		return taskInf;
	}

	public void setTaskInf(List<TaskTchSimpleInf> taskInf) {
		this.taskInf = taskInf;
	}
	
	@Override
	public String toString() {
		return "TaskTchList [taskInf=" + taskInf + "]";
	}
}
