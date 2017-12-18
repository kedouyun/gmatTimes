package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 19:49:20
 */
public class GrammarTypes implements Serializable {
	
	//语法类型
	private Long id;
	//
	private String name;

	/**
	 * 设置：语法类型
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：语法类型
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
