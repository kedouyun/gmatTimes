$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'gm/exampaper/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '试卷名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '状态', name: 'status', index: 'status', width: 80,formatter:function(cellvalue, options, row){
				return cellvalue!=1?"下架":"上架";
			}  }, 			
			{ label: '创建日期', name: 'createDate', index: 'create_date', width: 80 },
			{name:'已经存在的列名称', label:'操作', width:60,formatter:function(cellvalue, options, row){return '<a  onclick="openUri('+row.id+')" class="btn btn-success">组合试卷</a>&nbsp;<a  onclick="questionsquery('+row.id+')">查看试题</a>'}}
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
function openUri(id){
	openLayer("800px","600px","试题","questionsshowList");
	$("#questionsjqGrid").jqGrid({
        url: baseURL + 'gm/questions/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 20, key: true },
//			{ label: '试题可见性', name: 'isVisible', index: 'is_visible', width: 80 }, 
			{ label: '试题类型', name: 'questionType', index: 'is_visible', width: 80,formatter:function(cellvalue, options, row){
				if(cellvalue==1){
					return "简短选择题";
				}else if(cellvalue==2){return "阅读理解";}
			} }, 
			{ label: '创建人', name: 'creator', index: 'creator', width: 40 },			
			{ label: '分组名称', name: 'groupName', index: 'groupName', width: 50 }, 			
			{ label: '答案', name: 'answer', index: 'answer', width: 80 }, 			
			{ label: '解析', name: 'analysis', index: 'analysis', width: 80 }	,
			{ label: '创建日期', name: 'createTime', index: 'create_time', width: 100 }, 			
			{name:'已经存在的列名称', label:'操作',formatter:function(cellvalue, options, row){return '<a  onclick="vm.detail('+row.id+')">查看</a>'}}
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
        	$("#questionsjqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
}
var vm = new Vue({
	el:'#rapp',
	data:{
		showList: true,
		title: null,
		exampaper: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.exampaper = {};
		},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function () {
			var url = vm.exampaper.id == null ? "gm/exampaper/save" : "gm/exampaper/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.exampaper),
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
				    url: baseURL + "gm/exampaper/delete",
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
			$.get(baseURL + "gm/exampaper/info/"+id, function(r){
                vm.exampaper = r.exampaper;
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
        }
	}
});