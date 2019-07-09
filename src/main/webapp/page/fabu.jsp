<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
<script language="JavaScript" >
    $(function () {
        $("#district_id").change(function () {
            var dis=$(this).val();
            $.post("getStreetByDid",{"id":dis},function (data) {
                $("#street_id>option:gt(0)").remove();
for(var i=0;i<data.length;i++){
    var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
    $("#street_id").append(node);
}
            },"json")
        })
    })
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM method=post name=add.action
action=addHouse enctype="multipart/form-data">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
      <TD colspan="2" class=field>${info}</TD>
  <TR>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name=title> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=typeId>
        <OPTION value="">-请选择-</OPTION>
    <c:forEach items="${types}" var="t">
        <OPTION  value=${t.id}>${t.name}</OPTION>
    </c:forEach>
    </SELECT>
    </TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text 
name=floorage></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price> </TD></TR>
  <TR>
    <TD class=field>发布日期：</TD>
    <TD><INPUT class=text type=date name=pubdate></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=id id="district_id">
        <OPTION  value="">-请选择-</OPTION>
        <c:forEach items="${districts}" var="d">
            <option value="${d.id}">${d.name}</option>
        </c:forEach>
    </SELECT> 街：<SELECT class=text
        name=streetId id="street_id">
        <OPTION value="">-请选择-</OPTION>
    </SELECT> </TD></TR><!-- 
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系人：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact> </TD>
  </TR>
  <TR>
      <TD class=field>图片：</TD>
      <TD><INPUT id=cpath class=text type=file name=cpath> </TD>
  </TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description></TEXTAREA></TD></TR></TBODY></TABLE>
<DIV class=buttons>
    <INPUT value=立即发布 type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
