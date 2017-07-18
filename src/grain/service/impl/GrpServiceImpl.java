package grain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import grain.dao.mapper.CtctMapper;
import grain.dao.mapper.GrpMapper;
import grain.dto.Msg;
import grain.dto.StuSimpleInf;
import grain.dto.StudentList;
import grain.po.Contact;
import grain.po.Group;
import grain.po.Student;
import grain.service.GrpService;

public class GrpServiceImpl implements GrpService {
	@Autowired
	private GrpMapper grpMapper;
	@Autowired
	private CtctMapper ctctMapper;
	//�޸ķ�����
	@Override
	public Msg updateGrpName(String t_id,String g_id, String g_name) throws Exception {
		int status=2;
		Group group=grpMapper.findGroupByName(t_id,g_name);//�жϷ������Ƿ��ظ�
		if(group==null){
			group=grpMapper.findDefaultGroupById(g_id);//�ҳ���id��Ӧ�ķ���
			if(!group.getGroup_id().equals(group.getTeacher_id())){
				try {
					status=grpMapper.updateGroupName(g_id, g_name);
					if(status==0){
						status=2;
					}
					else{
						status=0;
					}
				} catch (Exception e) {
					status=2;
					throw e;
				}
			}
		}
		else{
			status=1;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�޸ķ���ѧ��
	@Override
	public Msg updateGrpStu(String g_id, List<String> s_ids) throws Exception {
		int status=1;
		List<Student> students=grpMapper.findGroupStu(g_id);//��ȡ�÷���ԭ����ѧ��
		Group group=grpMapper.findDefaultGroupById(g_id);//�ҳ���id��Ӧ�ķ���
		for(int i=0;i<s_ids.size();i++){
			int stu_status=1;//��ѧ��״̬��1Ϊ������0Ϊԭ��
			String n_s_id=s_ids.get(i);//�µķ���ѧ��id
			Contact contact=ctctMapper.findContactById(group.getTeacher_id(), n_s_id);
			if(contact!=null&&contact.getStatus()==1){//�жϸ�ѧ���Ƿ����ڸ���ʦ
				for(int j=0;j<students.size();j++){
					String o_s_id=students.get(j).getStudent_id();//�ɵķ���ѧ��id
					if(n_s_id.equals(o_s_id)){
						stu_status=0;//��ѧ���Ѵ���
						students.remove(j--);//�Ƴ�����ԭ����ѧ������Ȼ���ڵ�
						break;
					}
				}
				if(stu_status==1){
					try {
						grpMapper.insertGroupStu(g_id, n_s_id);
						grpMapper.updateGroupStuCount(1, g_id);
					} catch (DuplicateKeyException e1) {
						//��������ѧ��������
					} catch (Exception e) {
						throw e;
					} 
				}
			}
		}
		for(int i=0;i<students.size();i++){
			String s_id=students.get(i).getStudent_id();
			try {
				grpMapper.deleteGroupStu(g_id, s_id);
				grpMapper.updateGroupStuCount(0, g_id);
			} catch (Exception e) {
				throw e;
			} 
		}
		status=0;
		Msg msg=new Msg(status);
		return msg;
	}
	//ɾ������ĳѧ��
	public Msg deleteGrpStu(String g_id, String s_id) throws Exception {
		int status=1;
		Group group=grpMapper.findDefaultGroupById(g_id);//�ҳ���id��Ӧ�ķ���
		if(!group.getGroup_id().equals(group.getTeacher_id())){
			try {
				grpMapper.deleteGroupStu(g_id, s_id);
				grpMapper.updateGroupStuCount(0, g_id);
				status=0;
			} catch (Exception e) {
				throw e;
			} 
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�鿴����ѧ��
	@Override
	public StudentList findGrpStu(String g_id) throws Exception {
		List<Student> students=grpMapper.findGroupStu(g_id);
		StudentList sList=new StudentList();
		for(int i=0;i<students.size();i++){
		    Student stu=students.get(i);
		    StuSimpleInf sInfo=new StuSimpleInf(stu);
		    sList.addStuInfo(sInfo);
		}
		return sList;
	}
}
