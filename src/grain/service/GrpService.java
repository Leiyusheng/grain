package grain.service;

import java.util.List;

import grain.dto.StudentList;
import grain.dto.Msg;

public interface GrpService {
	/**
	 * 修改分组名
	 * @param t_id 老师id
	 * @param g_id 分组id
	 * @param g_name 分组名
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateGrpName(String t_id,String g_id,String g_name)throws Exception;
	/**
	 * 修改分组学生
	 * @param g_id 分组id
	 * @param s_ids 分组内的学生id数组
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg updateGrpStu(String g_id,List<String> s_ids)throws Exception;
	/**
	 * 删除分组学生
	 * @param g_id 分组id
	 * @param s_id 需要删除的学生id
	 * @return Msg 返回信息：0成功，1其他
	 * @throws Exception
	 */
	public Msg deleteGrpStu(String g_id,String s_id)throws Exception;
	/**
	 * 查看分组内学生
	 * @param g_id 分组id
	 * @return StudentList 学生列表
	 * @throws Exception
	 */
	public StudentList findGrpStu(String g_id)throws Exception;

}
