package grain.action;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import grain.dto.ApplyList;
import grain.dto.CheckTaskTchInf;
import grain.dto.CheckTchInf;
import grain.dto.GroupList;
import grain.dto.Msg;
import grain.dto.StudentList;
import grain.dto.TaskBoard;
import grain.dto.TaskResultTodayList;
import grain.dto.TaskTchCenterList;
import grain.dto.TaskTchList;
import grain.po.Task;
import grain.service.UserService;
import grain.service.GrpService;
import grain.service.TaskService;
import grain.service.TchService;

@Controller
public class TchAction {

	@Autowired
	TchService tchService;
	@Autowired
	UserService userService;
	@Autowired
	GrpService grpService;
	@Autowired
	TaskService taskService;
	
	@RequestMapping("/checkTchInf")
	public @ResponseBody CheckTchInf checkTchInf(String t_id)throws Exception{
		return tchService.findTchInf(t_id);
	}
	
	@RequestMapping("/editTchName")
	public @ResponseBody Msg editTchName(String t_id,String t_name)throws Exception{
		return tchService.updateTchName(t_id,t_name);
	}
	
	@RequestMapping("/editTchLogo")
	public @ResponseBody Msg editTchLogo(String t_id,String logo)throws Exception{
		return tchService.updateTchLogo(t_id,logo);
	}
	
	@RequestMapping("/editTchGender")
	public @ResponseBody Msg editStuGender(String t_id,int gender)throws Exception{
		return tchService.updateTchGender(t_id,gender);
	}
	
	@RequestMapping("/editTchBirthday")
	public @ResponseBody Msg editTchBirthday(String t_id,String birthday)throws Exception{
		return tchService.updateTchBirthday(t_id,birthday);
	}
	
	@RequestMapping("/editTchSign")
	public @ResponseBody Msg editTchSign(String t_id,String sign)throws Exception{
		return tchService.updateTchSign(t_id,sign);
	}
	
	@RequestMapping("/editTchInf")
	public @ResponseBody Msg editTchInf(String t_id,String inf)throws Exception{
		return tchService.updateTchInf(t_id,inf);
	}
	
	@RequestMapping("/editTchHomePic")
	public @ResponseBody Msg editTchHomePic(String t_id,String home_pic)throws Exception{
		return tchService.updateTchHomePic(t_id,home_pic);
	}
	
	@RequestMapping("/editTchBoardPic")
	public @ResponseBody Msg editTchBoardPic(String t_id,String board_pic)throws Exception{
		return tchService.updateTchBoardPic(t_id,board_pic);
	}
	
	@RequestMapping("/checkApplyList")
	public @ResponseBody ApplyList checkApplyList(String t_id)throws Exception{
		return tchService.findApplyList(t_id);
	}
	
	@RequestMapping("/handleApply")
	public @ResponseBody Msg handleApply(String t_id,String s_id)throws Exception{
		int method=1;
		return userService.updateContact(t_id, s_id, method);
	}
	
	@RequestMapping("/delApply")
	public @ResponseBody Msg delApply(String t_id,String s_id)throws Exception{
		return tchService.deleteApply(t_id, s_id);
	}
	
	@RequestMapping("/delStu")
	public @ResponseBody Msg delStu(String t_id,String s_id)throws Exception{
		int method=2;
		return userService.updateContact(t_id, s_id, method);
	}
	
	@RequestMapping("/checkGrp")
	public @ResponseBody GroupList checkGrp(String t_id)throws Exception{
		return tchService.findGroupListById(t_id);
	}
	
	@RequestMapping("/creGrp")
	public @ResponseBody Msg creGrp(String t_id,String grp_name)throws Exception{
		return tchService.insertGroup(t_id, grp_name);
	}
	
	@RequestMapping("/delGrp")
	public @ResponseBody Msg delGrp(String g_id)throws Exception{
		return tchService.deleteGroup(g_id);
	}
	
	@RequestMapping("/editGrpName")
	public @ResponseBody Msg editGrpName(String g_id,String g_name)throws Exception{
		return grpService.updateGrpName(g_id, g_name);
	}
	
	@RequestMapping("/checkGrpStu")
	public @ResponseBody StudentList checkGrpStu(String g_id)throws Exception{
		return grpService.findGrpStu(g_id);
	}
	
	@RequestMapping(value="/editGrpStu")
	public @ResponseBody Msg editGrpStu(String g_id,String s_ids)throws Exception{
		String[] s_id=s_ids.split(";");
		List<String> list=Arrays.asList(s_id);
		return grpService.updateGrpStu(g_id, list);
	}
	
	@RequestMapping("/delGrpStu")
	public @ResponseBody Msg delGrpStu(String g_id,String s_id)throws Exception{
		return grpService.deleteGrpStu(g_id, s_id);
	}
	
	@RequestMapping("/pubTask")
	public @ResponseBody Msg pubTask(Task task,String s_ids)throws Exception{
		String[] s_id=s_ids.split(";");
		List<String> list=Arrays.asList(s_id);
		return taskService.insertTask(task, list);
	}
	
	@RequestMapping("/editTask")
	public @ResponseBody Msg editTask(Task task,String s_ids)throws Exception{
		String[] s_id=s_ids.split(";");
		List<String> list=Arrays.asList(s_id);
		return taskService.updateTask(task,list);
	}
	
	@RequestMapping("/checkTaskTchInf")
	public @ResponseBody CheckTaskTchInf checkTaskTchInf(String task_id)throws Exception{
		return taskService.findTaskTchInf(task_id);
	}
	
	@RequestMapping("/checkTchTaskCenter")
	public @ResponseBody TaskTchCenterList checkTchTaskCenter(String t_id)throws Exception{
		return taskService.findTchCenterTask(t_id);
	}
	
	@RequestMapping("/searchTchTaskCenter")
	public @ResponseBody TaskTchCenterList searchTchTaskCenter(String t_id,String key)throws Exception{
		return taskService.getTchCenterTask(t_id,key);
	}
	
	@RequestMapping("/checkTchTodayTask")
	public @ResponseBody TaskTchList checkTchTodayTask(String t_id)throws Exception{
		return taskService.findTchTodayTask(t_id);
	}
	
	@RequestMapping("/searchTchTodayTask")
	public @ResponseBody TaskTchList searchTchTodayTask(String t_id,String key)throws Exception{
		return taskService.getTchTodayTask(t_id,key);
	}
	
	@RequestMapping("/checkStuTaskByTch")
	public @ResponseBody TaskTchCenterList checkStuTaskByTch(String t_id,String s_id)throws Exception{
		return taskService.findStuTaskByTch(t_id, s_id);
	}
	
	@RequestMapping("/checkTaskTodayResult")
	public @ResponseBody TaskResultTodayList checkTaskTodayResult(String task_id)throws Exception{
		return taskService.findTaskTodayList(task_id);
	}
	
	@RequestMapping("/checkTchBoard")
	public @ResponseBody TaskBoard checkTchBoard(String t_id,String last_time)throws Exception{
		return taskService.findBoardForTch(t_id, last_time);
	}
}
