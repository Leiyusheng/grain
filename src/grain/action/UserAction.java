package grain.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import grain.dto.MsgId;
import grain.dto.MsgUrl;
import grain.po.Praise;
import grain.dto.Msg;
import grain.service.UserService;
import grain.service.VerifyCodeService;

@Controller
public class UserAction {
	
	@Autowired
	private UserService userService;
	@Autowired
	private VerifyCodeService verifyCodeService;
	
	@RequestMapping("/login")
	public @ResponseBody MsgId login(int identity,String phone,String pwd)throws Exception{
		if((identity==1||identity==2)&&phone.length()==11&&pwd.length()>5&&pwd.length()<17){
			return userService.login(identity, phone, pwd);
		}
		MsgId loginMsg=new MsgId(3,null);
		return loginMsg;
	}
	
	@RequestMapping("/register")
	public @ResponseBody Msg register(int identity,String phone,String pwd,String pic_code,String sms_code,HttpServletRequest request)throws Exception{
		int inf=0;
		if((identity==1||identity==2)&&phone.length()==11&&pwd.length()>5&&pwd.length()<17){
			inf=userService.checkVerifyCode(1, pic_code, request);
			if(inf==0){
				inf=userService.checkVerifyCode(2, sms_code, request);
				if(inf==0){
					return userService.insertUser(identity, phone, pwd);
				}
			}
		}
		Msg msg=new Msg(inf);
		return msg;
	}
	
	@RequestMapping("/forgetPwd")
	public @ResponseBody Msg forgetPwd(int identity,String phone,String new_pwd,String pic_code,String sms_code,HttpServletRequest request)throws Exception{
		int inf=3;
		if((identity==1||identity==2)&&phone.length()==11&&new_pwd.length()>5&&new_pwd.length()<17){
			inf=userService.checkVerifyCode(1, pic_code, request);
			if(inf==0){
				inf=userService.checkVerifyCode(2, sms_code, request);
				if(inf==0){
					int method=1;
					return userService.updatePwd(method, identity, phone, new_pwd);
				}
			}
		}
		Msg msg=new Msg(inf);
		return msg;
	}
	
	@RequestMapping("/changePwd")
	public @ResponseBody Msg changePwd(int identity,String id,String new_pwd,String pic_code,String sms_code,HttpServletRequest request)throws Exception{
		int inf=3;
		if((identity==1||identity==2)&&new_pwd.length()>5&&new_pwd.length()<17){
			inf=userService.checkVerifyCode(1, pic_code, request);
			if(inf==0){
				inf=userService.checkVerifyCode(2, sms_code, request);
				if(inf==0){
					int method=2;
					return userService.updatePwd(method, identity, id, new_pwd);
				}
			}
		}
		Msg msg=new Msg(inf);
		return msg;
	}
	
	@RequestMapping("/handleApply")
	public @ResponseBody Msg handleApply(String t_id,String s_id)throws Exception{
		int method=1;
		return userService.updateContact(t_id, s_id, method);
	}
	
	@RequestMapping("/givePraise")
	public @ResponseBody Msg givePraise(Praise praise)throws Exception{
		return userService.updatePraise(praise);
	}
	
	@RequestMapping("/checkBoardPic")
	public @ResponseBody MsgUrl checkBoardPic(int identity,String id)throws Exception{
		return userService.checkBoardPic(identity, id);
	}
	
	@RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException { 
		//设置浏览器不要对数据进行缓存
        response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        //设置返回文件类型
        response.setContentType("image/jpeg");
        //生成随机字串  
        String verifyCode = verifyCodeService.generateVerifyCode(4);  
        //将验证码文本存入会话session
        HttpSession session = request.getSession(true);
        session.setAttribute("pic_code", verifyCode.toLowerCase());  
        //生成图片  
        int w = 220, h = 60;  
        verifyCodeService.outputImage(w, h, response.getOutputStream(), verifyCode);  
    }
	
	@RequestMapping("/getSmsCode")
	public @ResponseBody Msg getSmsCode(int method,String code,String phone,HttpServletRequest request){
		int inf=-1;
		inf=userService.checkVerifyCode(1, code, request);
		if(inf==0){
			try{
				inf=userService.checkPhone(method, phone);
			}
			catch (Exception e){
				inf=-1;
			}
		}
		if(inf==0){
			code=verifyCodeService.generateVerifyCode(4);
			HttpSession session = request.getSession(true);
	        session.setAttribute("sms_code", code); 
	        inf=verifyCodeService.sendSmsCode(phone, code);
		}
		Msg msg=new Msg(inf);
		return msg;
	}
	
	/**
     * 上传单个文件
     * @param file 上传文件 MultipartFile 的对象
     */
    @RequestMapping(value = "/uploadHeadPic", method = RequestMethod.POST)
    public @ResponseBody MsgUrl uploadHeadPic(@RequestParam("file") MultipartFile file) throws Exception{
    	int method=1;
        return userService.saveFile(method,file);
    }
    
    @RequestMapping(value = "/uploadTaskPic", method = RequestMethod.POST)
    public @ResponseBody MsgUrl uploadTaskPic(@RequestParam("file") MultipartFile file) throws Exception{
    	int method=2;
        return userService.saveFile(method,file);
    }
    
    @RequestMapping(value = "/uploadResultPic", method = RequestMethod.POST)
    public @ResponseBody MsgUrl uploadResultPic(@RequestParam("file") MultipartFile file) throws Exception{
    	int method=3;
        return userService.saveFile(method,file);
    }
    
    @RequestMapping(value = "/uploadBoardPic", method = RequestMethod.POST)
    public @ResponseBody MsgUrl uploadBoardPic(@RequestParam("file") MultipartFile file) throws Exception{
    	int method=4;
        return userService.saveFile(method,file);
    }
    
    @RequestMapping(value = "/uploadHomePic", method = RequestMethod.POST)
    public @ResponseBody MsgUrl uploadHomePic(@RequestParam("file") MultipartFile file) throws Exception{
    	int method=5;
        return userService.saveFile(method,file);
    }
}
