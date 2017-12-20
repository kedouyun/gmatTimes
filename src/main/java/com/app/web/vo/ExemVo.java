package com.app.web.vo;

public class ExemVo {
	
	private String answer;//正确答案
	private String userAnswer;//用户答案
	private Boolean status;//是否正确
	
	private Integer overTime;//单提 考试花费时间
	
	private Integer overExem;//1 考试结束
	
	private Integer score;//单题分值
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getOverExem() {
		return overExem;
	}

	public void setOverExem(Integer overExem) {
		this.overExem = overExem;
	}

	public Integer getOverTime() {
		return overTime;
	}

	public void setOverTime(Integer overTime) {
		this.overTime = overTime;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
}
