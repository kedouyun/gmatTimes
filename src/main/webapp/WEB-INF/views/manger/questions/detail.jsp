<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ taglib uri="/WEB-INF/PageInfo.tld" prefix="m" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, grammargroup-scalable=no" name="viewport">
<%@ include file="../common/head.html"%>
<script src="//cdn.bootcss.com/mathjax/2.7.0/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
</head>
<body>
<div id="rapp" >
	 <div id="detailInfoLayer" >
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">描述：</label>
				<p class="form-control-static">${parse.title}</p>
			</div>
			
			<div>
				<c:forEach items="${parse.choiceList}" var="list">
					<div >
						<p class="col-sm-2 control-label" >${list.key}</p>
							<p class="form-control-static" >${list.value}</p>
					</div>
				</c:forEach>
			</div>
			
		</form>
	</div>
</div>
<%@ include file="../common/bottom.html"%>
<script type="text/x-mathjax-config">
MathJax.Hub.Config({
            extensions: ["tex2jax.js"],
            jax: ["input/TeX","output/HTML-CSS"],
            tex2jax: { inlineMath: [['$$','$$'],['\\(','\\)']],displayMath: [['\\[','\\]']]},
            showMathMenu: false,
            showMathMenuMSIE: false,
            showProcessingMessages:false
});
</script>
</body>
</html>