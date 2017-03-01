package grain.dto;

import grain.po.Group;

public class GroupInf {
	private String g_id;
	private String g_name;
	private int count;
	
	public GroupInf() {}
	
	public GroupInf(Group group) {
		this.g_id = group.getGroup_id();
		this.g_name = group.getGroup_name();
		this.count = group.getStudent_count();
	}

	public String getG_id() {
		return g_id;
	}
	public void setG_id(String g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "GroupInfo [g_id=" + g_id + ", g_name=" + g_name + ", count=" + count + "]";
	}
	
}
