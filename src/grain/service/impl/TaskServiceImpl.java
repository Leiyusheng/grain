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
    //老师查看任务信息
    @Override
    public CheckTaskTchInf findTaskTchInf(String task_id) throws Exception {
        int status = 1;
        Task task;
        List<Student> sList;
        try {
            task = taskMapper.findTaskByTaskId(task_id);
            sList = taskMapper.findTaskStuList(task_id);
            
            status = 0;
        } catch (Exception e) {
            throw e;
        }
        TaskTchInf taskTchInf = new TaskTchInf(task,sList);
        CheckTaskTchInf checkTaskTchInf = new CheckTaskTchInf(status, taskTchInf);
        return checkTaskTchInf;
    }
    //学生查看任务信息
    @Override
    public CheckTaskStuInf findTaskStuInf(String task_id,String s_id) throws Exception {
        int status=1;
        int self_level=0;
        Task task;
        try {
            task=taskMapper.findTaskByTaskId(task_id);
            TaskStudent tStudent=taskMapper.findTaskStuById(task_id, s_id);
            self_level=tStudent.getDifficulty_level();//自评难度
            status=0;
        } catch (Exception e) {
            throw e;
        }
        TaskStuInf taskStuInf=new TaskStuInf(task,self_level);
        CheckTaskStuInf checkTaskStuInf=new CheckTaskStuInf(status, taskStuInf);
        return checkTaskStuInf;
    }
    //插入新任务
    @Override
    public Msg insertTask(Task task,List<String> s_ids) throws Exception {
        int status=1;
        String s=UUID.randomUUID().toString();
        String id=s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
        task.setTask_id(id);//设置任务id
        task.setTotal_num(s_ids.size());//设置任务总人数
        Date date=new Date(System.currentTimeMillis());//获取当前日期
        if(date.before(task.getStart_date())){//判断任务初始状态
            task.setStatus(0);
        }
        else{
            task.setStatus(1);
        }
        try {
            taskMapper.insertTask(task);
            for(int i=0;i<s_ids.size();i++){//加入任务的学生
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
    //编辑任务
    @Override
    public Msg updateTask(Task task,List<String> s_ids) throws Exception {
        int status=1;
        String task_id=task.getTask_id();
        Date date=new Date(System.currentTimeMillis());//获取当前日期
        if(date.before(task.getStart_date())){
            task.setStatus(0);
        }
        else{
            task.setStatus(1);
        }
        try {
            status=taskMapper.updateTask(task);
            List<Student> sList=taskMapper.findTaskStuList(task_id);//获取该任务原来的学生
            String t_id=taskMapper.findTaskByTaskId(task_id).getTeacher_id();
            for(int i=0;i<s_ids.size();i++){//修改任务的学生
                int stu_status=1;//该学生状态，1为新增，0为原有
                String n_s_id=s_ids.get(i);//新的分组学生id
                Contact contact=ctctMapper.findContactById(t_id, n_s_id);
                if(contact!=null&&contact.getStatus()==1){//判断该学生是否属于该老师
                    for(int j=0;j<sList.size();j++){
                        String o_s_id=sList.get(j).getStudent_id();//旧的分组学生id
                        if(n_s_id.equals(o_s_id)){
                            stu_status=0;//该学生已存在
                            sList.remove(j--);//移除分组原来的学生中任然存在的
                            break;
                        }
                    }
                    if(stu_status==1){
                        try {
                            TaskStudent taskStudent=new TaskStudent(task_id,n_s_id);
                            taskMapper.insertTaskStu(taskStudent);
                            taskMapper.updateTaskStuCount(1, task_id);
                        } catch (DuplicateKeyException e1) {
                            //加入已有学生则跳过
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
    //删除任务
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
    //查看学生任务中心
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
    //搜索学生任务中心
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
    //查看老师任务中心
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
    //搜索老师任务中心
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
    //查看学生今天个人任务列表
    @Override
    public TaskStuList findStuTodayTask(String s_id) throws Exception {
        List<Task> tasks = taskMapper.findTodayTaskByStuId(s_id);
        TaskStuList tList = new TaskStuList();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            int practice_time = 0;//获取完成时间
            int status = 0;//未发表
            int duration_day = 0;//连续打卡天数
            TaskStudent taskStudent = taskMapper.findTaskStuById(task.getTask_id(), s_id);
            if (taskStudent != null) {
                duration_day = taskStudent.getDuration_day();
            }
            TaskResult result = taskResultMapper.findTaskResultByStu(task.getTask_id(), s_id);
            if (result != null) {
                practice_time = result.getPractice_time();
                status = result.getStatus();
            }
            TaskStuSimpleInf sInf = new TaskStuSimpleInf(task, practice_time, status, duration_day);
            tList.addTaskInf(sInf);
        }
        return tList;
    }
    //搜索学生今天个人任务列表
    @Override
    public TaskStuList getStuTodayTask(String s_id,String key) throws Exception {
        List<Task> tasks = taskMapper.searchTodayTaskByStuId(s_id,key);
        TaskStuList tList = new TaskStuList();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            int practice_time = 0;//获取完成时间
            int status = 0;//未发表
            int duration_day = 0;//连续打卡天数
            TaskStudent taskStudent = taskMapper.findTaskStuById(task.getTask_id(), s_id);
            if (taskStudent != null) {
                duration_day = taskStudent.getDuration_day();
            }
            TaskResult result = taskResultMapper.findTaskResultByStu(task.getTask_id(), s_id);
            if (result != null) {
                practice_time = result.getPractice_time();
                status = result.getStatus();
            }
            TaskStuSimpleInf sInf = new TaskStuSimpleInf(task, practice_time, status, duration_day);
            tList.addTaskInf(sInf);
        }
        return tList;
    }
    //查看老师今天个人任务列表
    @Override
    public TaskTchList findTchTodayTask(String t_id) throws Exception {
        List<Task> tasks=taskMapper.findTodayTaskByTchId(t_id);
        TaskTchList tList=new TaskTchList();
        for(int i=0;i<tasks.size();i++){
            Task task=tasks.get(i);
            int finish_num=taskResultMapper.findTaskResultNumById(task.getTask_id());//获取今天完成人数
            System.out.println(finish_num);
            TaskTchSimpleInf tInf=new TaskTchSimpleInf(task,finish_num);
            tList.addTaskInf(tInf);
        }
        return tList;
    }
    //搜索老师今天个人任务列表
    @Override
    public TaskTchList getTchTodayTask(String t_id,String key) throws Exception {
    List<Task> tasks=taskMapper.searchTodayTaskByTchId(t_id,key);
        TaskTchList tList=new TaskTchList();
        for(int i=0;i<tasks.size();i++){
            Task task=tasks.get(i);
            int finish_num=taskResultMapper.findTaskResultNumById(task.getTask_id());//获取今天完成人数
            System.out.println(finish_num);
            TaskTchSimpleInf tInf=new TaskTchSimpleInf(task,finish_num);
            tList.addTaskInf(tInf);
        }
        return tList;
    }
    //老师查看学生任务列表
    @Override
    public TaskTchCenterList findStuTaskByTch(String t_id, String s_id) throws Exception {
        List<Task> tasks=taskMapper.findStuTaskByTch(t_id, s_id);
        TaskTchCenterList tList=new TaskTchCenterList();
        for(int i = 0;i < tasks.size();i ++){
            Task task=tasks.get(i);
            TaskTchCenterInf tInf = new TaskTchCenterInf(task);
            tList.addTaskInf(tInf);
        }
        return tList;
    }
    //学生查看老师任务列表
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
    //查看完成情况
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
    //编辑任务难度
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
    //更新任务完成情况
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
    //发表任务情况
    @Override
    public Msg updateResultStatus(TaskResult taskResult) throws Exception {
        int status = 1;
        try {
            TaskResult result = taskResultMapper.findTaskResultById(taskResult.getTask_result_id());
            TaskStudent taskStudent = taskMapper.findTaskStuById(result.getTask_id(), result.getStudent_id());
            //先进行更新操作，对表加行级排他锁直到该事务结束才释放，以保证后面对排名数据的读取正确
            taskMapper.updateTaskClockNum(result.getTask_id());
            Task task = taskMapper.findTaskByTaskId(result.getTask_id());
            result.setPublishInf(taskResult.getFinish_photo(), taskResult.getComments(), task.getClock_num());
            taskResultMapper.updateTaskResult(result);
            taskMapper.updateStuClockDay(taskStudent);
            status = boardMapper.updateResultStatus(taskResult.getTask_result_id());
            if(status == 0){
                status = 1;
            }
            else{
                status = 0;
            }
        } catch (Exception e) {
            status = 1;
            throw e;
        }
        Msg msg = new Msg(status);
        return msg;
    }
    //按日期查看学生任务完成情况
    @Override
    public TaskResultList findTaskResultList(String task_id,String s_id) throws Exception {
        int status = 1;
        TaskResultList rList;
        Task task = taskMapper.findTaskByTaskId(task_id);
        Student stu = stuMapper.findStuById(s_id);
        if (task != null&&task.getStatus() != 3&&stu != null) {
            status = 0;
            rList = new TaskResultList(status,task,stu);
            List<TaskResult> taskResults = taskResultMapper.findTaskResultByDate(task_id, s_id);
            for (int i = 0; i < taskResults.size(); i++) {
                TaskResult taskResult = taskResults.get(i);
                TaskResultSimpleInf tInf = new TaskResultSimpleInf(taskResult);
                rList.addTaskResultInf(tInf);
            }
        }
        else{
            rList=new TaskResultList(status);
        }
        return rList;
    }
    //老师查看单个任务今日完成情况
    @Override
    public TaskResultTodayList findTaskTodayList(String task_id) throws Exception {
        List<TaskResultTotalInf> totalInfs = taskResultMapper.findTaskResultByTch(task_id);
        Collections.sort(totalInfs, new Comparator<TaskResultTotalInf>() {
            @Override
            public int compare(TaskResultTotalInf o1, TaskResultTotalInf o2) {
                int flag = new Integer(o1.getClock_rank()).compareTo(new Integer(o2.getClock_rank()));//打卡顺序比较
                if (o1.getClock_rank() == 0 || o2.getClock_rank() == 0){
                    flag = -flag;
                }
                if (flag == 0) {
                    flag = new Integer(o2.getTotal_time()).compareTo(new Integer(o1.getTotal_time()));//总完成时间比较
                }
                if (flag == 0) {
                    flag = new Float(o2.getSelf_score()).compareTo(new Float(o1.getSelf_score()));//个人评分比较
                }
                return flag;
            }
        });
        TaskResultTodayList todayList = new TaskResultTodayList(totalInfs);
        return todayList;
    }
    //老师查看任务板
    @Override
    public TaskBoard findBoardForTch(String t_id, String last_time) throws Exception {
        List<TaskResult> rList=boardMapper.findResultForTch(t_id, last_time);
        TaskBoard taskBoard=new TaskBoard(rList);
        return taskBoard;
    }
    //老师查看是否有新结果
    @Override
    public Msg findTchNewResult(String t_id, String last_time){
        int status = 0;
        TaskResult taskResult = null;
        try {
            taskResult = boardMapper.findNewResultForTch(t_id, last_time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(taskResult != null){
            status = 1;
        }
        Msg msg = new Msg(status);
        return msg;
    }
    //学生查看任务板
    @Override
    public TaskBoard findBoardForStu(String s_id, String last_time) throws Exception {
        List<TaskResult> rList=boardMapper.findResultForStu(s_id, last_time);
        TaskBoard taskBoard=new TaskBoard(rList);
        return taskBoard;
    }
    //学生查看是否有新结果
    @Override
    public Msg findStuNewResult(String s_id, String last_time){
        int status = 0;
        TaskResult taskResult = null;
        try {
            taskResult = boardMapper.findNewResultForStu(s_id, last_time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(taskResult != null){
            status = 1;
        }
        Msg msg = new Msg(status);
        return msg;
    }
    //更新结果老师评分
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
    //更新结果老师评论
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
