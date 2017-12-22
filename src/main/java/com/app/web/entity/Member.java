package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO(前端用户)
 * @date 2017-11-19 21:25:29
 */
public class Member implements Serializable {
	
	//
	private Long id;
	//昵称
	private String username;
	//密码
	private String password;
	//邮箱
	private String email;
	//手机号
	private String phone;
	//状态 0:禁用，1:正常
	private Integer status;
	private Integer sex;//性别  0 :男   1:女
	private String headImage;//头像
	//创建时间
	private Date createDate;
	//
	private Date updateDate;
	//考试日期
	private Date examDate;
	private Integer practiceTotal;//做题总数
	private Integer practiceDay;//累计练习天数
	private Date lastPracticeDate;//最后练习日期
	
	//考试目标
	private String examTarget;

	
	public Date getLastPracticeDate() {
		return lastPracticeDate;
	}
	public void setLastPracticeDate(Date lastPracticeDate) {
		this.lastPracticeDate = lastPracticeDate;
	}
	public Integer getPracticeTotal() {
		return practiceTotal;
	}
	public void setPracticeTotal(Integer practiceTotal) {
		this.practiceTotal = practiceTotal;
	}
	public Integer getPracticeDay() {
		return practiceDay;
	}
	public void setPracticeDay(Integer practiceDay) {
		this.practiceDay = practiceDay;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public String getExamTarget() {
		return examTarget;
	}
	public void setExamTarget(String examTarget) {
		this.examTarget = examTarget;
	}
	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 设置：状态 0:禁用，1:正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0:禁用，1:正常
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

}
