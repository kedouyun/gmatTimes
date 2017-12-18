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
	    <form class="form-inline definewidth m20" action="<%=basePath%>/manger/sysDictionary/list.do" method="post">
			<div class="panel-body">
			    <div class="form-group col-sm-2">
							<input type="text" class="form-control" name="keyword" value="${params.keyword}" placeholder="输入用户名">
				</div>
			    <button type="submit" class="btn btn-default">查询</button>&nbsp;&nbsp;
			    <button type="button" class="btn btn-success" onclick="show_window('900px','400px','<%=basePath %>/manger/sysDictionary/add.do','添加')"><i class="fa fa-plus"></i>新增&nbsp;</button>&nbsp;&nbsp;
			    <button type="button" url="<%=basePath %>/manger/sysDictionary/delete.do" class="btn btn-danger option_deletes"><i class="fa fa-trash-o"></i>&nbsp;删除</button>
		    </div>
			<table class="table table-bordered table-hover definewidth m10">
			    <thead>
			    <tr>
			        <th><input type="checkbox" id="checkall" /></th>
			       	 <th>id</th>
			       	 <th>名称</th>
			       	 <th>字典码</th>
			      	 <th>字典类型</th>
			      	 <th>操作</th>
			    </tr>
			    </thead>
				<c:forEach var="sysDictionary" items="${pageInfo.list}"> 
				     <tr>
			            <td style="width: 1px"><input type="checkbox" name="arrayid" value="${sysDictionary.id }"/></td>
			         					    <td>${sysDictionary.id}</td>
										    <td>${sysDictionary.name}</td>
										    <td>${sysDictionary.code}</td>
										    <td>${sysDictionary.typeName}</td>
								            <td>
							<a onclick="show_window('900px','400px','<%=basePath %>/manger/sysDictionary/edit.do?id=${sysDictionary.id}','添加')" href="javascript:;" class=""><i class="fa fa-pencil-square-o"></i>修改</a>
	                  		<a href="javascript:;" url="<%=basePath %>/manger/sysDictionary/delete.do?id=${sysDictionary.id}"  class="option_delete">删除</a>
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
		</form>
    </div>
<%@ include file="../common/bottom.html"%>
</body>
</html>
