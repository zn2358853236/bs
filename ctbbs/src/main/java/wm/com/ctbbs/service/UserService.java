package wm.com.ctbbs.service;

import java.util.Map;

import wm.com.ctbbs.common.page.PageBean;
import wm.com.ctbbs.common.page.PageParam;
import wm.com.ctbbs.model.User;

public interface UserService {
	/**
	 * 保存用户信息.
	 * @param pmsUser
	 */
	public void create(User user);
	
	/**
	 * 根据ID获取用户信息.
	 * @param userId
	 * @return
	 */
	public User getById(Long userId);
	/**
	 * 根据登录名取得用户对象
	 */
	public User findUserByUserNo(String userNo);
	/**
	 * 根据激活码获得用户
	 */
	public User findUserByCode(String code);
	/**
	 * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
	 * 
	 * @param id
	 *            用户ID.
	 */
	public void deleteUserById(long userId);

	
	/**
	 * 更新用户信息.
	 * @param user
	 */
	public void update(User user);
	/**
	 * 根据用户ID更新用户密码.
	 * 
	 * @param userId
	 * @param newPwd
	 *            (已进行SHA1加密)
	 */
	public void updateUserPwd(Long userId, String newPwd, boolean isTrue);


	/**
	 * 查询并分页列出用户信息.
	 * @param pageParam
	 * @param paramMap
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
	
}
