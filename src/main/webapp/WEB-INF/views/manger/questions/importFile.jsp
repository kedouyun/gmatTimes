<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>附件管理</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<%@ include file="../common/head.html"%>
</head>
<body>
<div id="rapp">
	<!--查看附件-->
	<div id="attachmentInfoLayer" >
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">上传文件</label>
					<div class="col-sm-6">
					<a href="#" id="uploadFile" class="btn btn-success uploadFile" ><i ></i>&nbsp;导入试题</a>	
				</div>
			</div>
		</form>
	</div>
	<%@ include file="../common/bottom.html"%>
	<script src="<%=basePath %>/manger/libs/ajaxupload.js"></script>
	
	<script type="text/javascript">

	var ajaxUpload=new AjaxUpload('#uploadFile', {
		  action: '<%=basePath %>/manger/grammargroup/upload.do',
		  name: 'file',
		  autoSubmit:true,
		  responseType:"json",
		  data: {id:${id}},
		  onSubmit:function(file, extension){
		      layer.load(2);
		      /*if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
		          alert('只支持jpg、png、gif格式的图片！');
		          return false;
		      }*/
		  },
		  onComplete : function(file, r){
		      layer.closeAll('loading');
		      if(r.code == 0){
		        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		  		function colose_window(){
		  			 parent.location.reload();
		  		     parent.layer.close(index);
		  		}
		  		alert("导入成功！");
		  		setTimeout(function(){
		  			colose_window();
		  		},2000)
		      }else{
		          alert(r.msg);
		      }
		  }
		});
	</script>
</div>
</body>
</html>