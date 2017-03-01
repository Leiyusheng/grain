package grain.dao.mapper;

import grain.po.Student;

public interface StuMapper {
	
	public Student findStuById(String id)throws Exception;
	
	public Student findStuByPhone(String phone)throws Exception;
	
	public int insertStu(Student student)throws Exception;
	
	public int updateStuById(Student student)throws Exception;
	
}
