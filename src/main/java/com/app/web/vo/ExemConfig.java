package com.app.web.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExemConfig {
	private List<Long> questionIds;
	
	private Map<Long,ExemVo> answer=new HashMap<>();//用户操作集合  key：试题id  value:ExemVo

	private Integer progress=0;//当前进度
	//
	private Integer wrong=0;//错误数
	private Integer right=0;//正确数
	
	private Integer minute=0;//考试花费分钟
	private Integer second=0;//考试花费秒
	
	private String showAnswer;//是否显示答案 目前用于练习   1:是要显示答案
	private Integer limitTime;//（秒） 考试 时间限制，到时间提交试卷
	
	public Integer getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Integer limitTime) {
		this.limitTime = limitTime;
	}

	public Integer getRight() {
		return right;
	}

	public void setRight(Integer right) {
		this.right = right;
	}

	public String getShowAnswer() {
		return showAnswer;
	}

	public void setShowAnswer(String showAnswer) {
		this.showAnswer = showAnswer;
	}

	public Integer getMinute() {
		return minute;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	public Integer getSecond() {
		return second;
	}

	public void setSecond(Integer second) {
		this.second = second;
	}
	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public Integer getWrong() {
		return wrong;
	}

	public void setWrong(Integer wrong) {
		this.wrong = wrong;
	}

	public List<Long> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<Long> questionIds) {
		this.questionIds = questionIds;
	}

	public Map<Long, ExemVo> getAnswer() {
		return answer;
	}

	public void setAnswer(Map<Long, ExemVo> answer) {
		this.answer = answer;
	}



	
	
	
}
