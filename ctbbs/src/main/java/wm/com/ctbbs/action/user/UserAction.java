package wm.com.ctbbs.action.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import wm.com.ctbbs.model.User;
import wm.com.ctbbs.service.UserService;

/*
 * 用户相关信息 user_info
 * */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction {
   
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(UserAction.class);
	
	@Autowired
	private UserService userService;
	
	//打开个人中心
	public String info(){
		User user=this.getLoginedUser();
		return "information";
	}
	
	public String upload(){
		return "load";
	}
}
