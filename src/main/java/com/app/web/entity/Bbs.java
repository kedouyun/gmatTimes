package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liangliang
 * @Description: TODO(题库评论表)
 * @date 2017-12-07 16:05:14
 */
public class Bbs implements Serializable {
	
	//
	private Long id;
	//评论者
	private Long memberId;
	//回复人
	private Long toMemberId;
	//评论内容
	private String content;
	//状态（0:删除,1:在线）
	private Integer status;
	//点赞数
	private Integer faver;
	//所属试题
	private Long questionId;
	//上级id
	private Long parentId;
	//
	private Date createDate;

	private List<Bbs> commentList;//子评论
	
	private String memberName;//vo 用户名
	private String headImage;//vo 头像
	private Integer isFavor;//vo 是否点赞  0 未点  1 已点赞
	
	public Integer getIsFavor() {
		return isFavor;
	}
	public void setIsFavor(Integer isFavor) {
		this.isFavor = isFavor;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public List<Bbs> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Bbs> commentList) {
		this.commentList = commentList;
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
	 * 设置：评论者
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：评论者
	 */
	public Long getMemberId() {
		return memberId;
	}
	/**
	 * 设置：回复人
	 */
	public void setToMemberId(Long toMemberId) {
		this.toMemberId = toMemberId;
	}
	/**
	 * 获取：回复人
	 */
	public Long getToMemberId() {
		return toMemberId;
	}
	/**
	 * 设置：评论内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：评论内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：状态（0:删除,1:在线）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态（0:删除,1:在线）
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：点赞数
	 */
	public void setFaver(Integer faver) {
		this.faver = faver;
	}
	/**
	 * 获取：点赞数
	 */
	public Integer getFaver() {
		return faver;
	}
	/**
	 * 设置：所属试题
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	/**
	 * 获取：所属试题
	 */
	public Long getQuestionId() {
		return questionId;
	}
	/**
	 * 设置：上级id
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级id
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
	}

}
