package wm.com.ctbbs.service;

import java.util.Map;

import wm.com.ctbbs.common.page.PageBean;
import wm.com.ctbbs.common.page.PageParam;
import wm.com.ctbbs.model.UploadFile;;

public interface UploadService {
	/**
	 * 保存文件信息.
	 * @param uploadFile
	 */
	public void create(UploadFile uploadFile);
	
	/**
	 * 根据ID获取文件信息.
	 * @param fileId
	 * @return
	 */
	public UploadFile getById(Long fileId);
	/**
	 * 根据文件名取得文件对象
	 */
	public UploadFile findFileByFileName(String fileName);
	
	/**
	 * 根据ID删除一个文件，同时删除与该文件关联的角色关联信息.
	 * 
	 * @param id
	 *            用户ID.
	 */
	public void deleteFileById(long fileId);

	
	/**
	 * 更新用户信息.
	 * @param user
	 */
	public void update(UploadFile uploadFile);


	/**
	 * 查询并分页列出用户信息.
	 * @param pageParam
	 * @param paramMap
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
}
