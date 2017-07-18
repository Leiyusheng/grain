package grain.service;

import java.util.List;

import grain.dto.StudentList;
import grain.dto.Msg;

public interface GrpService {
	/**
	 * �޸ķ�����
	 * @param t_id ��ʦid
	 * @param g_id ����id
	 * @param g_name ������
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateGrpName(String t_id,String g_id,String g_name)throws Exception;
	/**
	 * �޸ķ���ѧ��
	 * @param g_id ����id
	 * @param s_ids �����ڵ�ѧ��id����
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateGrpStu(String g_id,List<String> s_ids)throws Exception;
	/**
	 * ɾ������ѧ��
	 * @param g_id ����id
	 * @param s_id ��Ҫɾ����ѧ��id
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg deleteGrpStu(String g_id,String s_id)throws Exception;
	/**
	 * �鿴������ѧ��
	 * @param g_id ����id
	 * @return StudentList ѧ���б�
	 * @throws Exception
	 */
	public StudentList findGrpStu(String g_id)throws Exception;

}
