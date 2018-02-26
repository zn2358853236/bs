package wm.com.ctbbs.action.user;

import wm.com.ctbbs.model.User;


/*
 * 用户接口
 * */

public interface UserLoginedAware {

	/**
	 * 取得登录的用户
	 * 
	 * @return
	 */
	public User getLoginedUser();
}
