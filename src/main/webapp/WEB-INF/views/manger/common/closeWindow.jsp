<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@ include file="../common/head.html"%>
</head>
<body>
		<div style="text-align: center;">
			<div><img alt="success" src="<%=basePath%>/manger/image/success.png"></div>
			<button id="transmit" onclick="colose_window()" class="btn btn-success">关闭 剩余<span id="miao">3</span>秒关闭</button>
		</div>
		<%@ include file="../common/bottom.html"%>
		<script type="text/javascript">
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		var wait=3;  
		timeOut();  
		function colose_window(){
			 parent.location.reload();
		     parent.layer.close(index);
		}
		function timeOut(){  
		    if(wait==0){  
		    	colose_window();
		    }else{                    
		        setTimeout(function(){  
		            wait--;  
		            $('#miao').text(wait);  
		            timeOut();  
		        },1000)  
		    }  
		}  
		</script>
</body>
</html>