<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../../common/head.jsp"%>
      <link rel="stylesheet" href="//code.kmf.com/dist/common/css/channel/common_w.css?201711291103" type="text/css" />
      <link rel="stylesheet" href="//code.kmf.com/dist/newgmat/css/channel/exam/exam-list.css?201711291103" />
</head>
<body>

	<div class="g-kmf-wrapper g-clearfix">
                <div class="g-smart-guide js-kmf-smart-guide" data-guideid="gmatweb_exam_new_mubu_pic"></div>

        <div class="kmf-maincol">
            <div class="p-tab-detai g-mod-shadow">
                <!---->
                <div class="p-workbook-mod">
                    <div class="exam-top-explain">
                        <p class="exam-top-tit">模考练习</p>
                        <p class="exam-top-intr">模考建议：建议大家还是以PREP和GWD为主要模考材料，因为其更接近真实考试题目。模考练习时大家不要过于在意分数，尽量控制好PACE时间养成控制做题PACE的好习惯。考满分模考练习不仅完全还原仿真考试的全过程，还为你提供设置每题/每科目最小时长方式帮你控制PACE。</p>
                    </div>
                    <div class="pw-top-tab">
                        <c:forEach items="${exampaperList}" var="exam">
	                        <a class="pw-choiced" href="javascript:;" data-type="PREP">${exam.name }</a>
                        </c:forEach>
                    </div>
                   	<c:forEach items="${exampaperList}" var="exam" varStatus="status">
                   		<c:if test="${status.index==0}">
	                   		<div class="pw-exam-intr">${exam.remark } </div>
                   		</c:if>
                   		<c:if test="${status.index!=0}">
                   			<div class="pw-exam-intr" style="display:none;">${exam.remark } </div>
                   		</c:if>
                   	</c:forEach>
                    <div class="workbook-list-mod g-clearfix"><div class="wb-list-box g-clearfix">
    <div class="wb-list-content" id="js-view-list-cont">
	        
	        <c:forEach items="${queryGroupList}" var="group">
	        	<div class="wb-view-lists active">
		            <div class="pw-single-mod js-link-jump" data-link="${baseurl}/exam/before/${group.id}">
		                <div class="border-box " data-done="0" data-tot="0">
		                    <div class="pw-single-left g-clearfix">
		                        <p class="single-tit">${group.name }</p>
		                        <p class="pract-pnum">练习人数：40131</p>
		                    </div>
		                    <div class="pw-single-right">
		                        <a href="javascript:;" class="single-pen-btn"></a>
		                    </div>
		                    <div class="continue-hover-mod">
		                        <a class="jx-pract" href=""> </a>
		                    </div>
		                </div>
		            </div>
		        </div>
	        
	        </c:forEach>
	        <script type="text/javascript">
	        	$(".js-link-jump").click(function(){
	        		location.href=$(this).attr("data-link");
	        	});
	        </script>
	        
	        
	        
        <div class="wb-view-lists ">
            <table class="view-lists-table">
                <thead>
                <tr>
                    <td width="66">状态</td>
                    <td width="203">练习册名称</td>
                    <td width="107">做题人数</td>
                    <td width="100">平均得分</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                
                <tr class="view-lists-tr ">
                    <td class="border-box " data-done="0" data-tot="0">
                        <div class="pw-single-right">
                            
                            <a href="javascript:;" class="single-pen-btn"></a>
                            
                            
                        </div>
                        <span class="wb-view-progress t-num"></span>
                        <span class="wb-view-progress t-total"></span>
                    </td>
                    <td>PREP模考测试1</td>
                    <td>40131人</td>
                    <td>800分</td>
                    <td>
                        
                            <a class="jx-pract jump-link-btn" href="http://gmat.kmf.com/exam/pre/373">开始练习</a>
                        
                    </td>
                </tr>
                
                <tr class="view-lists-tr ">
                    <td class="border-box " data-done="0" data-tot="0">
                        <div class="pw-single-right">
                            
                            <a href="javascript:;" class="single-pen-btn"></a>
                            
                            
                        </div>
                        <span class="wb-view-progress t-num"></span>
                        <span class="wb-view-progress t-total"></span>
                    </td>
                    <td>PREP模考测试2</td>
                    <td>17340人</td>
                    <td>800分</td>
                    <td>
                        
                            <a class="jx-pract jump-link-btn" href="http://gmat.kmf.com/exam/pre/374">开始练习</a>
                        
                    </td>
                </tr>
                
                <tr class="view-lists-tr ">
                    <td class="border-box " data-done="0" data-tot="0">
                        <div class="pw-single-right">
                            
                            <a href="javascript:;" class="single-pen-btn"></a>
                            
                            
                        </div>
                        <span class="wb-view-progress t-num"></span>
                        <span class="wb-view-progress t-total"></span>
                    </td>
                    <td>PREP模拟测试3</td>
                    <td>13052人</td>
                    <td>800分</td>
                    <td>
                        
                            <a class="jx-pract jump-link-btn" href="http://gmat.kmf.com/exam/pre/375">开始练习</a>
                        
                    </td>
                </tr>
                
                <tr class="view-lists-tr ">
                    <td class="border-box " data-done="0" data-tot="0">
                        <div class="pw-single-right">
                            
                            <a href="javascript:;" class="single-pen-btn"></a>
                            
                            
                        </div>
                        <span class="wb-view-progress t-num"></span>
                        <span class="wb-view-progress t-total"></span>
                    </td>
                    <td>PREP模拟测试4</td>
                    <td>10804人</td>
                    <td>800分</td>
                    <td>
                        
                            <a class="jx-pract jump-link-btn" href="http://gmat.kmf.com/exam/pre/376">开始练习</a>
                        
                    </td>
                </tr>
                
                <tr class="view-lists-tr ">
                    <td class="border-box " data-done="0" data-tot="0">
                        <div class="pw-single-right">
                            
                            <a href="javascript:;" class="single-pen-btn"></a>
                            
                            
                        </div>
                        <span class="wb-view-progress t-num"></span>
                        <span class="wb-view-progress t-total"></span>
                    </td>
                    <td>PREP模拟测试5</td>
                    <td>9843人</td>
                    <td>800分</td>
                    <td>
                        
                            <a class="jx-pract jump-link-btn" href="http://gmat.kmf.com/exam/pre/377">开始练习</a>
                        
                    </td>
                </tr>
                
                <tr class="view-lists-tr ">
                    <td class="border-box " data-done="0" data-tot="0">
                        <div class="pw-single-right">
                            
                            <a href="javascript:;" class="single-pen-btn"></a>
                            
                            
                        </div>
                        <span class="wb-view-progress t-num"></span>
                        <span class="wb-view-progress t-total"></span>
                    </td>
                    <td>PREP模拟测试6</td>
                    <td>9569人</td>
                    <td>800分</td>
                    <td>
                        
                            <a class="jx-pract jump-link-btn" href="http://gmat.kmf.com/exam/pre/378">开始练习</a>
                        
                    </td>
                </tr>
                
                <tr class="view-lists-tr ">
                    <td class="border-box " data-done="0" data-tot="0">
                        <div class="pw-single-right">
                            
                            <a href="javascript:;" class="single-pen-btn"></a>
                            
                            
                        </div>
                        <span class="wb-view-progress t-num"></span>
                        <span class="wb-view-progress t-total"></span>
                    </td>
                    <td>PREP模拟测试7</td>
                    <td>7973人</td>
                    <td>800分</td>
                    <td>
                        
                            <a class="jx-pract jump-link-btn" href="http://gmat.kmf.com/exam/pre/379">开始练习</a>
                        
                    </td>
                </tr>
                
                <tr class="view-lists-tr ">
                    <td class="border-box " data-done="0" data-tot="0">
                        <div class="pw-single-right">
                            
                            <a href="javascript:;" class="single-pen-btn"></a>
                            
                            
                        </div>
                        <span class="wb-view-progress t-num"></span>
                        <span class="wb-view-progress t-total"></span>
                    </td>
                    <td>PREP模拟测试8</td>
                    <td>8869人</td>
                    <td>800分</td>
                    <td>
                        
                            <a class="jx-pract jump-link-btn" href="http://gmat.kmf.com/exam/pre/380">开始练习</a>
                        
                    </td>
                </tr>
                
                <tr class="view-lists-tr ">
                    <td class="border-box " data-done="0" data-tot="0">
                        <div class="pw-single-right">
                            
                            <a href="javascript:;" class="single-pen-btn"></a>
                            
                            
                        </div>
                        <span class="wb-view-progress t-num"></span>
                        <span class="wb-view-progress t-total"></span>
                    </td>
                    <td>PREP模拟测试9</td>
                    <td>12125人</td>
                    <td>800分</td>
                    <td>
                        
                            <a class="jx-pract jump-link-btn" href="http://gmat.kmf.com/exam/pre/381">开始练习</a>
                        
                    </td>
                </tr>
                
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
                </div>
            </div>
        </div>
        <!--排行榜-->
        <div class="kmf-asidecol">
            <div class="exam-ranking-list-cont g-mod-shadow">
                <p class="exam-ranking-title">模考排行榜</p>
                <div class="erank-pang-mod">
                    <p class="time-select-tit">模考时间筛选：</p>
                    <div class="left-select js-down">
                        <span class="default-val js-cur-datat" data-ctype="today">今日</span>
                        <span class="select-arrow"></span>
                        <ul class="rank-sel-down" style="">
                            <li class="time-list" data-type="week">上周</li>
                            <li class="time-list" data-type="yesterday">昨日</li>
                            <li class="time-list" data-type="today">今日</li>
                        </ul>
                    </div>
                </div>

                <div class="exam-ranking-content">

                <ul class="exam-ranking-lists">
    <!--第一名-->
                    <li class="exam-ranking-cont top-three">
            <!--头像名次-->
            <div class="exam-ranking-place  js-user-card " data-id="1669966" data-sty="topleft">
                <div class="exam-ranking-place-photo">
                    <img src="//code.kmf.com/dist/common/images/avatar.jpg" alt="//code.kmf.com/dist/common/images/avatar.jpg">
                </div>
                <p class="exam-ranking-place-msg number-1">No.1</p>
            </div>
            <!--用户名/科目-->
            <div class="exam-ranking-user-daitels">
                <p class="exam-ranking-username  js-user-card " data-id="1669966" data-sty="topleft" title="skinnyfats">
                    skinnyfats
                </p>
                <p class="exam-ranking-subject">PREP模拟测试4</p>
            </div>
            <!--分数-->
            <div class="exam-ranking-score-cont">
                <p class="exam-ranking-score">800</p>
                <span class="exam-ranking-score-msg">分</span>
            </div>
        </li>
        
                    <li class="exam-ranking-cont top-three">
            <!--头像名次-->
            <div class="exam-ranking-place  js-user-card " data-id="1396390" data-sty="topleft">
                <div class="exam-ranking-place-photo">
                    <img src="http://img.kmf.com/gre/bbs/27/27604bd9226e717537041e0c85b96dad.jpg" alt="http://img.kmf.com/gre/bbs/27/27604bd9226e717537041e0c85b96dad.jpg">
                </div>
                <p class="exam-ranking-place-msg number-2">No.2</p>
            </div>
            <!--用户名/科目-->
            <div class="exam-ranking-user-daitels">
                <p class="exam-ranking-username  js-user-card " data-id="1396390" data-sty="topleft" title="Quanta">
                    Quanta
                </p>
                <p class="exam-ranking-subject">PREP模拟测试4</p>
            </div>
            <!--分数-->
            <div class="exam-ranking-score-cont">
                <p class="exam-ranking-score">790</p>
                <span class="exam-ranking-score-msg">分</span>
            </div>
        </li>
        
                    <li class="exam-ranking-cont top-three">
            <!--头像名次-->
            <div class="exam-ranking-place  js-user-card " data-id="1072231" data-sty="topleft">
                <div class="exam-ranking-place-photo">
                    <img src="//code.kmf.com/dist/common/images/avatar.jpg" alt="//code.kmf.com/dist/common/images/avatar.jpg">
                </div>
                <p class="exam-ranking-place-msg number-3">No.3</p>
            </div>
            <!--用户名/科目-->
            <div class="exam-ranking-user-daitels">
                <p class="exam-ranking-username  js-user-card " data-id="1072231" data-sty="topleft" title="windy逸">
                    windy逸
                </p>
                <p class="exam-ranking-subject">TN模拟测试15</p>
            </div>
            <!--分数-->
            <div class="exam-ranking-score-cont">
                <p class="exam-ranking-score">780</p>
                <span class="exam-ranking-score-msg">分</span>
            </div>
        </li>
        
                    <li class="exam-ranking-cont top-three">
            <!--头像名次-->
            <div class="exam-ranking-place  js-user-card " data-id="1444683" data-sty="topleft">
                <div class="exam-ranking-place-photo">
                    <img src="//code.kmf.com/dist/common/images/avatar.jpg" alt="//code.kmf.com/dist/common/images/avatar.jpg">
                </div>
                <p class="exam-ranking-place-msg number-3">No.3</p>
            </div>
            <!--用户名/科目-->
            <div class="exam-ranking-user-daitels">
                <p class="exam-ranking-username  js-user-card " data-id="1444683" data-sty="topleft" title="xmu的tomorrow">
                    xmu的tomorrow
                </p>
                <p class="exam-ranking-subject">TN模拟测试19</p>
            </div>
            <!--分数-->
            <div class="exam-ranking-score-cont">
                <p class="exam-ranking-score">780</p>
                <span class="exam-ranking-score-msg">分</span>
            </div>
        </li>
        
                    <li class="exam-ranking-cont top-three">
            <!--头像名次-->
            <div class="exam-ranking-place  js-user-card " data-id="1068127" data-sty="topleft">
                <div class="exam-ranking-place-photo">
                    <img src="http://img.kmf.com/gre/bbs/df/dff1da8ae75bc490071c3f8666be02ba.jpg" alt="http://img.kmf.com/gre/bbs/df/dff1da8ae75bc490071c3f8666be02ba.jpg">
                </div>
                <p class="exam-ranking-place-msg number-3">No.3</p>
            </div>
            <!--用户名/科目-->
            <div class="exam-ranking-user-daitels">
                <p class="exam-ranking-username  js-user-card " data-id="1068127" data-sty="topleft" title="Iris蛋蛋蛋">
                    Iris蛋蛋蛋
                </p>
                <p class="exam-ranking-subject">PREP模拟测试7</p>
            </div>
            <!--分数-->
            <div class="exam-ranking-score-cont">
                <p class="exam-ranking-score">780</p>
                <span class="exam-ranking-score-msg">分</span>
            </div>
        </li>
        
                    <li class="exam-ranking-cont top-three">
            <!--头像名次-->
            <div class="exam-ranking-place  js-user-card " data-id="737293" data-sty="topleft">
                <div class="exam-ranking-place-photo">
                    <img src="//code.kmf.com/dist/common/images/avatar.jpg" alt="//code.kmf.com/dist/common/images/avatar.jpg">
                </div>
                <p class="exam-ranking-place-msg number-3">No.3</p>
            </div>
            <!--用户名/科目-->
            <div class="exam-ranking-user-daitels">
                <p class="exam-ranking-username  js-user-card " data-id="737293" data-sty="topleft" title="tym1993">
                    tym1993
                </p>
                <p class="exam-ranking-subject">GWD模拟测试02</p>
            </div>
            <!--分数-->
            <div class="exam-ranking-score-cont">
                <p class="exam-ranking-score">780</p>
                <span class="exam-ranking-score-msg">分</span>
            </div>
        </li>
        
                            <!--默认列表-->
            <li class="exam-ranking-cont ">
                <!--头像名次-->
                <div class="exam-ranking-place">
                    <p class="exam-ranking-place-msg">7</p>
                </div>
                <!--用户名/科目-->
                <div class="exam-ranking-user-daitels ">
                    <p class="exam-ranking-username  js-user-card " data-id="1609575" data-sty="topleft" title="applebanana777">
                        applebanana777
                    </p>
                </div>
                <!--分数-->
                <div class="exam-ranking-score-cont">
                    <p class="exam-ranking-score">770</p>
                    <span class="exam-ranking-score-msg">分</span>
                </div>
            </li>
        
                            <!--默认列表-->
            <li class="exam-ranking-cont ">
                <!--头像名次-->
                <div class="exam-ranking-place">
                    <p class="exam-ranking-place-msg">7</p>
                </div>
                <!--用户名/科目-->
                <div class="exam-ranking-user-daitels ">
                    <p class="exam-ranking-username  js-user-card " data-id="1611341" data-sty="topleft" title="uaenapmo">
                        uaenapmo
                    </p>
                </div>
                <!--分数-->
                <div class="exam-ranking-score-cont">
                    <p class="exam-ranking-score">770</p>
                    <span class="exam-ranking-score-msg">分</span>
                </div>
            </li>
        
                            <!--默认列表-->
            <li class="exam-ranking-cont ">
                <!--头像名次-->
                <div class="exam-ranking-place">
                    <p class="exam-ranking-place-msg">7</p>
                </div>
                <!--用户名/科目-->
                <div class="exam-ranking-user-daitels ">
                    <p class="exam-ranking-username  js-user-card " data-id="1671293" data-sty="topleft" title="王宇昊">
                        王宇昊
                    </p>
                </div>
                <!--分数-->
                <div class="exam-ranking-score-cont">
                    <p class="exam-ranking-score">770</p>
                    <span class="exam-ranking-score-msg">分</span>
                </div>
            </li>
        
                            <!--默认列表-->
            <li class="exam-ranking-cont ">
                <!--头像名次-->
                <div class="exam-ranking-place">
                    <p class="exam-ranking-place-msg">7</p>
                </div>
                <!--用户名/科目-->
                <div class="exam-ranking-user-daitels ">
                    <p class="exam-ranking-username  js-user-card " data-id="1430312" data-sty="topleft" title="smallbk413">
                        smallbk413
                    </p>
                </div>
                <!--分数-->
                <div class="exam-ranking-score-cont">
                    <p class="exam-ranking-score">770</p>
                    <span class="exam-ranking-score-msg">分</span>
                </div>
            </li>
        
    
    

