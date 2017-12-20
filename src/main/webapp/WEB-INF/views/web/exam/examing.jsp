<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GMAT</title>
<link rel="stylesheet" type="text/css" href="${baseurl}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${baseurl}/css/index.css" />
<script src="//cdn.bootcss.com/mathjax/2.7.0/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
<script type="text/javascript" src="${baseurl}/js/jquery.min.js"></script>
<script type="text/javascript" src="${baseurl}/js/exem.js" ></script>
</head>
<body>
	<div id="MathJax_Message" style="display: none;"></div>

	<div class="s-gmat-main"
		style="top: 50%; margin-top: -309px; visibility: visible;">
		<div class="s-gmat-logo"></div>
		<!-- 顶部标题/时间等信息 -->
		<div class="s-gmat-header">
			<div class="s-header-left">[练习]CR-OG：第181-200题</div>
			<div class="s-header-right">
				<p class="s-time" id="js-time">
					<i></i><span>Time cost 39:49</span>
				</p>
				<p class="s-location" id="js-location" data-questionseq="1">
					<i></i><span>Location ${config.progress+1} of ${questionsNum}</span>
				</p>
			</div>
		</div>
		<!-- 收藏/设置条 -->
		<div class="s-top-bar">
			<div class="s-collect-setting">
				<p class="s-correction js-open-error" data-type="2" data-qid="21230"
					data-title="纠错"
					data-json="{&quot;0&quot;:&quot;\u5176\u4ed6&quot;,&quot;4&quot;:&quot;\u9898\u76ee\u5185\u5bb9\u9519\u8bef&quot;,&quot;5&quot;:&quot;\u683c\u5f0f\u9519\u8bef&quot;,&quot;6&quot;:&quot;\u7b54\u6848\u9519\u8bef&quot;,&quot;7&quot;:&quot;\u89e3\u6790\u9519\u8bef&quot;}">
					<i></i><span>纠错</span>
				</p>
				<p class="s-collect " id="js-collect" data-collect_id="21230"
					data-op="1" data-subject="2" data-object="question">
					<i></i><span>收藏</span>
				</p>
				<p class="s-setting" id="js-setting">
					<i></i><span>设置</span>
				</p>
			</div>
		</div>
		<input type="hidden" id="GlobeLogin" value="1">
		<!-- 练习题容器 -->					
		<form method="POST" action="${baseurl}/exam/exercise/${exampaperGroupId}/${rediskey}"
			accept-charset="UTF-8" id="questionForm">
			<input name="_token" type="hidden" value="WskYEKeSTfjX3OXhlW2da8cf6cZut1WikCYsPC2m">
				 <input id="sid" name="sid" type="hidden" value="110">
				<input type="hidden" value="1"> <input name="beginTime"
				type="hidden" value="0">  <input type="hidden" name="nid"
				value="ffgdrk"> <input name="qid" type="hidden"
				value="21230"> <input name="parent" type="hidden" value="0">
			<input name="type" type="hidden" value="101"> <input
				name="op" type="hidden" value="submit"> <input
				name="section" type="hidden" value="0"> <input
				name="the_prep_mask" type="hidden" value="0">
				 <input type="hidden" name="showAnswer" value="${config.showAnswer}" id="showAnswer"> 
				<input type="hidden" name="timeLimit" value="0">
				<input type="hidden" name="isPaceLimit" value="0">
				
				<input name="overTime" id="overTime" type="hidden" value="2389">
				<input type="hidden"  value="${questions.answer}" id="answer">
				<input id="u" name="u" type="hidden" value="${rediskey}"> 
				<input type="hidden" name="overExem" id="overExem" value="0">
				<input type="hidden" id="exampaperGroupId" value="${exampaperGroupId}">
			<div class="s-container">
				<div class="s-sc-topic-container">
					<p class="s-sc-topic">${quest.title}</p>
				</div>
				<ul class="s-sc-answoers-list">
					<c:forEach items="${quest.choiceList}" var="list">
						<li>
							<label> 
								<!-- <i class="inputRadio js-inputRadio"></i> -->
								<input name="answer" type="radio" value="${list.key}" />
								<span>${list.value}</span>
							</label>
						</li>
					</c:forEach>

				</ul>
				<!-- 正确答案 -->
				<div class="s-answers-results" style="display: none;">
					<p class="s-results-tips" data-correct="40" id="js-answer-result">
						备注：<a href="/question/09gdqk.html" target="_blank">点我查看题目解析</a>
					</p>
				</div>
			</div>
		</form>
		<!-- 底部帮助/退出/下一题条 -->
		<div class="s-bottom-bar">
			<div class="s-help-cont" id="js-help">
				<div class="s-help">
					<i></i>
					<p>
						<span>H</span>elp
					</p>
				</div>
			</div>
			<div class="s-quit-cont" id="js-quit" data-url="/practice/cr/og">
				<div class="s-quit">
					<i></i>
					<p>
						<span>Q</span>uit
					</p>
				</div>
			</div>
			<div class="s-pause-cont practice" id="js-pause">
				<div class="s-pause">
					<p>
						Pau<span>s</span>e
					</p>
				</div>
			</div>
			<div class="s-next-cont" id="js-next">
				<div class="s-next">
					<p>
						<span>N</span>ext
					</p>
					<i></i>
				</div>
			</div>
		</div>
	</div>

	<!-- 遮罩层 -->
	<div class="s-mask-layer"></div>
	<!-- 设置 弹窗 -->
	<div class="s-setting-dialog js-dialog">
		<div class="s-title">
			<p class="s-title-name">
				<i></i> <span>设置</span>
			</p>
			<i class="s-close js-close-btn"></i>
		</div>
		<div class="s-setting-container">
			<form method="POST"
				action="/gmat/pre/practice/${questionId}"
				accept-charset="UTF-8" >
				<input name="_token" type="hidden"
					value="WskYEKeSTfjX3OXhlW2da8cf6cZut1WikCYsPC2m"> <input
					name="u" type="hidden" value="u1511355500987423">
				<ul class="s-label-list">
					<li>
						<p>选项设置：</p> <span class="s-option active"><label>

								<i class="inputRadio js-inputRadio active"></i><input
								type="radio" class="s-setting-radio" name="disorder" value="1"
								checked="">乱序显示
						</label></span> <span class="s-option"><label><i
								class="inputRadio js-inputRadio"></i><input type="radio"
								class="s-setting-radio" name="disorder" value="0">正常显示</label></span>
					</li>
					<li>
						<p>答案显示设置：</p> <span class="s-answer"><label><i
								class="inputRadio js-inputRadio"></i><input type="radio"
								class="s-setting-radio" name="showAnswer" value="1">每题显示答案</label></span>
						<span class="s-answer"><label><i
								class="inputRadio js-inputRadio active"></i><input type="radio"
								class="s-setting-radio" name="showAnswer" value="0" checked="">全部做完显示答案</label></span>
					</li>
					<li>
						<p>时间提醒设置：</p> 
						<span class="s-remind"><label>
						<i class="inputRadio js-inputRadio active"></i><input type="radio"
								class="s-setting-radio" name="isTimeLimit" value="0" checked="">不提醒</label></span>
						<span class="s-remind"><label><i
								class="inputRadio js-inputRadio"></i><input type="radio"
								class="s-setting-radio" name="timeLimit" value="180">大于3min提醒</label></span>
						<span class="s-remind js-tips-btn"><label><i
								class="inputRadio js-inputRadio"></i><input type="radio"
								class="s-setting-radio" name="timeLimit" value="0">大于pace时间提醒</label></span>（下题生效）
						<div class="s-tips-container">
							<i class="s-arrow"></i>
							<p>Pace：参照考试时间计算出的每题节奏区间</p>
						</div>
					</li>
				</ul>
			</form>
		</div>
		<div class="s-button-container">
			<span class="s-enter-btn js-setting-enter">确定</span> <span
				class="js-close-btn">取消</span>
		</div>
	</div>
	<!-- alert弹窗 -->
	<div class="s-alert-dialog js-dialog">
		<div class="s-alert-title ">
			<span>Answer Confirmation</span> <i class="s-close js-close-btn"></i>
		</div>
		<p class="s-dialog-msg">You cannot leave this question unanswered!</p>
		<div class="s-button-container">
			<p class="s-enter-btn js-close-btn">
				O<span>K</span>
			</p>
		</div>
	</div>
	<!-- confitm弹窗 -->
	<div class="s-confirm-dialog js-dialog">
		<div class="s-confirm-title">
			<span>Answer Confirmation</span> <i class="s-close js-close-btn"></i>
		</div>
		<p class="s-dialog-msg">Click Yes to confirm your answer and
			continue to the next question.</p>
		<div class="s-confirm-button-container">
			<div class="s-buttons">
				<p class="s-enter-btn js-enter-btn">
					<span>Y</span>es
				</p>
			</div>
			<div class="s-buttons active">
				<p class="s-enter-btn js-close-btn">
					<span>N</span>o
				</p>
			</div>
		</div>
	</div>
	<!-- 退出提醒弹窗 -->
	<div class="s-quit-dialog js-dialog">
		<div class="s-quit-title">
			<span>Quit Confirmation</span> <i class="s-close js-close-btn"></i>
		</div>
		<p class="s-dialog-msg">
			<i class="s-qiut"></i><span>Are you sure you want to quit?</span>
		</p>
		<div class="s-quit-button-container">
			<div class="s-buttons">
				<p class="s-enter-btn js-enter-btn">
					<span>Y</span>es
				</p>
			</div>
			<div class="s-buttons active">
				<p class="s-enter-btn js-close-btn">
					<span>N</span>O
				</p>
			</div>
		</div>
	</div>
	<!-- 帮助弹窗 -->
	<div class="s-help-dialog js-dialog">
		<div class="s-help-title">
			<p>
				<i class="s-help"></i>Help
			</p>
			<i class="s-close js-close-btn"></i>
		</div>
		<div class="s-help-msg-container">
			<ul class="s-help-msg-list">
				<li>右上角的时钟图标<i class="s-time"></i>点击可以打开和关闭计时器
				</li>
				<li>右上角的文件夹<i class="s-location"></i>点击可以打开和关闭当前题号
				</li>
				<li>登录后点击右上角的星星图标 <i class="s-collect"></i>，所有被收藏的题目均可在“我的记录”-“收藏夹”中找到
				</li>
				<li>题目操作相关设置，你可以点击 <i class="s-setting"></i>根据你自身练习需求进行相关调整
				</li>
				<li>点击右下角<i class="s-next"></i>图标可以进入下一题。注意：如果你没有做当前题目，你将不可以进入下一题
				</li>
				<li>点击左下角的 <i class="s-quit"></i>或<i class="s-end"></i> 即可退出练习
				</li>
				<li>更多帮助可以加入QQ群: 146060530 进行说明</li>
			</ul>
		</div>
		<div class="s-close-button-container">
			<div class="s-close-button js-close-btn">
				<i class="s-close"></i>

				<p>
					C<span>l</span>ose
				</p>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$("#js-next").on("click",function(){
		var answer=$("input[name='answer']:checked");
		if(!$(answer).val()){
			alert("请选择答案");
			return;
		}
		var showAnswer=$("#showAnswer").val();
		if(showAnswer!="1"){
			$("#questionForm").submit();
		}else{
			var right=$("#answer").val();
			$("#showAnswer").val("0");
			if(right==$(answer).val()){
				$(answer).parent().css("color","#6dcb66");
			}else{
				$(answer).parent().css("color","red");
				
				$("input[type='radio']").each(function(){
					if($(this).val()==right){
						$(this).parent().css("color","#6dcb66");
					}
					$(this).attr("disabled","true");
				});
				
				$("#questionForm").append('<input type="hidden" name="answer" value="'+answer+'">');
			}
		}
		
	});
	var limitTime=${config.limitTime};
	var secent=0;
	 setInterval(function () {
		secent=secent+1;
		if(limitTime<=secent){
			//alert("考试时间到了,确定提交试卷了！");
			//$("#js-next").click();
		}
		var text=formatSeconds2(secent);
		$("#overTime").val(secent);
		$("#js-time").find("span").text("Time cost "+text);
	},1000);
	
	$("#js-help").click(function(){
		$(".s-help-dialog").show();
	})
	
	$(".js-close-btn").click(function(){
		$(".s-help-dialog").hide();
	})
	$("#js-quit").click(function(){
		$(".s-quit-dialog").show();
	})
	$(".s-enter-btn").click(function(){
		$(".s-quit-dialog").show();
	})
	$(".s-close").click(function(){
		$(".s-quit-dialog").hide();
	})
	
	$(".js-enter-btn").click(function(){
		$("#overExem").val("1");//提交结束去看考试结果
		$("#questionForm").attr("action","${baseurl}/exam/exercise/selfresult/"+$("#exampaperGroupId").val()+"/"+$("#u").val());
		$("#questionForm").submit();
	})
	
</script>

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