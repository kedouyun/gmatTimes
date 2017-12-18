package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 20:06:36
 */
public class Questions implements Serializable {
	
	//试卷问题
	private Long id;
	//
	private String content;
	private String name;
	//试题可见性
	private Integer isVisible;
	//
	private Long grammaticalGroupId;
	//
	private Date createTime;
	//
	private String answer;
	//
	private String analysis;
	
	private String creator; //创建人

	private int questionType;//1  单选题  2  阅读理解     3 多选   4判断题   5  填空题
	
	private Integer score; //分值
	//临时字段
	private String groupName;
	
	private String grammarTitleName;//临时字段
	private String grammarTypesName;//临时字段
	
	private Long exampaperQuestionsId;// 所属组id  组合vo
	
	
	public Long getExampaperQuestionsId() {
		return exampaperQuestionsId;
	}
	public void setExampaperQuestionsId(Long exampaperQuestionsId) {
		this.exampaperQuestionsId = exampaperQuestionsId;
	}
	public String getGrammarTypesName() {
		return grammarTypesName;
	}
	public void setGrammarTypesName(String grammarTypesName) {
		this.grammarTypesName = grammarTypesName;
	}
	public String getGrammarTitleName() {
		return grammarTitleName;
	}
	public void setGrammarTitleName(String grammarTitleName) {
		this.grammarTitleName = grammarTitleName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public int getQuestionType() {
		return questionType;
	}
	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 设置：试卷问题
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：试卷问题
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：试题可见性
	 */
	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}
	/**
	 * 获取：试题可见性
	 */
	public Integer getIsVisible() {
		return isVisible;
	}
	/**
	 * 设置：
	 */
	public void setGrammaticalGroupId(Long grammaticalGroupId) {
		this.grammaticalGroupId = grammaticalGroupId;
	}
	/**
	 * 获取：
	 */
	public Long getGrammaticalGroupId() {
		return grammaticalGroupId;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 获取：
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * 设置：
	 */
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	/**
	 * 获取：
	 */
	public String getAnalysis() {
		return analysis;
	}

}
