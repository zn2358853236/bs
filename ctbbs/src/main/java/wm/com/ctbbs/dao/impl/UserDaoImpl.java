package wm.com.ctbbs.dao.impl;

import org.springframework.stereotype.Repository;

import wm.com.ctbbs.common.dao.BaseDaoImpl;
import wm.com.ctbbs.dao.user.UserDao;
import wm.com.ctbbs.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
   
	@Override
	public User findByUserNo(String userNo) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne(getStatement("findByUserNo"), userNo);
	}

	@Override
	public User findByUserCode(String code) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne(getStatement("findByUserCode"), code);
	}

}
