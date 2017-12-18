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
	    <form class="form-inline definewidth m20" action="<%=basePath%>/manger/exampaperGroup/list.do" method="post">
			<div class="panel-body">
			    <div class="form-group col-sm-2">
					<input type="text" class="form-control" name="name" value="${params.name}" placeholder="输入试卷组名称">
				</div>
			    <button type="submit" class="btn btn-default">查询</button>&nbsp;&nbsp;
			    <button type="button" class="btn btn-success" onclick="show_window('900px','400px','<%=basePath %>/manger/exampaperGroup/add.do','添加')"><i class="fa fa-plus"></i>新增&nbsp;</button>&nbsp;&nbsp;
			    <button type="button" url="<%=basePath %>/manger/exampaperGroup/delete.do" class="btn btn-danger option_deletes"><i class="fa fa-trash-o"></i>&nbsp;删除</button>
		    </div>
			<table class="table table-bordered table-hover definewidth m10">
			    <thead>
			    <tr>
			        <th><input type="checkbox" id="checkall" /></th>
			       	 <th>试卷id</th>
			       	 <th>试卷组名称</th>
   					 <th>试卷名称</th>
   					 <th>状态</th>
   					 <th>创建日期</th>
   					 <th>练习人数</th>
   					 <th>平均得分</th>
   					 <th>试题数</th>
   					 <th>时间限制(Minute)</th>
			      	 <th>操作</th>
			    </tr>
			    </thead>
				<c:forEach var="exampaperGroup" items="${pageInfo.list}"> 
				     <tr>
			            <td style="width: 1px"><input type="checkbox" name="arrayid" value="{exampaperGroup.id }"/></td>
	      				<td>${exampaperGroup.id}</td>
					    <td>${exampaperGroup.name}</td>
					    <td>${exampaperGroup.exampaperName}</td>
					     <td>${exampaperGroup.status==1?"上架":"下架"}</td>
					   	<td><fmt:formatDate value="${exampaperGroup.createDate}" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
					    <td>${exampaperGroup.personTimes}</td>
					    <td>${exampaperGroup.avgAccuracy}</td>
					    <td>
					    	<a onclick="show_window('1000px','450px','${basePath}/manger/questions/myschoose.do?exampaperGroupId=${exampaperGroup.id}','试卷列表')" href="javascript:;" class="">${exampaperGroup.questionsCounNum}</a>
					    </td>
						<td>${exampaperGroup.limitTime}</td>
						<td>
							<a onclick="show_window('900px','400px','${basePath}/manger/exampaperGroup/edit.do?id=${exampaperGroup.id}','添加')" href="javascript:;" class=""><i class="fa fa-pencil-square-o"></i>修改</a>
							<a onclick="show_window('1000px','450px','${basePath}/manger/questions/schoose.do?exampaperGroupId=${exampaperGroup.id}','组合试卷')" href="javascript:;" class="">组合试卷</a>
	                  		<a href="javascript:;" url="${basePath}/manger/exampaperGroup/delete.do?id=${exampaperGroup.id}"  class="option_delete">删除</a>
			            </td>
			        </tr>
				</c:forEach>
				<tr>
			      	<td colspan="11">
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
