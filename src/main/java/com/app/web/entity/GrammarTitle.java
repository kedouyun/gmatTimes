package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 20:06:36
 */
public class GrammarTitle implements Serializable {
	
	//语法详情标题
	private Long id;
	//
	private String name;
	private String grammarTypesId;
	
	private String grammarTypesName;
	
	private String gmGrammarTitle;
	
	
	public String getGmGrammarTitle() {
		return gmGrammarTitle;
	}
	public void setGmGrammarTitle(String gmGrammarTitle) {
		this.gmGrammarTitle = gmGrammarTitle;
	}
	public String getGrammarTypesName() {
		return grammarTypesName;
	}
	public void setGrammarTypesName(String grammarTypesName) {
		this.grammarTypesName = grammarTypesName;
	}
	public String getGrammarTypesId() {
		return grammarTypesId;
	}
	public void setGrammarTypesId(String grammarTypesId) {
		this.grammarTypesId = grammarTypesId;
	}
	/**
	 * 设置：语法详情标题
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：语法详情标题
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}

}
