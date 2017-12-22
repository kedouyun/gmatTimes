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
					<!--评论展示容器-->
					<div class="entitled-discuss-content">
						<div class="discuss-comment-main">
							<!-- 铸铁 -->
							<div class="discuss-comment-item" data-pid="${bbs.id}">
								<!-- 当前楼层内容 -->
								<div class="discuss-item g-clearfix" data-tid="${bbs.id}">
									<!--头像信息容器-->
									<div class="user-photo-details">
										<!--头像容器-->
										<div class="user-photo-container">
											<img src="${baseurl}${bbs.headImage}"
												alt="PriscillaWEI" class="user-head-img js-user-cards fl">
										</div>
									</div>
									<div class="fl user-head-info">
										<h3 class="user-head-name">
											<b class="js-user-cards">${bbs.memberName}</b>
										</h3>
										<p class="user-head-msg">${bbs.content}</p>
										<div class="user-message-main g-clearfix">
											<!--赞/踩/回复-->
											<div class="user-message-btns-container" data-op="-1">
												<span class="user-praised is-icon-praised "> <i
													class="is-praised user-praised-icons"></i> <b>赞</b> <em
													class="praise-num">${bbs.faver}</em>
												</span> <span class="user-trample is-icon-trample "> <i
													class="is-trample user-praised-icons"></i> <b>踩</b> <em
													class="praise-num">0</em>
												</span> <span class="user-reply g-clearfix "> <i
													class="is-reply user-praised-icons"></i> <b>回复</b>
												</span>
											</div>
										</div>
										<div class="user-responses-wrap g-clearfix" data-qid="${bbs.memberId}">
											<textarea class="user-reply-msg"></textarea>
											<a href="javascript:;" class="user-responses-confirm">回复</a>
											<a href="javascript:;" class="user-responses-cancel">取消</a>
											<p class="user-responses-prohibit"></p>
										</div>
									</div>
								</div>
								<div class="discuss-item-reply-content">
									<!-- 回复内容楼 -->
									<c:forEach items="${page.commentList }" var="page">
											<div class="discuss-item g-clearfix" data-tid="${page.id}">
												<div class="user-photo-details">
													<!--头像容器-->
													<div class="user-photo-container">
														<img src="${baseurl}${page.headImage}"
															alt="fzjj" class="user-head-img js-user-cards fl">
													</div>
												</div>
												<div class="fl user-head-info">
													<h3 class="user-head-name">
														<b class="js-user-cards">${page.memberName}</b> <em class="is-tips-two">回复</em>
														<b class="js-user-cards" data-id="">${page.toMemberName}</b>
		
													</h3>
													<p class="user-head-msg">${page.content}</p>
													<div class="user-message-main g-clearfix">
														<!--赞/踩/回复-->
														<div class="user-message-btns-container" data-op="-1">
															<span class="user-praised is-icon-praised "> <i
																class="is-praised user-praised-icons"></i> <b>赞</b> <em
																class="praise-num">9</em>
															</span> <span class="user-trample is-icon-trample "> <i
																class="is-trample user-praised-icons"></i> <b>踩</b> <em
																class="praise-num">0</em>
															</span> <span class="user-reply g-clearfix"> <i
																class="is-reply user-praised-icons"></i> <b>回复</b>
															</span>
														</div>
														<!--日期/举报-->
														<div class="user-message-dates-container">
															<span class="user-send-time">2017-03-26 22:46:10</span> <span
																class="user-praised is-icon-reports"> <i
																class="is-reports user-praised-icons"></i> <b>举报</b>
		
																<ul class="user-reports-list g-mod-shadow"
																	style="display: none;">
		
																	<li data-type="1">广告等垃圾信息</li>
		
																	<li data-type="2">不文明内容</li>
		
																	<li data-type="3">与主题无关</li>
		
																	<li data-type="4">其他应该删除的内容</li>
		
																</ul>
		
															</span>
														</div>
													</div>
													<div class="user-responses-wrap g-clearfix" data-qid="${page.memberId}">
														<textarea class="user-reply-msg" maxlength="400"></textarea>
														<a href="javascript:;" class="user-responses-confirm">回复</a>
														<a href="javascript:;" class="user-responses-cancel">取消</a>
														<p class="user-responses-prohibit"></p>
													</div>
												</div>
											</div>
										</c:forEach>
								</div>
							</div>
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
										<p class="user-head-msg">${page.content}</p>
										<div class="user-message-main g-clearfix">
											<!--赞/踩/回复-->
											<div class="user-message-btns-container" data-op="-1">
												<span class="user-praised is-icon-praised "> <i
													class="is-praised user-praised-icons"></i> <b>赞</b> <em
													class="praise-num">${page.faver}</em>
												</span> <span class="user-trample is-icon-trample "> <i
													class="is-trample user-praised-icons"></i> <b>踩</b> <em
													class="praise-num">0</em>
												</span> <span class="user-reply g-clearfix "> <i
													class="is-reply user-praised-icons"></i> <b>回复</b>
												</span>
											</div>
											<!--日期/举报-->
											<div class="user-message-dates-container">
												<span class="user-send-time"><fmt:formatDate value="${page.createDate}" type="date" pattern="yyyy-MM-dd HH:mm"/></span> <span
													class="user-praised is-icon-reports"> <i
													class="is-reports user-praised-icons"></i> <b>举报</b>

													<ul class="user-reports-list g-mod-shadow" style="display: none;">
														<li data-type="1">广告等垃圾信息</li>
														<li data-type="2">不文明内容</li>
														<li data-type="3">与主题无关</li>
														<li data-type="4">其他应该删除的内容</li>
													</ul>

												</span>
											</div>
										</div>
										<div class="user-responses-wrap g-clearfix" data-qid="${page.memberId}">
											<textarea class="user-reply-msg"></textarea>
											<a href="javascript:;" class="user-responses-confirm">回复</a>
											<a href="javascript:;" class="user-responses-cancel">取消</a>
											<p class="user-responses-prohibit"></p>
										</div>
									</div>
								</div>
								<div class="discuss-item-reply-content">
									<!-- 回复内容楼 -->
									<c:forEach items="${page.commentList }" var="page">
											<div class="discuss-item g-clearfix" data-tid="${page.id}">
												<div class="user-photo-details">
													<!--头像容器-->
													<div class="user-photo-container">
														<img src="${baseurl}${page.headImage}"
															alt="fzjj" class="user-head-img js-user-cards fl">
													</div>
												</div>
												<div class="fl user-head-info">
													<h3 class="user-head-name">
														<b class="js-user-cards">${page.memberName}</b> <em class="is-tips-two">回复</em>
														<b class="js-user-cards" data-id="">${page.toMemberName}</b>
		
													</h3>
													<p class="user-head-msg">${page.content}</p>
													<div class="user-message-main g-clearfix">
														<!--赞/踩/回复-->
														<div class="user-message-btns-container" data-op="-1">
															<span class="user-praised is-icon-praised "> <i
																class="is-praised user-praised-icons"></i> <b>赞</b> <em
																class="praise-num">9</em>
															</span> <span class="user-trample is-icon-trample "> <i
																class="is-trample user-praised-icons"></i> <b>踩</b> <em
																class="praise-num">0</em>
															</span> <span class="user-reply g-clearfix"> <i
																class="is-reply user-praised-icons"></i> <b>回复</b>
															</span>
														</div>
														<!--日期/举报-->
														<div class="user-message-dates-container">
															<span class="user-send-time">2017-03-26 22:46:10</span> <span
																class="user-praised is-icon-reports"> <i
																class="is-reports user-praised-icons"></i> <b>举报</b>
		
																<ul class="user-reports-list g-mod-shadow"
																	style="display: none;">
		
																	<li data-type="1">广告等垃圾信息</li>
		
																	<li data-type="2">不文明内容</li>
		
																	<li data-type="3">与主题无关</li>
		
																	<li data-type="4">其他应该删除的内容</li>
		
																</ul>
		
															</span>
														</div>
													</div>
													<div class="user-responses-wrap g-clearfix" data-qid="${page.memberId}">
														<textarea class="user-reply-msg" maxlength="400"></textarea>
														<a href="javascript:;" class="user-responses-confirm">回复</a>
														<a href="javascript:;" class="user-responses-cancel">取消</a>
														<p class="user-responses-prohibit"></p>
													</div>
												</div>
											</div>
										</c:forEach>
								</div>
							</div>
						</c:forEach>

						</div>
						<!-- 页码容器 -->
						<div class="discuss-content-totalPage" page-total="9"
							page-current="1">
							<div class="g-kmf-page ">
								<a class="prev prev-disabled" href="javascript:void(0)"><span
									class="arrow"></span>上一页</a> <a href="javascript:void(0)"
									class="kmf-page current">1</a> <a href="javascript:void(0)"
									class="kmf-page">2</a> <a href="javascript:void(0)"
									class="kmf-page">3</a> <a href="javascript:void(0)"
									class="kmf-page">4</a> <a href="javascript:void(0)"
									class="kmf-page">5</a> <span>...</span> <a
									href="javascript:void(0)" class="kmf-page">9</a> <a
									class="next" href="javascript:void(0)"><span class="arrow"></span>下一页</a>
							</div>

						</div>
					</div>
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
		              data:{content:temp,questionId:$("#questionId").val()},
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
		              url: "${baseurl}/through/jijigng/save",
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
	              url: "${baseurl}/through/jijigng/faver",
	              data:{bbsId:dataId},
	              dataType: "json",
	              success: function(r){
	            	  console.log(JSON.stringify(r));
	              }
			  });
		});
		
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