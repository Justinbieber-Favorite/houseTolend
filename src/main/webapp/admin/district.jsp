<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>区域</title>
</head>
<link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
<script src="js/jquery-1.8.3.js"></script>
<!--jquery.easyui.min.js包含了easyUI中的所有插件-->
<script src="js/jquery.easyui.min.js"></script>
<script language="JavaScript" src="js/district.js"></script>
<script language="JavaScript">
    //街道函数//
    function CloseDialog() {
        $("#showStreetDialog").dialog("close")

    }


    function OpenShowStreet(id){
//打开窗口
        $("#showStreetDialog").dialog("open").dialog("setTitle","街道明细");

        //显示当前区域下的街道
        $('#dg2').datagrid({
            title:"街道信息",
            url:'getStreet?id='+id,  //服务器地址
            pagination:true,  //启用分页
            toolbar:"#ToolBar1",  //工具栏
            rownumbers:true,  //显示行号
            //singleSelect:true,  //实现单行选择
            pageList:[3,6,9,12], //设置每页大小
            pageSize:3, //每页三条
            columns:[[
                {field:'ck',checkbox:true,width:100,align:'left'},
                {field:'id',title:'编号',width:100,align:'left'},
                {field:'name',title:'街道名称',width:100,align:'left'},
                {field:'opt',title:'操作',width:100,align:'left',
                    formatter:function(value,row,index){
                        //发送同步请求
                        // return "<a href=\"delDistrict?id="+row.id+"\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">删除</a>";
                        //发送异步请求Ajax
                        return "<a href='javascript:DelStreet("+row.id+")'>删除</a>";
                    }}
            ]]
        });
    }

    function DelStreet(obj) {
        $.messager.confirm('提示框', '请君三思!!', function (flag) {
            if (flag) {
                $.post("DeleteSingleStreet", {"id": obj}, function (data) {
                    if (data.result == 1) {
                        $('#dg2').datagrid('reload');
                        $.messager.alert('提示框', '删除成功！^_^', 'info');
                    } else {

                        $('#dg2').datagrid('reload');
                        $.messager.alert('提示框', '删除失败！^_^', 'info');
                    }
                }, "json")
            } else {
                $.messager.alert('提示框', '请君仔细斟酌', 'info');
            }

        });
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

</div>
<div id="ToolBar1">
    <div style="height: 40px;">
        <a href="javascript:AddStreet()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:UpStreet()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>
    </div>

</div>
<!--添加的对话框-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="addDialogForm" method="post">
        <table>
            <tr>
                <td>区域名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id=addbname"/></td>
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
                <td><input type="hidden" class="easyui-validatebox" required
                           name="id" id="id"/></td>
            </tr>
            <tr>
                <td>区域名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id="upname"/></td>
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

</div>
<!--////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->

<!--显示街道的窗口-->
<div id="showStreetDialog" class="easyui-dialog" buttons="#StreetButtons"
     style="width: 500px; height: 350px; padding: 10px 20px;" closed="true">
    <table id="dg2"></table>
    <hr/>
   <%-- <form id="addDiasslogForm"  method="post">
        <table>
            <tr>
                <td>街道名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id="bname" /></td>
                <a href="javascript:SaveStreetDialog()"
                   class="easyui-linkbutton" iconCls="icon-add">添加</a>
            </tr>

        </table>
    </form>--%>
</div>
<div id="StreetButtons">

    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</body>

</html>
