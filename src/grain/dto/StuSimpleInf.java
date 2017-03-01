package grain.dto;

import grain.po.Student;

public class StuSimpleInf {
	private String s_id;
	private String head_logo;
	private String s_name;
	private String sign;
	
	public StuSimpleInf(){}
	
	public StuSimpleInf(Student student) {
		this.s_id = student.getStudent_id();
		this.head_logo = student.getHead_logo();
		this.s_name = student.getStudent_name();
		this.sign = student.getPersonalized_signature();
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getHead_logo() {
		return head_logo;
	}

	public void setHead_logo(String head_logo) {
		this.head_logo = head_logo;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "StuSimpleInfo [s_id=" + s_id + ", head_logo=" + head_logo + ", s_name=" + s_name + ", sign=" + sign
				+ "]";
	}
	
}
