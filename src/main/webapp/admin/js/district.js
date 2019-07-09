$(function () {
    $('#dg').datagrid({
        rownumbers: true,  //显示行号
        title: '区域信息',
        toolbar: '#ToolBar',
        url: 'getDistrict',
        pagination: true,
        pageList: [1, 3, 6,15,23], //设置每页大小
        pageSize: 3,//每页三条记录
        columns: [[
            {checkbox: true, width: 100, align: 'left'},
            {field: 'id', title: '区域编号', width: 100},
            {field: 'name', title: '区域名称', width: 100, align: 'right'},
            {
                field: 'del', title: '操作', width: 100, align: 'right',
                formatter: function (value, row, index) {
                    return "<a href='javascript:DeleteSingle(" + row.id + ")'>删除</a>||<a href='javascript:OpenShowStreet(" + row.id + ")'>查看街道</a>"

                }
            }
        ]]
    });
});

//添加区域
function Add() {
    $("#AddDialog").dialog("open").dialog("setTitle", ">>>>>>添加区域")
}

//修改区域
function ModifyBySelect() {
    //获取datagrid选中行  返回的数组
    var SelectRows = $("#dg").datagrid('getSelections');
    if (SelectRows.length != 1) {
        $.messager.alert('提示框', '你还没有选中行，或者选择了多行.', 'info');
        return;
    }
    $("#UpDialog").dialog("open").dialog("setTitle", ">>>>>>修改区域")
    var row = SelectRows[0];
    $.post("getDistrictSingle", {"id": row.id}, function (data) {
        $("#UpDialogForm").form("load", data);
    }, "json")
}


//单条删除区域

function DeleteSingle(obj) {
    $.messager.confirm('提示框', '请君三思!!', function (flag) {
        if (flag) {
            $.post("DeleteSingleDistrict", {"id": obj}, function (data) {
                if (data.result == 1) {
                    $('#dg').datagrid('reload');
                    $.messager.alert('提示框', '删除成功！^_^', 'info');
                } else {

                    $('#dg').datagrid('reload');
                    $.messager.alert('提示框', '删除失败！^_^', 'info');
                }
            }, "json")
        } else {
            $.messager.alert('提示框', '请君仔细斟酌', 'info');
        }

    });
}


//批量删除
function DeleteByFruitName() {
    var selectRows = $("#dg").datagrid("getSelections");
    if (selectRows == 0) {
        $.messager.alert("提示消息", "你还没有选择要操作的记录！", 'info');
        return;
    }
    $.messager.confirm('提示框', '请君三思!!', function (flag) {
        if (flag) {
            var s = "";
            for (var n = 0; n < selectRows.length; n++) {
                s = s + selectRows[n].id + ",";//拼接字符串 例如;4,5,6,7,8...   selectRows[n].id即表示的是id的这个值
            }
            s = s.substring(0, s.length - 1);//截取字符串4,5,6
            $.post("DeleteMoreDistrict", {"id": s}, function (data) {
                if (data.result >= 1) {
                    $('#dg').datagrid('reload');
                    $.messager.alert('提示框', '删除成功！^_^', 'info');
                } else {

                    $('#dg').datagrid('reload');
                    $.messager.alert('提示框', '删除失败！^_^', 'info');
                }
            }, "json")
        } else {
            $.messager.alert('提示框', '请君仔细斟酌', 'info');
        }

    });
}


//关闭窗口操作
function CloseDialog() {
    $("#AddDialog").dialog("close");
}

function CloseDialog() {
    $("#UpDialog").dialog("close");
}

//添加操作
function SaveDialog() {
    $('#addDialogForm').form('submit', {
        url: 'addDistrict',
        success: function (data) {
            var parseJSON = $.parseJSON(data);
            if (parseJSON.result == 1) {
                $("#addDialogForm").form("clear");
                $("#AddDialog").dialog("close");//窗口关闭
                $('#dg').datagrid('reload');
                $.messager.alert('提示框', '添加成功！^_^', 'info');
            } else {
                $("#AddDialog").dialog("close");//窗口关闭
                $('#dg').datagrid('reload');
                $.messager.alert('提示框', '添加失败！^_^', 'info');
            }
        }
    });

}

//修改操作
function UpDialog() {
    $('#UpDialogForm').form('submit', {
        url: 'updateDistrict',
        success: function (data) {
            var parseJSON = $.parseJSON(data);
            if (parseJSON.result == 1) {
                $("#UpDialog").dialog("close");//窗口关闭
                $('#dg').datagrid('reload');
                $.messager.alert('提示框', '修改成功！^_^', 'info');
            } else {
                $("#UpDialog").dialog("close");//窗口关闭
                $('#dg').datagrid('reload');
                $.messager.alert('提示框', '修改失败！^_^', 'info');
            }
        }
    });

}



