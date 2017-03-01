package grain.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import grain.po.Task;
import grain.po.Student;

public class TaskTchInf {
	private List<String> s_id;
	private List<String> s_name;
	private String task_logo;
	private String task_name;
	private int level;
	private Date s_date;
	private Date e_date;
	private String info;
	private int status;
	
	public TaskTchInf() {}
	
	public TaskTchInf(Task task,List<Student> tStudent) {
		s_id=new ArrayList<String>();
		s_name=new ArrayList<String>();
		for(int i=0;i<tStudent.size();i++){
			Student student=tStudent.get(i);
			this.s_id.add(student.getStudent_id());
			this.s_name.add(student.getStudent_name());
		}
		this.task_logo = task.getTask_logo();
		this.task_name = task.getTask_name();
		this.level = task.getDifficulty_level();
		this.s_date = task.getStart_date();
		this.e_date = task.getEnd_date();
		this.info = task.getTask_info();
		this.status = task.getStatus();
	}

	public List<String> getS_id() {
		return s_id;
	}
	public void setS_id(List<String> s_id) {
		this.s_id = s_id;
	}
	public List<String> getS_name() {
		return s_name;
	}
	public void setS_name(List<String> s_name) {
		this.s_name = s_name;
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
	@Override
	public String toString() {
		return "TaskTchInf [s_id=" + s_id + ", s_name=" + s_name + ", task_logo=" + task_logo
				+ ", task_name=" + task_name + ", level=" + level + ", s_date=" + s_date + ", e_date=" + e_date
				+ ", info=" + info + ", status=" + status + "]";
	}
	
}
