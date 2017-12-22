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
<link rel="stylesheet" type="text/css" href="${basePath}/kindeditor/themes/default/default.css" />
</head>
<body>
<div id="rapp" >
	    <div v-show="!showList" class="panel panel-default">
		<form class="form-horizontal" id="commentForm"  action="${basePath}/manger/activity/save.do" method="POST">
			<div class="form-group">
				   	<label class="col-sm-2 control-label">标题</label>
				   	<div class="col-sm-6">
				      <input type="text" class="form-control" name="title" value="" placeholder="" required/>
				    </div>
				</div>
				<div class="form-group">
				   	<label class="col-sm-2 control-label">内容</label>
				   	<div class="col-sm-10">
				   			<textarea rows="" cols="" class="content_textarea" name="content"></textarea>
				    </div>
				</div>
				<div class="form-group">
				   	<label class="col-sm-2 control-label">状态</label>
				   	<div class="col-sm-6">
				    	<label class="radio-inline">
						  <input type="radio" name="status" value="0" name="grammargroup.status" checked="checked"/> 下架
						</label>
						<label class="radio-inline">
						  <input type="radio" name="status" value="1" name="grammargroup.status" /> 上架
						</label>
				    </div>
				</div>
				<div class="form-group">
				   	<label class="col-sm-2 control-label">文章首页图</label>
				   	<div class="col-sm-6">
				     <input type='hidden' name='image' id="imagePathOne" value="${article.image}">
		        	  	<img id="show_img" width="100px" height="80px" src="${article.image}">
		        	   <input type="file" id="change_file" onchange="ajaxSubmit1()" />
				    </div>
				</div>
				<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<input type="submit" class="btn btn-primary submitButton" value="确定"/>
				&nbsp;&nbsp;<input type="button" class="btn btn-warning colose"  value="关闭"/>
				<div class="form-group">
				   	<label class="col-sm-2 control-label"></label>
				   	<div class="col-sm-6">
				    </div>
				</div>
				<div class="form-group">
				   	<label class="col-sm-2 control-label"></label>
				   	<div class="col-sm-6">
				    </div>
				</div>
			</div>
		</form>
	</div>
    </div>
<%@ include file="../common/bottom.html"%>

 <script type="text/javascript" src="${basePath}/kindeditor/kindeditor-min.js"></script>
 <script type="text/javascript" src="${basePath}/js/jquery.upload2.js"></script>
 
 <script type="text/javascript">
 KindEditor.ready(function(K) {
		K.create('.content_textarea', {
			resizeType:1 ,//编辑器只能调整高度
			uploadJson : '${basePath}/upload/upload.do',
	    	allowFileManager : true,	
	    	allowUpload : true, //允许上传图片
			urlType : 'absolute',
			afterChange : function() {
				K('.word_count1').html(this.count());
				K('.getInputContentTotal').val(this.count());
				K('.word_count2').html(this.count('text'));
			},
			items:['source', '|', 'fullscreen', 'undo', 'redo', 'print', 'cut', 'copy', 'paste',
				'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
				'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
				'superscript', '|', 'selectall', '-',
				'title', 'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold',
				'italic', 'underline', 'strikethrough', 'removeformat', '|', 'image',
				'flash', 'media', 'advtable', 'hr', 'emoticons', 'link', 'unlink']
			,afterBlur: function(){this.sync();}});
	});
 
 function ajaxSubmit1() {
	 $("#change_file").upload({
            url: '${basePath}/upload/upload.do',
            // 其他表单数据
            params: { name: 'image' },
            // 上传完成后, 返回json, text
            dataType: 'json',
            onSend: function (obj, str) { return true; },
            // 上传之后回调
            onComplate: function (data) {
	            $("#show_img").attr("src","${basePath}"+data.url);
	            $("#imagePathOne").val(data.url);
            }
        });
        $("#change_file").upload("ajaxSubmit");
 }
 </script>
</body>
</html>