package grain.po;

import java.sql.Date;

public class Student{

	private String student_id;
	private String student_name;
	private String password;
	private String phone_number;
	private String head_logo;
	private int gender;
	private Date birthday;
	private String personalized_signature;
	private String student_info;
	private int access_permission;
	private String home_background;
	private String board_background;
	
	public Student() {}
	
	public Student(String student_id, String student_name, String phone_number, String password) {
		this.student_id = student_id;
		this.password = password;
		this.phone_number = phone_number;
		this.student_name = student_name;
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
	public String getStudent_info() {
		return student_info;
	}
	public void setStudent_info(String student_info) {
		this.student_info = student_info;
	}
	public int getAccess_permission() {
		return access_permission;
	}
	public void setAccess_permission(int access_permission) {
		this.access_permission = access_permission;
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
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", password=" + password
				+ ", phone_number=" + phone_number + ", head_logo=" + head_logo + ", gender=" + gender + ", birthday="
				+ birthday + ", personalized_signature=" + personalized_signature + ", student_info=" + student_info
				+ ", access_permission=" + access_permission + ", home_background=" + home_background
				+ ", board_background=" + board_background + "]";
	}
	
}
