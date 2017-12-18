package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 20:06:36
 */
public class GrammarGroup implements Serializable {
	
	//语法题分组
	private Long id;
	//
	private Long grammarTitleId;
	private Long grammarTypesId;
	private String name;
	private String grammarTitleName;
	private String grammarTypesName;
	private Integer status;//0下假   1: 上架
	private Integer questionsCounNum;//题库数
	
	private Integer personTimes;//练习次数
	private Float avgAccuracy;//平均正确率
	private String useTime;//建议花费时间
	
	private Integer wrong;//vo     错题数
	private Integer progress;//vo  当前进度
	
	private GrammarGroupStatus grammarGroupStatus;
	
	public GrammarGroupStatus getGrammarGroupStatus() {
		return grammarGroupStatus;
	}
	public void setGrammarGroupStatus(GrammarGroupStatus grammarGroupStatus) {
		this.grammarGroupStatus = grammarGroupStatus;
	}
	public Float getAvgAccuracy() {
		return avgAccuracy;
	}
	public void setAvgAccuracy(Float avgAccuracy) {
		this.avgAccuracy = avgAccuracy;
	}
	public Integer getWrong() {
		return wrong;
	}
	public void setWrong(Integer wrong) {
		this.wrong = wrong;
	}
	public Integer getProgress() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public Integer getPersonTimes() {
		return personTimes;
	}
	public void setPersonTimes(Integer personTimes) {
		this.personTimes = personTimes;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getQuestionsCounNum() {
		return questionsCounNum;
	}
	public void setQuestionsCounNum(Integer questionsCounNum) {
		this.questionsCounNum = questionsCounNum;
	}
	public String getGrammarTypesName() {
		return grammarTypesName;
	}
	public void setGrammarTypesName(String grammarTypesName) {
		this.grammarTypesName = grammarTypesName;
	}
	public Long getGrammarTypesId() {
		return grammarTypesId;
	}
	public void setGrammarTypesId(Long grammarTypesId) {
		this.grammarTypesId = grammarTypesId;
	}
	public String getGrammarTitleName() {
		return grammarTitleName;
	}
	public void setGrammarTitleName(String grammarTitleName) {
		this.grammarTitleName = grammarTitleName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 设置：语法题分组
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：语法题分组
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setGrammarTitleId(Long grammarTitleId) {
		this.grammarTitleId = grammarTitleId;
	}
	/**
	 * 获取：
	 */
	public Long getGrammarTitleId() {
		return grammarTitleId;
	}

}
