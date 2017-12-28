package grain.po;

import java.util.Date;

public class Group {
	private String group_id;
	private String teacher_id;
	private String group_name;
	private int student_count;
	private Date create_time;

	public Group() {}

	public Group(String group_id, String teacher_id) {
		this.group_id = group_id;
		this.teacher_id = teacher_id;
		this.group_name = "所有人";
	}

	public Group(String group_id, String teacher_id, String group_name) {
		super();
		this.group_id = group_id;
		this.teacher_id = teacher_id;
		this.group_name = group_name;
	}

	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public int getStudent_count() {
		return student_count;
	}
	public void setStudent_count(int student_count) {
		this.student_count = student_count;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Group [group_id=" + group_id + ", teacher_id=" + teacher_id + ", group_name=" + group_name
				+ ", student_count=" + student_count + ", create_time=" + create_time + "]";
	}

}
