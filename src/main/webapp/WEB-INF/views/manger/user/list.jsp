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
	    <form class="form-inline definewidth m20" action="<%=basePath%>/sys/user/list.do" method="post">
			<div class="panel-body">
			    <div class="form-group col-sm-2">
							<input type="text" class="form-control" name="keyword" value="${params.keyword }" placeholder="输入用户名">
				</div>
			    <button type="submit" class="btn btn-default">查询</button>&nbsp;&nbsp;
			    <button type="button" class="btn btn-success" onclick="show_window('900px','400px','<%=basePath %>/sys/user/add.do','添加')"><i class="fa fa-plus"></i>新增&nbsp;</button>&nbsp;&nbsp;
			    <button type="button" url="<%=basePath %>/sys/user/delete.do" class="btn btn-danger option_deletes"><i class="fa fa-trash-o"></i>&nbsp;删除</button>
		    </div>
			<table class="table table-bordered table-hover definewidth m10">
			    <thead>
			    <tr>
			        <th><input type="checkbox" id="checkall" /></th>
			        <th>用户id</th>
			        <th>用户名</th>
			        <th>操作</th>
			    </tr>
			    </thead>
				<c:forEach var="sysRole" items="${pageInfo.list}"> 
				     <tr>
			            <td style="width: 1px"><input type="checkbox" name="arrayid" value="${sysRole.id}"/></td>
			            <td>${sysRole.id }</td>
			            <td>${sysRole.username }</td>
			            <td>
							<a onclick="show_window('900px','400px','<%=basePath %>/sys/user/edit.do?id=${sysRole.id}','添加')" href="javascript:;" class=""><i class="fa fa-pencil-square-o"></i>修改</a>
	                  		<a href="javascript:;" url="<%=basePath %>/sys/user/delete.do?id=${sysRole.id}"  class="option_delete">删除</a>
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