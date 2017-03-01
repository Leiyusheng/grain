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
	
	public CheckTaskTchInf findTaskTchInf(String task_id)throws Exception;
	
	public CheckTaskStuInf findTaskStuInf(String task_id,String s_id)throws Exception;
	
	public CheckTaskResultInf findTaskResultInf(String task_id,String s_id)throws Exception;
	
	public Msg insertTask(Task task,List<String> s_ids)throws Exception;
	
	public Msg updateTask(Task task,List<String> s_ids)throws Exception;
	
	public Msg deleteTask(String task_id)throws Exception;
	
	public TaskStuCenterList findStuCenterTask(String s_id)throws Exception;
	
	public TaskStuCenterList getStuCenterTask(String s_id,String key)throws Exception;
	
	public TaskTchCenterList findTchCenterTask(String t_id)throws Exception;
	
	public TaskTchCenterList getTchCenterTask(String t_id,String key)throws Exception;
	
	public TaskStuList findStuTodayTask(String s_id)throws Exception;
	
	public TaskStuList getStuTodayTask(String s_id,String key)throws Exception;
	
	public TaskTchList findTchTodayTask(String t_id)throws Exception;
	
	public TaskTchList getTchTodayTask(String t_id,String key)throws Exception;
	
	public TaskTchCenterList findStuTaskByTch(String t_id,String s_id)throws Exception;
	
	public TaskStuCenterList findTchTaskByStu(String t_id,String s_id)throws Exception;
	
	public Msg updateTaskLevel(String task_id,String s_id,int level)throws Exception;
	
	public Msg updateTaskResult(TaskResult taskResult)throws Exception;
	
	public Msg updateResultStatus(TaskResult taskResult)throws Exception;
	
	public TaskResultList findTaskResultList(String task_id,String s_id)throws Exception;
	
	public TaskResultTodayList findTaskTodayList(String task_id)throws Exception;
	
	public TaskBoard findBoardForTch(String t_id,String last_time)throws Exception;
	
	public TaskBoard findBoardForStu(String s_id,String last_time)throws Exception;
}
