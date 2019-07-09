<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<HEAD><TITLE>青鸟租房 - 用户注册</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>

<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
<script language="JavaScript" >
 $(function () {
   $("#btn").click(function () {
     var username=$("#uname").val();
     $.post("Check",{"name":username},function (data) {
       if(data.result==1){
$("#unotice").html("该用户名已被使用!").css("color","red");
       }else {
         $("#unotice").html("用户名可用!").css("color","green");
       }
     },"json");
   })
 });
 $(function () {
   $("#repass").blur(function () {
     var pass=$("#pass").val();
     var repass=$("#repass").val();
     if(pass!=repass){
       $("#recheck").html("两次输入密码不一致!请刷新网页后重试!!!").css("color","red");
       $("#repass").clean();
     }else {
       $("#recheck").html("干得漂亮!!!").css("color","green");
     }

   })
 })

</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新用户注册</DT>
  <DD class=past>填写个人信息</DD></DL>
<DIV class=box>
<FORM action="reg" method="post">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><INPUT class=text type=text name=name id="uname">
      <span id="unotice"></span>
    <input type="button" id="btn" value="检查用户名是否可用">
    </TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><INPUT class=text type=password name=password id="pass"></TD></TR>
  <TR>
    <TD class=field>确认密码：</TD>
    <TD><INPUT class=text type=password name=repassword id="repass">
      <span id="recheck"></span>
    </TD></TR>
  <TR>
    <TD class=field>电　　话：</TD>
    <TD><INPUT class=text type=text name=telephone> </TD></TR>
  <TR>
    <TD class=field>年　　龄：</TD>
    <TD><INPUT class=text type=text name=age>
      <INPUT class=text type=hidden name=isadmin value="0">
    </TD></TR>


  </TBODY></TABLE>
<DIV class=buttons>
<INPUT  value=立即注册 type=submit >
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
