package grain.dto;

import java.util.List;

import grain.po.TaskResultTotalInf;

public class TaskResultTodayList {
	private List<TaskResultTotalInf> resultInf;

	public TaskResultTodayList(List<TaskResultTotalInf> totalInfs) {
		resultInf=totalInfs;
	}
	
	public void addTaskResultInf(TaskResultTotalInf tInf){
		resultInf.add(tInf);
	}
	
	public List<TaskResultTotalInf> getResultInf() {
		return resultInf;
	}

	public void setResultInf(List<TaskResultTotalInf> resultInf) {
		this.resultInf = resultInf;
	}

	@Override
	public String toString() {
		return "TaskResultTodayList [resultInf=" + resultInf + "]";
	}
	
}
