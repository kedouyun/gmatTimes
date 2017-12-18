<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>GMATimes后台管理系统</title>
  <meta name="keywords" content="sbed">
  <meta name="description" content="sbed开发平台">
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" type="image/x-icon" href="../favicon.ico">
  <link rel="stylesheet" href="../manger/css/bootstrap.min.css">
  <link rel="stylesheet" href="../manger/css/font-awesome.min.css">
  <link rel="stylesheet" href="../manger/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../manger/css/all-skins.min.css">
  <link rel="stylesheet" href="../manger/css/main.css">
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="../manger/libs/html5shiv.min.js"></script>
  <script src="../manger/libs/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box" id="rapp" v-cloak>
  <div class="login-logo">
    <b>GMATimes管理系统</b>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
      <p class="login-box-msg">管理员登录</p>
      <div v-if="error" class="alert alert-danger alert-dismissible">
        <h4 style="margin-bottom: 0px;"><i class="fa fa-exclamation-triangle"></i> {{errorMsg}}</h4>
      </div>
      <div class="form-group has-feedback">
          <input type="text" class="form-control" v-model="username" placeholder="账号">
          <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="password" class="form-control" v-model="password" placeholder="密码" @keyup.enter="login">
          <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div v-show="errorTimes>=3">
          <div class="form-group has-feedback">
              <input type="text" class="form-control" v-model="captcha" placeholder="验证码" @keyup.enter="login">
              <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
              <img alt="如果看不清楚，请单击图片刷新！" class="pointer" :src="src" @click="refreshCode">
              &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" @click="refreshCode">点击刷新</a>
          </div>
      </div>

      <div class="row">
        <div class="col-xs-8">
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" class="btn btn-primary btn-block btn-flat" @click="login">登录</button>
        </div>
        <!-- /.col -->
      </div>
    <!-- /.social-auth-links -->

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<script src="../manger/libs/jquery.min.js"></script>
<script src="../manger/plugins/jqgrid/jquery.jqGrid.min.js"></script>
<script src="../manger/libs/vue.min.js"></script>
<script src="../manger/libs/bootstrap.min.js"></script>
<script src="../manger/libs/app.js"></script>
<script src="../manger/js/common.js"></script>
<script type="text/javascript">
var vm = new Vue({
	el:'#rapp',
	data:{
		username: '',
		password: '',
        captcha: '',
		error: false,
		errorMsg: '',
        src: baseURL + 'captcha.jpg',
        errorTimes: 0
	},
	beforeCreate: function(){
		if(self != top){
			top.location.href = self.location.href;
		}
	},
	methods: {
        refreshCode: function(){
            this.src = baseURL + "captcha.jpg?t=" + $.now();
        },
		login: function () {
            var data = "username="+vm.username+"&password="+vm.password+"&error="+vm.error+"&captcha="+vm.captcha;
			$.ajax({
				type: "POST",
			    url:  "../manger/login.do",
			    data: data,
			    dataType: "json",
			    success: function(r){
					if(r.code == 0){//登录成功
                        localStorage.setItem("token", r.token);
                        parent.location.href ='../manger/home.do';
					}else{
						vm.error = true;
						vm.errorMsg = r.msg;
                        vm.errorTimes=r.errorTimes;
                        vm.refreshCode();
					}
				}
			});
		},
        getLoginErrorTimes: function () {
            $.get("../manger/sys/getLoginErrorTimes", function(r){
                vm.errorTimes=r.errorTimes;
            });
        }
	},
    created: function () {
        this.getLoginErrorTimes();
    }
});
</script>
</body>
</html>
