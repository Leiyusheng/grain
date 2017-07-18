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
	//修改分组名
	@Override
	public Msg updateGrpName(String t_id,String g_id, String g_name) throws Exception {
		int status=2;
		Group group=grpMapper.findGroupByName(t_id,g_name);//判断分组名是否重复
		if(group==null){
			group=grpMapper.findDefaultGroupById(g_id);//找出该id对应的分组
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
	//修改分组学生
	@Override
	public Msg updateGrpStu(String g_id, List<String> s_ids) throws Exception {
		int status=1;
		List<Student> students=grpMapper.findGroupStu(g_id);//获取该分组原来的学生
		Group group=grpMapper.findDefaultGroupById(g_id);//找出该id对应的分组
		for(int i=0;i<s_ids.size();i++){
			int stu_status=1;//该学生状态，1为新增，0为原有
			String n_s_id=s_ids.get(i);//新的分组学生id
			Contact contact=ctctMapper.findContactById(group.getTeacher_id(), n_s_id);
			if(contact!=null&&contact.getStatus()==1){//判断该学生是否属于该老师
				for(int j=0;j<students.size();j++){
					String o_s_id=students.get(j).getStudent_id();//旧的分组学生id
					if(n_s_id.equals(o_s_id)){
						stu_status=0;//该学生已存在
						students.remove(j--);//移除分组原来的学生中任然存在的
						break;
					}
				}
				if(stu_status==1){
					try {
						grpMapper.insertGroupStu(g_id, n_s_id);
						grpMapper.updateGroupStuCount(1, g_id);
					} catch (DuplicateKeyException e1) {
						//加入已有学生则跳过
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
	//删除分组某学生
	public Msg deleteGrpStu(String g_id, String s_id) throws Exception {
		int status=1;
		Group group=grpMapper.findDefaultGroupById(g_id);//找出该id对应的分组
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
	//查看分组学生
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
