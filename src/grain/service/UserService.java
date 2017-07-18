package grain.service;

import grain.dto.MsgId;
import grain.dto.MsgUrl;
import grain.po.Praise;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import grain.dto.Msg;

public interface UserService {
	/**
	 * �û���¼
	 * @param identity �û���ݣ�1��ʦ��2ѧ��
	 * @param phone �绰
	 * @param pwd ����
	 * @return MsgId ������Ϣ��0�ɹ���1�������2�޴��û����û�id
	 * @throws Exception
	 */
	public MsgId login(int identity,String phone,String pwd)throws Exception;
	/**
	 * ���绰�����Ƿ���Ч
	 * @param method ��ʽ��1��ʦע�ᣬ2ѧ��ע�ᣬ3��ʦ�޸����룬4ѧ���޸�����
	 * @param phone �绰
	 * @return 0��Ч��3��Ч
	 * @throws Exception
	 */
	public int checkPhone(int method,String phone)throws Exception;
	/**
	 * �����û�
	 * @param identity �û���ݣ�1��ʦ��2ѧ��
	 * @param phone �绰
	 * @param pwd ����
	 * @return Msg ������Ϣ��0ע��ɹ���2�û����ڣ�3����
	 * @throws Exception
	 */
	public Msg insertUser(int identity,String phone,String pwd)throws Exception;
	/**
	 * �޸�����
	 * @param method �޸ķ�ʽ��1���绰��2��id
	 * @param identity �û���ݣ�1��ʦ��2ѧ��
	 * @param phone �绰/id
	 * @param new_pwd ������
	 * @return Msg ������Ϣ��0ע��ɹ���2�û����ڣ�3����
	 * @throws Exception
	 */
	public Msg updatePwd(int method,int identity,String phone,String new_pwd)throws Exception;
	/**
	 * ����ʦ����ϵ
	 * @param t_id ��ʦid
	 * @param s_id ѧ��id
	 * @param method ʦ����ϵ��1ͬ�⣬2ɾ��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateContact(String t_id,String s_id,int method)throws Exception;
	/**
	 * �����޵�״̬
	 * @param praise ����Ϣ
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updatePraise(Praise praise)throws Exception;
	/**
	 * �鿴����屳��ͼƬ
	 * @param identity ��ݣ�1��ʦ��2ѧ��
	 * @param id �û�id
	 * @return MsgUrl ������Ϣ��0�ɹ���1������ͼƬurl
	 * @throws Exception
	 */
	public MsgUrl checkBoardPic(int identity,String id)throws Exception;
	/**
	 * �����֤��
	 * @param way ��ʽ��1ͼƬ��֤�룬2������֤��
	 * @param code ��֤��
	 * @param request
	 * @return 0Ϊ��֤�ɹ���1ΪͼƬ��֤����4Ϊsession��û��ͼƬ��֤�룬5Ϊ������֤����6Ϊsession��û�ж�����֤��
	 */
	public int checkVerifyCode(int way,String code,HttpServletRequest request);
	/**
	 * �ϴ�ͼƬ
	 * @param method ͼƬ���ͣ�1Ϊͷ��2Ϊ����ͼƬ��3Ϊ���ͼƬ
	 * @param file ͼƬ�ļ�
	 * @return MsgUrl ������Ϣ��0�ɹ���1������ͼƬurl
	 * @throws Exception
	 */
	public MsgUrl saveFile(int method, MultipartFile file)throws Exception;
}
