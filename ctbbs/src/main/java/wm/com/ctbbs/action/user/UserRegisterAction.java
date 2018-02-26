package wm.com.ctbbs.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import wm.com.ctbbs.common.web.constant.SessionConstant;
import wm.com.ctbbs.enums.UserStatusEnum;
import wm.com.ctbbs.enums.UserTypeEnum;
import wm.com.ctbbs.model.User;
import wm.com.ctbbs.service.UserService;


/*
 * UserAction
 * */
@Controller("userRegisterAction")
@Scope("prototype")
public class UserRegisterAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(UserRegisterAction.class);
	
	@Autowired
	UserService userService;
	
	/**
	 * 进入注册页面.
	 * 
	 * @return
	 */
	public String registerPage() {
		return "register";
	}

	
	/*
	 * 用户注册
	 * */
	public String register(){
		
		try{
	        //获取验证码
			String checkcode=this.getString("checkcode");
			
			//判断验证码是否正确
			String exitCode=(String) this.getSessionMap().get("checkcode");
			if(StringUtils.isNotEmpty(checkcode)){
			   if(!exitCode.equalsIgnoreCase(checkcode)){
				this.getHttpRequest().setAttribute("msg","验证码错误！！");
				return INPUT;
			   }
			}else{
				this.getHttpRequest().setAttribute("msg","验证码不能为空！！");
				return INPUT;
			}
			
			//从表单获取用户信息
			String userNo=this.getString("userNo");
			String userPwd=this.getString("userPwd");
			String email=this.getString("email");
			String userName=this.getString("userName");
			String sex=this.getString("sex");
			String userWork=this.getString("userWork");
			String workArea=this.getString("workArea");
			String province=this.getString("province");
			String city=this.getString("city");
			String remark=this.getString("remark");
			//组装用户信息
			User  user=new User();
			user.setUserNo(userNo);
			user.setUserName(userName);
			//对密码进行加密处理
			user.setUserPwd(DigestUtils.sha1Hex(userPwd));
			user.setEmail(email);
			if(StringUtils.isNotEmpty(sex)){
				user.setSex(sex=="男"?1:0);
			}else{
				user.setSex(null);
			}
			user.setUserWork(StringUtils.isNotEmpty(userWork)?userWork:null);
			user.setWorkArea(StringUtils.isNotEmpty(workArea)?workArea:null);
			if(!province.equals("请选择")&&province!=null){
				user.setUserLocation(province+"-"+city);
			}else{
				user.setUserLocation(null);
			}
			user.setRemark(StringUtils.isNotEmpty(remark)?remark:null);
			user.setUserType(UserTypeEnum.SUB_USER.getDesc());
			user.setStatus(UserStatusEnum.INACTIVE.getValue());
			user.setIsChangedPwd(false);
			user.setLastLoginTime(null);
			user.setPwdErrorTime(null);
			user.setCode(DigestUtils.sha1Hex(userNo));
			user.setUserFace("/image/headImage/head.png");
            userService.create(user);
            this.getHttpRequest().setAttribute("msg","注册成功，请到邮箱激活！！");
			return "registerSuccess";
		
		}catch(Exception e){
			log.error("=== UserRegisterAction Exception:",e);
			this.getHttpRequest().setAttribute("msg","注册失败！！");
			return INPUT;
		}
		
	}
	
	/*
	 * ajax验证用户名
	 * */	
	 public String validateUserName() throws IOException{
		 
	     User existUser=userService.findUserByUserNo(this.getString("username"));
	     if(existUser!=null){
	    	this.write("<font>用户名已存在！</font>"); 
	     }else{
	    	this.write("<font>用户名可以使用！</font>");
	     }
	     return NONE;
	 }
	 
	
	/**
	 * 前台:激活用户的方法:
	 */
	public String active(){
		// 根据激活码查询用户
		String code=this.getString("validateCode");
		User existUser = userService.findUserByCode(code);
		if(existUser != null){
			Date validtime=existUser.getCreateTime(); //取时间 
			Calendar  calendar = new GregorianCalendar(); 
			calendar.setTime(validtime); 
			calendar.add(calendar.DATE,1); //把日期往后增加一天,整数  往后推,负数往前移动 
			validtime=calendar.getTime(); //这个时间就是日期往后推一天的结果 
			Date now=new Date();
			//时间在两天内
			if(now.before(validtime)){
				// 根据激活码查询到这个用户.
				existUser.setStatus(UserStatusEnum.ACTIVE.getValue());
				// 修改用户的状态
				userService.update(existUser);
				// 添加信息:
				this.getHttpRequest().setAttribute("msg","激活成功!请去登录!");
				return "activeSuccess";
			}else{
				this.getHttpRequest().setAttribute("msg","激活码已失效！");
				return "codeless";
			}
		}
		return INPUT;
	}
	

	
	
}
