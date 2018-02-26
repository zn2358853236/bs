package wm.com.ctbbs.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wm.com.ctbbs.common.page.PageBean;
import wm.com.ctbbs.common.page.PageParam;
import wm.com.ctbbs.dao.upload.UploadDao;
import wm.com.ctbbs.model.UploadFile;
import wm.com.ctbbs.service.UploadService;

/*
 * 文件服务层接口
 * 
 * */
@Service("uploadService")
@Transactional
public class UploadServiceImpl implements UploadService{
	
	@Autowired
	private UploadDao uploadDao;
	
	
	/*
	 * 保存文件信息
	 * */
	@Override
	public void create(UploadFile uploadFile) {
		// 增加
		uploadDao.insert(uploadFile);
	}

	/*
	 * 根据id查询文件信息
	 * */
	@Override
	public UploadFile getById(Long fileId) {
		// TODO Auto-generated method stub
		return uploadDao.getById(fileId);
	}
    
	/*
	 * 根据文件名查找文件信息
	 * */
	@Override
	public UploadFile findFileByFileName(String fileName) {
		// TODO Auto-generated method stub
		return uploadDao.findByFileName(fileName);
	}
    
	/*
	 * 根据文件id删除文件信息
	 * */
	@Override
	public void deleteFileById(long fileId) {
		// TODO Auto-generated method stub
		uploadDao.deleteById(fileId);
	}

	/*
	 * 更新文件信息
	 * */
	@Override
	public void update(UploadFile uploadFile) {
		// 
		uploadDao.update(uploadFile);
	}

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		//
		return uploadDao.listPage(pageParam, paramMap);
	}

}
