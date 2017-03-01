package grain.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import grain.po.Group;
import grain.po.Student;

public interface GrpMapper {
		
	public Group findDefaultGroupById(String id)throws Exception;
	
	public Group findGroupByName(@Param("t_id")String id,@Param("grp_name")String name)throws Exception;
	
	public List<Group> findGroupListById(String id)throws Exception;
	
	public int insertGroup(Group group)throws Exception;
	
	public int deleteGroup(String id)throws Exception;
	
	public List<Student> findGroupStu(String id)throws Exception;
	
	public int insertGroupStu(@Param("g_id")String g_id,@Param("s_id")String s_id)throws Exception;
	
	public int deleteGroupStu(@Param("g_id")String g_id,@Param("s_id")String s_id)throws Exception;
	
	public int deleteStu(@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;
	
	public int updateStuCount(@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;
	
	public int updateGroupStuCount(@Param("status")int status,@Param("g_id")String g_id)throws Exception;
	
	public int updateGroupName(@Param("g_id")String g_id,@Param("g_name")String g_name)throws Exception;
}
