package com.app.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliang
 * @Description: TODO(评论表点赞记录)
 * @date 2017-12-07 16:05:13
 */
public class BbsFaver implements Serializable {
	
	//
	private Long memberId;
	//
	private Long commentId;

	/**
	 * 设置：
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：
	 */
	public Long getMemberId() {
		return memberId;
	}
	/**
	 * 设置：
	 */
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	/**
	 * 获取：
	 */
	public Long getCommentId() {
		return commentId;
	}

}
