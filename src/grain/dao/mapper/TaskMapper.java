package grain.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import grain.po.Student;
import grain.po.Task;
import grain.po.TaskStudent;

public interface TaskMapper {
	
	public Task findTaskByTaskId(String id)throws Exception;
	
	public int insertTask(Task task)throws Exception;
	
	public int insertTaskStu(TaskStudent taskStudent)throws Exception;
	
	public int deleteTaskStu(@Param("task_id")String task_id,@Param("s_id")String s_id)throws Exception;
	
	public int updateTaskStuCount(@Param("status")int status,@Param("task_id")String task_id)throws Exception;
	
	public List<Student> findTaskStuList(String id)throws Exception;
	
	public TaskStudent findTaskStuById(@Param("task_id")String task_id,@Param("s_id")String s_id)throws Exception;
	
	public int updateTaskLevel(TaskStudent taskStudent)throws Exception;
	
	public int updateTask(Task task)throws Exception;
	
	public List<Task> findTaskCenterByStu(String id)throws Exception;
	
	public List<Task> searchTaskCenterByStu(@Param("id")String id,@Param("key")String key)throws Exception;
	
	public List<Task> findTaskCenterByTch(String id)throws Exception;
	
	public List<Task> searchTaskCenterByTch(@Param("id")String id,@Param("key")String key)throws Exception;
	
	public List<Task> findStuTaskByTch(@Param("t_id")String t_id,@Param("s_id")String s_id)throws Exception;
	
	public List<Task> findTchTaskByStu(@Param("s_id")String s_id,@Param("t_id")String t_id)throws Exception;
	
	public List<Task> findTodayTaskByStuId(String id)throws Exception;
	
	public List<Task> searchTodayTaskByStuId(@Param("id")String id,@Param("key")String key)throws Exception;
	
	public List<Task> findTodayTaskByTchId(String id)throws Exception;
	
	public List<Task> searchTodayTaskByTchId(@Param("id")String id,@Param("key")String key)throws Exception;
}
