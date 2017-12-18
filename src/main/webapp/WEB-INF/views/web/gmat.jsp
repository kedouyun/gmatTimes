<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GMAT</title>
<%@ include file="../common/head.jsp"%>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<jsp:include page="../common/commonLogin.jsp"/>
			
			<div class="jumbotron">
				<h1>
					轮播图
				</h1>
				<p>
					This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
				</p>
				<p>
					 <a class="btn btn-primary btn-large" href="#">Learn more</a>
				</p>
			</div>
			
			
			<div class="row">
				<div class="col-md-6">
					<div class="thumbnail">
						<img alt="300x200" src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/600/200/city/default.jpg" />
						<div class="caption">
							<h3>
								GMAT题库
							</h3>
							<p>
								分题型练习，逐一击破，查缺补漏，更上一层楼。
							</p>
							<p>
								 <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="thumbnail">
						<img alt="300x200" src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/600/200/sports/default.jpg" />
						<div class="caption">
							<h3>
								GMAT课程
							</h3>
							<p>
								GMAT各科系统知识点梳理讲解，基础强化冲刺一体课程让备考更有效率。
							</p>
							<p>
								 <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			
			
		</div>
	</div>
</div>
</body>
</html>