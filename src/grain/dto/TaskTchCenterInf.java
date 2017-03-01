package grain.dto;

import grain.po.Task;

public class TaskTchCenterInf {
	private String task_logo;
	private String task_id;
	private String task_name;
	private int level;
	private String info;
	private int total_num;
	private int status;
	
	public TaskTchCenterInf() {}
	
	public TaskTchCenterInf(Task task) {
		this.task_logo = task.getTask_logo();
		this.task_id = task.getTask_id();
		this.task_name = task.getTask_name();
		this.level = task.getDifficulty_level();
		this.info = task.getTask_info();
		this.total_num = task.getTotal_num();
		this.status = task.getStatus();
	}
	
	public String getTask_logo() {
		return task_logo;
	}
	public void setTask_logo(String task_logo) {
		this.task_logo = task_logo;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getTotal_num() {
		return total_num;
	}
	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TaskTchCenterInf [task_logo=" + task_logo + ", task_id=" + task_id + ", task_name=" + task_name
				+ ", level=" + level + ", info=" + info + ", total_num=" + total_num + ", status=" + status + "]";
	}
	
}
