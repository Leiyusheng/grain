package grain.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public interface VerifyCodeService {
	//���Ͷ�����֤��
	public int sendSmsCode(String phone,String code);
	//ʹ��ϵͳĬ���ַ�Դ������֤��
	public String generateVerifyCode(int verifySize);
	//ʹ��ָ��Դ������֤��
	public String generateVerifyCode(int verifySize, String sources);
	//���������֤���ļ�,��������֤��ֵ
	public String outputVerifyImage(int w, int h, File outputFile, int verifySize) throws IOException;
	//��������֤��ͼƬ��,��������֤��ֵ
	public String outputVerifyImage(int w, int h, OutputStream os, int verifySize) throws IOException;
	//����ָ����֤��ͼ���ļ�
	public void outputImage(int w, int h, File outputFile, String code) throws IOException;
	//���ָ����֤��ͼƬ�� 
	public void outputImage(int w, int h, OutputStream os, String code) throws IOException;
	
}
