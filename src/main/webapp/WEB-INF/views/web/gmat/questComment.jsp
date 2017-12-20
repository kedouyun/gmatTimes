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
		<div class="pattern-common  pattern  g-mod-shadow">
			<div class="sub-header g-clearfix" id="js-detail-headbar">
				<div class="header-title">题目内容</div>
				<div class="area-action">
					<ul class="list">
						<li><a href="javascript:void(0)" class="js-btn-fav"
							data-object="question" data-collect_id="3394" data-op="1"
							data-subject="2"> <span class="actionbg fav-ico"> </span><span
								class="text menu-text">收藏</span>
						</a></li>
						<li><a href="javascript:void(0)" class="js-open-error"
							data-type="2" data-qid="3394" data-title="纠错"
							data-json="{&quot;0&quot;:&quot;\u5176\u4ed6&quot;,&quot;4&quot;:&quot;\u9898\u76ee\u5185\u5bb9\u9519\u8bef&quot;,&quot;5&quot;:&quot;\u683c\u5f0f\u9519\u8bef&quot;,&quot;6&quot;:&quot;\u7b54\u6848\u9519\u8bef&quot;,&quot;7&quot;:&quot;\u89e3\u6790\u9519\u8bef&quot;}">
								<span class="actionbg modify-ico"></span> <span class="text">纠错</span>
						</a></li>
					</ul>
				</div>
			</div>
			<div class="dart">
				<div class="sub-content">
					<div class="text">
						${quest.title}
					</div>
					<ul class="options">
						<c:forEach items="${quest.choiceList}" var="list">
						<li>
							<label> 
								<span>${list.key}</span>
								${list.value}
							</label>
						</li>
						</c:forEach>
					</ul>
					<div class="show-answer-btn">显示答案</div>
					<div class="show-answer">
						正确答案: <span>D</span>
					</div>
				</div>
			</div>
			<div class="note-box js-note-box">
				<div class="note-cont js-add-note-cont">
					<p class="js-add-note i-add-note">
						<span></span> <i>添加做题笔记</i> <em class="change-em js-add-icon"></em>
					</p>
					<div class="note-textarea js-add-textarea-cont">
						<textarea id="js-add-textarea"
							placeholder="输入笔记内容,方便更好的理解题目,便于复习(1500字以内)" maxlength="1500"></textarea>
						<div class="js-note-btn">
							<a href="javascript:;" class="js-save-note">保存</a> <a
								href="javascript:;" class="js-cancel">取消</a>
						</div>
					</div>
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
				<!--选项卡-->
				<div class="entitled-discuss-comments" id="js-special-comment">
					<ul class="entitled-discuss-tab">
						<li class="entitled-discuss-btns js-entitled-tabs-btn active"
							data-type="2">优质讨论</li>
						<li class="entitled-discuss-btns js-entitled-tabs-btn"
							data-type="1">最新讨论</li>
					</ul>
				</div>
				<!--评论容器-->
				<div class="entitled-discuss-wrap">
					<!--评论输入框-->
					<div class="entitled-discuss-entry">
						<div class="entitled-user-photo">
							<img
								src="${baseurl}${sessionScope.member.headImage}"
								alt="用户头像">
						</div>
						<div class="entitled-textarea-container">
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
		<div class="i-detail-right  position-a ">

			<div class="g-smart-guide js-kmf-smart-guide"
				data-guideid="gmatweb_question_new_right_pic"></div>

			<div class="i-subject-item3 g-mod-shadow">
				<div class="base-info-bg">
					<p>题目基本信息</p>
				</div>
				<ul class="sub-info">
					<li>所属科目:逻辑CR</li>
					<li>题目来源1:PREP07 Test 1-1</li>
				</ul>
				<!--非awa-->
				<ul class="sub-level">
					<!--正确率/难度-->
					<li style="padding: 0 20px">正确率:<span>63% </span></li>
					<li style="padding: 0 20px">难度:<span> 难 </span></li>
				</ul>
			</div>
			<div class="g-smart-guide js-kmf-smart-guide"
				data-type="asideTextBox"
				data-guideid="gmatweb_question_new_right_wenzi"></div>
			<div class="i-subject-item5 g-mod-shadow">
				<div class="sub-new-answers-container">
					<h3>最新提问</h3>
					<div class="sub-answers-box">
						<ul class="sub-answers-list js-answer-list"
							style="top: -135.393px;">

							<li class="sub-answers-details-container" data-qid="45991"
								data-id="153330" data-uid="1509166">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/0f/0f82fc740f21a7f73b5209203c51f006.jpg"
											alt="佳l林jalo" title="佳l林jalo">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="佳l林jalo">佳l林jalo</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/60zhjk.html?cid=153330#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="45989"
								data-id="153329" data-uid="1509166">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/0f/0f82fc740f21a7f73b5209203c51f006.jpg"
											alt="佳l林jalo" title="佳l林jalo">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="佳l林jalo">佳l林jalo</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/dbzhhk.html?cid=153329#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="3814"
								data-id="153323" data-uid="1450301">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="不想被G杀" title="不想被G杀">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="不想被G杀">不想被G杀</span>
											<em>针对</em> <span class="sub-answers-subject">PS题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/b12xyk.html?cid=153323#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="1443"
								data-id="153321" data-uid="1211674">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="成名曲种太阳" title="成名曲种太阳">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="成名曲种太阳">成名曲种太阳</span>
											<em>针对</em> <span class="sub-answers-subject">CR题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/90143k.html?cid=153321#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="44"
								data-id="153320" data-uid="815560">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/3b/3b8d9bc4d9ad06af3af08f4340891775.jpg"
											alt="安大豆" title="安大豆">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="安大豆">安大豆</span> <em>针对</em>
											<span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/6f418h.html?cid=153320#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="23357"
								data-id="153300" data-uid="1557828">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/8f/8f21042011a6eb64bb72ea66f2c3749b.jpg"
											alt="Julia1128" title="Julia1128">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="Julia1128">Julia1128</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/edi0tk.html?cid=153300#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="139"
								data-id="153292" data-uid="1502164">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="我的骄傲无可救药" title="我的骄傲无可救药">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="我的骄傲无可救药">我的骄傲无可救药</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/c753vh.html?cid=153292#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="24477"
								data-id="153285" data-uid="1101903">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="vickyqiiiii" title="vickyqiiiii">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="vickyqiiiii">vickyqiiiii</span>
											<em>针对</em> <span class="sub-answers-subject">PS题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/7fivxk.html?cid=153285#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="21888"
								data-id="153277" data-uid="1150418">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/d0/d07db61bcfbb0815e23a06ef7c19392f.jpg"
											alt="emzheng" title="emzheng">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="emzheng">emzheng</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/5agw0k.html?cid=153277#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="45919"
								data-id="153275" data-uid="1684327">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="晚铃毓姝" title="晚铃毓姝">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="晚铃毓姝">晚铃毓姝</span>
											<em>针对</em> <span class="sub-answers-subject">DS题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/d4zfjk.html?cid=153275#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="45935"
								data-id="153274" data-uid="1684327">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="晚铃毓姝" title="晚铃毓姝">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="晚铃毓姝">晚铃毓姝</span>
											<em>针对</em> <span class="sub-answers-subject">DS题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/dezfzk.html?cid=153274#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="23037"
								data-id="153266" data-uid="1195955">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/dc/dcfa91570c927e4b731fa0c4a54d3c42.jpg"
											alt="winnieaam" title="winnieaam">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="winnieaam">winnieaam</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/7ahrxk.html?cid=153266#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="728"
								data-id="153253" data-uid="1240527">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="dgdugangan" title="dgdugangan">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="dgdugangan">dgdugangan</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/030k8h.html?cid=153253#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="45972"
								data-id="153249" data-uid="1204146">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/ae/ae7206273f9cebfc17da2fbaeafc0ea6.jpg"
											alt="l276988038" title="l276988038">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="l276988038">l276988038</span>
											<em>针对</em> <span class="sub-answers-subject">CR题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/8czh0k.html?cid=153249#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="23298"
								data-id="153240" data-uid="1298348">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/16/1602424f00fc35701537e25d0ee38b7d.jpg"
											alt="SgtSoap" title="SgtSoap">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="SgtSoap">SgtSoap</span>
											<em>针对</em> <span class="sub-answers-subject">CR题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/9dhz6k.html?cid=153240#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="1242"
								data-id="153225" data-uid="1053592">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="bilabilabiu" title="bilabilabiu">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="bilabilabiu">bilabilabiu</span>
											<em>针对</em> <span class="sub-answers-subject">CR题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/10fyih.html?cid=153225#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="3992"
								data-id="153194" data-uid="832246">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="文文文嘻嘻嘻" title="文文文嘻嘻嘻">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="文文文嘻嘻嘻">文文文嘻嘻嘻</span>
											<em>针对</em> <span class="sub-answers-subject">CR题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/eb32wk.html?cid=153194#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="660"
								data-id="153185" data-uid="1197391">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="Q版林黛玉" title="Q版林黛玉">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="Q版林黛玉">Q版林黛玉</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/f05ich.html?cid=153185#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="1"
								data-id="153173" data-uid="64462">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="yujinli" title="yujinli">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="yujinli">yujinli</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/c4ca1r.html?cid=153173#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="639"
								data-id="153163" data-uid="1240527">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="dgdugangan" title="dgdugangan">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="dgdugangan">dgdugangan</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/adahrh.html?cid=153163#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="45991"
								data-id="153330" data-uid="1509166">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/0f/0f82fc740f21a7f73b5209203c51f006.jpg"
											alt="佳l林jalo" title="佳l林jalo">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="佳l林jalo">佳l林jalo</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/60zhjk.html?cid=153330#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="45989"
								data-id="153329" data-uid="1509166">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/0f/0f82fc740f21a7f73b5209203c51f006.jpg"
											alt="佳l林jalo" title="佳l林jalo">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="佳l林jalo">佳l林jalo</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/dbzhhk.html?cid=153329#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="3814"
								data-id="153323" data-uid="1450301">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="不想被G杀" title="不想被G杀">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="不想被G杀">不想被G杀</span>
											<em>针对</em> <span class="sub-answers-subject">PS题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/b12xyk.html?cid=153323#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="1443"
								data-id="153321" data-uid="1211674">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="成名曲种太阳" title="成名曲种太阳">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="成名曲种太阳">成名曲种太阳</span>
											<em>针对</em> <span class="sub-answers-subject">CR题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/90143k.html?cid=153321#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="44"
								data-id="153320" data-uid="815560">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/3b/3b8d9bc4d9ad06af3af08f4340891775.jpg"
											alt="安大豆" title="安大豆">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="安大豆">安大豆</span> <em>针对</em>
											<span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/6f418h.html?cid=153320#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="23357"
								data-id="153300" data-uid="1557828">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/8f/8f21042011a6eb64bb72ea66f2c3749b.jpg"
											alt="Julia1128" title="Julia1128">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="Julia1128">Julia1128</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/edi0tk.html?cid=153300#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="139"
								data-id="153292" data-uid="1502164">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="我的骄傲无可救药" title="我的骄傲无可救药">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="我的骄傲无可救药">我的骄傲无可救药</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/c753vh.html?cid=153292#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="24477"
								data-id="153285" data-uid="1101903">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="vickyqiiiii" title="vickyqiiiii">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="vickyqiiiii">vickyqiiiii</span>
											<em>针对</em> <span class="sub-answers-subject">PS题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/7fivxk.html?cid=153285#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="21888"
								data-id="153277" data-uid="1150418">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/d0/d07db61bcfbb0815e23a06ef7c19392f.jpg"
											alt="emzheng" title="emzheng">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="emzheng">emzheng</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/5agw0k.html?cid=153277#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="45919"
								data-id="153275" data-uid="1684327">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="晚铃毓姝" title="晚铃毓姝">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="晚铃毓姝">晚铃毓姝</span>
											<em>针对</em> <span class="sub-answers-subject">DS题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/d4zfjk.html?cid=153275#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="45935"
								data-id="153274" data-uid="1684327">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="晚铃毓姝" title="晚铃毓姝">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="晚铃毓姝">晚铃毓姝</span>
											<em>针对</em> <span class="sub-answers-subject">DS题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/dezfzk.html?cid=153274#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="23037"
								data-id="153266" data-uid="1195955">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/dc/dcfa91570c927e4b731fa0c4a54d3c42.jpg"
											alt="winnieaam" title="winnieaam">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="winnieaam">winnieaam</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/7ahrxk.html?cid=153266#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="728"
								data-id="153253" data-uid="1240527">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="dgdugangan" title="dgdugangan">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="dgdugangan">dgdugangan</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/030k8h.html?cid=153253#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="45972"
								data-id="153249" data-uid="1204146">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/ae/ae7206273f9cebfc17da2fbaeafc0ea6.jpg"
											alt="l276988038" title="l276988038">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="l276988038">l276988038</span>
											<em>针对</em> <span class="sub-answers-subject">CR题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/8czh0k.html?cid=153249#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="23298"
								data-id="153240" data-uid="1298348">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img
											src="http://img.kmf.com/gre/bbs/16/1602424f00fc35701537e25d0ee38b7d.jpg"
											alt="SgtSoap" title="SgtSoap">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="SgtSoap">SgtSoap</span>
											<em>针对</em> <span class="sub-answers-subject">CR题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/9dhz6k.html?cid=153240#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="1242"
								data-id="153225" data-uid="1053592">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="bilabilabiu" title="bilabilabiu">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="bilabilabiu">bilabilabiu</span>
											<em>针对</em> <span class="sub-answers-subject">CR题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/10fyih.html?cid=153225#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="3992"
								data-id="153194" data-uid="832246">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="文文文嘻嘻嘻" title="文文文嘻嘻嘻">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="文文文嘻嘻嘻">文文文嘻嘻嘻</span>
											<em>针对</em> <span class="sub-answers-subject">CR题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/eb32wk.html?cid=153194#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="660"
								data-id="153185" data-uid="1197391">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="Q版林黛玉" title="Q版林黛玉">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="Q版林黛玉">Q版林黛玉</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/f05ich.html?cid=153185#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="1"
								data-id="153173" data-uid="64462">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="yujinli" title="yujinli">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="yujinli">yujinli</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/c4ca1r.html?cid=153173#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>

							<li class="sub-answers-details-container" data-qid="639"
								data-id="153163" data-uid="1240527">
								<dl class="sub-answers-shade">
									<dt class="sub-answers-photo">
										<img src="//code.kmf.com/dist/common/images/avatar.jpg"
											alt="dgdugangan" title="dgdugangan">
									</dt>
									<dd class="sub-answers-details">
										<p class="sub-answers-title">
											<span class="sub-answers-unsername" title="dgdugangan">dgdugangan</span>
											<em>针对</em> <span class="sub-answers-subject">SC题目</span>
										</p>
										<p class="sub-answers-msg-container">
											<span class="sub-answers-msg">发表了一个提问</span> <a
												class="sub-go-explain"
												href="/question/adahrh.html?cid=153163#js-special-comment"
												target="_self">去解答&gt;&gt;</a>
										</p>
									</dd>
								</dl>
							</li>
						</ul>
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
		              url: "${baseurl}/comment/gmat/save",
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