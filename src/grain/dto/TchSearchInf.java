package grain.dto;

import grain.po.Teacher;

public class TchSearchInf {
	private String t_id;
	private String t_name;
	private String head_logo;
	private int gender;
	private String sign;
	
	public TchSearchInf() {}
	
	public TchSearchInf(Teacher teacher) {
		this.t_id = teacher.getTeacher_id();
		this.t_name = teacher.getTeacher_name();
		this.head_logo = teacher.getHead_logo();
		this.gender = teacher.getGender();
		this.sign = teacher.getPersonalized_signature();
	}
	
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
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
		return "TchSearchInf [t_id=" + t_id + ", t_name=" + t_name + ", head_logo=" + head_logo + ", gender=" + gender
				+ ", sign=" + sign + "]";
	}
	
}
