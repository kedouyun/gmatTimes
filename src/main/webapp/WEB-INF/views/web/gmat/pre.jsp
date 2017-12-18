<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GMAT</title>
<%@ include file="../../common/head.jsp"%>
<link rel="stylesheet" type="text/css" href="${baseurl}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${baseurl}/css/pre.css" />
<script src="//cdn.bootcss.com/mathjax/2.7.0/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
</head>
<body>
<div class="s-gmat-main" style=" visibility: visible;">
        <div class="s-gmat-logo"></div>
        <!-- 顶部标题/时间等信息 -->
        <div class="s-gmat-header">
            <div class="s-header-left">[练习]：${grammarGroup.name }</div>
        </div>
        <div class="s-top-bar"></div>
        <!-- 内容容器 -->
        <div class="s-container">
            <div class="s-begin-container">
                <h3 class="s-begin-title"> 数据：</h3>
                <div class="s-begin-statistics">
                    <ul class="s-statistics-title-list">
                        <li>练习人数</li>
                        <li>题目总数</li>
                        <li>平均正确率</li>
                        <li>建议用时</li>
                        <li>我上次做题正确率</li>
                        <li>我的耗时（最近一次）</li>
                    </ul>
                    <ul class="s-statistics-content-list">
                        <li>${grammarGroup.personTimes }<span>人</span></li>
                        <li>${total }</li>
                        <li>${grammarGroup.avgAccuracy}% </li>
                        <li>${grammarGroup.useTime } </li>
                        <li>${grammarGroupStatus.accuracy==null?" ~":grammarGroupStatus.accuracy}${grammarGroupStatus.accuracy!=null?"%":""}</li>
                        <li>${secound==null?" ~":secound}</li>
                    </ul>
                </div>
                                <!-- 表单选项 -->
                <div class="s-options-container">
                    <form method="POST" action="${baseurl}/gmat/pre/practice" accept-charset="UTF-8"><input name="_token" type="hidden" value="WskYEKeSTfjX3OXhlW2da8cf6cZut1WikCYsPC2m">
                    <input name="grammarGroupId" type="hidden" value="${grammarGroup.id}">
                    <input name="u" type="hidden" value="u1511344365483233">
                    <input name="mode" type="hidden" value="1">
                    <input name="begin" type="hidden" value="begin">
                      <ul class="s-options-list">
                     <!--      	<li>
                                <label>
                                    <i class="inputCheckbox js-inputCheckbox active"></i><input checked="checked" name="disorder" type="checkbox" value="1">
                                    <span>题目选项乱序显示</span>
                                </label>
                            </li> -->
                                                        <li>
                                <label>
                                    <i class="inputCheckbox js-inputCheckbox"></i><input name="showAnswer" type="checkbox" value="1">
                                    <span>每题显示答案</span>
                                </label>
                            </li>
                            <li>
                                <label>
                                    <i class="inputCheckbox js-inputCheckbox"></i><input name="isTimeLimit" type="checkbox" value="1">
                                    <span>每题超时提醒</span>
                                </label>
                            </li>
                        </ul>
                        <div class="s-options-outtime">
                            <label>
                                <i class="inputRadio js-inputRadio"></i><input name="timeLimit" type="radio" value="180">
                                <span>3min/题</span>
                            </label>
                            <label>
                                <i class="inputRadio js-inputRadio"></i><input name="timeLimit" type="radio" value="0">
                                <span>超出pace时间/题</span>
                            </label>
                        </div>
                                            <input type="submit" class="s-submit" value="开始练习">
                    </form>
                </div>
            </div>
        </div>
        <!-- 底部帮助/退出 -->
        <div class="s-bottom-bar">
            <div class="s-help-cont " id="js-help">
                <div class="s-help">
                    <i></i>
                    <p><span>H</span>elp</p>
                </div>
            </div>
            <div class="s-quit-cont" id="js-quit" data-url="/practice/ir/og">
                <div class="s-quit">
                    <i></i>
                    <p><span>Q</span>uit</p>
                </div>
            </div>
        </div>
        <!-- 退出提醒弹窗 -->
        <div class="s-quit-dialog js-dialog">
            <div class="s-quit-title">
                <span>Quit Confirmation</span>
                <i class="s-close js-close-btn"></i>
            </div>
            <p class="s-dialog-msg"><i class="s-qiut"></i><span>Are you sure you want to quit?</span></p>
            <div class="s-quit-button-container">
                <div class="s-buttons">
                    <p class="s-enter-btn js-enter-btn"><span>Y</span>es</p>
                </div>
                <div class="s-buttons active">
                    <p class="s-enter-btn js-close-btn"><span>N</span>O</p>
                </div>
            </div>
        </div>
        <!-- 帮助弹窗 -->
        <div class="s-help-dialog js-dialog" style="display: none;">
            <div class="s-help-title">
                <p><i class="s-help"></i>Help</p>
                <i class="s-close js-close-btn"></i>
            </div>
            <div class="s-help-msg-container">
                <ul class="s-help-msg-list">
                    <li>右上角的时钟图标<i class="s-time"></i>点击可以打开和关闭计时器</li>
                    <li>右上角的文件夹<i class="s-location"></i>点击可以打开和关闭当前题号</li>
                    <li>登录后点击右上角的星星图标 <i class="s-collect"></i>，所有被收藏的题目均可在“我的记录”-“收藏夹”中找到</li>
                    <li>题目操作相关设置，你可以点击 <i class="s-setting"></i>根据你自身练习需求进行相关调整</li>
                    <li>点击右下角<i class="s-next"></i>图标可以进入下一题。注意：如果你没有做当前题目，你将不可以进入下一题</li>
                    <li>点击左下角的 <i class="s-quit"></i>或<i class="s-end"></i> 即可退出练习</li>
                    <li>更多帮助可以加入QQ群: 146060530 进行说明</li>
                </ul>
            </div>
            <div class="s-close-button-container">
                <div class="s-close-button js-close-btn">
                    <i class="s-close"></i>

                    <p>C<span>l</span>ose</p>
                </div>
            </div>
        </div>
    </div>

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