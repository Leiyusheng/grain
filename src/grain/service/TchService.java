package grain.service;

import grain.dto.ApplyList;
import grain.dto.CheckTchInf;
import grain.dto.CheckSearchInf;
import grain.dto.GroupList;
import grain.dto.Msg;

public interface TchService {
	/**
	 * ͨ���绰������ʦ
	 * @param s_id ѧ��id
	 * @param phone ��ʦ�绰
	 * @return CheckSearchInf ����ʦ�Ĳ�����Ϣ
	 * @throws Exception
	 */
	public CheckSearchInf findTchByPhone(String s_id,String phone)throws Exception;
	/**
	 * �鿴��ʦ��Ϣ
	 * @param t_id ��ʦid
	 * @return CheckTchInf ��ʦ������Ϣ
	 * @throws Exception
	 */
	public CheckTchInf findTchInf(String t_id)throws Exception;
	/**
	 * �޸���ʦ��
	 * @param t_id ��ʦid
	 * @param t_name ��ʦ��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTchName(String t_id,String t_name)throws Exception;
	/**
	 * �޸���ʦͷ��
	 * @param t_id ��ʦid
	 * @param logo ͷ��ͼƬ·��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTchLogo(String t_id,String logo)throws Exception;
	/**
	 * �޸���ʦ�Ա�
	 * @param t_id ��ʦid
	 * @param gender ��ʦ�Ա�
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTchGender(String t_id,int gender)throws Exception;
	/**
	 * �޸���ʦ����
	 * @param t_id ��ʦid
	 * @param birthday ��ʦ����
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTchBirthday(String t_id,String birthday)throws Exception;
	/**
	 * �޸���ʦǩ��
	 * @param t_id ��ʦid
	 * @param sign ��ʦǩ��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTchSign(String t_id,String sign)throws Exception;
	/**
	 * �޸���ʦ��ע
	 * @param t_id ��ʦid
	 * @param inf ��ʦ��ע
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTchInf(String t_id,String inf)throws Exception;
	/**
	 * �޸���ʦ������ҳ����
	 * @param t_id ��ʦid
	 * @param home_pic ����ͼƬ·��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTchHomePic(String t_id,String home_pic)throws Exception;
	/**
	 * �޸���ʦ����屳��
	 * @param t_id ��ʦid
	 * @param board_pic ����ͼƬ·��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTchBoardPic(String t_id,String board_pic)throws Exception;
	/**
	 * ���¶�ѧ��������
	 * @param s_id ѧ��id
	 * @param t_id ��ʦid
	 * @param info ���뱸ע
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateStuApply(String s_id,String t_id,String info)throws Exception;
	/**
	 * �鿴��ʦ�������¼
	 * @param t_id ��ʦid
	 * @return ApplyList �����б�
	 * @throws Exception
	 */
	public ApplyList findApplyList(String t_id)throws Exception;
	/**
	 * ɾ�������¼
	 * @param t_id ��ʦid
	 * @param s_id ѧ��id
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg deleteApply(String t_id,String s_id)throws Exception;
	/**
	 * �鿴�Ƿ����µ�ѧ�������¼
	 * @param t_id ��ʦid
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg findWhetherStuApply(String t_id)throws Exception;
	/**
	 * �鿴��ʦ�����б�
	 * @param t_id ��ʦid
	 * @return GroupList �����б�
	 * @throws Exception
	 */
	public GroupList findGroupListById(String t_id)throws Exception;
	/**
	 * �½�����
	 * @param t_id ��ʦid
	 * @param grp_name �·�����
	 * @return Msg ������Ϣ��0�ɹ���1���������ڣ�2����
	 * @throws Exception
	 */
	public Msg insertGroup(String t_id,String grp_name)throws Exception;
	/**
	 * ɾ������
	 * @param g_id ����id
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg deleteGroup(String g_id)throws Exception;
}
