package grain.service;

import java.util.List;

import grain.dto.CheckTaskResultInf;
import grain.dto.CheckTaskStuInf;
import grain.dto.CheckTaskTchInf;
import grain.dto.Msg;
import grain.dto.TaskBoard;
import grain.dto.TaskResultList;
import grain.dto.TaskResultTodayList;
import grain.dto.TaskStuCenterList;
import grain.dto.TaskStuList;
import grain.dto.TaskTchCenterList;
import grain.dto.TaskTchList;
import grain.po.Task;
import grain.po.TaskResult;

public interface TaskService {
	/**
	 * ��ʦ�鿴������Ϣ
	 * @param task_id ����id
	 * @return CheckTaskTchInf ������Ϣ
	 * @throws Exception
	 */
	public CheckTaskTchInf findTaskTchInf(String task_id)throws Exception;
	/**
	 * ѧ���鿴������Ϣ
	 * @param task_id ����id
	 * @param s_id ѧ��id
	 * @return CheckTaskStuInf ������Ϣ
	 * @throws Exception
	 */
	public CheckTaskStuInf findTaskStuInf(String task_id,String s_id)throws Exception;
	/**
	 * �鿴����������
	 * @param task_id ����id
	 * @param s_id ѧ��id
	 * @return CheckTaskResultInf ������������Ϣ
	 * @throws Exception
	 */
	public CheckTaskResultInf findTaskResultInf(String task_id,String s_id)throws Exception;
	/**
	 * ��������
	 * @param task ������Ϣ
	 * @param s_ids ��������ѧ��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg insertTask(Task task,List<String> s_ids)throws Exception;
	/**
	 * �޸�����
	 * @param task ������Ϣ
	 * @param s_ids ��������ѧ��
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTask(Task task,List<String> s_ids)throws Exception;
	/**
	 * ɾ������
	 * @param task_id ����id
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg deleteTask(String task_id)throws Exception;
	/**
	 * �鿴ѧ����������
	 * @param s_id ѧ��id
	 * @return TaskStuCenterList �����б�
	 * @throws Exception
	 */
	public TaskStuCenterList findStuCenterTask(String s_id)throws Exception;
	/**
	 * ѧ��������������
	 * @param s_id ѧ��id
	 * @param key �����ؼ���
	 * @return TaskStuCenterList �����б�
	 * @throws Exception
	 */
	public TaskStuCenterList getStuCenterTask(String s_id,String key)throws Exception;
	/**
	 * �鿴��ʦ��������
	 * @param t_id ��ʦid
	 * @return TaskTchCenterList �����б�
	 * @throws Exception
	 */
	public TaskTchCenterList findTchCenterTask(String t_id)throws Exception;
	/**
	 * ��ʦ������������
	 * @param t_id ��ʦid
	 * @param key �����ؼ���
	 * @return TaskTchCenterList �����б�
	 * @throws Exception
	 */
	public TaskTchCenterList getTchCenterTask(String t_id,String key)throws Exception;
	/**
	 * �鿴ѧ����������
	 * @param s_id ѧ��id
	 * @return TaskStuList �����б�
	 * @throws Exception
	 */
	public TaskStuList findStuTodayTask(String s_id)throws Exception;
	/**
	 * ѧ��������������
	 * @param s_id ѧ��id
	 * @param key �����ؼ���
	 * @return TaskStuList �����б�
	 * @throws Exception
	 */
	public TaskStuList getStuTodayTask(String s_id,String key)throws Exception;
	/**
	 * �鿴��ʦ��������
	 * @param t_id ��ʦid
	 * @return TaskTchList �����б�
	 * @throws Exception
	 */
	public TaskTchList findTchTodayTask(String t_id)throws Exception;
	/**
	 * ��ʦ������������
	 * @param t_id ��ʦid
	 * @param key �����ؼ���
	 * @return TaskTchList �����б�
	 * @throws Exception
	 */
	public TaskTchList getTchTodayTask(String t_id,String key)throws Exception;
	/**
	 * ��ʦ�鿴ѧ������
	 * @param t_id ��ʦid
	 * @param s_id ѧ��id
	 * @return TaskTchCenterList �����б�
	 * @throws Exception
	 */
	public TaskTchCenterList findStuTaskByTch(String t_id,String s_id)throws Exception;
	/**
	 * ѧ���鿴��ʦ����
	 * @param t_id ��ʦid
	 * @param s_id ѧ��id
	 * @return TaskStuCenterList �����б�
	 * @throws Exception
	 */
	public TaskStuCenterList findTchTaskByStu(String t_id,String s_id)throws Exception;
	/**
	 * �޸����������Ѷ�
	 * @param task_id ����id
	 * @param s_id ѧ��id 
	 * @param level �����Ѷ�
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTaskLevel(String task_id,String s_id,int level)throws Exception;
	/**
	 * �޸�����������
	 * @param taskResult �����Ϣ
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateTaskResult(TaskResult taskResult)throws Exception;
	/**
	 * ����������״̬
	 * @param taskResult �����Ϣ
	 * @return Msg ������Ϣ��0�ɹ���1����
	 * @throws Exception
	 */
	public Msg updateResultStatus(TaskResult taskResult)throws Exception;
	/**
	 * �鿴ѧ�������������б�
	 * @param task_id ����id
	 * @param s_id ѧ��id
	 * @return TaskResultList �������б�
	 * @throws Exception
	 */
	public TaskResultList findTaskResultList(String task_id,String s_id)throws Exception;
	/**
	 * �鿴������ս���б�
	 * @param task_id ����id
	 * @return TaskResultTodayList �������б�
	 * @throws Exception
	 */
	public TaskResultTodayList findTaskTodayList(String task_id)throws Exception;
	/**
	 * ��ʦ�鿴�����
	 * @param t_id ��ʦid
	 * @param last_time ���һ����ʾ�������ʱ�䣨��һ�η���ʹ�õ�ǰʱ�䣩
	 * @return TaskBoard ������¼�б�
	 * @throws Exception
	 */
	public TaskBoard findBoardForTch(String t_id,String last_time)throws Exception;
	/**
	 * �鿴��ʦ������Ƿ����µļ�¼
	 * @param t_id ��ʦid
	 * @param last_time ���һ����ʾ�������ʱ�䣨��һ�η���ʹ�õ�ǰʱ�䣩
	 * @return Msg��0�ޣ�1��
	 * @throws Exception
	 */
	public Msg findTchNewResult(String t_id,String last_time)throws Exception;
	/**
	 * ѧ���鿴�����
	 * @param s_id ѧ��id
	 * @param last_time ���һ����ʾ�������ʱ�䣨��һ�η���ʹ�õ�ǰʱ�䣩
	 * @return TaskBoard ������¼�б�
	 * @throws Exception
	 */
	public TaskBoard findBoardForStu(String s_id,String last_time)throws Exception;
	/**
	 * �鿴ѧ��������Ƿ����µļ�¼
	 * @param s_id ѧ��id
	 * @param last_time ���һ����ʾ�������ʱ�䣨��һ�η���ʹ�õ�ǰʱ�䣩
	 * @return Msg��0�ޣ�1��
	 * @throws Exception
	 */
	public Msg findStuNewResult(String s_id,String last_time)throws Exception;
	/**
	 * ���½����ʦ����
	 * @param id ���id
	 * @param t_id ��ʦid
	 * @param score ����
	 * @return Msg ������Ϣ��0�ɹ���1��Ȩ�ޣ�2����
	 * @throws Exception
	 */
	public Msg updateResultTchScore(String id,String t_id,float score) throws Exception;
	/**
	 * ���½����ʦ����
	 * @param id ���id
	 * @param t_id ��ʦid
	 * @param comment ����
	 * @return Msg ������Ϣ��0�ɹ���1��Ȩ�ޣ�2����
	 * @throws Exception
	 */
	public Msg updateResultTchComment(String id,String t_id,String comment) throws Exception;
}
