package grain.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import grain.po.Contact;

public interface CtctMapper {
	
	public Contact findContactById(@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;
	
	public Contact findContactByTchPhone(@Param("phone")String phone,@Param("s_id")String s_id)throws Exception;
	
	public Contact findContactByStuPhone(@Param("phone")String phone,@Param("t_id")String t_id)throws Exception;
	
	public Contact findTchNewContact(String t_id)throws Exception;
	
	public List<Contact> findStuApplyListById(String id)throws Exception;
	
	public List<Contact> findTchApplyListById(String id)throws Exception;
	
	public int updateContact(@Param("status")int status,@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;
	
	public int updateShowStatus(@Param("status")int status,@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;
	
	public int updateContactTime(@Param("info")String info,@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;

	public int insertContact(Contact contact)throws Exception;
}
