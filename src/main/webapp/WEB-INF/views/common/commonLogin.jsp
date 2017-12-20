<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<nav class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">GMATimes</a>
		</div>
		
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active">
					 <a href="#">GMAT题库</a>
				</li>
				<li>
					 <a href="#">GMAT课程</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${empty sessionScope.member}">
					<li>
						 <a href="${baseurl}/user/login">登陆</a>
					</li>
					<li>
						<a href="${baseurl}/user/register" >注册</a>
					</li>
				</c:if>
				
				<c:if test="${!empty sessionScope.member}">
					<li>
						<a href="${baseurl}/user/my/center">${sessionScope.member.username}</a>
					</li>
					<li class="dropdown">
					 <a href="#" class="dropdown-toggle" data-toggle="dropdown">我的<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							 <a href="#">我的课程</a>
						</li>
						<li>
							 <a href="${baseurl}/message/list">消息</a>
						</li>
						<li>
							 <a href="#">账号管理</a>
						</li>
						<li class="divider">
						</li>
						<li>
							 <a href="${baseurl}/user/exit">退出</a>
						</li>
					</ul>
				</li>
				</c:if>
			</ul>
		</div>
		
		
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active">
					 <a href="#">首页</a>
				</li>
				<li>
					 <a href="${baseurl}/learn/guide/all">备考指南</a>
				</li>
				<li>
					 <a href="${baseurl}/gmat/practice">练习</a>
				</li>
				<li>
					 <a href="${baseurl}/exam">模考</a>
				</li>
				<li>
					 <a href="#">换库机经</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					 我的GMAT
				</li>
			</ul>
		</div>
</nav>