<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GMAT</title>
<%@ include file="../../common/head.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/common.css" />
<link rel="stylesheet" href="//code.kmf.com/dist/common/css/channel/common_w.css?201711151432" type="text/css">
<link rel="stylesheet" href="//code.kmf.com/dist/newgmat/css/channel/practise/result.css?201711151432">
<script
	src="//cdn.bootcss.com/mathjax/2.7.0/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
</head>
<body>
	<div class="g-kmf-wrapper g-clearfix">
        <div class="i-result ">
            <div class="i-result-title g-clearfix">
                                    <ul class="nav">
                        <li>
                            <a href="http://gmat.kmf.com/practice">练习</a>
                        </li>
                        <li>&gt;</li>
                        <li>
                            <a href="http://gmat.kmf.com/practice/ir">IR</a>
                        </li>
                        <li>&gt;</li>
                        <li>
                            <a href="http://gmat.kmf.com/practice/ir/og/1">OG</a>
                        </li>
                        <li>&gt;</li>
                        <li>
                            <a href="javascript:void (0);">IR-OG：第21-30题</a>
                        </li>
                    </ul>
                            </div>
            <div class="i-result-sum g-mod-shadow">
                <h3>答题情况小结</h3>
                <ul class="i-tab g-clearfix" id="result-sum">
                    <li class="active">总体情况</li>
                    <li class="">Pace分析</li>
               </ul>
                <input type="hidden" id="correct_num" value="1">
                <input type="hidden" id="total_num" value="2">
                <input type="hidden" id="average_cost" value="1967">                
                <input type="hidden" id="cost_total" value="10">                
                <div class="i-tab-cont g-clearfix" id="result-sum-cont">
                
                <!-- ################ -->
                  <input type="hidden" id="groupkey" value="${groupkey}">          
                <!-- ################ -->
                    <div class="tab-cont" style="display: block;">

                        <input type="hidden" id="learn_total" value="0">                        
                        <input type="hidden" id="suggest_total" value="300">                        
                        <div class="i-charts" style="display: none">
                            <p class="title">练习词数</p>
                            <div id="word-num" class="word-num"></div>

                        </div>
                        <div class="i-charts">
                            <p class="title">答对题数</p>
                            <div id="result-num" class="g-circle"></div>
                            <p class="user-average">用户平均练习结果：${progress}/${questionTotal}</p>
                        </div>
                        <div class="i-charts">
                            <p class="title">做题时间</p>
                            <div class="user-time">
                                <p><i>${minute}</i>min<i>${second}</i>s</p>
                                <p>共计耗时</p>
                            </div><p class="user-average">用户平均做题时间：</p>
                            
                        </div>

                        <div class="i-charts score-bg  score-zero ">
                                                            <div class="result-no-login">
                                    <p><a class="login-btn js-kmf-login" href="javascript:void(0);">登录</a>后使用可以：</p>
                                    <p>1.存储并帮你分析你的练习数据；</p>
                                    <p>2.使用错题本功能；</p>
                                    <p>3.获得相应的成长值，记录你的成长轨迹。</p>
                                </div>
                                                    </div>
                                                <div class="g-smart-guide js-kmf-smart-guide toeflweb_index_home_right_word g-guide-text-close" data-guideid="gmatweb_practiceresult_new_wenzi"><a href="http://da.kmf.com/da/dn?p=93&amp;ps=186&amp;g=1545&amp;i=21353&amp;u=http%3A%2F%2Fhd.kmf.com%2Factivity%2Fjoin_course%3Fid%3D1677&amp;m=8076aab9712273c67016bde81537c425" target="_blank">
	<span class="smart-guide-hot">提示</span>
	<span class="smart-guide-text">SC | 7日速成计划 &gt;&gt;</span>
