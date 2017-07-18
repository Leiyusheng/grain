package grain.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grain.dao.mapper.CtctMapper;
import grain.dao.mapper.GrpMapper;
import grain.dao.mapper.StuMapper;
import grain.dao.mapper.TchMapper;
import grain.dto.ApplyInf;
import grain.dto.ApplyList;
import grain.dto.CheckTchInf;
import grain.dto.CheckSearchInf;
import grain.dto.GroupInf;
import grain.dto.GroupList;
import grain.dto.Msg;
import grain.dto.SearchInf;
import grain.dto.TeacherInf;
import grain.po.Contact;
import grain.po.Group;
import grain.po.Student;
import grain.po.Teacher;
import grain.service.TchService;

@Service
public class TchServiceImpl implements TchService {

	@Autowired
	private TchMapper tchMapper;
	@Autowired
	private StuMapper stuMapper;
	@Autowired
	private CtctMapper ctctMapper;
	@Autowired
	private GrpMapper grpMapper;
	//������ʦ
	@Override
	public CheckSearchInf findTchByPhone(String s_id,String phone) throws Exception {
		int status=3;
		SearchInf tInf;
		Teacher teacher=tchMapper.findTchByPhone(phone);
		if(teacher==null){
			status=1;
			tInf=new SearchInf();
		}
		else{
			Contact contact=ctctMapper.findContactByTchPhone(phone, s_id);
			if(contact==null){
				status=0;
			}
			else if(contact.getStatus()==1){//��ʦ��ͬ��
				status=2;
			}
			else{
				status=0;
			}
			tInf=new SearchInf(teacher);
		}
		CheckSearchInf cSearchInf=new CheckSearchInf(status, tInf);
		return cSearchInf;
	}
	//�鿴��ʦ��Ϣ
	@Override
	public CheckTchInf findTchInf(String t_id) throws Exception {
		int status=1;
		TeacherInf teacherInfo = null;
		try{
			Teacher teacher=tchMapper.findTchById(t_id);
			teacherInfo=new TeacherInf(teacher);
			status=0;
		} catch (Exception e){
			throw e;
		}
		CheckTchInf checkTchInf=new CheckTchInf(status,teacherInfo);
		return checkTchInf;
	}
	//�༭��ʦ����
	@Override
	public Msg updateTchName(String t_id,String t_name) throws Exception {
		int status=1;
		try {
			Teacher tch=tchMapper.findTchById(t_id);
			tch.setTeacher_name(t_name);
			status=tchMapper.updateTchById(tch);
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
	//�༭��ʦͷ��
	@Override
	public Msg updateTchLogo(String t_id,String logo) throws Exception {
		int status=1;
		try {
			Teacher tch=tchMapper.findTchById(t_id);
			tch.setHead_logo(logo);
			status=tchMapper.updateTchById(tch);
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
	//�༭��ʦ�Ա�
	@Override
	public Msg updateTchGender(String t_id,int gender) throws Exception {
		int status=1;
		try {
			Teacher tch=tchMapper.findTchById(t_id);
			tch.setGender(gender);
			status=tchMapper.updateTchById(tch);
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
	//�༭��ʦ����
	@Override
	public Msg updateTchBirthday(String t_id,String birthday) throws Exception {
		int status=1;
		try {
			Teacher tch=tchMapper.findTchById(t_id);
			Date date=Date.valueOf(birthday);
			tch.setBirthday(date);
			status=tchMapper.updateTchById(tch);
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
	//�༭��ʦǩ��
	@Override
	public Msg updateTchSign(String t_id,String sign) throws Exception {
		int status=1;
		try {
			Teacher tch=tchMapper.findTchById(t_id);
			tch.setPersonalized_signature(sign);
			status=tchMapper.updateTchById(tch);
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
	//�༭��ʦ��Ϣ
	@Override
	public Msg updateTchInf(String t_id,String inf) throws Exception {
		int status=1;
		try {
			Teacher tch=tchMapper.findTchById(t_id);
			tch.setTeacher_info(inf);
			status=tchMapper.updateTchById(tch);
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
	//�༭��ʦ������ҳ����
	@Override
	public Msg updateTchHomePic(String t_id, String home_pic) throws Exception {
		int status=1;
		try {
			Teacher tch=tchMapper.findTchById(t_id);
			tch.setHome_background(home_pic);
			status=tchMapper.updateTchById(tch);
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
	//�༭��ʦ����屳��ͼƬ
	@Override
	public Msg updateTchBoardPic(String t_id,String board_pic) throws Exception {
		int status=1;
		try {
			Teacher tch=tchMapper.findTchById(t_id);
			tch.setBoard_background(board_pic);
			status=tchMapper.updateTchById(tch);
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
	//�鿴�����б�
	@Override
	public ApplyList findApplyList(String t_id) throws Exception {
		List<Contact> contacts=ctctMapper.findStuApplyListById(t_id);
		ApplyList aList=new ApplyList();
		int identity=1;
		for(int i=0;i<contacts.size();i++){
			Contact con=contacts.get(i);
			if(con.getShow_status()/10==0){
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
			int method=10+contact.getShow_status()%10;//��show_status��ʮλ��Ϊ1
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
	//���ѧ��
	@Override
	public Msg updateStuApply(String s_id, String t_id, String info) throws Exception {
		Contact contact=ctctMapper.findContactById(t_id, s_id);
		int status=3;
		if(contact==null){//��Ӧ��ϵ������
			Student student=stuMapper.findStuById(s_id);
			if(student==null){
				status=2;//��Ӧѧ��������
			}
			else{
				contact=new Contact(t_id,s_id,3,0,info);
				try {
					ctctMapper.insertContact(contact);
					status=0;
				} catch (Exception e) {
					throw e;
				}
			}
		}
		else if(contact.getStatus()==1){
			status=1;//ѧ���Ѵ���
		}
		else{
			try {
				ctctMapper.updateContact(3, t_id, s_id);
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
	//�鿴�Ƿ����µ�ѧ��
	@Override
	public Msg findWhetherStuApply(String t_id) throws Exception {
		int status=1;
		Contact contact=ctctMapper.findTchNewContact(t_id);
		if(contact==null){
			status=0;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�鿴����
	@Override
	public GroupList findGroupListById(String t_id) throws Exception {
		GroupList gList=new GroupList();
		Group DefGrp=grpMapper.findDefaultGroupById(t_id);
		GroupInf DefGrpInf=new GroupInf(DefGrp);
		gList.addGroupInfo(DefGrpInf);
		List<Group> groups=grpMapper.findGroupListById(t_id);
		for(int i=0;i<groups.size();i++){
			Group grp=groups.get(i);
			GroupInf gInfo=new GroupInf(grp);
			gList.addGroupInfo(gInfo);
		}
		return gList;
	}
	//��������
	@Override
	public Msg insertGroup(String t_id, String grp_name) throws Exception {
		int status=2;
		Group group=grpMapper.findGroupByName(t_id,grp_name);//�жϷ������Ƿ��ظ�
		if(group==null){
			String s=UUID.randomUUID().toString();
			String id=s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
			group=new Group(id,t_id,grp_name);
			try {
				grpMapper.insertGroup(group);
				status=0;
			} catch (Exception e) {
				status=2;
				throw e;
			}
		}
		else{
			status=1;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//ɾ������
	@Override
	public Msg deleteGroup(String g_id) throws Exception {
		
		int status=1;
		try {
			status=grpMapper.deleteGroup(g_id);
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
