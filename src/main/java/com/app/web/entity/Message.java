package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO(消息表)
 * @date 2017-12-20 17:33:10
 */
public class Message implements Serializable {
	
	//
	private Long id;
	//创建时间
	private Date createTime;
	//发送人id
	private Long fromMemberId;
	//接收人
	private Long toMemberId;
	//状态，0评论，1点赞
	private Integer status;
	//具体消息类型的实体id
	private Long forKey;
	//具体消息类型的实体id的模块id
	private Long forKeyId;
	//类型  0试题  1bbs
	private Integer type;
	//0未读  1已读
	private Integer isread;

	private String username;//用户名 vo
	private String commentContent;//评论内容  vo
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Long getForKeyId() {
		return forKeyId;
	}
	public void setForKeyId(Long forKeyId) {
		this.forKeyId = forKeyId;
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
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：发送人id
	 */
	public void setFromMemberId(Long fromMemberId) {
		this.fromMemberId = fromMemberId;
	}
	/**
	 * 获取：发送人id
	 */
	public Long getFromMemberId() {
		return fromMemberId;
	}
	/**
	 * 设置：接收人
	 */
	public void setToMemberId(Long toMemberId) {
		this.toMemberId = toMemberId;
	}
	/**
	 * 获取：接收人
	 */
	public Long getToMemberId() {
		return toMemberId;
	}
	/**
	 * 设置：状态，0评论，1点赞
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态，0评论，1点赞
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setForKey(Long forKey) {
		this.forKey = forKey;
	}
	/**
	 * 获取：
	 */
	public Long getForKey() {
		return forKey;
	}
	/**
	 * 设置：类型  0试题  1bbs
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型  0试题  1bbs
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：0未读  1已读
	 */
	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	/**
	 * 获取：0未读  1已读
	 */
	public Integer getIsread() {
		return isread;
	}

}
