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
	    <form class="form-inline definewidth m20" action="<%=basePath%>/manger/grammartitle/list.do" method="post">
			<div class="panel-body">
			     <button type="button" class="btn btn-success" onclick="show_window('900px','400px','<%=basePath %>/manger/grammartitle/add.do','添加')"><i class="fa fa-plus"></i>新增&nbsp;</button>&nbsp;&nbsp;
			    <button type="button" url="<%=basePath %>/manger/grammartitle/delete.do" class="btn btn-danger option_deletes"><i class="fa fa-trash-o"></i>&nbsp;删除</button>
		    </div>
			<table class="table table-bordered table-hover definewidth m10">
			    <thead>
			    <tr>
			        <th><input type="checkbox" id="checkall" /></th>
			        <th>id</th>
			        <th>类型字段</th>
			        <th>类型</th>
			        <th>操作</th>
			    </tr>
			    </thead>
				<c:forEach var="grammarTitle" items="${pageInfo.list}"> 
				     <tr>
			            <td style="width: 1px"><input type="checkbox" name="arrayid" value="${grammarTitle.id}"/></td>
			            <td>${grammarTitle.id }</td>
			            <td>${grammarTitle.name }</td>
			            <td>${grammarTitle.grammarTypesName}</td>
			            <td>
							<a onclick="show_window('900px','400px','<%=basePath %>/manger/grammartitle/edit.do?id=${grammarTitle.id}','添加')" href="javascript:;" class=""><i class="fa fa-pencil-square-o"></i>修改</a>
	                  		<a href="javascript:;" url="<%=basePath %>/manger/grammartitle/delete.do?id=${grammarTitle.id}"  class="option_delete">删除</a>
			            </td>
			        </tr>
				</c:forEach>
				<tr>
			      	<td colspan="5">
			      		<div class="fenye" style="text-align: right;">
							<m:pageInfo name="pageInfo" />
						</div>
	      			</td>
				</tr>
    		</table>
    		<input type="hidden" id="deleState" value="${deleState}"/>
		</form>
    </div>
<%@ include file="../common/bottom.html"%>
</body>
</html>