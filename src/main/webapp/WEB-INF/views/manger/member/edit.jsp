<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ taglib uri="/WEB-INF/PageInfo.tld" prefix="m" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<%@ include file="../common/head.html"%>
</head>
<body>
<div id="rapp" >
	    <div v-show="!showList" class="panel panel-default">
		<form class="form-horizontal" id="commentForm"  action="${basePath}/sys/user/update.do" method="POST">
			<input type="hidden" name="id" value="${user.id}">
			<div class="form-group">
			   	<label class="col-sm-2 control-label">用户名</label>
			   	<div class="col-sm-6">
			      <input type="text" class="form-control" name="username" value="${user.username}" placeholder="登录账号" required/>
			    </div>
			</div>
			<div class="form-group">
			   	<label class="col-sm-2 control-label">邮箱</label>
			   	<div class="col-sm-6">
			      <input type="text" class="form-control" name="email" value="${user.email}" placeholder="邮箱"/>
			    </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">状态</label>
				<label class="radio-inline">
				  <input type="radio" name="status" value="0" name="user.status"  <c:if test="${user.status==0 }"> checked="checked" </c:if>/> 禁用
				</label>
				<label class="radio-inline">
				  <input type="radio" name="status" value="1" name="user.status"  <c:if test="${user.status==1 }"> checked="checked" </c:if>/> 正常
				</label>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<input type="submit" class="btn btn-primary submitButton" value="确定"/>
				&nbsp;&nbsp;<input type="button" class="btn btn-warning colose"  value="关闭"/>
			</div>
		</form>
	</div>
    </div>
<%@ include file="../common/bottom.html"%>
</body>
</html>