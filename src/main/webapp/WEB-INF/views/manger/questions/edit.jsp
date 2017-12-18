<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ taglib uri="/WEB-INF/PageInfo.tld" prefix="m" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, grammargroup-scalable=no" name="viewport">
<%@ include file="../common/head.html"%>
</head>
<body>
<div id="rapp" >
	    <div v-show="!showList" class="panel panel-default">
		<form class="form-horizontal" id="commentForm"  action="/manger/grammargroup/update.do" method="POST">
			<input type="hidden" name="id" value="${grammargroup.id}">
			<div class="form-group">
				<label class="col-sm-2 control-label">名称</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="name" value="${grammargroup.name }" placeholder="别名"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">类型</label>
				<div class="col-sm-6">
					<select class="form-control" name="grammarTypesId" >
						<c:forEach items="${grammarTypes}" var="types">
							<c:if test="${grammargroup.grammarTypesId==types.id}">
								<option value="${types.id}" selected="selected">${types.name}</option>
							</c:if>
							<c:if test="${grammargroup.grammarTypesId!=types.id}">
								<option value="${types.id}" >${types.name}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">字段类型</label>
				<div class="col-sm-6">
					<select class="form-control" name="grammarTitleId" >
						<c:forEach items="${grammarTitleList}" var="title">
							<c:if test="${grammargroup.grammarTitleId==title.id}">
								<option value="${title.id}" selected="selected">${title.name}</option>
							</c:if>
							<c:if test="${grammargroup.grammarTitleId!=title.id}">
								<option value="${title.id}" >${title.name}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">状态</label>
				<label class="radio-inline">
				  <input type="radio" name="status" value="0" name="grammargroup.status"  <c:if test="${grammargroup.status==0 }"> checked="checked" </c:if>/> 下架
				</label>
				<label class="radio-inline">
				  <input type="radio" name="status" value="1" name="grammargroup.status"  <c:if test="${grammargroup.status==1 }"> checked="checked" </c:if>/> 上架
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