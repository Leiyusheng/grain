package grain.dto;

import java.sql.Date;

import grain.po.Task;

public class TaskStuInf {
	private String t_id;
	private String t_name;
	private String task_logo;
	private String task_name;
	private int level;
	private Date s_date;
	private Date e_date;
	private String info;
	private int status;
	private int self_level;
	
	public TaskStuInf() {}
	
	public TaskStuInf(Task task,int self_level) {
		this.t_id = task.getTeacher_id();
		this.t_name = task.getTeacher_name();
		this.task_logo = task.getTask_logo();
		this.task_name = task.getTask_name();
		this.level = task.getDifficulty_level();
		this.s_date = task.getStart_date();
		this.e_date = task.getEnd_date();
		this.info = task.getTask_info();
		this.status = task.getStatus();
		this.self_level = self_level;
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
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public Date getE_date() {
		return e_date;
	}
	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSelf_level() {
		return self_level;
	}
	public void setSelf_level(int self_level) {
		this.self_level = self_level;
	}
	@Override
	public String toString() {
		return "TaskStuInf [t_id=" + t_id + ", t_name=" + t_name + ", task_logo=" + task_logo + ", task_name="
				+ task_name + ", level=" + level + ", s_date=" + s_date + ", e_date=" + e_date + ", info=" + info
				+ ", status=" + status + ", self_level=" + self_level + "]";
	}
	
}
