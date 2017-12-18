$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'gm/grammargroup/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 10, key: true },
			{ label: '分组名称', name: 'name', index: 'name', width: 80 },			
			{ label: '所属字段类型', name: 'grammarTitleName', index: 'grammarTitleName', width: 80 },		
			{ label: '类型', name: 'grammarTypesName', index: 'grammarTypesName', width: 50 }	,		
			{ label: '试题数量', name: 'questionsCounNum', index: 'questionsCounNum', width: 20 }	,		
			{ label: '状态', name: 'status', index: 'status', width: 20,formatter:function(cellvalue, options, row){
				return cellvalue!=1?"下架":"上架";
			} }	,		
			{name:'已经存在的列名称', label:'操作', width:60,formatter:function(cellvalue, options, row){return '<a  onclick="show_window(\'300px\',\'200px\',\'../../../gm/grammargroup/uploadUi.do?id='+row.id+'\',\'编辑\')" class="btn btn-success">导入</a>&nbsp;<a  onclick="questionsquery('+row.id+')">查看试题</a>'}}
			//{name:'已经存在的列名称', label:'操作',formatter:function(cellvalue, options, row){return '<a  onclick="upload('+row.id+')" class="btn btn-success">导入</a>&nbsp;<a  onclick="questionsquery('+row.id+')">查看试题</a>'}}
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
    
    
    window.upload=function(id){
        if(id == null){
            return ;
        }
        vm.id=id;
        openLayer('300px', '200px', '查看附件', 'uploadInfoLayer');
    }
    
});
function questionsquery(id){
    window.location.href="../gm/questions.html?id="+id;
}
var vm = new Vue({
	el:'#rapp',
	data:{
		showList: true,
		showListedit:false,
		title: null,
		grammarGroup: {},
		grammarTypesOptions:{},
		grammarTitleOptions:{},
		questionsShowList:false,
		questionsedit:false,
		questions: {},
		improtFile:false,
		fileName:null,
		id:null
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			 vm.showListedit=true;
			vm.title = "新增";
			vm.grammarGroup = {};
			vm.searchTyple();
		},
		update: function () {
			var id = getSelectedRow();
			vm.searchTyple();
			
			if(id == null){
				return ;
			}
			vm.showList = false;
			 vm.showListedit=true;
            vm.title = "修改";
            vm.getInfo(id);
		},
		saveOrUpdate: function () {
			var url = vm.grammarGroup.id == null ? "gm/grammargroup/save" : "gm/grammargroup/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.grammarGroup),
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
				    url: baseURL + "gm/grammargroup/delete",
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
			$.get(baseURL + "gm/grammargroup/info/"+id, function(r){
				setTimeout(function(){
					vm.grammarGroup = r.grammarGroup;
				},50);
				vm.searchTitleId(r.grammarGroup.grammarTypesId);
            });
		},
		reload: function () {
			vm.showList = true;
			 vm.showListedit=false;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        refresh: function () {
            vm.showList = true;
            vm.showListedit=false;
          
            window.location.reload();
        },
        searchTitle:function(ele){
        	var grammarTypesId=ele.target.value;
        	vm.searchTitleId(grammarTypesId);
        },
        searchTitleId:function(grammarTypesId){
        	
        	$.ajax({
				type: "GET",
			    url: baseURL + "gm/grammartitle/search/"+grammarTypesId,
                contentType: "application/json",
			    success: function(r){
			    	if(r.code === 0){
			    		vm.grammarTitleOptions=r.grammarTitles;
			    		debugger;
					}else{
						alert(r.msg);
					}
				}
			});
        },
        searchTyple:function(){
        	$.ajax({
				type: "POST",
			    url: baseURL + "gm/grammartypes/search",
                contentType: "application/json",
			    success: function(r){
			    	if(r.code === 0){
			    		vm.grammarTypesOptions=r.grammarTypes;
					}else{
						alert(r.msg);
					}
				}
			});
        }
        
	}
});