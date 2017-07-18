package grain.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import grain.dao.mapper.BoardMapper;
import grain.dao.mapper.CtctMapper;
import grain.dao.mapper.GrpMapper;
import grain.dao.mapper.StuMapper;
import grain.dao.mapper.TaskMapper;
import grain.dao.mapper.TaskResultMapper;
import grain.dao.mapper.TchMapper;
import grain.dto.MsgId;
import grain.dto.MsgUrl;
import grain.dto.Msg;
import grain.po.Group;
import grain.po.Praise;
import grain.po.Student;
import grain.po.Task;
import grain.po.Teacher;
import grain.service.ImgCompressService;
import grain.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private ServletContext servletContext;
	@Autowired
	private StuMapper stuMapper;
	@Autowired
	private TchMapper tchMapper;
	@Autowired
	private CtctMapper ctctMapper;
	@Autowired
	private GrpMapper grpMapper;
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private TaskResultMapper taskResultMapper;
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private ImgCompressService imgCompressService;
	
	private final String rootPath;//tomcat��Ŀ¼��
	
	public UserServiceImpl() {
		this.rootPath = "apache-tomcat";
	}
	public UserServiceImpl(String rootPath) {
		this.rootPath = rootPath;
	}
	
	//MD5����
	public String EncoderByMd5(String s) throws Exception{ 
	 	//���MD5ժҪ�㷨�� MessageDigest ����  
	 	MessageDigest mdInst = MessageDigest.getInstance("MD5");  
	 	//ʹ��ָ�����ֽڸ���ժҪ  
	 	mdInst.update(s.getBytes());  
	 	//�������  
	 	byte[] md = mdInst.digest();  
	 	//������ת����ʮ�����Ƶ��ַ�����ʽ  
	 	StringBuffer buf = new StringBuffer("");  
	 	for (int i,offset = 0; offset < md.length; offset++) {  
	 		i = md[offset];  
	 		if (i < 0)  
	 			i += 256;
	 		if (i < 16)  
	 			buf.append("0");  
	 		buf.append(Integer.toHexString(i));  
	 	}
	 	return buf.toString();
	}
	//��¼
	@Override
	public MsgId login(int identity, String phone, String pwd) throws Exception {
		int status=3;
		String id=null;
		if(identity==1){
			try {
				Teacher teacher=tchMapper.findTchByPhone(phone);
				if(EncoderByMd5(pwd).equals(teacher.getPassword())){
					status=0;
					id=teacher.getTeacher_id();
				}
				else{
					status=1;
				}
			} catch (Exception e) {
				status=2;
				//throw e;
			}
		}
		else if(identity==2){
			try {
				Student student=stuMapper.findStuByPhone(phone);
				if(EncoderByMd5(pwd).equals(student.getPassword())){
					status=0;
					id=student.getStudent_id();
				}
				else{
					status=1;
				}
			} catch (Exception e) {
				status=2;
				//throw e;
			}
		}
		MsgId loginMsg=new MsgId(status,id);
		return loginMsg;
	}
	//��֤�绰�Ƿ���Ч
	public int checkPhone(int method, String phone) throws Exception {
		int status=3;
		Teacher teacher=null;
		Student student=null;
		switch (method) {
		case 1:
			teacher=tchMapper.findTchByPhone(phone);
			if(teacher==null){
				status=0;
			}
			break;
		case 2:
			student=stuMapper.findStuByPhone(phone);
			if(student==null){
				status=0;
			}
			break;
		case 3:
			teacher=tchMapper.findTchByPhone(phone);
			if(teacher!=null){
				status=0;
			}
			break;
		case 4:
			student=stuMapper.findStuByPhone(phone);
			if(student!=null){
				status=0;
			}
			break;
		default:
			break;
		}
		return status;
	}
	//ע��
	@Override
	public Msg insertUser(int identity, String phone, String pwd) throws Exception {
		int status=3;
		if(identity==1){
			Teacher teacher=tchMapper.findTchByPhone(phone);
			if(teacher==null){
				String s=UUID.randomUUID().toString();
				String id=s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
				String name="����"+phone.substring(7);
				teacher=new Teacher(id,name,phone,EncoderByMd5(pwd));
				Group group=new Group(id,id);
				try {
					tchMapper.insertTch(teacher);
					grpMapper.insertGroup(group);
					status=0;
				} catch (Exception e) {
					status=3;
					throw e;
				}
			}
			else{
				status=2;
			}
		}
		else if(identity==2){
			Student student=stuMapper.findStuByPhone(phone);
			if(student==null){
				String s=UUID.randomUUID().toString();
				String id=s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
				String name="����"+phone.substring(7);
				student=new Student(id,name,phone,EncoderByMd5(pwd));
				try {
					stuMapper.insertStu(student);
					status=0;
				} catch (Exception e) {
					status=3;
					throw e;
				}
			}
			else{
				status=2;
			}
		}
		Msg msg=new Msg(status);
		return msg;
	}
	/**
	 * �޸����� 
	 * 1���绰��2��id
	 */
	@Override
	public Msg updatePwd(int method, int identity, String phone, String new_pwd) throws Exception {
		int status=3;
		if(identity==1){
			Teacher teacher=null;
			if(method==1){
				teacher=tchMapper.findTchByPhone(phone);
			}
			else if(method==2){
				teacher=tchMapper.findTchById(phone);
			}
			if(teacher!=null){
				teacher.setPassword(EncoderByMd5(new_pwd));
				try {
					status=tchMapper.updateTchById(teacher);
					if(status==0){
						status=1;
					}
					else{
						status=0;
					}
				} catch (Exception e) {
					status=3;
					throw e;
				}
			}
			else{
				status=2;
			}
		}
		else if(identity==2){
			Student student=null;
			if(method==1){
				student=stuMapper.findStuByPhone(phone);
			}
			else if(method==2){
				student=stuMapper.findStuById(phone);
			}
			if(student!=null){
				student.setPassword(EncoderByMd5(new_pwd));
				try {
					status=stuMapper.updateStuById(student);
					if(status==0){
						status=1;
					}
					else{
						status=0;
					}
				} catch (Exception e) {
					status=3;
					throw e;
				}
			}
			else{
				status=2;
			}
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//����ѧ����ʦ��ϵ��1ͬ�⣬2ɾ��
	@Override
	public Msg updateContact(String t_id, String s_id, int method) throws Exception {
		int status=1;
		try {
			status=ctctMapper.updateContact(method, t_id, s_id);
			if(status==0){
				status=1;
			}
			else if(method==1){
				grpMapper.insertGroupStu(t_id, s_id);
				grpMapper.updateGroupStuCount(1, t_id);
				tchMapper.updateTchStuCount(1, t_id);
				status=0;
			}
			else if(method==2){
				tchMapper.updateTchStuCount(0, t_id);
				grpMapper.updateStuCount(t_id, s_id);
				List<Task> tList=taskMapper.findStuTaskByTch(t_id, s_id);
				for(int i=0;i<tList.size();i++){//�Ƴ�����ʦ������ѧ���������¼
					Task task=tList.get(i);
					if(task.getStatus()<2){//ֻ�Ƴ���δ������
						try {
							taskMapper.deleteTaskStu(task.getTask_id(), s_id);
							taskMapper.updateTaskStuCount(0, task.getTask_id());
						} catch (Exception e) {
							throw e;
						}
					}
				}
				grpMapper.deleteStu(t_id, s_id);
				status=0;
			}
		} catch (Exception e) {
			status=1;
			throw e;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//����
	@Override
	public Msg updatePraise(Praise praise) throws Exception {
		int status=1;
		Praise pr=taskResultMapper.findPraise(praise);
		try {
			if(pr==null){
				taskResultMapper.insertPraise(praise);
				boardMapper.updateResultPraise(praise);
			}
			else if(pr.getPraise_status()!=praise.getPraise_status()){
				taskResultMapper.updatePraise(praise);
				boardMapper.updateResultPraise(praise);
			}
			status=0;
		} catch (Exception e) {
			status=1;
			throw e;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//��ȡ�û�����屳��ͼƬ
	@Override
	public MsgUrl checkBoardPic(int identity, String id) throws Exception {
		int status=1;
		String url=null;
		if(identity==1){
			url=tchMapper.findTchById(id).getBoard_background();
			status=0;
		}
		else if(identity==2){
			url=stuMapper.findStuById(id).getBoard_background();
			status=0;
		}
		MsgUrl msg=new MsgUrl(status,url);
		return msg;
	}
	/**
	 * ��֤��֤��
	 * @param way 1ΪͼƬ��֤�룬2Ϊ������֤��
	 * inf 0Ϊ��֤�ɹ���1ΪͼƬ��֤����4Ϊsession��û��ͼƬ��֤�룬5Ϊ������֤����6Ϊsession��û�ж�����֤��
	 */
	@Override
	public int checkVerifyCode(int way, String code, HttpServletRequest request) {
		int inf=1;
		HttpSession session = request.getSession();
		if(way==1){
			if(code.length()==4){//��֤�볤��
				if(session.getAttribute("pic_code") == null){//session��û����֤��
					inf=4;
				}else{
					String pic_code=session.getAttribute("pic_code")+"";
					if(code.equals(pic_code)){
						inf=0;
					}
					else{
						inf=1;
					}
				}
			}
			else{
				inf=1;
			}
		}
		else if(way==2){
			if(code.length()==4){//��֤�볤��
				if(session.getAttribute("sms_code") == null){//session��û����֤��
					inf=6;
				}else{
					String sms_code=session.getAttribute("sms_code")+"";
					if(code.equals(sms_code)){
						inf=0;
					}
					else{
						inf=5;
					}
				}
			}
			else{
				inf=5;
			}
		}
		return inf;
	}
	/**
	 * ����ͼƬ�ļ�
	 * method��1Ϊͷ��2Ϊ����ͼƬ��3Ϊ���ͼƬ
	 */
	@Override
	public MsgUrl saveFile(int method, MultipartFile file) throws Exception{
		if (!file.isEmpty()) {
            try {
                // getRealPath() ȡ�� WEB-INF �����ļ���·��
                // ��������� "/temp", �� temp ����ʱ���� temp �ı���·��, ������ʱ���� null/temp (��Ч·��)
            	String s = UUID.randomUUID().toString();//�������ͼƬurl��
				String url = File.separator + s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24) + ".jpg";
				String catalog = null;
				switch (method) {
				case 1:
					catalog = File.separator +  "head" + File.separator;
					break;
				case 2:
					catalog = File.separator +  "task" + File.separator;
					break;
				case 3:
					catalog = File.separator +  "result" + File.separator;
					break;
				case 4:
					catalog = File.separator +  "board" ;
					break;
				case 5:
					catalog = File.separator +  "home" ;
					break;
				default:
					break;
				}
				String path0 = servletContext.getRealPath("WEB-INF");
				int index = path0.indexOf(rootPath);//����tomcat��Ŀ¼
				if(method>3){
					String path = path0.substring(0, index) + "pic" + catalog + url;//�滻ΪͼƬ��ԴĿ¼
					FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(path));
					url = "pic" + catalog + url;
				}
				else{
					String path = path0.substring(0, index) + "pic" + catalog + "original" + url;//�滻ΪͼƬ��ԴĿ¼
	                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(path));
	                String thumbnail = path0.substring(0, index) + "pic" + catalog + "thumbnail" + url;//�滻ΪͼƬ��ԴĿ¼
	                imgCompressService.imgCompress(path, thumbnail,method);
	                url = "pic" + catalog + "thumbnail" + url;
				}
                MsgUrl msgUrl=new MsgUrl(0,url);
                return msgUrl;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MsgUrl msgUrl=new MsgUrl(1,null);
        return msgUrl;
	}
}
