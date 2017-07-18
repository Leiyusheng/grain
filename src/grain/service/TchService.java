package grain.service;

import grain.dto.ApplyList;
import grain.dto.CheckTchInf;
import grain.dto.CheckSearchInf;
import grain.dto.GroupList;
import grain.dto.Msg;

public interface TchService {
	/**
	 * 通过电话查找老师
	 * @param s_id 学生id
	 * @param phone 老师电话
	 * @return CheckSearchInf 该老师的查找信息
	 * @throws Exception
	 */
	public CheckSearchInf findTchByPhone(String s_id,String phone)throws Exception;
	/**
	 * 查看老师信息
	 * @param t_id 老师id
	 * @return CheckTchInf 老师个人信息
	 * @throws Exception
	 */
	public CheckTchInf findTchInf(String t_id)throws Exception;
	/**
	 * 修改老师名
	 * @param t_id 老师id
	 * @param t_name 老师名
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateTchName(String t_id,String t_name)throws Exception;
	/**
	 * 修改老师头像
	 * @param t_id 老师id
	 * @param logo 头像图片路径
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateTchLogo(String t_id,String logo)throws Exception;
	/**
	 * 修改老师性别
	 * @param t_id 老师id
	 * @param gender 老师性别
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateTchGender(String t_id,int gender)throws Exception;
	/**
	 * 修改老师生日
	 * @param t_id 老师id
	 * @param birthday 老师生日
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateTchBirthday(String t_id,String birthday)throws Exception;
	/**
	 * 修改老师签名
	 * @param t_id 老师id
	 * @param sign 老师签名
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateTchSign(String t_id,String sign)throws Exception;
	/**
	 * 修改老师备注
	 * @param t_id 老师id
	 * @param inf 老师备注
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateTchInf(String t_id,String inf)throws Exception;
	/**
	 * 修改老师个人主页背景
	 * @param t_id 老师id
	 * @param home_pic 背景图片路径
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateTchHomePic(String t_id,String home_pic)throws Exception;
	/**
	 * 修改老师任务板背景
	 * @param t_id 老师id
	 * @param board_pic 背景图片路径
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateTchBoardPic(String t_id,String board_pic)throws Exception;
	/**
	 * 更新对学生的申请
	 * @param s_id 学生id
	 * @param t_id 老师id
	 * @param info 申请备注
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateStuApply(String s_id,String t_id,String info)throws Exception;
	/**
	 * 查看老师的申请记录
	 * @param t_id 老师id
	 * @return ApplyList 申请列表
	 * @throws Exception
	 */
	public ApplyList findApplyList(String t_id)throws Exception;
	/**
	 * 删除申请记录
	 * @param t_id 老师id
	 * @param s_id 学生id
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg deleteApply(String t_id,String s_id)throws Exception;
	/**
	 * 查看是否有新的学生申请记录
	 * @param t_id 老师id
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg findWhetherStuApply(String t_id)throws Exception;
	/**
	 * 查看老师分组列表
	 * @param t_id 老师id
	 * @return GroupList 分组列表
	 * @throws Exception
	 */
	public GroupList findGroupListById(String t_id)throws Exception;
	/**
	 * 新建分组
	 * @param t_id 老师id
	 * @param grp_name 新分组名
	 * @return Msg 返回信息：0成功，1分组名存在，2其他
	 * @throws Exception
	 */
	public Msg insertGroup(String t_id,String grp_name)throws Exception;
	/**
	 * 删除分组
	 * @param g_id 分组id
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg deleteGroup(String g_id)throws Exception;
}
