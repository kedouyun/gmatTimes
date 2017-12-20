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
					<form id="ChangePass" class="form-horizontal" action="${baseurl}/user/password" method="post">
                    <div class="form-group">
                        <label for="Oldpass" class="tit"><em class="red">*</em>当前密码</label>
                        <div class="pull-left has-error">
                            <input type="password" class="form-control pull-left" id="Oldpass" name="oldpassword">
                        </div>
                        <span class="fl f12 has-error">密码不能为空</span>
                    </div>
                    <div class="form-group">
                        <label for="Pass" class="tit"><em class="red">*</em>新密码</label>
                        <div class="pull-left">
                            <input type="password" class="form-control pull-left" id="Pass" name="newpassword">
                        </div>
                        <span class="fl f12">
                            <span>密码长度应为6-20个字符</span>
                            <span class="clearfix"><b class="fl fn">强度：</b><em class="fl"><i></i><i></i><i></i></em></span>
                        </span>
                    </div>
                    <div class="form-group">
                        <label for="Repass" class="tit"><em class="red">*</em>确认密码</label>
                        <div class="pull-left">
                            <input type="password" class="form-control pull-left" id="Repass" name="re_newpassword">
                        </div>
                        <span class="fl f12">重新输入新密码</span>
                    </div>
                    <div class="form-group">
                        <label for="" class="tit"></label>
                        <div class="pull-left">
                            <button type="button" class="btn btn-submit">保存密码</button>
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