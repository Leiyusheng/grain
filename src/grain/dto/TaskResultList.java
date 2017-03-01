package grain.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TaskResultList {
	private int msg;
	private Date s_date;
	private Date e_date;
	private int status;
	private List<TaskResultSimpleInf> resultInf;
	
	public TaskResultList(int status) {
		msg=status;
		resultInf=new ArrayList<TaskResultSimpleInf>();
	}
	
	public TaskResultList(int msg,Date start,Date end,int status){
		this.msg = msg;
		this.s_date = start; 
		this.e_date = end;
		this.status = status;
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
		return "TaskResultList [msg=" + msg + ", s_date=" + s_date + ", e_date=" + e_date + ", status=" + status
				+ ", resultInf=" + resultInf + "]";
	}
	
}
