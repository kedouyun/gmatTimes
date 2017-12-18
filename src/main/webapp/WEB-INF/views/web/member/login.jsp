<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<%@ include file="../../common/head.jsp"%>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="container">
					<div class="row clearfix" style="margin-top: 3%;">
						<div class="col-md-6 column">
							<div class="jumbotron">
								<h1>
									Hello, world!
								</h1>
								<p>
									This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
								</p>
								<p>
									 <a class="btn btn-primary btn-large" href="#">Learn more</a>
								</p>
							</div>
						</div>
						<div class="col-md-6 column">
							<!--  -->
								<div class="tabbable" id="tabs-872286">
									<ul class="nav nav-tabs">
									<!-- 	<li >
											 <a href="#panel-58645" data-toggle="tab">手机注册</a>
										</li> -->
										<li class="active">
											 <a href="#panel-145802" data-toggle="tab">登陆</a>
										</li>
									</ul>
									<div class="tab-content">
										<!-- <div class="tab-pane " id="panel-58645">
											<form role="form" action="/user/login">
												<div class="form-group">
													 <label for="exampleInputEmail1"></label><input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入手机号"/>
												</div>
												<div class="form-group">
													<input type="password" class="form-control" id="exampleInputPassword1" />
												</div>
												<div class="checkbox">
													 <label><input type="checkbox" />Check me out</label>
												</div> <button type="submit" class="btn btn-default">Submit</button>
											</form>
										</div> -->
										<div class="tab-pane active" id="panel-145802">
											<form role="form" action="${baseurl}/user/loginAction"  method="POST">
												<div class="form-group">
													<input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="请输入邮箱"/>
													<!--  <label for="exampleInputEmail1">邮箱注册</label> -->
												</div>
												<div class="form-group">
													 <input type="password" name="password" class="form-control" id="exampleInputPassword1" />
												</div>
												<div class="checkbox">
												</div> 
												<button type="submit" class="btn btn-default">登陆</button>
												<a href="/user/forgot" class="btn btn-default">忘记密码</a>
											</form>	
										</div>
									</div>
								</div>	
							<!--  -->
							
						</div>
					</div>
				</div>
		</div>
	</div>
</div>
</body>
</html>