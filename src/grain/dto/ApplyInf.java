package grain.dto;

import grain.po.Contact;

public class ApplyInf {
	
	private String id;
	private String head_logo;
	private String name;
	private String info;
	private int status;
	
	public ApplyInf(){}
	
	
	public ApplyInf(int identity,Contact contact) {
		if(identity==1){
			this.id = contact.getStudent_id();
			this.head_logo = contact.getHead_logo();
			this.name = contact.getStudent_name();
			this.info = contact.getApply_info();
			this.status = contact.getStatus();
		}
		else if(identity==2){
			this.id = contact.getTeacher_id();
			this.head_logo = contact.getHead_logo();
			this.name = contact.getTeacher_name();
			this.info = contact.getApply_info();
			this.status = contact.getStatus();
		}
		
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHead_logo() {
		return head_logo;
	}
	public void setHead_logo(String head_logo) {
		this.head_logo = head_logo;
	}
	public String getName() {
		return name;
	}
	public void setS_name(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ApplyInfo [id=" + id + ", head_logo=" + head_logo + ", name=" + name + ", info=" + info
				+ ", status=" + status + "]";
	}
	
}
