package grain.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grain.dao.mapper.CtctMapper;
import grain.dao.mapper.StuMapper;
import grain.dao.mapper.TchMapper;
import grain.dto.ApplyInf;
import grain.dto.ApplyList;
import grain.dto.CheckSearchInf;
import grain.dto.CheckStuInf;
import grain.dto.Msg;
import grain.dto.SearchInf;
import grain.dto.StudentInf;
import grain.dto.TchSimpleInf;
import grain.dto.TeacherList;
import grain.po.Contact;
import grain.po.Student;
import grain.po.Teacher;
import grain.service.StuService;

@Service
public class StuServiceImpl implements StuService {
	@Autowired
	StuMapper stuMapper;
	@Autowired
	TchMapper tchMapper;
	@Autowired
	CtctMapper ctctMapper;
	//����ѧ��
	@Override
	public CheckSearchInf findStuByPhone(String t_id, String phone) throws Exception {
		int status=3;
		SearchInf sInf;
		Student student=stuMapper.findStuByPhone(phone);
		if(student==null){
			status=1;
			sInf=new SearchInf();
		}
		else{
			Contact contact=ctctMapper.findContactByStuPhone(phone, t_id);
			if(contact==null){
				status=0;
			}
			else if(contact.getStatus()==1){//ѧ����ͬ��
				status=2;
			}
			else{
				status=0;
			}
			sInf=new SearchInf(student);
		}
		CheckSearchInf cSearchInf=new CheckSearchInf(status, sInf);
		return cSearchInf;
	}
	//�鿴ѧ����Ϣ
	@Override
	public CheckStuInf findStuInf(String id) throws Exception {
		int status=1;
		StudentInf stuInfo = null;
		try {
			Student student=stuMapper.findStuById(id);
			stuInfo=new StudentInf(student);
			status=0;
		} catch (Exception e) {
			throw e;
		}
		CheckStuInf checkStuInf=new CheckStuInf(status,stuInfo);
		return checkStuInf;
	}
	//�༭ѧ������
	@Override
	public Msg updateStuName(String s_id,String s_name) throws Exception {
		int status=1;
		try {
			Student stu=stuMapper.findStuById(s_id);
			stu.setStudent_name(s_name);
			status=stuMapper.updateStuById(stu);
			if(status==0){
				status=1;
			}
			else{
				status=0;
			}
		} catch (Exception e) {
			status=1;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�༭ѧ��ͷ��
	@Override
	public Msg updateStuLogo(String s_id,String logo) throws Exception {
		int status=1;
		try {
			Student stu=stuMapper.findStuById(s_id);
			stu.setHead_logo(logo);
			status=stuMapper.updateStuById(stu);
			if(status==0){
				status=1;
			}
			else{
				status=0;
			}
		} catch (Exception e) {
			status=1;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�༭ѧ���Ա�
	@Override
	public Msg updateStuGender(String s_id,int gender) throws Exception {
		int status=1;
		try {
			Student stu=stuMapper.findStuById(s_id);
			stu.setGender(gender);
			status=stuMapper.updateStuById(stu);
			if(status==0){
				status=1;
			}
			else{
				status=0;
			}
		} catch (Exception e) {
			status=1;
		}
			Msg msg=new Msg(status);
			return msg;
		}
	//�༭ѧ������
	@Override
	public Msg updateStuBirthday(String s_id,String birthday) throws Exception {
		int status=1;
		try {
			Student stu=stuMapper.findStuById(s_id);
			Date date=Date.valueOf(birthday);
			stu.setBirthday(date);
			status=stuMapper.updateStuById(stu);
			if(status==0){
				status=1;
			}
			else{
				status=0;
			}
		} catch (Exception e) {
			status=1;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�༭ѧ��ǩ��
	@Override
	public Msg updateStuSign(String s_id,String sign) throws Exception {
		int status=1;
		try {
			Student stu=stuMapper.findStuById(s_id);
			stu.setPersonalized_signature(sign);
			status=stuMapper.updateStuById(stu);
			if(status==0){
				status=1;
			}
			else{
				status=0;
			}
		} catch (Exception e) {
			status=1;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�༭ѧ����ע
	@Override
	public Msg updateStuInf(String s_id,String inf) throws Exception {
		int status=1;
		try {
			Student stu=stuMapper.findStuById(s_id);
			stu.setStudent_info(inf);
			status=stuMapper.updateStuById(stu);
			if(status==0){
				status=1;
			}
			else{
				status=0;
			}
		} catch (Exception e) {
			status=1;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�༭ѧ��������ҳ����
	@Override
	public Msg updateStuHomePic(String s_id, String home_pic) throws Exception {
		int status=1;
		try {
			Student stu=stuMapper.findStuById(s_id);
			stu.setHome_background(home_pic);
			status=stuMapper.updateStuById(stu);
			if(status==0){
				status=1;
			}
			else{
				status=0;
			}
		} catch (Exception e) {
			status=1;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�༭ѧ������屳��ͼƬ
	@Override
	public Msg updateStuBoardPic(String s_id,String board_pic) throws Exception {
		int status=1;
		try {
			Student stu=stuMapper.findStuById(s_id);
			stu.setBoard_background(board_pic);
			status=stuMapper.updateStuById(stu);
			if(status==0){
				status=1;
			}
			else{
				status=0;
			}
		} catch (Exception e) {
			status=1;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�鿴ѧ������Ȩ��
	public Msg findStuAccess(String s_id) throws Exception {
		int status=-1;
		Student stu=stuMapper.findStuById(s_id);
		if(stu!=null){
			status=stu.getAccess_permission();
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�޸�ѧ������Ȩ��
	@Override
	public Msg updateStuAccess(String s_id,int access) throws Exception {
		int status=1;
		try {
			Student stu=stuMapper.findStuById(s_id);
			stu.setAccess_permission(access);//�޸�ѧ��Ȩ��
			status=stuMapper.updateStuById(stu);
			if(status==0){
				status=1;
			}
			else{
				status=0;
			}
		} catch (Exception e) {
			status=1;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�����ʦ
	@Override
	public Msg updateTchApply(String s_id, String t_id, String info) throws Exception {
		Contact contact=ctctMapper.findContactById(t_id, s_id);
		int status=3;
		if(contact==null){//��Ӧ��ϵ������
			Teacher teacher=tchMapper.findTchById(t_id);
			if(teacher==null){
				status=2;//��Ӧ��ʦ������
			}
			else{
				contact=new Contact(t_id,s_id,0,0,info);
				try {
					ctctMapper.insertContact(contact);
					status=0;
				} catch (Exception e) {
					throw e;
				}
			}
		}
		else if(contact.getStatus()==1){
			status=1;//��ʦ�Ѵ���
		}
		else{
			try {
				ctctMapper.updateContact(0, t_id, s_id);
				ctctMapper.updateShowStatus(0, t_id, s_id);
				ctctMapper.updateContactTime(info, t_id, s_id);
				status=0;
			} catch (Exception e) {
				status=3;
				throw e;
			}
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�鿴��ʦ�б�
	@Override
	public TeacherList findTchList(String s_id) throws Exception {
		List<Teacher> teachers=tchMapper.findTchListById(s_id);
		TeacherList tList=new TeacherList();
		for(int i=0;i<teachers.size();i++){
			Teacher tch=teachers.get(i);
			TchSimpleInf tInfo=new TchSimpleInf(tch);
			tList.addTchInfo(tInfo);
		}
		return tList;
	}
	//�鿴�������б�
	@Override
	public ApplyList findApplyList(String s_id) throws Exception {
		List<Contact> contacts=ctctMapper.findTchApplyListById(s_id);
		ApplyList aList=new ApplyList();
		int identity=2;
		for(int i=0;i<contacts.size();i++){
			Contact con=contacts.get(i);
			if(con.getShow_status()%10==0){
				ApplyInf aInfo=new ApplyInf(identity,con);
				aList.addApplyInfo(aInfo);
			}
		}
		return aList;
	}
	//ɾ������
	@Override 
	public Msg deleteApply(String t_id, String s_id) throws Exception {
		int status=1;
		try {
			Contact contact=ctctMapper.findContactById(t_id, s_id);
			int method=1+(contact.getShow_status()/10)*10;//��show_status��ʮλ��Ϊ1
			status=ctctMapper.updateShowStatus(method, t_id, s_id);
			if(status==0){
				status=1;
			}
			else{
				status=0;
			}
		} catch (Exception e) {
			status=1;
			throw e;
		}
		Msg msg=new Msg(status);
		return msg;
	}
}
