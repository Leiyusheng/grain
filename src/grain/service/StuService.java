package grain.service;

import grain.dto.ApplyList;
import grain.dto.CheckStuInf;
import grain.dto.Msg;
import grain.dto.TeacherList;

public interface StuService {
	
	public CheckStuInf findStuInf(String id)throws Exception;
	
	public Msg updateStuName(String s_id,String s_name)throws Exception;
	
	public Msg updateStuLogo(String s_id,String logo)throws Exception;
	
	public Msg updateStuGender(String s_id,int gender)throws Exception;
	
	public Msg updateStuBirthday(String s_id,String birthday)throws Exception;
	
	public Msg updateStuSign(String s_id,String sign)throws Exception;
	
	public Msg updateStuInf(String s_id,String inf)throws Exception;
	
	public Msg updateStuHomePic(String s_id,String home_pic)throws Exception;
	
	public Msg updateStuBoardPic(String s_id,String board_pic)throws Exception;
	
	public Msg findStuAccess(String s_id)throws Exception;
	
	public Msg updateStuAccess(String s_id,int access)throws Exception;

	public Msg updateTchApply(String s_id,String t_id,String info)throws Exception;
	
	public TeacherList findTchList(String s_id)throws Exception;
	
	public ApplyList findAppliedList(String s_id) throws Exception;
	
	public Msg deleteApplied(String t_id, String s_id) throws Exception;
}
