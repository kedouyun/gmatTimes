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
	<input type="hidden" id="urlpath" value="${baseurl}">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="container">
					<form id="Register" class="form-horizontal" action="${baseurl}/user/email" method="post">
                    <div class="form-group">
                        <label for="Oldpass" class="tit"><em class="red">*</em>邮箱</label>
                        <div class="pull-left has-error">
                            <input type="text" class="form-control pull-left" id="email" name="email">
                        </div>
                    </div>
                    <div class="form-group">
						 <input type="text" name="code" class="form-control" />
						 <img alt="验证码" src="${baseurl}/get_registerCheckNum" class="js_registerCheckNum">
					</div>
                    
                    <div class="form-group">
                        <label for="" class="tit"></label>
                        <div class="pull-left">
                            <button type="button" class="btn btn-b">立即绑定</button>
                        </div>
                    </div>
                </form>
				</div>
		</div>
	</div>	
</div>

<script type="text/javascript" src="${baseurl}/js/member.js"></script>

</body>
</html>