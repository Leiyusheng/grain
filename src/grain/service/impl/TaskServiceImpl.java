package grain.service.impl;

import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import grain.dao.mapper.BoardMapper;
import grain.dao.mapper.CtctMapper;
import grain.dao.mapper.StuMapper;
import grain.dao.mapper.TaskMapper;
import grain.dao.mapper.TaskResultMapper;
import grain.dto.CheckTaskResultInf;
import grain.dto.CheckTaskStuInf;
import grain.dto.CheckTaskTchInf;
import grain.dto.Msg;
import grain.dto.TaskBoard;
import grain.dto.TaskResultInf;
import grain.dto.TaskResultList;
import grain.dto.TaskResultSimpleInf;
import grain.dto.TaskResultTodayList;
import grain.dto.TaskStuCenterInf;
import grain.dto.TaskStuCenterList;
import grain.dto.TaskStuList;
import grain.dto.TaskStuSimpleInf;
import grain.dto.TaskTchCenterInf;
import grain.dto.TaskTchCenterList;
import grain.dto.TaskStuInf;
import grain.dto.TaskTchInf;
import grain.dto.TaskTchList;
import grain.dto.TaskTchSimpleInf;
import grain.po.Contact;
import grain.po.Student;
import grain.po.Task;
import grain.po.TaskResult;
import grain.po.TaskResultTotalInf;
import grain.po.TaskStudent;
import grain.service.TaskService;

