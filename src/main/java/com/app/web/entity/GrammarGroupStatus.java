package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 20:06:36
 */
public class GrammarGroupStatus implements Serializable {
	
	//语法题分组用户个性状态
	private Long id;
	//
	private Integer progress;
	//
	private Integer wrong;
	//
	private Long grammarGroupId;
	//
	private Long userId;
	private Integer costTime;//花费时间
	
	private Float accuracy;//正确率
	
	private String contentStatus;//状态
	
	private String cacheKey;//状态
	
	
	
	public String getCacheKey() {
		return cacheKey;
	}
	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}
	public String getContentStatus() {
		return contentStatus;
	}
	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}
	public Float getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Float accuracy) {
		this.accuracy = accuracy;
	}
	public Integer getCostTime() {
		return costTime;
	}
	public void setCostTime(Integer costTime) {
		this.costTime = costTime;
	}
	/**
	 * 设置：语法题分组用户个性状态
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：语法题分组用户个性状态
	 */
	public Long getId() {
		return id;
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
	public void setGrammarGroupId(Long grammarGroupId) {
		this.grammarGroupId = grammarGroupId;
	}
	/**
	 * 获取：
	 */
	public Long getGrammarGroupId() {
		return grammarGroupId;
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

}
