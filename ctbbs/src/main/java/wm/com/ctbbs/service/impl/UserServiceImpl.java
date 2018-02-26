package wm.com.ctbbs.service.impl;

import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wm.com.ctbbs.common.page.PageBean;
import wm.com.ctbbs.common.page.PageParam;
import wm.com.ctbbs.dao.user.UserDao;
import wm.com.ctbbs.model.User;
import wm.com.ctbbs.service.UserService;
import wm.com.ctbbs.utils.SendEmail;

/*
 * 用户服务层接口
 * 
 * */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

		@Autowired
		private UserDao userDao;
		
		/**
		 * 保存用户信息.
		 * @param pmsUser
		 */
		public void create(User user) {
			userDao.insert(user);
			this.postMail(user);
		}
		
		/**
		 * 根据ID获取用户信息.
		 * @param userId
		 * @return
		 */
		public User getById(Long userId) {
			return userDao.getById(userId);
		}
		
		/**
		 * 根据激活码获得用户
		 */
		public User findUserByCode(String code) {
			return userDao.findByUserCode(code);
		}


		/**
		 * 根据登录名取得用户对象
		 */
		public User findUserByUserNo(String userNo) {
			return userDao.findByUserNo(userNo);
		}

		/**
		 * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
		 * 
		 * @param id
		 *            用户ID.
		 */
		public void deleteUserById(long userId) {
			User user = userDao.getById(userId);
			if (user != null) {
				if ("1".equals(user.getUserType())) {
					throw new RuntimeException("【" + user.getUserNo() + "】为超级管理员，不能删除！");
				}
				userDao.deleteById(user.getId());
			}
		}

		
		/**
		 * 更新用户信息.
		 * @param user
		 */
		public void update(User user) {
			userDao.update(user);
		}
		
		/**
		 * 根据用户ID更新用户密码.
		 * 
		 * @param userId
		 * @param newPwd
		 *            (已进行SHA1加密)
		 */
		public void updateUserPwd(Long userId, String newPwd, boolean isTrue) {
		    User pmsUser = userDao.getById(userId);
			pmsUser.setUserPwd(newPwd);
			pmsUser.setPwdErrorCount(0); // 密码错误次数重置为0
			pmsUser.setIsChangedPwd(isTrue); // 设置密码为已修改过
			userDao.update(pmsUser);
		}



		/**
		 * 查询并分页列出用户信息.
		 * @param pageParam
		 * @param paramMap
		 * @return
		 */
		public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
			return userDao.listPage(pageParam, paramMap);
		}

		/*
		 * 发送激活邮件
		 * param:user
		 * 
		 * */
		protected void postMail(User user){
			String email=user.getEmail();
			 ///邮件的内容
	        StringBuffer sb=new StringBuffer("点击下面链接激活账号，24小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
	        sb.append("<a href=\"http://localhost:8080/ctbbs/reg_active.action?email=");
	        sb.append(email); 
	        sb.append("&validateCode="); 
	        sb.append(user.getCode());
	        sb.append("\">http://www.87ctbbs.com/user/active.jhtml？code="); 
	        sb.append(DigestUtils.sha1Hex(email));
	        sb.append("</a>");
	        //发送邮件
	        SendEmail.send(email, sb.toString());
		}

	
}
