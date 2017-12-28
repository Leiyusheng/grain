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
     * 老师查看任务信息
     * @param task_id 任务id
     * @return CheckTaskTchInf 任务信息
     * @throws Exception
     */
    public CheckTaskTchInf findTaskTchInf(String task_id)throws Exception;
    /**
     * 学生查看任务信息
     * @param task_id 任务id
     * @param s_id 学生id
     * @return CheckTaskStuInf 任务信息
     * @throws Exception
     */
    public CheckTaskStuInf findTaskStuInf(String task_id,String s_id)throws Exception;
    /**
     * 查看任务完成情况
     * @param task_id 任务id
     * @param s_id 学生id
     * @return CheckTaskResultInf 任务完成情况信息
     * @throws Exception
     */
    public CheckTaskResultInf findTaskResultInf(String task_id,String s_id)throws Exception;
    /**
     * 增加任务
     * @param task 任务信息
     * @param s_ids 参与任务学生
     * @return Msg 返回信息：0成功，1其他
     * @throws Exception
     */
    public Msg insertTask(Task task,List<String> s_ids)throws Exception;
    /**
     * 修改任务
     * @param task 任务信息
     * @param s_ids 参与任务学生
     * @return Msg 返回信息：0成功，1其他
     * @throws Exception
     */
    public Msg updateTask(Task task,List<String> s_ids)throws Exception;
    /**
     * 删除任务
     * @param task_id 任务id
     * @return Msg 返回信息：0成功，1其他
     * @throws Exception
     */
    public Msg deleteTask(String task_id)throws Exception;
    /**
     * 查看学生任务中心
     * @param s_id 学生id
     * @return TaskStuCenterList 任务列表
     * @throws Exception
     */
    public TaskStuCenterList findStuCenterTask(String s_id)throws Exception;
    /**
     * 学生任务中心搜索
     * @param s_id 学生id
     * @param key 搜索关键词
     * @return TaskStuCenterList 任务列表
     * @throws Exception
     */
    public TaskStuCenterList getStuCenterTask(String s_id,String key)throws Exception;
    /**
     * 查看老师任务中心
     * @param t_id 老师id
     * @return TaskTchCenterList 任务列表
     * @throws Exception
     */
    public TaskTchCenterList findTchCenterTask(String t_id)throws Exception;
    /**
     * 老师任务中心搜索
     * @param t_id 老师id
     * @param key 搜索关键词
     * @return TaskTchCenterList 任务列表
     * @throws Exception
     */
    public TaskTchCenterList getTchCenterTask(String t_id,String key)throws Exception;
    /**
     * 查看学生今日任务
     * @param s_id 学生id
     * @return TaskStuList 任务列表
     * @throws Exception
     */
    public TaskStuList findStuTodayTask(String s_id)throws Exception;
    /**
     * 学生今日任务搜索
     * @param s_id 学生id
     * @param key 搜索关键词
     * @return TaskStuList 任务列表
     * @throws Exception
     */
    public TaskStuList getStuTodayTask(String s_id,String key)throws Exception;
    /**
     * 查看老师今日任务
     * @param t_id 老师id
     * @return TaskTchList 任务列表
     * @throws Exception
     */
    public TaskTchList findTchTodayTask(String t_id)throws Exception;
    /**
     * 老师今日任务搜索
     * @param t_id 老师id
     * @param key 搜索关键词
     * @return TaskTchList 任务列表
     * @throws Exception
     */
    public TaskTchList getTchTodayTask(String t_id,String key)throws Exception;
    /**
     * 老师查看学生任务
     * @param t_id 老师id
     * @param s_id 学生id
     * @return TaskTchCenterList 任务列表
     * @throws Exception
     */
    public TaskTchCenterList findStuTaskByTch(String t_id,String s_id)throws Exception;
    /**
     * 学生查看老师任务
     * @param t_id 老师id
     * @param s_id 学生id
     * @return TaskStuCenterList 任务列表
     * @throws Exception
     */
    public TaskStuCenterList findTchTaskByStu(String t_id,String s_id)throws Exception;
    /**
     * 修改任务自评难度
     * @param task_id 任务id
     * @param s_id 学生id 
     * @param level 自评难度
     * @return Msg 返回信息：0成功，1其他
     * @throws Exception
     */
    public Msg updateTaskLevel(String task_id,String s_id,int level)throws Exception;
    /**
     * 修改任务结果内容
     * @param taskResult 结果信息
     * @return Msg 返回信息：0成功，1其他
     * @throws Exception
     */
    public Msg updateTaskResult(TaskResult taskResult)throws Exception;
    /**
     * 更新任务结果状态
     * @param taskResult 结果信息
     * @return Msg 返回信息：0成功，1其他
     * @throws Exception
     */
    public Msg updateResultStatus(TaskResult taskResult)throws Exception;
    /**
     * 查看学生单个任务结果列表
     * @param task_id 任务id
     * @param s_id 学生id
     * @return TaskResultList 任务结果列表
     * @throws Exception
     */
    public TaskResultList findTaskResultList(String task_id,String s_id)throws Exception;
    /**
     * 查看任务今日结果列表
     * @param task_id 任务id
     * @return TaskResultTodayList 任务结果列表
     * @throws Exception
     */
    public TaskResultTodayList findTaskTodayList(String task_id)throws Exception;
    /**
     * 老师查看任务板
     * @param t_id 老师id
     * @param last_time 最近一条显示结果发表时间（第一次访问使用当前时间）
     * @return TaskBoard 任务板记录列表
     * @throws Exception
     */
    public TaskBoard findBoardForTch(String t_id,String last_time)throws Exception;
    /**
     * 查看老师任务板是否有新的记录
     * @param t_id 老师id
     * @param last_time 最近一条显示结果发表时间（第一次访问使用当前时间）
     * @return Msg：0无，1有
     * @throws Exception
     */
    public Msg findTchNewResult(String t_id,String last_time);
    /**
     * 学生查看任务板
     * @param s_id 学生id
     * @param last_time 最近一条显示结果发表时间（第一次访问使用当前时间）
     * @return TaskBoard 任务板记录列表
     * @throws Exception
     */
    public TaskBoard findBoardForStu(String s_id,String last_time)throws Exception;
    /**
     * 查看学生任务板是否有新的记录
     * @param s_id 学生id
     * @param last_time 最近一条显示结果发表时间（第一次访问使用当前时间）
     * @return Msg：0无，1有
     * @throws Exception
     */
    public Msg findStuNewResult(String s_id,String last_time);
    /**
     * 更新结果老师评分
     * @param id 结果id
     * @param t_id 老师id
     * @param score 评分
     * @return Msg 返回消息：0成功，1无权限，2其他
     * @throws Exception
     */
    public Msg updateResultTchScore(String id,String t_id,float score) throws Exception;
    /**
     * 更新结果老师评论
     * @param id 结果id
     * @param t_id 老师id
     * @param comment 评论
     * @return Msg 返回消息：0成功，1无权限，2其他
     * @throws Exception
     */
    public Msg updateResultTchComment(String id,String t_id,String comment) throws Exception;
}
