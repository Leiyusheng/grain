package grain.service;

import grain.dto.MsgId;
import grain.dto.MsgUrl;
import grain.po.Praise;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import grain.dto.Msg;

public interface UserService {
    /**
     * 用户登录
     * @param identity 用户身份：1老师，2学生
     * @param phone 电话
     * @param pwd 密码
     * @return MsgId 返回消息：0成功，1密码错误，2无此用户；用户id
     * @throws Exception
     */
    public MsgId login(int identity,String phone,String pwd)throws Exception;
    /**
     * 检测电话号码是否有效
     * @param method 方式：1老师注册，2学生注册，3老师修改密码，4学生修改密码
     * @param phone 电话
     * @return 0有效，3无效
     * @throws Exception
     */
    public int checkPhone(int method,String phone)throws Exception;
    /**
     * 插入用户
     * @param identity 用户身份：1老师，2学生
     * @param phone 电话
     * @param pwd 密码
     * @return Msg 返回消息：0注册成功，2用户存在，3其他
     * @throws Exception
     */
    public Msg insertUser(int identity,String phone,String pwd)throws Exception;
    /**
     * 修改密码
     * @param method 修改方式：1传电话，2传id
     * @param identity 用户身份：1老师，2学生
     * @param phone 电话/id
     * @param new_pwd 新密码
     * @return Msg 返回消息：0注册成功，2用户存在，3其他
     * @throws Exception
     */
    public Msg updatePwd(int method,int identity,String phone,String new_pwd)throws Exception;
    /**
     * 更新师生关系
     * @param t_id 老师id
     * @param s_id 学生id
     * @param method 师生关系：1同意，2删除
     * @return Msg 返回消息：0成功，1其他
     * @throws Exception
     */
    public Msg updateContact(String t_id,String s_id,int method)throws Exception;
    /**
     * 更新赞的状态
     * @param praise 赞信息
     * @return Msg 返回消息：0成功，1其他
     * @throws Exception
     */
    public Msg updatePraise(Praise praise)throws Exception;
    /**
     * 查看任务板背景图片
     * @param identity 身份：1老师，2学生
     * @param id 用户id
     * @return MsgUrl 返回消息：0成功，1其他；图片url
     * @throws Exception
     */
    public MsgUrl checkBoardPic(int identity,String id)throws Exception;
    /**
     * 检查验证码
     * @param way 方式：1图片验证码，2短信验证码
     * @param code 验证码
     * @param request
     * @return 0为验证成功，1为图片验证错误，4为session中没有图片验证码，5为短信验证错误，6为session中没有短信验证码
     */
    public int checkVerifyCode(int way,String code,HttpServletRequest request);
    /**
     * 上传图片
     * @param method 图片类型：1为头像，2为任务图片，3为结果图片
     * @param file 图片文件
     * @return MsgUrl 返回消息：0成功，1其他；图片url
     * @throws Exception
     */
    public MsgUrl saveFile(int method, MultipartFile file)throws Exception;
}
