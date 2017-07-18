package grain.service;

import grain.dto.ApplyList;
import grain.dto.CheckStuInf;
import grain.dto.CheckSearchInf;
import grain.dto.Msg;
import grain.dto.TeacherList;

public interface StuService {
	/**
	 * 通过电话查找学生
	 * @param t_id 老师id
	 * @param phone 学生电话
	 * @return CheckSearchInf 该学生的查找信息
	 * @throws Exception
	 */
	public CheckSearchInf findStuByPhone(String t_id,String phone)throws Exception;
	/**
	 * 查看学生信息
	 * @param id 学生id
	 * @return CheckStuInf 学生个人信息
	 * @throws Exception
	 */
	public CheckStuInf findStuInf(String id)throws Exception;
	/**
	 * 修改学生姓名
	 * @param s_id 学生id
	 * @param s_name 学生名
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateStuName(String s_id,String s_name)throws Exception;
	/**
	 * 修改学生头像
	 * @param s_id 学生id
	 * @param logo 头像图片路径
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateStuLogo(String s_id,String logo)throws Exception;
	/**
	 * 修改学生性别
	 * @param s_id 学生id
	 * @param gender 学生性别
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateStuGender(String s_id,int gender)throws Exception;
	/**
	 * 修改学生生日
	 * @param s_id 学生id
	 * @param birthday 学生生日
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateStuBirthday(String s_id,String birthday)throws Exception;
	/**
	 * 修改学生签名
	 * @param s_id 学生id
	 * @param sign 学生签名
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateStuSign(String s_id,String sign)throws Exception;
	/**
	 * 修改学生备注
	 * @param s_id 学生id
	 * @param inf 学生备注
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateStuInf(String s_id,String inf)throws Exception;
	/**
	 * 修改学生个人主页背景
	 * @param s_id 学生id
	 * @param home_pic 背景图片路径
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateStuHomePic(String s_id,String home_pic)throws Exception;
	/**
	 * 修改学生任务板背景
	 * @param s_id 学生id
	 * @param board_pic 背景图片路径
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateStuBoardPic(String s_id,String board_pic)throws Exception;
	/**
	 * 查看学生任务板权限
	 * @param s_id 学生id
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg findStuAccess(String s_id)throws Exception;
	/**
	 * 修改学生任务板权限
	 * @param s_id 学生id
	 * @param access 个人权限
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateStuAccess(String s_id,int access)throws Exception;
	/**
	 * 更新对老师的申请
	 * @param s_id 学生id
	 * @param t_id 老师id
	 * @param info 申请备注
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateTchApply(String s_id,String t_id,String info)throws Exception;
	/**
	 * 查看老师列表
	 * @param s_id 学生id
	 * @return TeacherList 老师列表
	 * @throws Exception
	 */
	public TeacherList findTchList(String s_id)throws Exception;
	/**
	 * 查看学生的申请记录
	 * @param s_id 学生id
	 * @return ApplyList 申请列表
	 * @throws Exception
	 */
	public ApplyList findApplyList(String s_id) throws Exception;
	/**
	 * 删除申请记录
	 * @param t_id 老师id
	 * @param s_id 学生id
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg deleteApply(String t_id, String s_id) throws Exception;
}
