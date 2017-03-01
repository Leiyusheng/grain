package grain.dto;

import grain.po.Task;

public class TaskStuSimpleInf {
	private String t_id;
	private String t_name;
	private String task_logo;
	private String task_id;
	private String task_name;
	private int level;
	private String info;
	private int practice_time;
	
	public TaskStuSimpleInf() {}
	
	public TaskStuSimpleInf(Task task, int practice_time) {
		this.t_id = task.getTeacher_id();
		this.t_name = task.getTeacher_name();
		this.task_logo = task.getTask_logo();
		this.task_id = task.getTask_id();
		this.task_name = task.getTask_name();
		this.level = task.getDifficulty_level();
		this.info = task.getTask_info();
		this.practice_time = practice_time;
	}

	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
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
	public int getPractice_time() {
		return practice_time;
	}
	public void setPractice_time(int practice_time) {
		this.practice_time = practice_time;
	}
	@Override
	public String toString() {
		return "TaskSimpleInf [t_id=" + t_id + ", t_name=" + t_name + ", task_logo=" + task_logo + ", task_id="
				+ task_id + ", task_name=" + task_name + ", level=" + level + ", info=" + info 
				+ ", practice_time=" + practice_time + "]";
	}
	
}
