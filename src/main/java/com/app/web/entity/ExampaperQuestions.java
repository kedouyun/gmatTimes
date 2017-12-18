package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO(考试组试题)
 * @date 2017-12-05 10:26:49
 */
public class ExampaperQuestions implements Serializable {
	
	//
	private Long id;
	//
	private Long exampaperGroupId;
	//
	private Long questionsId;

	private Questions questions;
	
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	//试卷组名称
     private String exampapeName;
     
     
	public String getExampapeName() {
		return exampapeName;
	}
	public void setExampapeName(String exampapeName) {
		this.exampapeName = exampapeName;
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
	 * 设置：
	 */
	public void setExampaperGroupId(Long exampaperGroupId) {
		this.exampaperGroupId = exampaperGroupId;
	}
	/**
	 * 获取：
	 */
	public Long getExampaperGroupId() {
		return exampaperGroupId;
	}
	/**
	 * 设置：
	 */
	public void setQuestionsId(Long questionsId) {
		this.questionsId = questionsId;
	}
	/**
	 * 获取：
	 */
	public Long getQuestionsId() {
		return questionsId;
	}

}
