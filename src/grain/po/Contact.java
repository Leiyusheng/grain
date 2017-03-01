package grain.po;

import java.util.Date;

public class Contact {
	
	private String teacher_id;
	private String teacher_name;
	private String student_id;
	private String student_name;
	private String head_logo;
	private int status;
	private int show_status;
	private Date create_time;
	private String apply_info;
	
	public Contact(){}
	
	public Contact(String teacher_id, String student_id, int status, int show_status, String apply_info) {
		super();
		this.teacher_id = teacher_id;
		this.student_id = student_id;
		this.status = status;
		this.show_status = show_status;
		this.apply_info = apply_info;
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

	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getHead_logo() {
		return head_logo;
	}
	public void setHead_logo(String head_logo) {
		this.head_logo = head_logo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getShow_status() {
		return show_status;
	}
	public void setShow_status(int show_status) {
		this.show_status = show_status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getApply_info() {
		return apply_info;
	}
	public void setApply_info(String apply_info) {
		this.apply_info = apply_info;
	}
	@Override
	public String toString() {
		return "Contact [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", student_id=" + student_id
				+ ", student_name=" + student_name + ", head_logo=" + head_logo + ", status=" + status
				+ ", show_status=" + show_status + ", create_time=" + create_time + ", apply_info=" + apply_info + "]";
	}
	
}
