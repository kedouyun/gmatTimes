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
		<form class="form-horizontal" id="commentForm"  action="${basePath}/manger/exampaper/update.do" method="POST">
			<input type="hidden" name="id" value="${exampaper.id}">
						<div class="form-group">
							   	<label class="col-sm-2 control-label">试卷名称</label>
							   	<div class="col-sm-6">
							      <input type="text" class="form-control" name="name" value="${exampaper.name}" placeholder="" required/>
							    </div>
							</div>
							<div class="form-group">
							   	<label class="col-sm-2 control-label">描述</label>
							   	<div class="col-sm-6">
							   		  <textarea rows="5" cols="15" class="form-control" name="remark">${exampaper.remark}</textarea>
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