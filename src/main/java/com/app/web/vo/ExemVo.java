package com.app.web.vo;

public class ExemVo {
	
	private String answer;
	private String userAnswer;
	private Boolean status;
	
	private Integer overTime;
	
	private Integer overExem;//1 考试结束
	
	
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
