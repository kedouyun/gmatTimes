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
			<div class="row">
				<div class="col-md-15">
					<div class="thumbnail">
						<div class="caption">
							<h3>
								<img src="${baseurl}${sessionScope.member.headImage}" alt="用户头像" width="50">
								${sessionScope.member.username}
								历史做题数量:${sessionScope.member.practiceTotal}
								累计练习天数:${sessionScope.member.practiceDay}
							</h3>
						</div>
					</div>
				</div>
				
				<div class="col-md-15">
					<div class="thumbnail">
						<div class="caption">
							<h3>
								距离**年**月**的考试:<fmt:formatDate value="${sessionScope.member.examDate }" type="date" pattern="yyyy-MM-dd"/>
								剩余：<span id="date"></span>天
								考试目标分：${sessionScope.member.examTarget }
							</h3>
						</div>
					</div>
				</div>
				<div class="col-md-15">
					<div class="thumbnail">
						<div class="caption">
							<h3>
							
								<form action="${baseurl}/user/saveUserTarget" id="reg_testdate" name="reg_testdate">
									<select name="YYYY" onChange="YYYYDD(this.value)">
										<option value="">请选择 年</option>
									</select>
									<select name="MM" onChange="MMDD(this.value)">
										<option value="">选择 月</option>
									</select>
									<select name="DD">
										<option value="">选择 日</option>
									</select>
									目标分数：<input type="text" name="score" value="600">
									<button type="button" class="btn-b">提交</button>
								</form>
							</h3>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${baseurl}/js/member.js"></script>

<script language="JavaScript"> 
var target="<fmt:formatDate value="${sessionScope.member.examDate }" type="date" pattern="yyyy-MM-dd"/>";
$("#date").text(getTime2Time(target,getNowFormatDate()));
function getTime2Time($time1, $time2)
{
    var time1 = arguments[0], time2 = arguments[1];
    time1 = Date.parse(time1)/1000;
    time2 = Date.parse(time2)/1000;
    var time_ = time1 - time2;
    return (time_/(3600*24));
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
    return currentdate;
}
function YYYYMMDDstart(){   
	MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];   
	
	//先给年下拉框赋内容   
	var y  = new Date().getFullYear();  
	for (var i = (y); i < (y+5); i++) //以今年为准，前30年，后30年   
		   document.reg_testdate.YYYY.options.add(new Option(" "+ i +" 年", i));   
	
	//赋月份的下拉框   
	for (var i = 1; i < 13; i++)   
		   document.reg_testdate.MM.options.add(new Option(" " + i + " 月", i));   
	
	document.reg_testdate.YYYY.value = y;   
	document.reg_testdate.MM.value = new Date().getMonth() + 1;   
	var n = MonHead[new Date().getMonth()];   
	if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;   
		writeDay(n); //赋日期下拉框Author:meizz   
	document.reg_testdate.DD.value = new Date().getDate();   
}   
if(document.attachEvent)   
	window.attachEvent("onload", YYYYMMDDstart);   
else   
window.addEventListener('load', YYYYMMDDstart, false);   
function YYYYDD(str) //年发生变化时日期发生变化(主要是判断闰平年)   
{   
	var MMvalue = document.reg_testdate.MM.options[document.reg_testdate.MM.selectedIndex].value;   
	if (MMvalue == ""){ var e = document.reg_testdate.DD; optionsClear(e); return;}   
	var n = MonHead[MMvalue - 1];   
	if (MMvalue ==2 && IsPinYear(str)) n++;   
	writeDay(n)   
}   
function MMDD(str)   //月发生变化时日期联动   
{   
	var YYYYvalue = document.reg_testdate.YYYY.options[document.reg_testdate.YYYY.selectedIndex].value;   
	if (YYYYvalue == ""){ var e = document.reg_testdate.DD; optionsClear(e); return;}   
	var n = MonHead[str - 1];   
	if (str ==2 && IsPinYear(YYYYvalue)) n++;   
	writeDay(n)   
}   
function writeDay(n)   //据条件写日期的下拉框   
{   
	var e = document.reg_testdate.DD; optionsClear(e);   
	for (var i=1; i<(n+1); i++)   
	e.options.add(new Option(" "+ i + " 日", i));   
}   
function IsPinYear(year)//判断是否闰平年   
{
	return(0 == year%4 && (year%100 !=0 || year%400 == 0));
}   
function optionsClear(e)   
{   
	e.options.length = 1;   
}   
</script>

</body>
</html>