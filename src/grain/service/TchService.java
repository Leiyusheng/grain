package grain.service;

import grain.dto.ApplyList;
import grain.dto.CheckTchInf;
import grain.dto.CheckTchSearchInf;
import grain.dto.GroupList;
import grain.dto.Msg;

public interface TchService {
	
	public CheckTchSearchInf findTchByPhone(String s_id,String phone)throws Exception;
	
	public CheckTchInf findTchInf(String t_id)throws Exception;
	
	public Msg updateTchName(String t_id,String t_name)throws Exception;
	
	public Msg updateTchLogo(String t_id,String logo)throws Exception;
	
	public Msg updateTchGender(String t_id,int gender)throws Exception;
	
	public Msg updateTchBirthday(String t_id,String birthday)throws Exception;
	
	public Msg updateTchSign(String t_id,String sign)throws Exception;
	
	public Msg updateTchInf(String t_id,String inf)throws Exception;
	
	public Msg updateTchHomePic(String t_id,String home_pic)throws Exception;
	
	public Msg updateTchBoardPic(String t_id,String board_pic)throws Exception;
	
	public ApplyList findApplyList(String t_id)throws Exception;
	
	public Msg deleteApply(String t_id,String s_id)throws Exception;
	
	public GroupList findGroupListById(String t_id)throws Exception;
	
	public Msg insertGroup(String t_id,String grp_name)throws Exception;
	
	public Msg deleteGroup(String g_id)throws Exception;
}
