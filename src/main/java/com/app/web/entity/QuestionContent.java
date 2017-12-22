package com.app.web.entity;

import java.util.LinkedHashMap;


public class QuestionContent {

	private String title;
	private String readingQuestion;//阅读理解 问题
	private String titleImg = "";
	private LinkedHashMap<String, String> choiceList;
	private LinkedHashMap<String, String> choiceImgList;

	public String getReadingQuestion() {
		return readingQuestion;
	}

	public void setReadingQuestion(String readingQuestion) {
		this.readingQuestion = readingQuestion;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public LinkedHashMap<String, String> getChoiceList() {
		return choiceList;
	}

	public void setChoiceList(LinkedHashMap<String, String> choiceList) {
		this.choiceList = choiceList;
	}

	public LinkedHashMap<String, String> getChoiceImgList() {
		return choiceImgList;
	}

	public void setChoiceImgList(LinkedHashMap<String, String> choiceImgList) {
		this.choiceImgList = choiceImgList;
	}

}
