$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'gm/grammartitle/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '类型字段', name: 'name', index: 'name', width: 80 },			
			{ label: '类型', name: 'grammarTypesName', index: 'grammarTypesName', width: 80 },			
        ],
		viewrecords: true,
        height: "100%",
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rapp',
	data:{
		showList: true,
		title: null,
		grammarTitle: {},
		options:{},
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.grammarTitle = {};
			vm.searchTyple();
		},
		update: function () {
			var id = getSelectedRow();
			vm.searchTyple();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id)
		},
		saveOrUpdate: function () {
			var url = vm.grammarTitle.id == null ? "gm/grammartitle/save" : "gm/grammartitle/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.grammarTitle),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "gm/grammartitle/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "gm/grammartitle/info/"+id, function(r){
                vm.grammarTitle = r.grammarTitle;
            });
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        },
        searchTyple:function(){
        	$.ajax({
				type: "POST",
			    url: baseURL + "gm/grammartypes/search",
                contentType: "application/json",
			    success: function(r){
			    	if(r.code === 0){
			    		vm.options=r.grammarTypes;
					}else{
						alert(r.msg);
					}
				}
			});
        }
	}
});