</a><a href="javascript:void(0)" class="smart-guide-close"></a></div>


                    </div>
                          <div class="tab-cont" style="display: none;">
                            <div class="res-pace mb20">
                                <div class="res-static g-clearfix">

                                    <div class="stage">
                                        <div class="stages">
                                            Pace诊断<strong>E</strong>
                                        </div>
                                        <p>Pace不稳定，还需要不断练习做题时的节奏哦！</p>
                                    </div>

                                </div>
                                <div id="ResultContainer" style="width: 1160px; height: 300px; -webkit-tap-highlight-color: transparent; user-select: none; position: relative; background: transparent;" _echarts_instance_="ec_1511683603563"><div style="position: relative; overflow: hidden; width: 1160px; height: 180px; padding: 0px; margin: 0px; border-width: 0px;"><canvas width="1160" height="180" data-zr-dom-id="zr_0" style="position: absolute; left: 0px; top: 0px; width: 1160px; height: 180px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); padding: 0px; margin: 0px; border-width: 0px;"></canvas></div><div></div></div>

                                <div class="res-relate ym-clearfix ">
                                    <div class="res-pra-time fl">
                                        <span>总耗时：10 秒</span><span>平均每题耗时：5 秒</span>
                                    </div>
                                </div>
                                <div class="g-smart-guide js-kmf-smart-guide" data-guideid="gmatweb_learn_result_mid_top_wz"></div>
                            </div>
                        </div>
                    </div>
            </div>
            <div class="i-result-pattern g-mod-shadow">
                <h3>答案及解析</h3>
                                    <div class="nav-flow">
                        <div class="nav-flow-box">
                            <div class="answer-nav">
                                <div class="opt-sub">
                                    <input id="opt-all" type="radio" value="1" name="opt" checked="checked">
                                    <label for="opt-all">全部题目</label>
                                </div>
                                <input type="hidden" name="exam_unique" id="exam_unique" value="u1511682889306999">

                                <ul class="list-num g-clearfix">
                                    <c:forEach items="${config.answer}" var="map" varStatus="status">
                                     	<li data-id="${map.key}">
                                           <a class="${map.value.status}-state  ${map.value.status}-state-act" href="javascript:void(0);">
                                              ${status.index+1}
                                           </a>
                                       </li>
									</c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                
                <div class="answer-info" id="ahchor">
                	<div class="r-pattern-common  r-pattern ">
        <h3>题目信息</h3>
        <ul class="action-bar">
              <li>
                <a class="js-btn-fav " data-object="question" data-collect_id="3394" data-op=" 1 " data-subject="2" href="javascript:void(0);">
                    <span class="actionbg fav-ico"></span>
                    <span class="text menu-text">收藏</span>
                </a>
              </li>
        </ul>
                        <!--单选题DOM-不带父级-->
            <div class="dart">
                <div class="sub-content">
                    <div class="text">
                        Although fullerenes--spherical molecules made entirely of carbon--were first found in the laboratory, they have since been found in nature, formed in fissures of the rare mineral shungite. Since laboratory synthesis of fullerenes requires distinctive conditions of temperature and pressure, this discovery should give geologists a test case for evaluating hypotheses about the state of the Earth's crust at the time these naturally occurring fullerenes were formed.<br><br>Which of the following, if true, most seriously undermines the argument?
                    </div>
                    <ul class="options">
                         <li>
                         	<span class="opts-item">A</span>Confirming that the shungite genuinely contained fullerenes took careful experimentation.
                         </li>
                    </ul>
                    <p class="my-answer">我的答案：A</p>
                    <p class="true-answer">正确答案：D</p>
                    <p class="user-data-info">
                          <span>9486人做过此题</span>
                      	  <span>我的耗时4s</span>
                          <span>平均耗时为5min16s</span>
                          <span>平均正确率为52%</span>
                   </p>
                </div>
            </div>
    </div>
				    <div class="note-box js-note-box"><div class="note-cont js-note-login">
				    	<p>
				       		 <span></span> 登录后可添加笔记，	<a class="btn-commont" href="javascritp:;" target="_blank">查看评论</a>
				        		。如果你还没有账号你可以<a href="/account/passportregister" class="btn-register">注册 </a> 一个账号。
				    	</p>
					</div>
					</div>
    <!--不带父题目的题目解析-->
        <div class="r-anls anls-c">
        <ul id="r-explane" class="i-tab g-clearfix">
            <li class="active" data-type="0">题目解析</li>
                    </ul>
        <ul class="action-bar">
                        <li>
                <a href="javascript:void(0)" class="js-open-error" data-type="2" data-qid="22281" data-title="纠错" data-json="{&quot;0&quot;:&quot;\u5176\u4ed6&quot;,&quot;4&quot;:&quot;\u9898\u76ee\u5185\u5bb9\u9519\u8bef&quot;,&quot;5&quot;:&quot;\u683c\u5f0f\u9519\u8bef&quot;,&quot;6&quot;:&quot;\u7b54\u6848\u9519\u8bef&quot;,&quot;7&quot;:&quot;\u89e3\u6790\u9519\u8bef&quot;}">
                    <span class="actionbg modify-ico"></span>
                    <span class="text">纠错</span>
                </a>
            </li>
        </ul>
        <div class="content content-explain">
                            <div class="none-anls">
                    <p>该题目暂无解析，快来<a href="http://gmat.kmf.com/question/cdh6xk.html#QuestionExplain" target="_blank">补充完善解析</a>吧！</p>
                </div>
                                </div>
            </div>
            <div class="r-comment">
        <h3>题目讨论</h3>
        <p>对该题目还存在疑问？看看考友是怎么理解的吧！<a href="http://gmat.kmf.com/question/cdh6xk.html" target="_blank">参与题目讨论</a></p>
    </div>
    <div id="js-kmf-modify">
        <div class="modify-body">
            <input type="hidden" name="id" value="22281">
            <input type="hidden" name="report_id" value="22281">
            <input type="hidden" name="subject" value="6">
            <div class="modify-item-type g-clearfix">
                <label class="label-type">请选择错误类型：</label>
                <select name="mistake" class="modify-type">
                    <option value="1">错别字</option>
                    <option value="2" selected="selected">知识点重复</option>
                    <option value="3">知识点内容有错误</option>
                    <option value="4">其他</option>
                </select>
            </div>
            <div class="modify-item-msg g-clearfix">
                <label class="label-msg">请描述一下这个错误：</label>
                <textarea class="modify-msg" name="message"></textarea>
            </div>
            <div class="modify-buttons">
                <a href="javascript:void(0)" class="g-btn-normal save-modify">立即提交</a><span class="js-modify-tips"></span>
            </div>
        </div>
    </div>

    </div>
            </div>
        </div>
    </div>
    
    <script type="text/javascript" src="${baseurl}/js/echarts.simple.min.js"></script>
	<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('result-num'));

	var option = {
		color:['#62cd62','#fa7070'],
	    tooltip: {
	        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    legend: {
	        show:false,
	        orient: 'vertical',
	        x: 'left',
	        data:['right','wrong']
	    },
	    series: [
	        {
	            name:'访问来源',
	            type:'pie',
	            radius: ['58%', '70%'],
	            avoidLabelOverlap: false,
	            hoverAnimation:false,
	            silent:true,
	            label: {
	                normal: {
	                    show: true,
	                    position: 'center',
	                    formatter:function(){
	                        return "${rightTotal}/${answerTotal}"
	                    },
	                    textStyle:{ fontSize:20,color:'#666' }
	                },
	                emphasis: { show: true, textStyle: { fontSize: '30', fontWeight: 'bold' }}
	            },
	            labelLine:{ normal:{ show: false}},
	            data:[{value:${rightTotal}, name:'right'}, {value:${wrongTotal},name:'wrong'}]
	        }
	    ]
	};
	 myChart.setOption(option);
	 
	 $(".list-num li").click(function(){
		 $(".list-num li").attr("class","");
		 $(this).attr("class","current");
		  var dataId=$(this).attr("data-id");
		  detail(dataId);
	 });
	 detail($(".list-num li:first").attr("data-id"));
	 $(".list-num li:first").attr("class","current");
	 
	 function detail(dataId){
		 var groupkey=$("#groupkey").val();
		   $.ajax({
              type: "GET",
              url: "${baseurl}/exam/exercise/detailQuestion/"+groupkey+"/"+dataId,
              dataType: "json",
              success: function(r){
            	  if(r.code==0){
                	$(".sub-content .text").text(r.parse.title);
                	$(".sub-content .options").empty();
                	var temp="";
                	for( val in r.parse.choiceList){
                		temp+='<li><span class="opts-item">'+val+'</span>'+r.parse.choiceList[val]+'</li>';
                	}
                	$(".sub-content .options").append(temp);
                	
                	$(".my-answer").text("我的答案："+r.exemVo.userAnswer);
                	$(".true-answer").text("正确答案："+r.exemVo.answer);
                	
       				MathJax.Hub.Queue(['Typeset', MathJax.Hub]);
       				$(".btn-commont").attr("href","${baseurl}/comment/exam/"+dataId);
       				
            	  }
              }
          });
	 }


	 
	</script>
	
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