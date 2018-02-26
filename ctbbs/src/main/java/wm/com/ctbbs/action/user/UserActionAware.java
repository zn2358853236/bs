package wm.com.ctbbs.action.user;

import wm.com.ctbbs.model.User;


/*
 * 用户接口
 * */

public interface UserActionAware {

	/**
	 * 取得登录的用户
	 * 
	 * @return
	 */
	public User getLoginedUser();
}
