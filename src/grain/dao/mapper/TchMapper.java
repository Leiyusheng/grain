package grain.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import grain.po.Teacher;

public interface TchMapper {
	
	public Teacher findTchById(String id)throws Exception;
	
	public Teacher findTchByPhone(String phone)throws Exception;
	
	public int insertTch(Teacher teacher)throws Exception;
	
	public int updateTchById(Teacher teacher)throws Exception;
	
	public List<Teacher> findTchListById(String id)throws Exception;
	
	public int updateTchStuCount(@Param("status")int status,@Param("t_id")String t_id)throws Exception;
}
