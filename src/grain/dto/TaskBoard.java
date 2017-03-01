package grain.dto;

import java.util.ArrayList;
import java.util.List;

import grain.po.TaskResult;

public class TaskBoard {
	private List<TaskResult> resInf;
	
	public TaskBoard() {
		resInf=new ArrayList<TaskResult>();
	}
	
	public TaskBoard(List<TaskResult> resInf) {
		this.resInf = resInf;
	}

	public List<TaskResult> getResInf() {
		return resInf;
	}

	public void setResInf(List<TaskResult> resInf) {
		this.resInf = resInf;
	}

	@Override
	public String toString() {
		return "TaskBoard [resInf=" + resInf + "]";
	}
	
}
