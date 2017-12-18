package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO(练习文章)
 * @date 2017-12-08 15:02:44
 */
public class Article implements Serializable {
	
	//
	private Long id;
	//标题
	private String title;
	//类型(0:备考指南,1:语法sc,2:逻辑CR，3:阅读RC,4:阅读RC)
	private String type;
	//内容
	private String content;
	//状态(0:下线 1:上线）
	private Integer status;
	//
	private Date createTime;
	//头图
	private String image;

	private int times;//阅读次数
	
	
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：类型(0:备考指南,1:语法sc,2:逻辑CR，3:阅读RC,4:阅读RC)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:备考指南,1:语法sc,2:逻辑CR，3:阅读RC,4:阅读RC)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：状态(0:下线 1:上线）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:下线 1:上线）
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：头图
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：头图
	 */
	public String getImage() {
		return image;
	}

}
