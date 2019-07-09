
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
<script language="JavaScript" src="js/housenopass.js"></script>
<body>
<table id="dg" style="width: 1200px"></table>
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:AllChoose()" class="easyui-linkbutton"
                iconCls="icon-ok" plain="true">批量操作</a>
    </div>
    <div>标题:<input type="text" id="h_title" name="h_title" width="10px">
        发布时间:<input type="date" id="h_begin_date" name="begin_pubdate" width="10px">至
        <input type="date" id="h_end_date" name="end_pubdate" width="10px">
        房屋大小:<input type="text" id="h_floorage" name="h_floorage" width="10px">
        <a href="javascript:search()" class="easyui-linkbutton"
           iconCls="icon-search" plain="true">搜索</a>
    </div>

</div>

</body>
</html>
