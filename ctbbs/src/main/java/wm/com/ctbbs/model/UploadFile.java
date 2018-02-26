package wm.com.ctbbs.model;

import java.util.Date;

import wm.com.ctbbs.common.entity.BaseEntity;

public class UploadFile extends BaseEntity {
	
	private String path;//存储路径
	private String fileName; //文件名
	private Integer fileSize; // 文件大小
	private String fileSort; //文件类型
	private Long uploadUser; //上传人
	private Long attchActicle; //关联文章
	private Integer downloadCount;// 被下载次数
	private String description; //文件描述
	
	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileSort() {
		return fileSort;
	}
	public void setFileSort(String fileSort) {
		this.fileSort = fileSort;
	}
	public Long getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(Long uploadUser) {
		this.uploadUser = uploadUser;
	}
	public Long getAttchActicle() {
		return attchActicle;
	}
	public void setAttchActicle(Long attchActicle) {
		this.attchActicle = attchActicle;
	}
	public Integer getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(Integer downloadCount) {
		this.downloadCount = downloadCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
