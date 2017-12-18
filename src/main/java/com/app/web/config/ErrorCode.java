package com.app.web.config;

/**
 * 状态码+信息
 * 
 * @author guochao
 *
 */
public enum ErrorCode {

	SYS_ERROR_CODE_00001(00001, "请稍后重试"), //
	SYS_ERROR_CODE_00002(00002, "短信发送失败"), //
	SYS_ERROR_CODE_00003(00003, "验证码错误"), //
	SYS_ERROR_CODE_00004(00004, "用户已存在"), //
	SYS_ERROR_CODE_00005(00005, "用户不存在"), //
	SYS_ERROR_CODE_00006(00006, "手机号或密码不正确"), //
	SYS_ERROR_CODE_00007(00007, "登录已过期"), //
	SYS_ERROR_CODE_00008(8, "已支付过的订单"), //
	
	
	SYS_ERROR_CODE_10001(10001, "请稍后重试"), //
	SYS_ERROR_CODE_10002(10002, "短信发送失败"), //
	SYS_ERROR_CODE_10003(10003, "验证码错误"), //
	SYS_ERROR_CODE_10004(10004, "用户已存在"), //
	SYS_ERROR_CODE_10005(10005, "用户不存在"), //
	SYS_ERROR_CODE_10006(10006, "手机号或密码不正确"), //
	SYS_ERROR_CODE_10007(10007, "未登录"), //

	
	
	SYS_ERROR_CODE_400(400, "不正确的请求"), //
	SYS_ERROR_CODE_404(404, "找不到页面"), //
	SYS_ERROR_CODE_405(405, "服务器错误"), //
	SYS_ERROR_CODE_500(500, "内部服务器错误"), //

	SYS_ERROR_CODE_501(501, "无操作权限"), //
	SYS_ERROR_CODE_502(502, "参数错误"), //

	ERROR_CODE_SUCCESS(200, "ok");//

	public int value;
	public String message;

	ErrorCode(int value, String message) {
		this.value = value;
		this.message = message;
	}

}
