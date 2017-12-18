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
	    <form class="form-inline definewidth m20" action="<%=basePath%>/manger/questions/schoose.do" method="post">
			<div class="panel-body">
			    
			    <input type="hidden" name="grammaticalGroupId" value="${params.grammaticalGroupId}">
			    <input type="hidden" name="exampaperGroupId" value="${params.exampaperGroupId}" id="exampaperGroupId">
			  <%--   <button type="button" class="btn btn-success" onclick="show_window('900px','400px','<%=basePath %>/manger/questions/add.do','添加')"><i class="fa fa-plus"></i>新增&nbsp;</button>&nbsp;&nbsp; --%>
			  <button type="button" url="<%=basePath %>/manger/exampaperQuestions/delete.do" class="btn btn-danger option_deletes"><i class="fa fa-trash-o"></i>&nbsp;删除</button>
		    </div>
			<table class="table table-bordered table-hover definewidth m10">
			    <thead>
			    <tr>
			        <th><input type="checkbox" id="checkall" /></th>
			        <th>id</th>
			        <th>试题类型</th>
			        <th>所属分组</th>
			        <th>所属字段</th>
			        <th>所属类型</th>
			        <th>创建日期</th>
			        <th>答案</th>
			        <th>创建人</th>
			        <th>操作</th>
			    </tr>
			    </thead>
				<c:forEach var="questions" items="${pageInfo.list}"> 
				     <tr>
			            <td style="width: 1px"><input type="checkbox" name="arrayid" value="${questions.exampaperQuestionsId}"/></td>
			            <td>${questions.id }</td>
			            <td>${questions.questionType==1?"选择题":"阅读理解"}</td>
			            <td>${questions.groupName}</td>
			            <td>${questions.grammarTitleName}</td>
			            <td>${questions.grammarTypesName}</td>
			            <td><fmt:formatDate value="${questions.createTime}" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
			            <td>${questions.answer}</td>
			            <td>${questions.creator}</td>
			            <td>	
							<a href="javascript:;" onclick="show_window('900px','400px','<%=basePath %>/manger/questions/detail.do?id=${questions.id}','查看')">查看试题</a>&nbsp;
	                  		<a href="javascript:;" url="<%=basePath %>/manger/exampaperQuestions/delete.do?id=${questions.exampaperQuestionsId}"  class="option_delete">删除试题</a> 
			            </td>
			        </tr>
				</c:forEach>
				<tr>
			      	<td colspan="12">
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
<script type="text/javascript">
		function change(that){
			if($(that).val()==""){
				return;
			}
			$.ajax({
				type: "GET",
				url: "<%=basePath%>/manger/grammartitle/search/"+$(that).val()+".do",
				dataType:"json",
				success: function(r){
					if(r.code == 0){
						var text="<option value=\"\">--选择字段类型--</option>";
						if(r.grammarTitles.length>0){
							$(r.grammarTitles).each(function(){
								text+="<option value=\""+this.id+"\" >"+this.name+"</option>"
							});
							
							$("#grammarTitleId").empty();
							$("#grammarTitleId").append(text);
						}else{
							$("#grammarTitleId").empty();
							text+="<option value=\"\" >无数据请添加字段类型</option>"
							$("#grammarTitleId").append(text);
						}
						
					}else{
						alert(r.msg);
					}
				}
			});
		}
		

		function changeGroup(groupId){
			if(!groupId){
				return;
			}
			$.ajax({
				type: "GET",
				url: "<%=basePath%>/manger/grammargroup/search/"+$(groupId).val()+".do",
				dataType:"json",
				success: function(r){
					if(r.code == 0){
						var text="<option value=\"\">--请选择所属分组--</option>";
						if(r.grammarGroup.length>0){
							$(r.grammarGroup).each(function(){
								text+="<option value=\""+this.id+"\" >"+this.name+"</option>"
							});
							$("#grammarGroupId").empty();
							$("#grammarGroupId").append(text);
						}else{
							$("#grammarGroupId").empty();
							text+="<option value=\"\" >无数据请添加所属分组</option>"
							$("#grammarGroupId").append(text);
						}
					}else{
						alert(r.msg);
					}
				}
			});
		}
		
		$(".option_save").click(function(){
			var url=$(this).attr("url");
			var _data=[];
			$("input[name='arrayid']:checked").each(function(index){
				_data[index]=$(this).val();
			});
			 if(0==_data.length){
		    	alert("请选择一条记录");
		    	return ;
			 }
			confirm('确定要保存到试卷里吗？', function(){
				$.ajax({
					type: "POST",
					data:{"questionsIds":_data.toString(),"exampaperGroupId":$("#exampaperGroupId").val()},
					url: url,
					success: function(r){
						if(r.code == 0){
							alert('操作成功', function(){
								window.location.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		});
		
		
</script>
</body>
</html>