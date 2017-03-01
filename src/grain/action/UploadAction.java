package grain.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import grain.dto.MsgUrl;
import grain.service.UserService;


@Controller
public class UploadAction {
    
    @Autowired
    private UserService userService;
    /**
     * 上传单个文件
     * @param file 上传文件 MultipartFile 的对象
     */
   /* @RequestMapping(value = "/uploadHeadPic", method = RequestMethod.POST)
    public @ResponseBody MsgUrl uploadHeadPic(@RequestParam("file") MultipartFile file) {
    	int method=1;
        return userService.saveFile(method,file);
    }*/
    
    /*@RequestMapping("/uploadfile")  
    public @ResponseBody String uploadPhone(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request) 
    		throws IllegalStateException, IOException{  
              String path=uploadFile(file, request);   
              return path;  
    }
    private String  uploadFile(MultipartFile file,HttpServletRequest request)  
    throws IOException {  
    	String path=request.getSession().getServletContext().getRealPath("pic");  
    	String fileName=file.getOriginalFilename();  
    	File targetFile=new File(path,fileName);  
    	if(!targetFile.exists()){  
    		targetFile.mkdirs();  
    	}  
    	file.transferTo(targetFile);  
    	//request.setAttribute("filePath",targetFile.getAbsolutePath());  
    	return targetFile.getAbsolutePath();  
	}  */
}