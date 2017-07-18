package grain.service;

import grain.dto.ApplyList;
import grain.dto.CheckStuInf;
import grain.dto.CheckSearchInf;
import grain.dto.Msg;
import grain.dto.TeacherList;

public interface StuService {
	/**
	 * ͨ���绰����ѧ��
	 * @param t_id ��ʦid
	 * @param phone ѧ���绰
	 * @return CheckSearchInf ��ѧ���Ĳ�����Ϣ
	 * @throws Exception
	 */
	public CheckSearchInf findStuByPhone(String t_id,String phone)throws Exception;
	/**
	 * �鿴ѧ����Ϣ
	 * @param id ѧ��id
	 * @return CheckStuInf ѧ��������Ϣ
	 * @throws Exception
	 */
	public CheckStuInf findStuInf(String id)throws Exception;
	/**
	 * �޸�ѧ������
	 * @param s_id ѧ��id
	 * @param s_name ѧ����
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateStuName(String s_id,String s_name)throws Exception;
	/**
	 * �޸�ѧ��ͷ��
	 * @param s_id ѧ��id
	 * @param logo ͷ��ͼƬ·��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateStuLogo(String s_id,String logo)throws Exception;
	/**
	 * �޸�ѧ���Ա�
	 * @param s_id ѧ��id
	 * @param gender ѧ���Ա�
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateStuGender(String s_id,int gender)throws Exception;
	/**
	 * �޸�ѧ������
	 * @param s_id ѧ��id
	 * @param birthday ѧ������
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateStuBirthday(String s_id,String birthday)throws Exception;
	/**
	 * �޸�ѧ��ǩ��
	 * @param s_id ѧ��id
	 * @param sign ѧ��ǩ��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateStuSign(String s_id,String sign)throws Exception;
	/**
	 * �޸�ѧ����ע
	 * @param s_id ѧ��id
	 * @param inf ѧ����ע
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateStuInf(String s_id,String inf)throws Exception;
	/**
	 * �޸�ѧ��������ҳ����
	 * @param s_id ѧ��id
	 * @param home_pic ����ͼƬ·��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateStuHomePic(String s_id,String home_pic)throws Exception;
	/**
	 * �޸�ѧ������屳��
	 * @param s_id ѧ��id
	 * @param board_pic ����ͼƬ·��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateStuBoardPic(String s_id,String board_pic)throws Exception;
	/**
	 * �鿴ѧ�������Ȩ��
	 * @param s_id ѧ��id
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg findStuAccess(String s_id)throws Exception;
	/**
	 * �޸�ѧ�������Ȩ��
	 * @param s_id ѧ��id
	 * @param access ����Ȩ��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateStuAccess(String s_id,int access)throws Exception;
	/**
	 * ���¶���ʦ������
	 * @param s_id ѧ��id
	 * @param t_id ��ʦid
	 * @param info ���뱸ע
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTchApply(String s_id,String t_id,String info)throws Exception;
	/**
	 * �鿴��ʦ�б�
	 * @param s_id ѧ��id
	 * @return TeacherList ��ʦ�б�
	 * @throws Exception
	 */
	public TeacherList findTchList(String s_id)throws Exception;
	/**
	 * �鿴ѧ���������¼
	 * @param s_id ѧ��id
	 * @return ApplyList �����б�
	 * @throws Exception
	 */
	public ApplyList findApplyList(String s_id) throws Exception;
	/**
	 * ɾ�������¼
	 * @param t_id ��ʦid
	 * @param s_id ѧ��id
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg deleteApply(String t_id, String s_id) throws Exception;
}
