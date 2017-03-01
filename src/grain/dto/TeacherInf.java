package grain.dto;

import java.sql.Date;

import grain.po.Teacher;

public class TeacherInf {
	private String t_name;
	private String head_logo;
	private int gender;
	private Date birthday;
	private String signature;
	private String info;
	private String phone;
	private String home_pic;
	
	public TeacherInf(){}
	
	public TeacherInf(Teacher teacher) {
		this.t_name = teacher.getTeacher_name();
		this.head_logo = teacher.getHead_logo();
		this.gender = teacher.getGender();
		this.birthday = teacher.getBirthday();
		this.signature = teacher.getPersonalized_signature();
		this.info = teacher.getTeacher_info();
		this.phone = teacher.getPhone_number();
		this.home_pic = teacher.getHome_background();
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHome_pic() {
		return home_pic;
	}

	public void setHome_pic(String home_pic) {
		this.home_pic = home_pic;
	}

	@Override
	public String toString() {
		return "TeacherInf [t_name=" + t_name + ", head_logo=" + head_logo + ", gender=" + gender + ", birthday="
				+ birthday + ", signature=" + signature + ", info=" + info + ", phone=" + phone + ", home_pic="
				+ home_pic + "]";
	}
	
}
