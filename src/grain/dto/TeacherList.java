package grain.dto;

import java.util.ArrayList;
import java.util.List;

public class TeacherList {
	private List<TchSimpleInf> tchInfo;
	
	public TeacherList() {
		tchInfo=new ArrayList<TchSimpleInf>();
	}
	
	public void addTchInfo(TchSimpleInf tInfo){
		tchInfo.add(tInfo);
	}

	public List<TchSimpleInf> getTchInfo() {
		return tchInfo;
	}

	public void setTchInfo(List<TchSimpleInf> tchInfo) {
		this.tchInfo = tchInfo;
	}
	
}
