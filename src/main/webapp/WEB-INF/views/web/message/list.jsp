<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<%@ include file="../../common/head.jsp"%>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<c:forEach items="${pageInfo.list}" var="page"> 
		  		<li> 
		  			<c:if test="${page.status==0 }">有人评论了你</c:if>
		  			<c:if test="${page.status==1 }">有人给你点赞了</c:if>
		  			<c:if test="${page.status==0 }">
		  				<span>${page.username}回复：${page.commentContent }</span>
		  			</c:if>
		  			<a href="${baseurl}/comment/gmat/${page.forKeyId}">查看详情</a>
		  		</li>
		  	</c:forEach>
		  	<div>
				<m:pageInfo name="pageInfo" />
			</div>
		</div>
	</div>
</div>
</body>
</html>