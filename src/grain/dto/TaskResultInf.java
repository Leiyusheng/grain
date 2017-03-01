package grain.dto;

import java.sql.Date;

import grain.po.Task;
import grain.po.TaskResult;

public class TaskResultInf {
	private String task_res_id;
	private String task_name;
	private String t_name;
	private Date s_date;
	private Date e_date;
	private float score;
	private int time;
	private int status;
	
	public TaskResultInf() {}
	
	public TaskResultInf(Task task,TaskResult taskResult) {
		this.task_res_id = taskResult.getTask_result_id();
		this.task_name = taskResult.getTask_name();
		this.t_name = task.getTeacher_name();
		this.s_date = task.getStart_date();
		this.e_date = task.getEnd_date();
		this.score = taskResult.getSelf_score();
		this.time = taskResult.getPractice_time();
		this.status = taskResult.getStatus();
	}
	
	public String getTask_res_id() {
		return task_res_id;
	}
	
	public void setTask_res_id(String task_res_id) {
		this.task_res_id = task_res_id;
	}
	
	public String getTask_name() {
		return task_name;
	}
	
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	
	public String getT_name() {
		return t_name;
	}
	
	public void setT_name(String t_name) {
		this.t_name = t_name;
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
	
	public float getScore() {
		return score;
	}
	
	public void setScore(float score) {
		this.score = score;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TaskResultInf [task_res_id=" + task_res_id + ", task_name=" + task_name + ", t_name=" + t_name
				+ ", s_date=" + s_date + ", e_date=" + e_date + ", score=" + score + ", time=" + time + ", status="
				+ status + "]";
	}
	
}
