package grain.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import grain.po.Contact;

public interface CtctMapper {
	
	public Contact findContactById(@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;
	
	public Contact findContactByPhone(@Param("phone")String phone,@Param("s_id")String s_id)throws Exception;
	
	public List<Contact> findApplyListById(String id)throws Exception;
	
	public List<Contact> findAppliedListById(String id)throws Exception;
	
	public int updateContact(@Param("status")int status,@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;
	
	public int updateShowStatus(@Param("status")int status,@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;
	
	public int updateContactTime(@Param("info")String info,@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;

	public int insertContact(Contact contact)throws Exception;
}
