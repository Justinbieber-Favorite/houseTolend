<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  Object o=session.getAttribute("logininfo");
  if(o==null){
    out.print("<script>alert('登录已超时或未登录!请登录后重试');location.href='login.jsp'</script>");
  }
%>
<HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK
rel=stylesheet type=text/css href="../css/style.css">

<META name=GENERATOR ></HEAD>
<BODY>

<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
  <div class="ui-red searchs" style="color: red" >${info}</div>
<DIV class=search>
   <LABEL class="ui-red searchs" style="text-align: center">欢迎您:${sessionScope.logininfo.name}</LABEL><LABEL class="ui-green searchs"><a href="getHouse" title="">管理房屋信息</a></LABEL><LABEL class="ui-green searchs"><a href="getFabu" title="">发布房屋信息</a></LABEL>
<LABEL class=ui-green>
    <INPUT onclick='location.href="login.jsp"' value="退       出" type=button name=search></LABEL>
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${infoo.list}" var="inn">
      <TR>
          <TD class=house-thumb><SPAN><A href="details.jsp" target="_blank">
              <img src="http://localhost:80/${inn.path}" width="100" height="75" alt=""></A></SPAN></TD>
          <TD>
              <DL>
                  <DT><A href="details.jsp" target="_blank">${inn.title}</A></DT>
                  <DD>区域:${inn.dname} 街道:${inn.sname} 面积:${inn.floorage}㎡<BR>联系人：${inn.contact} ========>>>>
                      <c:choose>
                          <c:when test="${inn.ispass==0}">
                              待审核
                          </c:when>
                          <c:when test="${inn.ispass==1}">
                              已审核
                          </c:when>
                      </c:choose>
                  </DD></DL></TD>
          <TD class=house-type><LABEL class=ui-green><INPUT onclick="location.href='uphouse?id=${inn.id}'" value="修    改" type=button name=search></LABEL></TD>
          <TD class=house-price><LABEL class=ui-green><INPUT onclick="location.href='delhouse?id=${inn.id}'" value="删    除" type=button name=search></LABEL></TD></TR>
  </c:forEach>

  </TBODY></TABLE></DIV>
<DIV class=pager>
<UL>
    <c:forEach begin="1" end="${infoo.pages}" step="1" var="i">
        <LI class=current><A id=widget_1160989910
                             href="getHouse?page=${i}"
                             parseContent="true" showError="true" targets="houseArea"
                             ajaxAfterValidation="false" validate="false"
                             dojoType="struts:BindAnchor">${i}</A>
        </LI>
    </c:forEach>
  </UL><SPAN class=total>${infoo.pageNum}/${infoo.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
