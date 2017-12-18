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
	    <div class="panel panel-default">
		<form class="form-horizontal" id="commentForm" action="${basePath}/manger/grammargroup/save.do" method="POST">
			<div class="form-group">
				<label class="col-sm-2 control-label">组名称</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="name" placeholder="字段名称" required/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">类型</label>
				<div class="col-sm-6">
					<select class="form-control" name="grammarTypesId" onchange="change(this)" required>
						<option value="">--选择--</option>
						<c:forEach items="${grammarTypes}" var="types">
							<option value="${types.id}">${types.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">字段类型</label>
				<div class="col-sm-6">
					<select class="form-control" name="grammarTitleId" id="grammarTitleId" required>
							<option value="">--优选选择类型--</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">状态</label>
				<label class="radio-inline">
				  <input type="radio" name="status" value="0" name="user.status"   checked="checked"/> 下架
				</label>
				<label class="radio-inline">
				  <input type="radio" name="status" value="1" name="user.status"   /> 上架
				</label>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">建议用时</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="userTime" value="" placeholder="建议用时"/>
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
<script type="text/javascript">
		function change(that){
			$.ajax({
				type: "GET",
				url: "<%=basePath%>/manger/grammartitle/search/"+$(that).val()+".do",
				dataType:"json",
				success: function(r){
					if(r.code == 0){
						var text="";
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
</script>
</body>
</html>