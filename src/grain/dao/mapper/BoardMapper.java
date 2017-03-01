package grain.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import grain.po.Praise;
import grain.po.TaskResult;

public interface BoardMapper {
	
	public List<TaskResult> findResultForTch(@Param("t_id")String t_id,@Param("last_time")String last_time)throws Exception;
	
	public List<TaskResult> findResultForStu(@Param("s_id")String t_id,@Param("last_time")String last_time)throws Exception;
	
	public int updateResultStatus(String id)throws Exception;
	
	public int updateResultPraise(Praise praise)throws Exception;
}
