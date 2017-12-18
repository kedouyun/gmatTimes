<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GMAT</title>
<%@ include file="../../common/head.jsp"%>
<script src="//cdn.bootcss.com/mathjax/2.7.0/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
<style type="text/css">
.workbook-list-mod .pw-single-mod {
	cursor: pointer;
    margin-right: 18px;
    float: left;
    width: 260px;
    height: 116px;
    border: 2px solid #FFF;
    box-sizing: border-box;
    margin-bottom: 20px;
}
.border-box {
    display: block;
    position: relative;
    width: 256px;
    height: 112px;
    padding: 12px 15px 8px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    float: left;
}
.pw-single-left {
    float: left;
    width: 180px;
}.pw-single-left .single-tit {
    font-size: 16px;
    line-height: 28px;
}
.single-icon-data {
    margin-top: 10px;
    display: block;
}
.single-icon-data .data-icon {
    float: left;
    padding-left: 22px;
    position: relative;
    margin-right: 15px;
}
.single-icon-data a.min-color, .single-icon-data span.min-color {
    color: #999;
}
.single-icon-data .data-icon:last-child {
    margin-right: 0;
}
.single-icon-data .data-icon i.over-none {
    background-position: -7px -6px;
}
.single-icon-data .data-icon {
    float: left;
    padding-left: 22px;
    position: relative;
    margin-right: 15px;
}
	
</style>

</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<jsp:include page="../../common/commonLogin.jsp"/>
			
			<!--  -->
			<div class="col-md-8 column">
				<div class="tabbable" id="tabs-253144">
					<ul class="nav nav-tabs">
						<c:forEach var="grammarTypes" items="${grammarTypesList }" varStatus="status">
							 <c:if test="${typesId==grammarTypes.id}">
								<li  class="active" >
									 <a href="${baseurl}/gmat/practice/${grammarTypes.id}" >${grammarTypes.name}</a>
								</li>
							</c:if>
							
							<c:if test="${typesId!=grammarTypes.id}">
								<li >
									 <a href="${baseurl}/gmat/practice/${grammarTypes.id}">${grammarTypes.name}</a>
								</li>
							</c:if> 
							
						</c:forEach>
					</ul>
					<div class="col-md-12 column">
							<c:forEach var="grammarTitle" items="${grammarTitleList }" varStatus="status">
								 <c:if test="${titleId==grammarTitle.id}"> 
										<a class="btn btn-default btn-primary " href="${baseurl}/gmat/practice/${grammarTitle.grammarTypesId}/${grammarTitle.id}">${grammarTitle.name}</a>
								</c:if>
								 <c:if test="${titleId!=grammarTitle.id}"> 
										<a class="btn btn-default " href="${baseurl}/gmat/practice/${grammarTitle.grammarTypesId}/${grammarTitle.id}">${grammarTitle.name}</a>
								</c:if>
							
							</c:forEach>
					</div>
				</div>
				<div class="col-md-12 column" style="margin: 10px 0;">
					<c:forEach var="grammarGroup" items="${grammarGroupList }"> 
						<div class="border-box">
						     <span>${grammarGroup.grammarTitleName}</span>
							 <a href="${baseurl}/gmat/pre/${grammarGroup.id}" class="btn btn-default" target="_blank">${grammarGroup.name }</a>
						     <span>进度：${grammarGroup.progress==null?"--":grammarGroup.progress}/${grammarGroup.questionsCounNum}</span>
						     <span>错题：${grammarGroup.wrong}</span>
						     <c:if test="${!empty grammarGroup.progress}">
						     	<c:if test="${grammarGroup.progress<grammarGroup.questionsCounNum}">
							     <a href="${baseurl}/gmat/pre/${grammarGroup.id}">重新开始</a>
							     <a href="${baseurl}/gmat/practice/result/${grammarGroup.id}/${grammarGroup.grammarGroupStatus.key}">查看上次结果</a>
							     <a href="${baseurl}/gmat/pre/practice/${grammarGroup.id}/${grammarGroup.grammarGroupStatus.key}/${grammarGroup.grammarGroupStatus.progress}">继续练习</a>
						     	</c:if>
						     </c:if>
						</div>
					</c:forEach>
				</div>
			</div>
			
			<!--  -->
			<div class="col-md-4 column">
				<ul>
					<li>
						Lorem ipsum dolor sit amet
					</li>
					<li>
						Consectetur adipiscing elit
					</li>
					<li>
						Integer molestie lorem at massa
					</li>
					<li>
						Facilisis in pretium nisl aliquet
					</li>
					<li>
						Nulla volutpat aliquam velit
					</li>
					<li>
						Faucibus porta lacus fringilla vel
					</li>
					<li>
						Aenean sit amet erat nunc
					</li>
					<li>
						Eget porttitor lorem
					</li>
				</ul>
			</div>
			
		</div>
	</div>
</div>

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