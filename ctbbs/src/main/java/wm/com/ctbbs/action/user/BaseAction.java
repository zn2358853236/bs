package wm.com.ctbbs.action.user;

import wm.com.ctbbs.common.web.constant.SessionConstant;
import wm.com.ctbbs.common.web.struts.Struts2ActionSupport;
import wm.com.ctbbs.model.User;

/**
 * 
 * @描述: Web系统权限模块基础支撑Action.
 */
@SuppressWarnings("serial")
public class BaseAction extends Struts2ActionSupport implements UserActionAware {

	/**
	 * 取出当前登录用户对象
	 */
	@Override
	public User getLoginedUser() {
		User user = (User) this.getSessionMap().get(SessionConstant.USER_SESSION_KEY);
		return user;
	}

}
