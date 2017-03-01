package grain.dto;

import java.util.ArrayList;
import java.util.List;

public class GroupList {
	private List<GroupInf> grpInfo;

	public GroupList() {
		grpInfo=new ArrayList<GroupInf>();
	}
	public void addGroupInfo(GroupInf groupInfo){
		grpInfo.add(groupInfo);
	}
	
	public List<GroupInf> getGrpInfo() {
		return grpInfo;
	}
}
