package wm.com.ctbbs.dao.upload;

import wm.com.ctbbs.common.dao.BaseDao;
import wm.com.ctbbs.model.UploadFile;
import wm.com.ctbbs.model.User;

public interface UploadDao extends BaseDao<UploadFile> {
	/**
	 * 根据用户登录名获取用户信息.
	 * 
	 * @param fileName
	 *            .
	 * @return UploadFile .
	 */
	UploadFile findByFileName(String fileName);
}
