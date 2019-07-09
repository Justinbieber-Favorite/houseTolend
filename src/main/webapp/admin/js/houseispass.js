$(function () {
    $('#dg').datagrid({
        rownumbers:true,  //显示行号
        title:'已审核',
        toolbar:'#ToolBar',
        url:'HouseYesPass',
        pagination:true,
        pageList:[1,3,6,12], //设置每页大小
        pageSize:3,//每页三条记录
        columns:[[
            {checkbox:true,width:70,align:'left'},
            {field:'id',title:'编号',width:70},
            {field:'title',title:'标题',width:70},
            {field:'price',title:'出租价格',width:70},
            {field:'pubdate',title:'发布时间',width:100,formatter: function(value,row,index){
                    var date = new Date(value);
                    var y= date.getFullYear();
                    var m=date.getMonth()+1;
                    var d=date.getDate();
                    return y+'年'+(m<10?('0'+m):m)+'月'+(d<10?('0'+d):d)+'日';
                }},
            {field:'contact',title:'联系方式',width:70},
            {field:'floorage',title:'房屋大小㎡',width:70},
            {field:'tname',title:'房屋类型',width:70},
            {field:'dname',title:'区域名称',width:70},
            {field:'sname',title:'街道名称',width:70},
            {field:'del',title:'操作',width:70,align:'right',
                formatter: function(value,row,index){
                    return "<a href='javascript:ChangeFail("+row.id+")'>审批失败</a>"
                }
            }
        ]]
    });
});

function ChangeFail(id) {
    $.post("CheckFail",{"id":id},function (data) {
        if(data.result>0){
            $('#dg').datagrid('reload');
        }else {
            $.messager.alert('提示框','审核失败！^_^','info');
            $('#dg').datagrid('reload');
        }
    },"json")

}

//批量操作
function AllChoose() {
    var selectRows = $("#dg").datagrid("getSelections");
    if(selectRows==0){
        $.messager.alert("提示消息", "你还没有选择要操作的记录！", 'info');
        return;
    }
    $.messager.confirm('提示框','请君三思!!',function (flag) {
        if(flag){
            var s="";
            for(var n=0;n<selectRows.length;n++){
                s=s+selectRows[n].id+",";//拼接字符串 例如;4,5,6,7,8...   selectRows[n].id即表示的是id的这个值
            }
            s=s.substring(0,s.length-1);//截取字符串4,5,6
            $.post("CheckAllFail",{"ids":s},function (data)  {//传送字符串到后台
                if(data.result>=1){
                    $('#dg').datagrid('reload');
                    $.messager.alert('提示框', '批量操作成功！^_^', 'info');
                }else {

                    $('#dg').datagrid('reload');
                    $.messager.alert('提示框', '批量操作失败！^_^', 'info');
                }
            },"json")
        }else {
            $.messager.alert('提示框','请君仔细斟酌','info');
        }

    });
}

function search() {
    var h_title=$("#h_title").val();
    var  h_begin_date=$("#h_begin_date").val();
    var  h_end_date=$("#h_end_date").val();
    var  h_floorage=$("#h_floorage").val();
    $("#dg").datagrid("load",{"h_title":h_title,"begin_pubdate":h_begin_date,"end_pubdate":h_end_date,"h_floorage":h_floorage});
}

