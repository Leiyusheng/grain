package grain.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public interface VerifyCodeService {
	//发送短信验证码
	public int sendSmsCode(String phone,String code);
	//使用系统默认字符源生成验证码
	public String generateVerifyCode(int verifySize);
	//使用指定源生成验证码
	public String generateVerifyCode(int verifySize, String sources);
	//生成随机验证码文件,并返回验证码值
	public String outputVerifyImage(int w, int h, File outputFile, int verifySize) throws IOException;
	//输出随机验证码图片流,并返回验证码值
	public String outputVerifyImage(int w, int h, OutputStream os, int verifySize) throws IOException;
	//生成指定验证码图像文件
	public void outputImage(int w, int h, File outputFile, String code) throws IOException;
	//输出指定验证码图片流 
	public void outputImage(int w, int h, OutputStream os, String code) throws IOException;
	
}