public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private StuMapper stuMapper;
	@Autowired
	private CtctMapper ctctMapper;
	@Autowired
	private TaskResultMapper taskResultMapper;
	@Autowired
	private BoardMapper boardMapper;
	//��ʦ�鿴������Ϣ
	@Override
	public CheckTaskTchInf findTaskTchInf(String task_id) throws Exception {
		int status=1;
		Task task;
		List<Student> sList;
		try {
			task=taskMapper.findTaskByTaskId(task_id);
			sList=taskMapper.findTaskStuList(task_id);
			
			status=0;
		} catch (Exception e) {
			throw e;
		}
		TaskTchInf taskTchInf=new TaskTchInf(task,sList);
		CheckTaskTchInf checkTaskTchInf=new CheckTaskTchInf(status, taskTchInf);
		return checkTaskTchInf;
	}
	//ѧ���鿴������Ϣ
	@Override
	public CheckTaskStuInf findTaskStuInf(String task_id,String s_id) throws Exception {
		int status=1;
		int self_level=0;
		Task task;
		try {
			task=taskMapper.findTaskByTaskId(task_id);
			TaskStudent tStudent=taskMapper.findTaskStuById(task_id, s_id);
			self_level=tStudent.getDifficulty_level();//�����Ѷ�
			status=0;
		} catch (Exception e) {
			throw e;
		}
		TaskStuInf taskStuInf=new TaskStuInf(task,self_level);
		CheckTaskStuInf checkTaskStuInf=new CheckTaskStuInf(status, taskStuInf);
		return checkTaskStuInf;
	}
	//����������
	@Override
	public Msg insertTask(Task task,List<String> s_ids) throws Exception {
		int status=1;
		String s=UUID.randomUUID().toString();
		String id=s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
		task.setTask_id(id);//��������id
		task.setTotal_num(s_ids.size());//��������������
		Date date=new Date(System.currentTimeMillis());//��ȡ��ǰ����
		if(date.before(task.getStart_date())){//�ж������ʼ״̬
			task.setStatus(0);
		}
		else{
			task.setStatus(1);
		}
		try {
			taskMapper.insertTask(task);
			for(int i=0;i<s_ids.size();i++){//���������ѧ��
				String s_id=s_ids.get(i);
				TaskStudent taskStudent=new TaskStudent(id,s_id);
				taskMapper.insertTaskStu(taskStudent);
			}
			status=0;
		} catch (Exception e) {
			throw e;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�༭����
	@Override
	public Msg updateTask(Task task,List<String> s_ids) throws Exception {
		int status=1;
		String task_id=task.getTask_id();
		Date date=new Date(System.currentTimeMillis());//��ȡ��ǰ����
		if(date.before(task.getStart_date())){
			task.setStatus(0);
		}
		else{
			task.setStatus(1);
		}
		try {
			status=taskMapper.updateTask(task);
			List<Student> sList=taskMapper.findTaskStuList(task_id);//��ȡ������ԭ����ѧ��
			String t_id=taskMapper.findTaskByTaskId(task_id).getTeacher_id();
			for(int i=0;i<s_ids.size();i++){//�޸������ѧ��
				int stu_status=1;//��ѧ��״̬��1Ϊ������0Ϊԭ��
				String n_s_id=s_ids.get(i);//�µķ���ѧ��id
				Contact contact=ctctMapper.findContactById(t_id, n_s_id);
				if(contact!=null&&contact.getStatus()==1){//�жϸ�ѧ���Ƿ����ڸ���ʦ
					for(int j=0;j<sList.size();j++){
						String o_s_id=sList.get(j).getStudent_id();//�ɵķ���ѧ��id
						if(n_s_id.equals(o_s_id)){
							stu_status=0;//��ѧ���Ѵ���
							sList.remove(j--);//�Ƴ�����ԭ����ѧ������Ȼ���ڵ�
							break;
						}
					}
					if(stu_status==1){
						try {
							TaskStudent taskStudent=new TaskStudent(task_id,n_s_id);
							taskMapper.insertTaskStu(taskStudent);
							taskMapper.updateTaskStuCount(1, task_id);
						} catch (DuplicateKeyException e1) {
							//��������ѧ��������
						} catch (Exception e) {
							throw e;
						} 
					}
				}
			}
			for(int i=0;i<sList.size();i++){
				String s_id=sList.get(i).getStudent_id();
				try {
					taskMapper.deleteTaskStu(task_id, s_id);
					taskMapper.updateTaskStuCount(0, task_id);
				} catch (Exception e) {
					throw e;
				} 
			}
			status=0;
		} catch (Exception e) {
			throw e;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//ɾ������
	@Override
	public Msg deleteTask(String task_id) throws Exception {
		int status=2;
		Task task=taskMapper.findTaskByTaskId(task_id);
		if(task==null){
			status=1;
		}
		else{
			task.setStatus(3);
			try {
				status=taskMapper.updateTask(task);
				if(status==0){
					status=2;
				}
				else{
					status=0;
				}
			} catch (Exception e) {
				throw e;
			}
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//�鿴ѧ����������
	@Override
	public TaskStuCenterList findStuCenterTask(String s_id) throws Exception {
		List<Task> tasks=taskMapper.findTaskCenterByStu(s_id);
		TaskStuCenterList tList=new TaskStuCenterList();
		for(int i=0;i<tasks.size();i++){
			Task task=tasks.get(i);
			TaskStuCenterInf tInf=new TaskStuCenterInf(task);
			tList.addTaskInf(tInf);
		}
		return tList;
	}
	//����ѧ����������
	@Override
	public TaskStuCenterList getStuCenterTask(String s_id,String key) throws Exception {
		List<Task> tasks=taskMapper.searchTaskCenterByStu(s_id,key);
		TaskStuCenterList tList=new TaskStuCenterList();
		for(int i=0;i<tasks.size();i++){
			Task task=tasks.get(i);
			TaskStuCenterInf tInf=new TaskStuCenterInf(task);
			tList.addTaskInf(tInf);
		}
		return tList;
	}
	//�鿴��ʦ��������
	@Override
	public TaskTchCenterList findTchCenterTask(String t_id) throws Exception {
		List<Task> tasks=taskMapper.findTaskCenterByTch(t_id);
		TaskTchCenterList tList=new TaskTchCenterList();
		for(int i=0;i<tasks.size();i++){
			Task task=tasks.get(i);
			TaskTchCenterInf tInf=new TaskTchCenterInf(task);
			tList.addTaskInf(tInf);
		}
		return tList;
	}
	//������ʦ��������
	@Override
	public TaskTchCenterList getTchCenterTask(String t_id,String key) throws Exception {
		List<Task> tasks=taskMapper.searchTaskCenterByTch(t_id,key);
		TaskTchCenterList tList=new TaskTchCenterList();
		for(int i=0;i<tasks.size();i++){
			Task task=tasks.get(i);
			TaskTchCenterInf tInf=new TaskTchCenterInf(task);
			tList.addTaskInf(tInf);
		}
		return tList;
	}
	//�鿴ѧ��������������б�
	@Override
	public TaskStuList findStuTodayTask(String s_id) throws Exception {
		List<Task> tasks=taskMapper.findTodayTaskByStuId(s_id);
		TaskStuList tList=new TaskStuList();
		for(int i=0;i<tasks.size();i++){
			Task task=tasks.get(i);
			int practice_time=0;//��ȡ���ʱ��
			int status=0;//δ����
			TaskResult result=taskResultMapper.findTaskResultByStu(task.getTask_id(), s_id);
			if(result!=null){
				practice_time=result.getPractice_time();
				status=result.getStatus();
			}
			TaskStuSimpleInf sInf=new TaskStuSimpleInf(task, practice_time,status);
			tList.addTaskInf(sInf);
		}
		return tList;
	}
	//����ѧ��������������б�
	@Override
	public TaskStuList getStuTodayTask(String s_id,String key) throws Exception {
		List<Task> tasks=taskMapper.searchTodayTaskByStuId(s_id,key);
		TaskStuList tList=new TaskStuList();
		for(int i=0;i<tasks.size();i++){
			Task task=tasks.get(i);
			int practice_time=0;//��ȡ���ʱ��
			int status=0;//δ����
			TaskResult result=taskResultMapper.findTaskResultByStu(task.getTask_id(), s_id);
			if(result!=null){
				practice_time=result.getPractice_time();
				status=result.getStatus();
			}
			TaskStuSimpleInf sInf=new TaskStuSimpleInf(task, practice_time,status);
			tList.addTaskInf(sInf);
		}
		return tList;
	}
	//�鿴��ʦ������������б�
	@Override
	public TaskTchList findTchTodayTask(String t_id) throws Exception {
		List<Task> tasks=taskMapper.findTodayTaskByTchId(t_id);
		TaskTchList tList=new TaskTchList();
		for(int i=0;i<tasks.size();i++){
			Task task=tasks.get(i);
			int finish_num=taskResultMapper.findTaskResultNumById(task.getTask_id());//��ȡ�����������
			System.out.println(finish_num);
			TaskTchSimpleInf tInf=new TaskTchSimpleInf(task,finish_num);
			tList.addTaskInf(tInf);
		}
		return tList;
	}
	//������ʦ������������б�
	@Override
	public TaskTchList getTchTodayTask(String t_id,String key) throws Exception {
	List<Task> tasks=taskMapper.searchTodayTaskByTchId(t_id,key);
		TaskTchList tList=new TaskTchList();
		for(int i=0;i<tasks.size();i++){
			Task task=tasks.get(i);
			int finish_num=taskResultMapper.findTaskResultNumById(task.getTask_id());//��ȡ�����������
			System.out.println(finish_num);
			TaskTchSimpleInf tInf=new TaskTchSimpleInf(task,finish_num);
			tList.addTaskInf(tInf);
		}
		return tList;
	}
	//��ʦ�鿴ѧ�������б�
	@Override
	public TaskTchCenterList findStuTaskByTch(String t_id, String s_id) throws Exception {
		List<Task> tasks=taskMapper.findStuTaskByTch(t_id, s_id);
		TaskTchCenterList tList=new TaskTchCenterList();
		for(int i=0;i<tasks.size();i++){
			Task task=tasks.get(i);
			TaskTchCenterInf tInf=new TaskTchCenterInf(task);
			tList.addTaskInf(tInf);
		}
		return tList;
	}
	//ѧ���鿴��ʦ�����б�
	@Override
	public TaskStuCenterList findTchTaskByStu(String t_id, String s_id) throws Exception {
		List<Task> tasks=taskMapper.findTchTaskByStu(s_id, t_id);
		TaskStuCenterList sList=new TaskStuCenterList();
		for(int i=0;i<tasks.size();i++){
			Task task=tasks.get(i);
			TaskStuCenterInf tInf=new TaskStuCenterInf(task);
			sList.addTaskInf(tInf);
		}
		return sList;
	}
	//�鿴������
	@Override
	public CheckTaskResultInf findTaskResultInf(String task_id, String s_id) throws Exception {
		int status=1;
		Task task=taskMapper.findTaskByTaskId(task_id);
		TaskResult taskResult=taskResultMapper.findTaskResultByStu(task_id, s_id);
		TaskResultInf taskResultInf;
		if(task==null){
			taskResultInf=new TaskResultInf();
			status=1;
		}
		else{
			if(taskResult==null){
				String s=UUID.randomUUID().toString();
				String id=s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
				taskResult=new TaskResult(id,s_id,task_id);
				try {
					taskResultMapper.insertTaskResult(taskResult);
					status=0;
				} catch (Exception e) {
					status=1;
					throw e;
				}
			}
			else{
				status=0;
			}
			taskResultInf=new TaskResultInf(task,taskResult);
		}
		CheckTaskResultInf checkTaskResultInf=new CheckTaskResultInf(status,taskResultInf);
		return checkTaskResultInf;
	}
	//�༭�����Ѷ�
	public Msg updateTaskLevel(String task_id, String s_id, int level) throws Exception {
		int status=1;
		TaskStudent taskStudent=taskMapper.findTaskStuById(task_id, s_id);
		if(taskStudent==null){
			status=1;
		}
		else{
			taskStudent.setDifficulty_level(level);
			try {
				status=taskMapper.updateTaskLevel(taskStudent);
				if(status==0){
					status=1;
				}
				else{
					status=0;
				}
			} catch (Exception e) {
				throw e;
			}
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//��������������
	@Override
	public Msg updateTaskResult(TaskResult taskResult) throws Exception {
		int status=1;
		try {
			TaskResult result=taskResultMapper.findTaskResultById(taskResult.getTask_result_id());
			result.setBasicInf(taskResult.getPractice_time(), taskResult.getSelf_score());
			status=taskResultMapper.updateTaskResult(result);
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
	//�����������
	@Override
	public Msg updateResultStatus(TaskResult taskResult) throws Exception {
		int status=1;
		try {
			TaskResult result=taskResultMapper.findTaskResultById(taskResult.getTask_result_id());
			result.setPublishInf(taskResult.getFinish_photo(), taskResult.getComments());
			taskResultMapper.updateTaskResult(result);
			status=boardMapper.updateResultStatus(taskResult.getTask_result_id());
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
	//�����ڲ鿴ѧ������������
	@Override
	public TaskResultList findTaskResultList(String task_id,String s_id) throws Exception {
		int status=1;
		TaskResultList rList;
		Task task=taskMapper.findTaskByTaskId(task_id);
		Student stu=stuMapper.findStuById(s_id);
		if(task!=null&&task.getStatus()!=3&&stu!=null){
			status=0;
			rList=new TaskResultList(status,task,stu);
			List<TaskResult> taskResults=taskResultMapper.findTaskResultByDate(task_id, s_id);
			for(int i=0;i<taskResults.size();i++){
				TaskResult taskResult=taskResults.get(i);
				TaskResultSimpleInf tInf=new TaskResultSimpleInf(taskResult);
				rList.addTaskResultInf(tInf);
			}
		}
		else{
			rList=new TaskResultList(status);
		}
		return rList;
	}
	//��ʦ�鿴�����������������
	@Override
	public TaskResultTodayList findTaskTodayList(String task_id) throws Exception {
		List<TaskResultTotalInf> totalInfs=taskResultMapper.findTaskResultByTch(task_id);
		Collections.sort(totalInfs, new Comparator<TaskResultTotalInf>() {
			@Override
			public int compare(TaskResultTotalInf o1, TaskResultTotalInf o2) {
				int flag=new Integer(o2.getTotal_time()).compareTo(new Integer(o1.getTotal_time()));//�����ʱ��Ƚ�
				if(flag==0){
					flag=new Integer(o2.getToday_time()).compareTo(new Integer(o1.getToday_time()));//�������ʱ��Ƚ�
				}
				if(flag==0){
					flag=new Float(o2.getSelf_score()).compareTo(new Float(o1.getSelf_score()));//�������ֱȽ�
				}
				return flag;
			}
		});
		TaskResultTodayList todayList=new TaskResultTodayList(totalInfs);
		return todayList;
	}
	//��ʦ�鿴�����
	@Override
	public TaskBoard findBoardForTch(String t_id, String last_time) throws Exception {
		List<TaskResult> rList=boardMapper.findResultForTch(t_id, last_time);
		TaskBoard taskBoard=new TaskBoard(rList);
		return taskBoard;
	}
	//��ʦ�鿴�Ƿ����½��
	@Override
	public Msg findTchNewResult(String t_id, String last_time) throws Exception {
		int status=1;
		TaskResult taskResult=boardMapper.findNewResultForTch(t_id, last_time);
		if(taskResult==null){
			status=0;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//ѧ���鿴�����
	@Override
	public TaskBoard findBoardForStu(String s_id, String last_time) throws Exception {
		List<TaskResult> rList=boardMapper.findResultForStu(s_id, last_time);
		TaskBoard taskBoard=new TaskBoard(rList);
		return taskBoard;
	}
	//ѧ���鿴�Ƿ����½��
	@Override
	public Msg findStuNewResult(String s_id, String last_time) throws Exception {
		int status=1;
		TaskResult taskResult=boardMapper.findNewResultForStu(s_id, last_time);
		if(taskResult==null){
			status=0;
		}
		Msg msg=new Msg(status);
		return msg;
	}
	//���½����ʦ����
	@Override
	public Msg updateResultTchScore(String id,String t_id,float score) throws Exception {
		int status=2;
		try {
			TaskResult result=taskResultMapper.findTaskResultById(id);
			Task task=taskMapper.findTaskByTaskId(result.getTask_id());
			if(!t_id.equals(task.getTeacher_id())){
				status=1;
				return new Msg(status);
			}
			result.setTch_score(score);
			status=boardMapper.updateResultTchScore(result);
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
		Msg msg=new Msg(status);
		return msg;
	}
	//���½����ʦ����
	@Override
	public Msg updateResultTchComment(String id,String t_id,String comment) throws Exception {
		int status=2;
		try {
			TaskResult result=taskResultMapper.findTaskResultById(id);
			Task task=taskMapper.findTaskByTaskId(result.getTask_id());
			if(!t_id.equals(task.getTeacher_id())){
				status=1;
				return new Msg(status);
			}
			result.setTch_comment(comment);
			status=boardMapper.updateResultTchComment(result);
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
		Msg msg=new Msg(status);
		return msg;
	}
}
