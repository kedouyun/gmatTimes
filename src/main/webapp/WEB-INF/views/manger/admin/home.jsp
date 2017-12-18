<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>GMATimes后台管理系统</title>
  <meta name="keywords" content="sbed">
  <meta name="description" content="sbed开发平台">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" type="image/x-icon" href="../favicon.ico">
  <link rel="stylesheet" href="../manger/css/bootstrap.min.css">
  <link rel="stylesheet" href="../manger/css/font-awesome.min.css">
  <link rel="stylesheet" href="../manger/css/AdminLTE.min.css">
  <link rel="stylesheet" href="../manger/css/all-skins.min.css">
  <link rel="stylesheet" href="../manger/css/main.css">
  <!--[if lt IE 9]>
  <script src="../manger/libs/html5shiv.min.js"></script>
  <script src="../manger/libs/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper" id="rapp" v-cloak>
  <header class="main-header">
    <a href="javascript:;" class="logo">
      <span class="logo-mini"><b>GMATimes</b></span>
      <span class="logo-lg"><b>GMATimes</b></span>
    </a>
    <nav class="navbar navbar-static-top" role="navigation">
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">GMATimes navigation</span>
      </a>
	  <div style="float:left;color:#fff;padding:15px 10px;">欢迎 {{user.username}}</div>
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
		  <li><a href="javascript:;" @click="updatePassword"><i class="fa fa-lock"></i> &nbsp;修改密码</a></li>
          <li><a href="javascript:;" @click="logout"><i class="fa fa-sign-out"></i> &nbsp;退出系统</a></li>
		</ul>
      </div>
    </nav>
  </header>

  <aside class="main-sidebar">
    <section class="sidebar">
      <ul class="sidebar-menu">
        <!-- vue生成的菜单 -->
        <c:forEach items="${menuList }" var="menu">
        		 <li >
       		 	    <a href="javascript:;"  onclick="openOrclose(this)"> <i class="${menu.icon }"></i>
	       		 	    <span>${menu.name }</span>
	       		 	    <i class="fa fa-angle-left pull-right"></i>
       		 	    </a>
       		 	    <ul class="treeview-menu" style="display: none;">
	       		 	    <c:forEach items="${ menu.list}" var="item">
		       		 	    	<li><a href="javascript:;" onclick="forword('${item.url}')"><i class="${item.icon }"></i> ${item.name }</a></li>
	       		 	    </c:forEach>
       		 	    </ul>
        		 </li>
        </c:forEach>
         </ul>
    </section>
  </aside>
  <!-- =============================================== -->
  <div class="content-wrapper" style="min-height: 549px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <ol class="breadcrumb" id="nav_title" style="position:static;float:none;">
	        <li class="active">
	            <a :href="baseURL+'admin/index.html'"><i class="fa fa-home" style="font-size:20px;position:relative;top:2px;left:-3px;"></i>首页</a>
	        <li class="active">{{navTitle}}</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content" style="background:#fff;">
      <iframe scrolling="yes" frameborder="0" id="div_view" style="width:100%;min-height:200px;overflow:visible;background:#fff;" ></iframe>
    </section>
  </div>

  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      Version 1.0.0
    </div>
    Copyright &copy; 2017 <a href="#" target="_blank">GMATimes</a> All Rights Reserved
  </footer>

  <div class="control-sidebar-bg"></div>
  
  <!-- 修改密码 -->
<div id="passwordLayer" style="display: none;">
	<form class="form-horizontal">
	<div class="form-group">
		<div class="form-group">
		   	<label class="col-sm-2 control-label">账号</label>
            <div class="col-sm-6">
		        <span class="label label-success" style="vertical-align: bottom;">{{user.username}}</span>
            </div>
		</div>
		<div class="form-group">
		   	<label class="col-sm-2 control-label">原密码</label>
		   	<div class="col-sm-6">
		      <input type="password" class="form-control" v-model="password" placeholder="原密码"/>
		    </div>
		</div>
		<div class="form-group">
		   	<label class="col-sm-2 control-label">新密码</label>
		   	<div class="col-sm-6">
		      <input type="text" class="form-control" v-model="newPassword" placeholder="新密码"/>
		    </div>
		</div>
	</div>
	</form>
</div>

</div>
<script src="../manger/libs/jquery.min.js"></script>
<script src="../manger/plugins/jqgrid/jquery.jqGrid.min.js"></script>
<script src="../manger/libs/vue.min.js"></script>
<script src="../manger/libs/router.js"></script>
<script src="../manger/libs/bootstrap.min.js"></script>
<script src="../manger/plugins/layer/layer.js"></script>
<script src="<%=basePath%>/js/validate/jquery.validate.min.js"></script>
<script src="../manger/js/common.js"></script>
<script src="../manger/js/index.js"></script>
<script type="text/javascript">
var path="<%=basePath%>";
function forword(url){
     $('#div_view').attr('src', path+url);
}
function openOrclose(obj){
	if($(obj).next().css("display")=="none"){
		$(".treeview-menu").each(function(){
			$(this).hide();	
		});
		$(".active").each(function(){
			$(this).attr("class","");	
		});
		$(obj).next().show();
		$(obj).parent().attr("class","active");
	}else{
		$(obj).next().hide();	
	}
}
$('.sidebar-list a').bind('click', function(){
	    $('li a').removeClass('changeColor');
	    $(this).addClass('changeColor');
});

window.onload=function(){  
	  window.onresize = init_window_height;  
}
function init_window_height(){
		var window_height=document.documentElement.clientHeight;
		$(".content-wrapper").css("height",(window_height-70)+"px");
		$(".sidebar-wrap").css("height",(window_height-70)+"px");
		$(".result-wrap").css("height",(window_height-70)+"px");
}

</script>
</body>
</html>
