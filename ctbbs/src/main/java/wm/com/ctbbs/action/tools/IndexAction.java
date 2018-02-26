package wm.com.ctbbs.action.tools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import wm.com.ctbbs.action.user.BaseAction;
import wm.com.ctbbs.model.User;

@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends BaseAction{
    /*
     * 
     * 进入首页
     * */
	public String  homePage(){
		return "home";
	}

}
