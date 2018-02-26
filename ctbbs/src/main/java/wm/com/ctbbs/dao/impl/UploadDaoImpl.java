package wm.com.ctbbs.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import wm.com.ctbbs.common.dao.BaseDaoImpl;
import wm.com.ctbbs.common.page.PageBean;
import wm.com.ctbbs.common.page.PageParam;
import wm.com.ctbbs.dao.upload.UploadDao;
import wm.com.ctbbs.model.UploadFile;
import wm.com.ctbbs.model.User;

@Repository("uploadDao")
public class UploadDaoImpl extends BaseDaoImpl<UploadFile> implements UploadDao{

	@Override
	public UploadFile findByFileName(String fileName) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne(getStatement("findFileByFileName"), fileName);
	}

	
}
