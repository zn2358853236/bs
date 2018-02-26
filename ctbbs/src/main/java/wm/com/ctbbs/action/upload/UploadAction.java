package wm.com.ctbbs.action.upload;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import wm.com.ctbbs.action.user.BaseAction;
import wm.com.ctbbs.service.UploadService;
import wm.com.ctbbs.service.UserService;
/*
 * 文件上传处理接口
 * 
 * */
@Controller("uploadAction")
@Scope("prototype")
public class UploadAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(UploadAction.class);
	
	//文件上传参数
	private File uploadify;  
    private String uploadifyFileName ;  
    private String uploadifyContentType ; 
    
    /*文件上传下载*/
	@Autowired
	UploadService uploadService;
	
	
	/*
	 * 上传文件处理
	 * */
	public  String upLoad(){
		
		String realpath = ServletActionContext.getServletContext().getRealPath("/uploadFile");
        //D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
        System.out.println("realpath: "+realpath);
        if (uploadify != null) {
            File savefile = new File(new File(realpath), uploadifyFileName);
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            try {
				FileUtils.copyFile(uploadify, savefile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            ActionContext.getContext().put("message", "文件上传成功");
        }
        return "success";
		
	}

	public File getUploadify() {
		return uploadify;
	}

	public void setUploadify(File uploadify) {
		this.uploadify = uploadify;
	}

	public String getUploadifyFileName() {
		return uploadifyFileName;
	}

	public void setUploadifyFileName(String uploadifyFileName) {
		this.uploadifyFileName = uploadifyFileName;
	}

	public String getUploadifyContentType() {
		return uploadifyContentType;
	}

	public void setUploadifyContentType(String uploadifyContentType) {
		this.uploadifyContentType = uploadifyContentType;
	}

	
	
	
	
	
	
	
}
