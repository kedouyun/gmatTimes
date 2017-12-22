<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GMAT</title>
<%@ include file="../../common/head.jsp"%>
  <link rel="stylesheet" href="//code.kmf.com/dist/common/css/channel/common_w.css?201711291103" type="text/css" />
         <link rel="stylesheet" href="//code.kmf.com/dist/newgmat/css/channel/questionlib/lib-detail.css?201711291103" />
<script
	src="//cdn.bootcss.com/mathjax/2.7.0/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
</head>
<body>
	<input type="hidden" id="questionId" value="${questionId}">
	
	<div class="g-kmf-wrapper g-clearfix">
		<div class="g-detail-header">
			<div class="header-cont g-clerafix">
				<div class="title">
					<a href="/question">题库</a> &gt; <span> <a
						href="/question/cr">逻辑CR</a>
					</span> &gt; <span class="active">题目062mak</span>
				</div>
			</div>
		</div>

		<!--题目详情页左侧区域-->
		<div class="i-detail-left">
			<div class="g-smart-guide js-kmf-smart-guide"
				data-guideid="gmatweb_question_new_left_pic"></div>
			<!--题目解析-->
			
			<input type="hidden" id="report"
				value="{&quot;1&quot;:&quot;\u5e7f\u544a\u7b49\u5783\u573e\u4fe1\u606f&quot;,&quot;2&quot;:&quot;\u4e0d\u6587\u660e\u5185\u5bb9&quot;,&quot;3&quot;:&quot;\u4e0e\u4e3b\u9898\u65e0\u5173&quot;,&quot;4&quot;:&quot;\u5176\u4ed6\u5e94\u8be5\u5220\u9664\u7684\u5185\u5bb9&quot;}">
			<div class="i-entitled-discuss g-mod-shadow">
				<div class="entitled-discuss-top">
					<h3>题目讨论</h3>
					<p>如果对题目有疑问，欢迎来提出你的问题，热心的小伙伴会帮你解答。</p>
				</div>
				<!--评论容器-->
				<div class="entitled-discuss-wrap">
					<div class="entitled-discuss-content">
						<div class="discuss-comment-main">
						<c:forEach items="${ pageInfo.list}" var="page">
							<div class="discuss-comment-item" data-pid="${page.id}">
								<!-- 当前楼层内容 -->
								<div class="discuss-item g-clearfix" data-tid="${page.id}">
									<!--头像信息容器-->
									<div class="user-photo-details">
										<!--头像容器-->
										<div class="user-photo-container">
											<img src="${baseurl}${page.headImage}"
												alt="PriscillaWEI" class="user-head-img js-user-cards fl">
										</div>
									</div>
									<div class="fl user-head-info">
										<h3 class="user-head-name">
											<b class="js-user-cards">${page.memberName}</b>
										</h3>
										<a class="user-head-msg" href="${baseurl}/through/detailList/${page.id}">${page.title}</a>
										<p class="user-head-msg">${page.content}</p>
									</div>
								</div>
								<div class="discuss-item-reply-content">
									<!-- 回复内容楼 -->
									
								</div>
							</div>
						</c:forEach>

						</div>
					</div>
					
					
					<!--评论输入框-->
					<div class="entitled-discuss-entry">
						<div class="entitled-user-photo">
							<img
								src="${baseurl}${sessionScope.member.headImage}"
								alt="用户头像">
						</div>
						<div class="entitled-textarea-container">
							<input type="text" name="title" id="title">
							<textarea class="user-discuss-entry" maxlength="400"
								placeholder="我要提问/表达观点……（限400字）"></textarea>
							<div class="user-discuss-change g-clearfix">
								<div class="user-discuss-change-details">
									<span class="count js-count">已经输入<em class="cur-count">0</em>个字
									</span> <label class="user-discuss-options"> <i
										class="inputCheckbox js-inputCheckbox"></i><input
										type="checkbox" name=""
										class="user-discuss-checkbox js-inputCheckbox"> <span
										class="user-discuss-tips">标记为提问，会有更多小伙伴帮你解答</span>
									</label>
								</div>
								<a href="javascript:;" class="discuss-change-r ">发表</a>
							</div>
						</div>
					</div>
					
					<!--评论展示容器-->
					
				</div>
			</div>
		</div>
		
	</div>
	<script type="text/javascript">
		$(".discuss-change-r").click(function(){
			var temp=$(".user-discuss-entry").val().trim();
			
			if(temp){
				  $.ajax({
		              type: "POST",
		              url: "${baseurl}/through/jijigng/save",
		              data:{content:temp,questionId:$("#questionId").val(),title:$("#title").val()},
		              dataType: "json",
		              success: function(r){
		            	  console.log(r.toString());
		              }
				  });
				$(".user-discuss-entry").val("");
			}
		});
	
		$(".user-reply").click(function(){
			if($(this).parent().parent().next().css("height")=="144px"){
				$(this).parent().parent().next().css("height","0");
			}else{
				$(this).parent().parent().next().css("height","144px");
			}
		});
		
		$(".user-responses-confirm").click(function(){
			var temp=$(this).prev().val().trim();
			var data_pid=$(this).parent().parent().parent().parent().attr("data-pid");//评论id
			if(data_pid==null){
				data_pid=$(this).parent().parent().parent().parent().parent().attr("data-pid");
			}
			var to_memberId=$(this).parent().attr("data-qid");
			if(temp){
				$.ajax({
		              type: "POST",
		              url: "${baseurl}/comment/gmat/save",
		              data:{content:temp,questionId:$("#questionId").val(),toMemberId:to_memberId,parentId:data_pid},
		              dataType: "json",
		              success: function(r){
		            	  console.log(r.toString());
		              }
				  });
			}
		})
		
		$(".user-praised").click(function(){
			var dataId=$(this).parent().parent().parent().parent().attr("data-tid");
			debugger;
			$.ajax({
	              type: "POST",
	              url: "${baseurl}/comment/gmat/faver",
	              data:{commentId:dataId},
	              dataType: "json",
	              success: function(r){
	            	  console.log(r.toString());
	              }
			  });
		});
		
	</script>
</body>
</html>