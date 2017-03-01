package grain.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import grain.po.TaskResult;
import grain.po.TaskResultTotalInf;
import grain.po.Praise;

public interface TaskResultMapper {
	
	public TaskResult findTaskResultById(String id)throws Exception;
	
	public TaskResult findTaskResultByStu(@Param("task_id")String task_id,@Param("s_id")String s_id)throws Exception;
	
	public int findTaskResultNumById(String id)throws Exception;
	
	public int insertTaskResult(TaskResult taskResult)throws Exception;
	
	public int updateTaskResult(TaskResult taskResult)throws Exception;
	
	public Praise findPraise(Praise praise)throws Exception;
	
	public int insertPraise(Praise praise)throws Exception;
	
	public int updatePraise(Praise praise)throws Exception;
	
	public List<TaskResult> findTaskResultByDate(@Param("task_id")String task_id,@Param("s_id")String s_id)throws Exception;
	
	public List<TaskResultTotalInf> findTaskResultByTch(String task_id)throws Exception;
}
