package grain.dto;

import java.sql.Date;

import grain.po.Student;

public class StudentInf {
	private String s_name;
	private String head_logo;
	private int gender;
	private Date birthday;
	private String signature;
	private String info;
	private String phone;
	private String home_pic;
	
	public StudentInf(){}
	
	public StudentInf(Student student){
		this.s_name=student.getStudent_name();
		this.head_logo=student.getHead_logo();
		this.gender=student.getGender();
		this.birthday=student.getBirthday();
		this.signature=student.getPersonalized_signature();
		this.info=student.getStudent_info();
		this.phone=student.getPhone_number();
		this.home_pic=student.getHome_background();
	}
	
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
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
		return "StudentInf [s_name=" + s_name + ", head_logo=" + head_logo + ", gender=" + gender + ", birthday="
				+ birthday + ", signature=" + signature + ", info=" + info + ", phone=" + phone + ", home_pic="
				+ home_pic + "]";
	}
	
	
}
