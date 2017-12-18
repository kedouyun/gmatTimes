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
		<form class="form-horizontal" id="commentForm" action="<%=basePath%>/manger/role/save.do" method="POST">
			<input type="hidden" name="menuIdList" id="menuIdList">
			<div class="form-group">
				<label class="col-sm-2 control-label">组名称</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="name" placeholder="字段名称" required/>
				</div>
			</div>
			<div class="form-group">
			   	<label class="col-sm-2 control-label">授权</label>
			   	<div class="col-sm-6">
			      <ul id="menuTree" class="ztree"></ul>
			    </div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<input type="button" class="btn btn-primary submitButton_01" value="确定"/>
				&nbsp;&nbsp;<input type="button" class="btn btn-warning colose"  value="关闭"/>
			</div>
		</form>
	</div>
    </div>
<%@ include file="../common/bottom.html"%>
<script type="text/javascript">
var setting = {
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "parentId",
				rootPId: -1
			},
			key: {
				url:"nourl"
			}
		},
		check:{
			enable:true,
			nocheckInherit:true
		}
	};
var ztree;
getMenuTree(null);
function getMenuTree(roleId) {
	//加载菜单树
	$.get("<%=basePath%>/sys/menu/list", function(r){
		ztree = $.fn.zTree.init($("#menuTree"), setting, r);
		//展开所有节点
		ztree.expandAll(true);
	});
}
$(".submitButton_01").click(function(){
	var nodes = ztree.getCheckedNodes(true);
	var menuIdList = new Array();
	for(var i=0; i<nodes.length; i++) {
		menuIdList.push(nodes[i].id);
	}
	//vm.role.menuIdList = menuIdList;
	$("#menuIdList").val(menuIdList.toString());
	debugger;
	$("#commentForm").submit();
});


/* $.ajax({
	type: "POST",
    url: "/manger/role/save.do",
    data: JSON.stringify(vm.role),
    success: function(r){
    	if(r.code === 0){
			alert('操作成功', function(){
				vm.reload();
			});
		}else{
			alert(r.msg);
		}
	}
}); */
</script>
</body>
</html>