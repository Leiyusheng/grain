package grain.dto;

import grain.po.Teacher;

public class TchSimpleInf {
	private String t_id;
	private String head_logo;
	private String t_name;
	private String sign;
	
	public TchSimpleInf(){}
	
	public TchSimpleInf(Teacher teacher) {
		this.t_id = teacher.getTeacher_id();
		this.head_logo = teacher.getHead_logo();
		this.t_name = teacher.getTeacher_name();
		this.sign = teacher.getPersonalized_signature();
	}

	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getHead_logo() {
		return head_logo;
	}
	public void setHead_logo(String head_logo) {
		this.head_logo = head_logo;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "TchSimpleInfo [t_id=" + t_id + ", head_logo=" + head_logo + ", t_name=" + t_name + ", sign=" + sign
				+ "]";
	}
	
}
