package wm.com.ctbbs.model;

import java.util.Date;

import wm.com.ctbbs.common.entity.BaseEntity;

/*
 * 
 * 论坛用户类
 * 
 * */
public class User extends BaseEntity {
  /*对应属性*/
	private String userNo;//账号
	private String userPwd; //密码
	private String userName; // 姓名
	private Integer sex;//性别
	private String userWork;//职业
	private String workArea;//所属领域
	private String userLocation; //居住地
	private String userFace;//头像
	private String email;  //邮箱
	private Integer status; //状态 激活或冻结
	private String userType; // 用户类型，超级管理员由系统初始化时添加，不能删除
	private Date lastLoginTime;// 最后登录时间
	private Boolean isChangedPwd;// 是否更改过密码
	private Integer pwdErrorCount; // 连续输错密码次数（连续5次输错就冻结帐号）
	private Date pwdErrorTime; // 最后输错密码的时间
	private String remark; // 描述
	private Integer topicCount;// 发表的总主题数
	private Integer articleCount;// 发表的总文章数
	private String code; //激活码
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getUserWork() {
		return userWork;
	}

	public void setUserWork(String userWork) {
		this.userWork = userWork;
	}

	public String getWorkArea() {
		return workArea;
	}

	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public String getUserFace() {
		return userFace;
	}

	public void setUserFace(String userFace) {
		this.userFace = userFace;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Boolean getIsChangedPwd() {
		return isChangedPwd;
	}

	public void setIsChangedPwd(Boolean isChangedPwd) {
		this.isChangedPwd = isChangedPwd;
	}

	public Integer getPwdErrorCount() {
		return pwdErrorCount;
	}

	public void setPwdErrorCount(Integer pwdErrorCount) {
		this.pwdErrorCount = pwdErrorCount;
	}

	public Date getPwdErrorTime() {
		return pwdErrorTime;
	}

	public void setPwdErrorTime(Date pwdErrorTime) {
		this.pwdErrorTime = pwdErrorTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(Integer topicCount) {
		this.topicCount = topicCount;
	}

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
   
}
