<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<%@ include file="../../common/head.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/upload/css/font-awesome.4.6.0.css">
<link rel="stylesheet" href="<%=basePath%>/js/upload/css/amazeui.min.css">
<link rel="stylesheet" href="<%=basePath%>/js/upload/css/amazeui.cropper.css">
<link rel="stylesheet" href="<%=basePath%>/js/upload/css/custom_up_img.css">
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form action="${baseurl}/user/saveUserCent">
				<div>
					<label>更换头像</label>
					<div><img width="100" height="100" src="http://img.kmf.com/gre/bbs/c3/c3e7083efa99699640cebed201e599d5.jpg" alt="大头像"></div>
					<p><br><button type="button" class="btn-b f16 P-avatar">更换头像</button></p>
				</div>
				<div class="form-group clearfix">
	                 <label for="Age" class="tit">性别</label>
	                 <label class="radio-inline">
	                     <input type="radio" id="Male" value="0" name="sex" checked="">男
	                 </label>&nbsp;&nbsp;&nbsp;&nbsp;
	                 <label class="radio-inline">
	                     <input type="radio" id="Female" value="1" name="sex">女
	                 </label>
	             </div>
	             <div class="pull-left">
	                 <button type="button" class="btn-w">保存</button>
	             </div>
	          </form>
		</div>
	</div>
	<!-- ## -->
	<center>
<div class="up-img-cover"  id="up-img-touch" >
	<img class="am-circle" alt="点击图片上传" src="img/hu.jpg" data-am-popover="{content: '点击上传', trigger: 'hover focus'}" >
</div>
</center>
<div><a style="text-align: center; display: block;"  id="pic"></a></div>

<!--图片上传框-->
<div class="am-modal am-modal-no-btn up-frame-bj " tabindex="-1" id="doc-modal-1">
  <div class="am-modal-dialog up-frame-parent up-frame-radius">
	<div class="am-modal-hd up-frame-header">
	   <label>修改头像</label>
	  <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
	</div>
	<div class="am-modal-bd  up-frame-body">
	  <div class="am-g am-fl">
		<div class="am-form-group am-form-file">
		  <div class="am-fl">
			<button type="button" class="am-btn am-btn-default am-btn-sm">
			  <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
		  </div>
		  <input type="file" id="inputImage">
		</div>
	  </div>
	  <div class="am-g am-fl" >
		<div class="up-pre-before up-frame-radius">
			<img alt="" src="" id="image" >
		</div>
		<div class="up-pre-after up-frame-radius">
		</div>
	  </div>
	  <div class="am-g am-fl">
		<div class="up-control-btns">
			<span class="am-icon-rotate-left"  onclick="rotateimgleft()"></span>
			<span class="am-icon-rotate-right" onclick="rotateimgright()"></span>
			<span class="am-icon-check" id="up-btn-ok" url="${baseurl }/webupload/file"></span>
		</div>
	  </div>
	  
	</div>
  </div>
</div>

<!--加载框-->
<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
  <div class="am-modal-dialog">
	<div class="am-modal-hd">正在上传...</div>
	<div class="am-modal-bd">
	  <span class="am-icon-spinner am-icon-spin"></span>
	</div>
  </div>
</div>

<!--警告框-->
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
  <div class="am-modal-dialog">
	<div class="am-modal-hd">信息</div>
	<div class="am-modal-bd"  id="alert_content">
			  成功了
	</div>
	<div class="am-modal-footer">
	  <span class="am-modal-btn">确定</span>
	</div>
  </div>
</div>
	<!-- ## -->
	
</div>
<script src="<%=basePath%>/js/upload/js/amazeui.min.js" charset="utf-8"></script>
<script src="<%=basePath%>/js/upload/js/cropper.min.js" charset="utf-8"></script>
<script src="<%=basePath%>/js/upload/js/custom_up_img.js" charset="utf-8"></script>
</body>
</html>