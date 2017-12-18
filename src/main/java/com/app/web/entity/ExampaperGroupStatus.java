package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO(模拟考试状态)
 * @date 2017-12-18 15:15:31
 */
public class ExampaperGroupStatus implements Serializable {
	
	//
	private Long id;
	//状态
	private String contentStatus;
	//redis
	private String key;
	//
	private Date createDate;
	//
	private Integer progress;
	//
	private Integer wrong;
	//
	private Long userId;
	//
	private Integer costTime;
	//
	private Float accuracy;

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
	 * 设置：状态
	 */
	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}
	/**
	 * 获取：状态
	 */
	public String getContentStatus() {
		return contentStatus;
	}
	/**
	 * 设置：redis
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 获取：redis
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：
	 */
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	/**
	 * 获取：
	 */
	public Integer getProgress() {
		return progress;
	}
	/**
	 * 设置：
	 */
	public void setWrong(Integer wrong) {
		this.wrong = wrong;
	}
	/**
	 * 获取：
	 */
	public Integer getWrong() {
		return wrong;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setCostTime(Integer costTime) {
		this.costTime = costTime;
	}
	/**
	 * 获取：
	 */
	public Integer getCostTime() {
		return costTime;
	}
	/**
	 * 设置：
	 */
	public void setAccuracy(Float accuracy) {
		this.accuracy = accuracy;
	}
	/**
	 * 获取：
	 */
	public Float getAccuracy() {
		return accuracy;
	}

}