</ul>
</div>

            </div>

                        <div class="g-smart-guide js-kmf-smart-guide" data-guideid="gmatweb_exam_new_right_pic"></div>

            <div class="exam-right-mod g-mod-shadow">       <p class="exam-right-tit">上次模考情况</p>
       
       <div class="pre-mock-info">
         <p class="pre-mock-tit">上次模考成绩 :
         </p>
         <p class="pre-mock-totnum">总分：--</p>
         <p class="pre-mock-vernum">Verbal：--</p>
         <p class="pre-mock-quanum">Quant：--</p>
         <p class="pre-mock-grow">成长值：--</p>

         
         <p class="no-login-btn">
           <a class="js-kmf-login" href="javscript:;">登录</a>
           后可见
         </p>
         
       </div>
       
       <div class="pre-mock-chart">
         <p class="mock-defal-tit">看看其他人的模考情况</p>
         
            <div class="no-login-predata"></div>
         
       </div>
       <div class="histry-info-mod">
       
         <p class="mock-info-word">GMAT考友鲅鱼饺子</p>
         <p class="mock-info-word">
           <span>790</span>
           分
         </p>
         <p class="mock-info-word">Verbal&amp;Quant共计耗时：53min15s</p>
         
       </div>


</div>


            <div class="my-mock-chart g-mod-shadow">
                <p class="mock-defal-tit">我的模考数据概览</p>
                <p class="mock-defal-more">模考一段时间后，可更好了解自己备考情况~</p>
                <div class="mock-chart-table" id="mock-chart-table"></div>
                <div class="my-mock-state js-nomock">
                    <img src="//code.kmf.com/dist/newgmat/css/img/exam/no-mock.jpg">
                    <p class="no-login-tips">这个人很懒，还有没进行过模考练习</p>
                </div>
                <div class="my-mock-state js-nologin" style="display: block;">
                    <img src="//code.kmf.com/dist/newgmat/css/img/exam/no-login.jpg">
                    <p class="no-login-tips"><a class="js-kmf-login" href="javascript:;">登录</a>后可以记录     你模考成长曲线哦~</p>
                </div>
            </div>
        </div>
    </div>

</body>
</html>