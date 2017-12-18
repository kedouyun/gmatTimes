<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../../common/head.jsp"%>
          <link rel="stylesheet" href="//code.kmf.com/dist/common/css/channel/common_w.css?201711291103" type="text/css"/>

        <link type="text/css" rel="stylesheet" href="//code.kmf.com/dist/newgmat/css/channel/exam/exam-test.css?201711291103" />
</head>
<body>

	<div class="s-gmat-main" style="top: 50%; margin-top: -136.5px; visibility: visible;">
    <div class="s-gmat-logo"></div>
    
    <!-- 顶部标题/时间等信息 -->
    <div class="s-gmat-header">
        <div class="s-header-left">AWA题目说明</div>
        <!--<div class="s-header-right">
            <p class="s-time"><i></i><span>Time cost 29:38</span></p>
            <p class="s-location"><i></i><span>Location 1 of 12</span></p>
        </div>-->
    </div>
    <!-- 收藏/设置条 -->
    <div class="s-top-bar">
        <!--<div class="s-collect-setting">
            <p class="s-collect"><i></i><span>收藏</span></p>
            <p class="s-setting"><i></i><span>设置</span></p>
        </div>-->
    </div>
    <!-- 练习题容器 -->
    <form method="POST" action="${baseurl}/exam/before/${exampaper.id}" accept-charset="UTF-8" id="questionForm"><input name="_token" type="hidden" value="G0WTiYvxGq7qhHAuUR73v7fkiRHxiGvlqsjms9oe">

    <div class="s-container">

        <p class="intr-line-mod intr-center"><strong class="intr-tit-word">Analytical Writing Assessment Instructions<br>Analysis of an Argument Essay<br>Time- ${exampaper.limitTime} minutes</strong></p>
        <p class="intr-line-mod"><strong class="intr-defule-word">RESPONCE EVALUATION:</strong>:Trained raters with back grounds in various subject-matter areas,including management education,will evaluate the overall quality of your reasoning and writting.They will consider how well you</p>
        <ul class="intr-ul-list intr-mar-none awa-explain">
            <li>identify important features of the argument and analyze them</li>
            <li>organize your analysis of the argument presented;</li>
            <li>provide relevant supporting reasons and examples;and</li>
            <li>control the elements of standard written English.</li>
        </ul>

        <p class="intr-line-mod">Click<span class="intr-next-icon"></span>to continue.</p>

        <input id="sid" name="sid" type="hidden" value="381">
        <input id="examUnique" name="exam_unique" type="hidden" value="u1513565644046145">
        <input id="u" name="u" type="hidden" value="u1513565644046145">
        <input name="mode" type="hidden" value="3">
        <input name="beginTime" type="hidden" value="0">
        <input name="overTime" type="hidden" value="0">
        <input name="section" type="hidden" value="1">
        <input name="qid" type="hidden" value="20012">
        <input name="op" type="hidden" value="submit">
        <input name="is_end" type="hidden" value="0">
        <input name="current_type" type="hidden" value="before">
        <input name="section_timeout" type="hidden" value="0">
    </div>
    </form>
    <div class="s-bottom-bar">

        <div class="s-help-cont" id="js-help">
            <div class="s-help">
                <i></i>
                <p><span>H</span>elp</p>
            </div>
        </div>
        <div class="s-end-cont" id="js-exam-end">
            <div class="s-end-exam">
                <i></i>
                <p><span>E</span>nd Exam</p>
            </div>
        </div>

        <div class="s-next-cont  do-before" id="js-exam-next">
            <div class="s-next">
                <p><span>N</span>ext</p>
                <i></i>
            </div>
        </div>
    </div>

 </div>
<script type="text/javascript">
	$("#js-exam-next").click(function(){
		$("#questionForm").submit();
	});
</script>
</body>
</html>