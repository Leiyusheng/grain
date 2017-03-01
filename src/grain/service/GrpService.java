package grain.service;

import java.util.List;

import grain.dto.StudentList;
import grain.dto.Msg;

public interface GrpService {
	
	public Msg updateGrpName(String g_id,String g_name)throws Exception;
	
	public Msg updateGrpStu(String g_id,List<String> s_ids)throws Exception;
	
	public Msg deleteGrpStu(String g_id,String s_id)throws Exception;
	
	public StudentList findGrpStu(String g_id)throws Exception;

}
