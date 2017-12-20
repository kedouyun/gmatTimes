package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO(试卷组)
 * @date 2017-12-03 16:08:46
 */
public class ExampaperGroup implements Serializable {
	
	//
	private Long id;
	//试卷组名称
	private String name;
	//试卷组名称
	private String exampaperId;
	//状态//0下假   1: 上架
	private Integer status;
	//试卷组创建日期
	private Date createDate;
	//练习人数
	private Integer personTimes;
	//平均得分
	private Float avgAccuracy;
	
	private Integer sort;//排序
	
	
	//vo 试卷名
	private String exampaperName;
	
	private Integer questionsCounNum;//试题数
	
private Integer limitTime;//限制时间踢动提交
	
	
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(Integer limitTime) {
		this.limitTime = limitTime;
	}
	public Integer getQuestionsCounNum() {
		return questionsCounNum;
	}
	public void setQuestionsCounNum(Integer questionsCounNum) {
		this.questionsCounNum = questionsCounNum;
	}
	public String getExampaperName() {
		return exampaperName;
	}
	public void setExampaperName(String exampaperName) {
		this.exampaperName = exampaperName;
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
	 * 设置：试卷组名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：试卷组名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：试卷组名称
	 */
	public void setExampaperId(String exampaperId) {
		this.exampaperId = exampaperId;
	}
	/**
	 * 获取：试卷组名称
	 */
	public String getExampaperId() {
		return exampaperId;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：练习人数
	 */
	public void setPersonTimes(Integer personTimes) {
		this.personTimes = personTimes;
	}
	/**
	 * 获取：练习人数
	 */
	public Integer getPersonTimes() {
		return personTimes;
	}
	public Float getAvgAccuracy() {
		return avgAccuracy;
	}
	public void setAvgAccuracy(Float avgAccuracy) {
		this.avgAccuracy = avgAccuracy;
	}


}
