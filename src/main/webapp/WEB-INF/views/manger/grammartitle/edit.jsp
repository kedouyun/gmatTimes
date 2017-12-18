<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ taglib uri="/WEB-INF/PageInfo.tld" prefix="m" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, grammarTitle-scalable=no" name="viewport">
<%@ include file="../common/head.html"%>
</head>
<body>
<div id="rapp" >
	    <div v-show="!showList" class="panel panel-default">
		<form class="form-horizontal" id="form_table" action="${basePath}/manger/grammartitle/update.do" method="POST">
			<input type="hidden" name="id" value="${grammarTitle.id}">
			<div class="form-group">
				<label class="col-sm-2 control-label">名称</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="name" value="${grammarTitle.name }" placeholder="别名"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">类型</label>
				<div class="col-sm-6">
					<select class="form-control" name="grammarTypesId" >
						<c:forEach items="${grammarTypes}" var="types">
							<c:if test="${grammarTitle.grammarTypesId==types.id}">
								<option value="${types.id}" selected="selected">${types.name}</option>
							</c:if>
							<c:if test="${grammarTitle.grammarTypesId!=types.id}">
								<option value="${types.id}" >${types.name}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<input type="button" class="btn btn-primary submitButton" value="确定"/>
				&nbsp;&nbsp;<input type="button" class="btn btn-warning colose"  value="关闭"/>
			</div>
		</form>
	</div>
    </div>
<%@ include file="../common/bottom.html"%>
</body>
</html>