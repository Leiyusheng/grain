package grain.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public interface VerifyCodeService {
	/**
	 * ���Ͷ�����֤��
	 * @param phone �绰
	 * @param code ��֤��
	 * @return 0�ɹ���22ͬһ���ֻ�����֤��������ÿ������ܻ�ȡ��10����33ͬһ���ֻ���ͬһ��֤��ģ��ÿ30��ֻ�ܷ���һ�������෵��ֵ����Ƭ��api
	 */
	public int sendSmsCode(String phone,String code);
	/**
	 * ʹ��ϵͳĬ���ַ�Դ������֤��
	 * @param verifySize ��֤�볤��
	 * @return ��֤��
	 */
	public String generateVerifyCode(int verifySize);
	/**
	 * ʹ��ָ��Դ������֤��
	 * @param verifySize ��֤�볤��
	 * @param sources ��֤���ַ�Դ
	 * @return ��֤��
	 */
	public String generateVerifyCode(int verifySize, String sources);
	/**
	 * ���������֤���ļ�,��������֤��ֵ
	 * @param w ͼƬ��
	 * @param h ͼƬ��
	 * @param outputFile Ŀ���ļ�
	 * @param verifySize ��֤�볤��
	 * @return ��֤��
	 * @throws IOException
	 */
	public String outputVerifyImage(int w, int h, File outputFile, int verifySize) throws IOException;
	/**
	 * ��������֤��ͼƬ��,��������֤��ֵ
	 * @param w ͼƬ��
	 * @param h ͼƬ��
	 * @param os �����
	 * @param verifySize ��֤�볤��
	 * @return ��֤��
	 * @throws IOException
	 */
	public String outputVerifyImage(int w, int h, OutputStream os, int verifySize) throws IOException;
	//����ָ����֤��ͼ���ļ�
	/**
	 * ����ָ����֤��ͼ���ļ�
	 * @param w ͼƬ��
	 * @param h ͼƬ��
	 * @param outputFile ����ļ�
	 * @param code ��֤��
	 * @throws IOException
	 */
	public void outputImage(int w, int h, File outputFile, String code) throws IOException;
	/**
	 * ���ָ����֤��ͼƬ��
	 * @param w ͼƬ��
	 * @param h ͼƬ��
	 * @param os �����
	 * @param code ��֤��
	 * @throws IOException
	 */
	public void outputImage(int w, int h, OutputStream os, String code) throws IOException;
	
}
