package grain.po;

import java.sql.Date;

public class Task {
	private String task_id;
	private String teacher_id;
	private String teacher_name;
	private String task_logo;
	private String task_name;
	private int difficulty_level;
	private Date start_date;
	private Date end_date;
	private String task_info;
	private int status;
	private int total_num;
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
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
	public int getDifficulty_level() {
		return difficulty_level;
	}
	public void setDifficulty_level(int difficulty_level) {
		this.difficulty_level = difficulty_level;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getTask_info() {
		return task_info;
	}
	public void setTask_info(String task_info) {
		this.task_info = task_info;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTotal_num() {
		return total_num;
	}
	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}
	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", teacher_id=" + teacher_id + ", teacher_name=" + teacher_name
				+ ", task_logo=" + task_logo + ", task_name=" + task_name + ", difficulty_level=" + difficulty_level
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", task_info=" + task_info + ", status="
				+ status + ", total_num=" + total_num + "]";
	}
}
