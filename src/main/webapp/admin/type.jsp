
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房屋</title>
</head>
<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
<script src="js/jquery-1.8.3.js"></script>
<!--jquery.easyui.min.js包含了easyUI中的所有插件-->
<script src="js/jquery.easyui.min.js"></script>
<script language="JavaScript">
    $(function () {
        $('#dg').datagrid({
            rownumbers:true,  //显示行号
            title:'房屋信息',
            toolbar:'#ToolBar',
            url:'getType',
            pagination:true,
            pageList:[1,3,6,12], //设置每页大小
            pageSize:3,//每页三条记录
            columns:[[
                {checkbox:true,width:100,align:'left'},
                {field:'id',title:'房屋编号',width:100},
                {field:'name',title:'房屋类型',width:100,align:'right'},
                {field:'del',title:'操作',width:100,align:'right',
                    formatter: function(value,row,index){
                     return "<a href='javascript:DeleteSingle("+row.id+")'>删除</a>"


                    }
                }
            ]]
        });
    });

    <!------------------------------------------->
    <!-------------------点击按钮单条删除----------------------->
    <!------------------------------------------->

    //单条删除
    
    function DeleteSingle(obj) {
        $.messager.confirm('提示框','请君三思!!',function (flag) {
            if(flag){
                $.post("DeleteSingleType",{"id":obj},function (data)  {
            if(data.result==1){
                $('#dg').datagrid('reload');
                $.messager.alert('提示框', '删除成功！^_^', 'info');
            }else {

                $('#dg').datagrid('reload');
                $.messager.alert('提示框', '删除失败！^_^', 'info');
                }
                },"json")
            }else {
                $.messager.alert('提示框','请君仔细斟酌','info');
            }

        });
    }
    <!------------------------------------------->
    <!-------------------点击上方图标实现批量删除----------------------->
    <!------------------------------------------->

    //批量删除
 function DeleteByFruitName() {
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
             $.post("DeleteMoreType",{"id":s},function (data)  {
                 if(data.result>=1){
                     $('#dg').datagrid('reload');
                     $.messager.alert('提示框', '删除成功！^_^', 'info');
                 }else {

                     $('#dg').datagrid('reload');
                     $.messager.alert('提示框', '删除失败！^_^', 'info');
                 }
             },"json")
         }else {
             $.messager.alert('提示框','请君仔细斟酌','info');
         }

     });
 }




    <!------------------------------------------->
    <!------------------------------------------->
    <!------------------------------------------->

    //添加区域
    function Add() {
        $("#AddDialog").dialog("open").dialog("setTitle",">>>>>>添加房屋")
    }

//添加操作
       function SaveDialog() {
           $('#addDialogForm').form('submit', {
               url: 'addType',
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
    //关闭添加的窗口的操作
    function CloseDialog() {
        $("#AddDialog").dialog("close");
    }

    <!------------------------------------------->
    <!------------------------------------------->
    <!------------------------------------------->


    //修改区域
    function ModifyBySelect() {
        //获取datagrid选中行  返回的数组
        var SelectRows = $("#dg").datagrid('getSelections');
        if(SelectRows.length!=1){
            $.messager.alert('提示框','你还没有选中行，或者选择了多行.','info');
            return;
        }
        $("#UpDialog").dialog("open").dialog("setTitle",">>>>>>修改房屋")
        var row = SelectRows[0];
        $.post("getTypeSingle",{"id":row.id},function (data) {
            $("#UpDialogForm").form("load",data);
        },"json")
    }


    //修改操作
       function UpDialog() {
           $('#UpDialogForm').form('submit', {
               url: 'updateType',
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

    //关闭修改的窗口的操作
    function CloseDialog() {
        $("#UpDialog").dialog("close");
    }
    <!------------------------------------------->
    <!------------------------------------------->
    <!------------------------------------------->


</script>
<body>
<table id="dg" style="width: 700px"></table>
<!-------------------工具栏------------------------>
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:ModifyBySelect()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">批量删除</a>
    </div>
</div>
<!------------------------------------------->
<!-------------------添加操作弹出的界面显示------------------------>
<!--添加对话框-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="addDialogForm" method="post">
        <table>
            <tr>
                <td>房屋名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id=addbname" /></td>
            </tr>
        </table>
    </form>
</div>
<!------------------------------------------->
<!---------------------输入数据后的判断添加按钮  提交还是取消----------------------->
<!--添加按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<!------------------------------------------->
<!-------------------修改操作弹出的界面显示------------------------>
<!--修改对话框-->
<div id="UpDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="UpDialogForm" method="post">
        <table>
            <tr>

                <td><input type="hidden"   class="easyui-validatebox" required
                           name="id" id="id" /></td>
            </tr>
            <tr>
                <td>房屋名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id="upname" /></td>
            </tr>

        </table>
    </form>
</div>
<!------------------------------------------->
<!---------------------输入数据后的判断修改按钮  确认修改还是放弃修改----------------------->
<!--修改按钮-->
<div id="upDialogButtons">
    <a href="javascript:UpDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">修改</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>

</div>


</body>
</html>
