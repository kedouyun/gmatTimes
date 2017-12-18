package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO(字典类型)
 * @date 2017-12-08 14:26:23
 */
public class SysDictionary implements Serializable {
	
	//
	private Integer id;
	//名称
	private String name;
	//字典码
	private String code;
	//字典类型
	private Integer dictionaryTypeId;

	private String typeName;//临时
	
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：字典类型
	 */
	public void setDictionaryTypeId(Integer dictionaryTypeId) {
		this.dictionaryTypeId = dictionaryTypeId;
	}
	/**
	 * 获取：字典类型
	 */
	public Integer getDictionaryTypeId() {
		return dictionaryTypeId;
	}

}
