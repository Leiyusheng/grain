package grain.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
	private List<StuSimpleInf> stuInfo;
	
	public StudentList() {
		stuInfo=new ArrayList<StuSimpleInf>();
	}
	
	public void addStuInfo(StuSimpleInf sInfo){
		stuInfo.add(sInfo);
	}

	public List<StuSimpleInf> getStuInfo() {
		return stuInfo;
	}

	public void setStuInfo(List<StuSimpleInf> stuInfo) {
		this.stuInfo = stuInfo;
	}
	
}
