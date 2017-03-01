package grain.dto;

import java.util.ArrayList;
import java.util.List;

public class ApplyList {
	private List<ApplyInf> applyInfo;
	
	public ApplyList() {
		applyInfo=new ArrayList<ApplyInf>();
	}
	
	public void addApplyInfo(ApplyInf aInfo){
		applyInfo.add(aInfo);
	}
	
	public List<ApplyInf> getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(List<ApplyInf> applyInfo) {
		this.applyInfo = applyInfo;
	}
	
}
