<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="../../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../../css/font-awesome.min.css">
<link rel="stylesheet" href="../../../plugins/jqgrid/ui.jqgrid-bootstrap.css">
<link rel="stylesheet" href="../../../plugins/ztree/css/metroStyle/metroStyle.css">
<link rel="stylesheet" href="../../../css/main.css">
<script src="../../../libs/jquery.min.js"></script>
<script src="../../../plugins/layer/layer.js"></script>
<script src="../../../libs/bootstrap.min.js"></script>
<script src="../../../libs/vue.min.js"></script>
<script src="../../../plugins/jqgrid/grid.locale-cn.js"></script>
<script src="../../../plugins/jqgrid/jquery.jqGrid.min.js"></script>
<script src="../../../plugins/ztree/jquery.ztree.all.min.js"></script>
<script src="../../../js/common.js"></script>

</head>
<body>
<div id="rapp" v-cloak>
	<div v-show="showList">
        <div class="panel panel-default">
            <div class="panel-heading">
                功能操作
            </div>
            <div class="panel-body">
				<div class="row">
					<a class="btn btn-default" @click="refresh">刷新</a>

					<a v-if="hasPermission('gm:questions:save')" class="btn btn-success" @click="add"><i class="fa fa-plus"></i>&nbsp;新增</a>
					<a v-if="hasPermission('gm:questions:update')" class="btn btn-warning" @click="update"><i class="fa fa-pencil-square-o"></i>&nbsp;修改</a>
					<a v-if="hasPermission('gm:questions:delete')" class="btn btn-danger" @click="del"><i class="fa fa-trash-o"></i>&nbsp;删除</a>
				</div>
			</div>
		</div>
	    <table id="jqGrid"></table>
	    <div id="jqGridPager"></div>
    </div>
    
    <div v-show="!showList" class="panel panel-default">
		<div class="panel-heading">{{title}}</div>
		<form class="form-horizontal">
											<div class="form-group">
			   	<label class="col-sm-2 control-label"></label>
			   	<div class="col-sm-6">
			      <input type="text" class="form-control" v-model="questions.content" placeholder=""/>
			    </div>
			</div>
			<div class="form-group">
			   	<label class="col-sm-2 control-label">试题可见性</label>
			   	<div class="col-sm-6">
			      <input type="text" class="form-control" v-model="questions.isVisible" placeholder="试题可见性"/>
			    </div>
			</div>
			<div class="form-group">
			   	<label class="col-sm-2 control-label"></label>
			   	<div class="col-sm-6">
			      <input type="text" class="form-control" v-model="questions.grammaticalGroupId" placeholder=""/>
			    </div>
			</div>
									<div class="form-group">
			   	<label class="col-sm-2 control-label"></label>
			   	<div class="col-sm-6">
			      <input type="text" class="form-control" v-model="questions.createTime" placeholder=""/>
			    </div>
			</div>
			<div class="form-group">
			   	<label class="col-sm-2 control-label"></label>
			   	<div class="col-sm-6">
			      <input type="text" class="form-control" v-model="questions.answer" placeholder=""/>
			    </div>
			</div>
			<div class="form-group">
			   	<label class="col-sm-2 control-label"></label>
			   	<div class="col-sm-6">
			      <input type="text" class="form-control" v-model="questions.analysis" placeholder=""/>
			    </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<input type="button" class="btn btn-primary" @click="saveOrUpdate" value="确定"/>
				&nbsp;&nbsp;<input type="button" class="btn btn-warning" @click="reload" value="返回"/>
			</div>
		</form>
	</div>
</div>

<script src="../../../js/modules/sys/questions.js"></script>

</body>
</html>