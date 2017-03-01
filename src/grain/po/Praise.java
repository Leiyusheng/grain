package grain.po;

import java.util.Date;

public class Praise {
	private String task_result_id;
	private String person_id;
	private int praise_status;
	private Date create_time;
	
	public String getTask_result_id() {
		return task_result_id;
	}
	public void setTask_result_id(String task_result_id) {
		this.task_result_id = task_result_id;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public int getPraise_status() {
		return praise_status;
	}
	public void setPraise_status(int praise_status) {
		this.praise_status = praise_status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Praise [task_result_id=" + task_result_id + ", person_id=" + person_id + ", praise_status="
				+ praise_status + ", create_time=" + create_time + "]";
	}
	
}
