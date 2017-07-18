package grain.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import grain.po.Student;
import grain.po.Task;

public class TaskResultList {
	private int msg;
	private Date s_date;
	private Date e_date;
	private String s_name;
	private String t_name;
	private String s_phone;
	private String task_name;
	private int status;
	private List<TaskResultSimpleInf> resultInf;
	
	public TaskResultList(int status) {
		msg=status;
		resultInf=new ArrayList<TaskResultSimpleInf>();
	}
	
	public TaskResultList(int msg,Task task,Student stu){
		this.msg = msg;
		this.s_date = task.getStart_date(); 
		this.e_date = task.getEnd_date();
		this.s_name = stu.getStudent_name();
		this.t_name = task.getTeacher_name();
		this.s_phone = stu.getPhone_number();
		this.task_name = task.getTask_name();
		this.status = task.getStatus();
		this.resultInf = new ArrayList<TaskResultSimpleInf>();
	}
	
	public void addTaskResultInf(TaskResultSimpleInf tInf) {
		resultInf.add(tInf);
	}

	
	public int getMsg() {
		return msg;
	}

	public void setMsg(int msg) {
		this.msg = msg;
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

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getS_phone() {
		return s_phone;
	}

	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<TaskResultSimpleInf> getResultInf() {
		return resultInf;
	}

	public void setResultInf(List<TaskResultSimpleInf> resultInf) {
		this.resultInf = resultInf;
	}

	@Override
	public String toString() {
		return "TaskResultList [msg=" + msg + ", s_date=" + s_date + ", e_date=" + e_date + ", s_name=" + s_name
				+ ", t_name=" + t_name + ", s_phone=" + s_phone + ", task_name=" + task_name + ", status=" + status
				+ ", resultInf=" + resultInf + "]";
	}
	
}
