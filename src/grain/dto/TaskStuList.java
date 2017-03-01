package grain.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskStuList {
	private List<TaskStuSimpleInf> taskInf;
	
	public TaskStuList() {
		taskInf=new ArrayList<TaskStuSimpleInf>();
	}
	
	public void addTaskInf(TaskStuSimpleInf tInf){
		taskInf.add(tInf);
	}
	
	public List<TaskStuSimpleInf> getTaskInf() {
		return taskInf;
	}

	public void setTaskInf(List<TaskStuSimpleInf> taskInf) {
		this.taskInf = taskInf;
	}

	@Override
	public String toString() {
		return "TaskStuList [taskInf=" + taskInf + "]";
	}
	
}
