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
			<div class="container">
					<div class="row clearfix" style="margin-top: 3%;">
						<div class="col-md-10 column">
							<c:forEach items="${typelist}" var="type">
								<a class="btn btn-default" href="${baseurl}/learn/${type.code}/all">${type.name }</a>
							</c:forEach>
						</div>
						<div class="col-md-10 column">
							<div>
								<ul class="nav">
								  <c:forEach items="${pageInfo.list}" var="page"> 
								  		<li> <a href="${baseurl}/learn/detail/${page.id}">${page.title }</a></li>
								  </c:forEach>
								</ul>
								<div>
									<m:pageInfo name="pageInfo" />
								</div>
							</div>	
						</div>
					</div>
				</div>
		</div>
	</div>
</div>
</body>
</html>