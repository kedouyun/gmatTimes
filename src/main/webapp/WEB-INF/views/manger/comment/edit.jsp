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
		<form class="form-horizontal" id="commentForm"  action="/sys/comment/update.do" method="POST">
			<input type="hidden" name="id" value="${comment.id}">
			
													<div class="form-group">
							   	<label class="col-sm-2 control-label"></label>
							   	<div class="col-sm-6">
							      <input type="text" class="form-control" name="id" value="${comment.id}" placeholder="" required/>
							    </div>
							</div>
																			<div class="form-group">
							   	<label class="col-sm-2 control-label">评论者</label>
							   	<div class="col-sm-6">
							      <input type="text" class="form-control" name="memberId" value="${comment.memberId}" placeholder="" required/>
							    </div>
							</div>
																			<div class="form-group">
							   	<label class="col-sm-2 control-label">回复人</label>
							   	<div class="col-sm-6">
							      <input type="text" class="form-control" name="toMemberId" value="${comment.toMemberId}" placeholder="" required/>
							    </div>
							</div>
																			<div class="form-group">
							   	<label class="col-sm-2 control-label">评论内容</label>
							   	<div class="col-sm-6">
							      <input type="text" class="form-control" name="content" value="${comment.content}" placeholder="" required/>
							    </div>
							</div>
																			<div class="form-group">
							   	<label class="col-sm-2 control-label">状态（0:删除,1:在线）</label>
							   	<div class="col-sm-6">
							      <input type="text" class="form-control" name="status" value="${comment.status}" placeholder="" required/>
							    </div>
							</div>
																			<div class="form-group">
							   	<label class="col-sm-2 control-label">点赞数</label>
							   	<div class="col-sm-6">
							      <input type="text" class="form-control" name="faver" value="${comment.faver}" placeholder="" required/>
							    </div>
							</div>
																			<div class="form-group">
							   	<label class="col-sm-2 control-label">所属试题</label>
							   	<div class="col-sm-6">
							      <input type="text" class="form-control" name="questionId" value="${comment.questionId}" placeholder="" required/>
							    </div>
							</div>
																			<div class="form-group">
							   	<label class="col-sm-2 control-label">上级id</label>
							   	<div class="col-sm-6">
							      <input type="text" class="form-control" name="parentId" value="${comment.parentId}" placeholder="" required/>
							    </div>
							</div>
																			<div class="form-group">
							   	<label class="col-sm-2 control-label"></label>
							   	<div class="col-sm-6">
							      <input type="text" class="form-control" name="createDate" value="${comment.createDate}" placeholder="" required/>
							    </div>
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