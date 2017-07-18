package grain.dto;

import grain.po.Student;
import grain.po.Teacher;

public class SearchInf {
	private String id;
	private String name;
	private String head_logo;
	private int gender;
	private String sign;
	
	public SearchInf() {}
	
	public SearchInf(Teacher teacher) {
		this.id = teacher.getTeacher_id();
		this.name = teacher.getTeacher_name();
		this.head_logo = teacher.getHead_logo();
		this.gender = teacher.getGender();
		this.sign = teacher.getPersonalized_signature();
	}
	
	public SearchInf(Student student) {
		this.id = student.getStudent_id();
		this.name = student.getStudent_name();
		this.head_logo = student.getHead_logo();
		this.gender = student.getGender();
		this.sign = student.getPersonalized_signature();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHead_logo() {
		return head_logo;
	}

	public void setHead_logo(String head_logo) {
		this.head_logo = head_logo;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "TchSearchInf [id=" + id + ", name=" + name + ", head_logo=" + head_logo + ", gender=" + gender
				+ ", sign=" + sign + "]";
	}
	
	
}
