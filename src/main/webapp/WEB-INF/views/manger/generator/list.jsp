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
	    <form class="form-inline definewidth m20" action="${basePath }/sys/generator/list.do" method="post">
			<button type="button" url="${basePath}/sys/user/delete.do" class="btn btn-default option_xiazai">下载</button>
			<table class="table table-bordered table-hover definewidth m10">
			    <thead>
			    <tr>
			        <th><input type="checkbox" id="checkall" /></th>
			        <th>表名</th>
			        <th>Engine</th>
			        <th>表备注</th>
			        <th>创建时间</th>
			        <th>操作</th>
			    </tr>
			    </thead>
				<c:forEach var="generator" items="${pageInfo.list}"> 
				     <tr>
			            <td style="width: 1px"><input type="checkbox" name="arrayid" value="${generator.tableName}"/></td>
			            <td>${generator.tableName}</td>
			            <td>${generator.engine}</td>
			            <td>${generator.tableComment}</td>
			            <td>${generator.createTime}</td>
			            <td>
							<a  href="<%=basePath %>/sys/generator/code.do?tables=${generator.tableName}"  class="">下载</a>
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

<script type="text/javascript">
$(".option_xiazai").click(function(){
	var _data=[];
	$("input[name='arrayid']:checked").each(function(index){
		_data[index]=$(this).val();
	});
	 if(0==_data.length){
    	alert("请选择一条记录");
    	return ;
	 }
	 location.href = "/sys/generator/code.do?tables=" +_data.toString();
});

</script>
</body>
</html>