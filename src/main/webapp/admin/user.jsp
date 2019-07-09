
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
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
            title:'管理员信息',
            toolbar:'#ToolBar',
            url:'getUser',
            pagination:true,
            pageList:[1,3,6,12], //设置每页大小
            pageSize:3,//每页三条记录
            columns:[[
                {checkbox:true,width:100,align:'left'},
                {field:'id',title:'编号',width:100},
                {field:'name',title:'名称',width:100,align:'right'},
                {field:'telephone',title:'电话',width:100,align:'right'},
                {field:'age',title:'年龄',width:100,align:'right'},
                {field:'del',title:'操作',width:100,align:'right',
                    formatter: function(value,row,index){
                     return "<a href='javascript:DeleteSingle("+row.id+")'>删除</a>"

                    }
                }
            ]]
        });
    });
    //添加区域
  function Add() {
        $("#AddDialog").dialog("open").dialog("setTitle",">>>>>>添加管理员")
    }
    //修改区域
    function ModifyBySelect() {
        //获取datagrid选中行  返回的数组
        var SelectRows = $("#dg").datagrid('getSelections');
        if(SelectRows.length!=1){
            $.messager.alert('提示框','你还没有选中行，或者选择了多行.','info');
            return;
        }
        $("#UpDialog").dialog("open").dialog("setTitle",">>>>>>修改管理员")
var row = SelectRows[0];
        $.post("getUsersSingle",{"id":row.id},function (data) {
$("#UpDialogForm").form("load",data);
        },"json")
    }
    
    //单条删除
    
    function DeleteSingle(obj) {
        $.messager.confirm('提示框','请君三思!!',function (flag) {
            if(flag){
                $.post("DeleteSingleUser",{"id":obj},function (data)  {
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
             $.post("DeleteMoreUsers",{"id":s},function (data)  {//传送字符串到后台
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
               url: 'addUser',
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
               url: 'updateUsers',
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
       function search() {
           var s_name=$("#s_name").val();
           var  s_telephone=$("#s_telephone").val();
           var  s_min_age=$("#s_min_age").val();
           var  s_max_age=$("#s_max_age").val();
$("#dg").datagrid("load",{"name":s_name,"telephone":s_telephone,"min_age":s_min_age,"max_age":s_max_age});
       }


</script>
<body>
<table id="dg" style="width: 700px"></table>
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:ModifyBySelect()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">批量删除</a>
    </div>
    <div>姓名:<input type="text" id="s_name" name="name" width="10px"><br/>
        电话:<input type="text" id="s_telephone" name="telephone" width="10px"><br/>
        最小年龄:<input type="text" id="s_min_age" name="min_age" width="10px"><br/>
        最大年龄:<input type="text" id="s_max_age" name="max_age" width="10px">
        <a
                href="javascript:search()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">搜索</a>
    </div>

</div>
<!--添加的对话框-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="addDialogForm" method="post">
        <table>
            <tr>

                <td>姓名:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" /></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" class="easyui-validatebox" required
                           name="password"  /></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="telephone" /></td>

                <td><input type="hidden" class="easyui-validatebox" required
                           name="isadmin"  value="1"/></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="age" /></td>
            </tr>
        </table>
    </form>
</div>

<!--修改的对话框-->
<div id="UpDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="UpDialogForm" method="post">
        <table>
            <tr>

                <td><input type="hidden"   class="easyui-validatebox" required
                           name="id" id="id" /></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" /></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" class="easyui-validatebox" required
                           name="password"  /></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="telephone" /></td>
        </tr>
            <tr>
                <td><input type="hidden" class="easyui-validatebox" required
                           name="isadmin"  value="1"/></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="age" /></td>
            </tr>

        </table>
    </form>
</div>

<!--添加按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<!--修改按钮-->
<div id="upDialogButtons">
    <a href="javascript:UpDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">修改</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>


</body>
</html>
