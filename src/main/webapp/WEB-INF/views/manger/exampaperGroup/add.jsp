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
		<form class="form-horizontal" id="commentForm"  action="${basePath}/manger/exampaperGroup/save.do" method="POST">
				<div class="form-group">
				   	<label class="col-sm-2 control-label">试卷名称</label>
				   	<div class="col-sm-6">
				      <input type="text" class="form-control" name="name" value="" placeholder="" required/>
				    </div>
				</div>
				
				<div class="form-group">
				   	<label class="col-sm-2 control-label">试卷名称</label>
				   	<div class="col-sm-6">
				    	<select class="form-control" name="exampaperId"  required>
							<c:forEach items="${exampaperList}" var="types">
								<option value="${types.id}">${types.name}</option>
							</c:forEach>
						</select>
				    </div>
				</div>
				<div class="form-group">
				   	<label class="col-sm-2 control-label">时间限制(Minute)</label>
				   	<div class="col-sm-6">
				      <input type="text" class="form-control" name="limitTime" value="" placeholder="分钟" required/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">状态</label>
					<label class="radio-inline">
					  <input type="radio" name="status" value="0" name="user.status" /> 下架
					</label>
					<label class="radio-inline">
					  <input type="radio" name="status" value="1" name="user.status"  checked="checked"  /> 上架
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