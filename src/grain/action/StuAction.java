package grain.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import grain.dto.ApplyList;
import grain.dto.CheckStuInf;
import grain.dto.CheckTaskResultInf;
import grain.dto.CheckTaskStuInf;
import grain.dto.CheckSearchInf;
import grain.dto.Msg;
import grain.dto.TaskBoard;
import grain.dto.TaskResultList;
import grain.dto.TaskStuCenterList;
import grain.dto.TaskStuList;
import grain.dto.TeacherList;
import grain.po.TaskResult;
import grain.service.StuService;
import grain.service.TaskService;
import grain.service.TchService;
import grain.service.UserService;



@Controller
public class StuAction {
	@Autowired
	StuService stuService;
	@Autowired
	TchService tchService;
	@Autowired
	UserService userService;
	@Autowired
	TaskService taskService;

	@RequestMapping("/checkStuInf")
	public @ResponseBody CheckStuInf checkStuInf(String s_id)throws Exception{
		return stuService.findStuInf(s_id);
	}

	@RequestMapping("/editStuName")
	public @ResponseBody Msg editStuName(String s_id,String s_name)throws Exception{
		return stuService.updateStuName(s_id,s_name);
	}

	@RequestMapping("/editStuLogo")
	public @ResponseBody Msg editStuLogo(String s_id,String logo)throws Exception{
		return stuService.updateStuLogo(s_id,logo);
	}

	@RequestMapping("/editStuGender")
	public @ResponseBody Msg editStuGender(String s_id,int gender)throws Exception{
		return stuService.updateStuGender(s_id,gender);
	}

	@RequestMapping("/editStuBirthday")
	public @ResponseBody Msg editStuBirthday(String s_id,String birthday)throws Exception{
		return stuService.updateStuBirthday(s_id,birthday);
	}

	@RequestMapping("/editStuSign")
	public @ResponseBody Msg editStuSign(String s_id,String sign)throws Exception{
		return stuService.updateStuSign(s_id,sign);
	}

	@RequestMapping("/editStuInf")
	public @ResponseBody Msg editStuInf(String s_id,String inf)throws Exception{
		return stuService.updateStuInf(s_id,inf);
	}

	@RequestMapping("/editStuHomePic")
	public @ResponseBody Msg editStuHomePic(String s_id,String home_pic)throws Exception{
		return stuService.updateStuHomePic(s_id,home_pic);
	}

	@RequestMapping("/editStuBoardPic")
	public @ResponseBody Msg editStuBoardPic(String s_id,String board_pic)throws Exception{
		return stuService.updateStuBoardPic(s_id,board_pic);
	}

	@RequestMapping("/checkAccess")
	public @ResponseBody Msg checkAccess(String s_id)throws Exception{
		return stuService.findStuAccess(s_id);
	}

	@RequestMapping("/setAccess")
	public @ResponseBody Msg setAccess(String s_id,int access)throws Exception{
		return stuService.updateStuAccess(s_id, access);
	}

	@RequestMapping("/checkStu")
	public @ResponseBody CheckSearchInf checkStu(String t_id,String phone)throws Exception{
		return stuService.findStuByPhone(t_id,phone);
	}

	@RequestMapping("/applyTch")//0成功，1已添加，2老师不存在，3其他
	public @ResponseBody Msg applyTch(String s_id,String t_id,String info)throws Exception{
		return stuService.updateTchApply(s_id, t_id, info);
	}

	@RequestMapping("/checkTchList")
	public @ResponseBody TeacherList checkTchList(String s_id)throws Exception{
		return stuService.findTchList(s_id);
	}

	@RequestMapping("/checkTchApplyList")
	public @ResponseBody ApplyList checkTchApplyList(String s_id)throws Exception{
		return stuService.findApplyList(s_id);
	}

	@RequestMapping("/delTchApply")
	public @ResponseBody Msg delTchApply(String t_id,String s_id)throws Exception{
		return stuService.deleteApply(t_id, s_id);
	}

	@RequestMapping("/delTch")
	public @ResponseBody Msg delTch(String s_id,String t_id)throws Exception{
		int method=2;
		return userService.updateContact(t_id, s_id, method);
	}

	@RequestMapping("/checkTaskStuInf")
	public @ResponseBody CheckTaskStuInf checkTaskStuInf(String task_id,String s_id)throws Exception{
		return taskService.findTaskStuInf(task_id,s_id);
	}

	@RequestMapping("/checkResultByDate")
	public @ResponseBody  TaskResultList checkResultByDate(String task_id,String s_id)throws Exception{
		return taskService.findTaskResultList(task_id,s_id);
	}

	@RequestMapping("/checkStuTaskCenter")
	public @ResponseBody TaskStuCenterList checkStuTaskCenter(String s_id)throws Exception{
		return taskService.findStuCenterTask(s_id);
	}

	@RequestMapping("/searchStuTaskCenter")
	public @ResponseBody TaskStuCenterList searchStuTaskCenter(String s_id,String key)throws Exception{
		return taskService.getStuCenterTask(s_id,key);
	}

	@RequestMapping("/checkStuTodayTask")
	public @ResponseBody TaskStuList checkStuTodayTask(String s_id)throws Exception{
		return taskService.findStuTodayTask(s_id);
	}

	@RequestMapping("/searchStuTodayTask")
	public @ResponseBody TaskStuList searchStuTodayTask(String s_id,String key)throws Exception{
		return taskService.getStuTodayTask(s_id,key);
	}

	@RequestMapping("/checkTchTaskByStu")
	public @ResponseBody TaskStuCenterList checkTchTaskByStu(String t_id,String s_id)throws Exception{
		return taskService.findTchTaskByStu(t_id, s_id);
	}

	@RequestMapping("/checkTaskResultInf")
	public @ResponseBody CheckTaskResultInf checkTaskResultInf(String task_id,String s_id)throws Exception{
		return taskService.findTaskResultInf(task_id, s_id);
	}

	@RequestMapping("/editTaskLevel")
	public @ResponseBody Msg editTaskLevel(String task_id,String s_id,int level)throws Exception{
		return taskService.updateTaskLevel(task_id, s_id, level);
	}

	@RequestMapping("/saveTaskResult")
	public @ResponseBody Msg inputTaskResult(TaskResult taskResult)throws Exception{
		return taskService.updateTaskResult(taskResult);
	}

	@RequestMapping("/pubTaskResult")
	public @ResponseBody Msg pubTaskResult(TaskResult taskResult)throws Exception{
		return taskService.updateResultStatus(taskResult);
	}

	@RequestMapping("/checkStuBoard")
	public @ResponseBody TaskBoard checkStuBoard(String s_id,String last_time)throws Exception{
		return taskService.findBoardForStu(s_id, last_time);
	}

	@RequestMapping("/checkStuNewResult")
	public @ResponseBody Msg checkStuNewResult(String s_id,String last_time)throws Exception{
		return taskService.findStuNewResult(s_id, last_time);
	}
}