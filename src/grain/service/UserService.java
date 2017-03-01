package grain.service;

import grain.dto.MsgId;
import grain.dto.MsgUrl;
import grain.po.Praise;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import grain.dto.Msg;

public interface UserService {
	public MsgId login(int identity,String phone,String pwd)throws Exception;
	
	public Msg insertUser(int identity,String phone,String pwd)throws Exception;
	
	public Msg updatePwd(int method,int identity,String phone,String new_pwd)throws Exception;
	
	public Msg updateContact(String t_id,String s_id,int method)throws Exception;
	
	public Msg updatePraise(Praise praise)throws Exception;
	
	public MsgUrl checkBoardPic(int identity,String id)throws Exception;
	
	public int checkVerifyCode(int way,String code,HttpServletRequest request);
	
	public MsgUrl saveFile(int method, MultipartFile file)throws Exception;
}
