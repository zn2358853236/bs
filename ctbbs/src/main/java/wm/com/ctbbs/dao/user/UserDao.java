package wm.com.ctbbs.dao.user;

import wm.com.ctbbs.common.dao.BaseDao;
import wm.com.ctbbs.model.User;

public interface UserDao extends BaseDao<User> {
	/**
	 * 根据用户登录名获取用户信息.
	 * 
	 * @param loginName
	 *            .
	 * @return user .
	 */
	User findByUserNo(String userNo);
	
	/**
	 * 根据用户激活码获取用户信息.
	 * 
	 * @param code
	 *            .
	 * @return user .
	 */
	User findByUserCode(String code);
}
