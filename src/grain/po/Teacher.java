package grain.po;

import java.sql.Date;

public class Teacher {
	private String teacher_id;
	private String teacher_name;
	private String password;
	private String phone_number;
	private String head_logo;
	private int gender;
	private Date birthday;
	private String personalized_signature;
	private String teacher_info;
	private int student_count;
	private String home_background;
	private String board_background;
	
	public Teacher() {}
	
	public Teacher(String id, String name, String phone, String pwd){
		this.teacher_id = id;
		this.teacher_name = name;
		this.phone_number = phone;
		this.password = pwd;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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
	public String getPersonalized_signature() {
		return personalized_signature;
	}
	public void setPersonalized_signature(String personalized_signature) {
		this.personalized_signature = personalized_signature;
	}
	public String getTeacher_info() {
		return teacher_info;
	}
	public void setTeacher_info(String teacher_info) {
		this.teacher_info = teacher_info;
	}
	public int getStudent_count() {
		return student_count;
	}
	public void setStudent_count(int student_count) {
		this.student_count = student_count;
	}
	public String getHome_background() {
		return home_background;
	}

	public void setHome_background(String home_background) {
		this.home_background = home_background;
	}

	public String getBoard_background() {
		return board_background;
	}

	public void setBoard_background(String board_background) {
		this.board_background = board_background;
	}

	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", password=" + password
				+ ", phone_number=" + phone_number + ", head_logo=" + head_logo + ", gender=" + gender + ", birthday="
				+ birthday + ", personalized_signature=" + personalized_signature + ", teacher_info=" + teacher_info
				+ ", student_count=" + student_count + ", home_background=" + home_background + ", board_background="
				+ board_background + "]";
	}
	
	
}
