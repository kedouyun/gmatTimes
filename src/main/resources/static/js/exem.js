/**  
* 将秒数换成时分秒格式  
* 整理：www.jbxue.com  
*/  
    
function formatSeconds(value) {  
    var theTime = parseInt(value);// 秒  
    var theTime1 = 0;// 分  
    var theTime2 = 0;// 小时  
    if(theTime > 60) {  
        theTime1 = parseInt(theTime/60);  
        theTime = parseInt(theTime%60);  
            if(theTime1 > 60) {  
            theTime2 = parseInt(theTime1/60);  
            theTime1 = parseInt(theTime1%60);  
            }  
    }  
        var result = ""+parseInt(theTime)+"秒";  
        if(theTime1 > 0) {  
        result = ""+parseInt(theTime1)+"分"+result;  
        }  
        if(theTime2 > 0) {  
        result = ""+parseInt(theTime2)+"小时"+result;  
        }  
    return result;  
}  
  
function formatSeconds2(a) {   
  var hh = parseInt(a/3600);  
  
  if(hh<10){ 
	  hh = "0" + hh; 
  }
  var mm = parseInt((a-hh*3600)/60);  
  if(mm<10){
	  mm = "0" + mm;  
  }
  	var ss = parseInt((a-hh*3600)%60);  
  if(ss<10) {
	  ss = "0" + ss;  
  }
  var length ;
  if(hh="00"){
	  length = mm + ":" + ss;  
  }else{
	  length = hh + ":" + mm + ":" + ss;  
  }
  
  if(a>0){  
    return length;  
  }else{  
    return "NaN";  
  }  
} 