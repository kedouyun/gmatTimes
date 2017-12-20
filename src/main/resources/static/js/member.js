var urlpath=$("#urlpath").val();
function submit(id,success,error){
	var ChangePass=$("#"+id).serialize();
	$.ajax({
	      type: "POST",
	      url: $("#"+id).attr("action"),
	      data:ChangePass,
	      dataType: "json",
	      success: success
	})
}
$(".btn-submit").click(function(){
	submit("ChangePass",function(r){
		  alert(r.errorMessage);
    },function(r){});
});
$("#Register .btn-b").click(function(){
	submit("Register",function(r){
		  alert(r.errorMessage);
  },function(r){});
});
