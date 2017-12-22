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
	    <form class="form-inline definewidth m20" action="<%=basePath%>/manger/activity/list.do" method="post">
			<div class="panel-body">
			   <%--  <div class="form-group col-sm-2">
							<input type="text" class="form-control" name="keyword" value="${params.keyword}" placeholder="输入用户名">
				</div>
			    <button type="submit" class="btn btn-default">查询</button>&nbsp;&nbsp; --%>
			    <button type="button" class="btn btn-success" onclick="show_window('1100px','600px','<%=basePath %>/manger/activity/add.do','添加')"><i class="fa fa-plus"></i>新增&nbsp;</button>&nbsp;&nbsp;
			    <button type="button" url="<%=basePath %>/manger/activity/delete.do" class="btn btn-danger option_deletes"><i class="fa fa-trash-o"></i>&nbsp;删除</button>
		    </div>
			<table class="table table-bordered table-hover definewidth m10">
			    <thead>
			    <tr>
			         <th><input type="checkbox" id="checkall" /></th>
 			       	 <th>id</th>
 			       	 <th>标题</th>
 					 <th>类型</th>
 					 <th>状态</th>
 					 <th>创建日期</th>
 					 <th>头图</th>
			         <th>操作</th>
			    </tr>
			    </thead>
				<c:forEach var="article" items="${pageInfo.list}"> 
				     <tr>
			            <td style="width: 1px"><input type="checkbox" name="arrayid" value="${article.id }"/></td>
	      				<td>${article.id}</td>
					    <td>${article.title}</td>
					    <td>${article.type}</td>
					    <td>${article.status==1?"已发布":"待发布"}</td>
					    <td><fmt:formatDate value="${article.createTime}" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
					    <td>${article.image}</td>
			            <td>
							<a onclick="show_window('1100px','600px','<%=basePath %>/manger/activity/edit.do?id=${article.id}','添加')" href="javascript:;" class=""><i class="fa fa-pencil-square-o"></i>修改</a>
	                  		<a href="javascript:;" url="<%=basePath %>/manger/activity/delete.do?id=${article.id}"  class="option_delete">删除</a>
			            </td>
			        </tr>
				</c:forEach>
				<tr>
			      	<td colspan="9">
			      		<div class="fenye" style="text-align: right;">
							<m:pageInfo name="pageInfo" />
						</div>
	      			</td>
				</tr>
    		</table>
		</form>
    </div>
<%@ include file="../common/bottom.html"%>
</body>
</html>
