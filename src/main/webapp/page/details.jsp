<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>

<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search>
<FORM method=get><INPUT class=text type=text name=keywords>
 <LABEL class="ui-green searchs"><a href="list.jsp" target="_blank">搜索房屋</a></LABEL>
</FORM></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
 </DL></DIV>
<DIV id=position class=wrap>当前位置：青鸟租房网 - 浏览房源详情</DIV>
<DIV id=view class="main wrap">
<DIV class=intro>
<DIV class=lefter>
<H1>${house.title}</H1>
<DIV class=subinfo>2013-06-28 14:06:33.0</DIV>
<DIV class=houseinfo>
<P>户　　型：<SPAN>${house.tname}</SPAN></P>
<P>面　　积：<SPAN>${house.floorage}m<SUP>2</SUP></SPAN></P>
<P>位　　置：<SPAN>${house.dname}${house.sname}</SPAN></P>
  <P>价　　格：<SPAN>${house.price}</SPAN></P>
  <P>发布时间：<SPAN><fmt:formatDate value="${house.pubdate}" pattern="yyyy年MM月dd日"></fmt:formatDate></SPAN></P>
<P>联系方式：<SPAN>${house.contact}</SPAN></P></DIV></DIV>
  <
<DIV class=side>
<P><A class=bold href="http://localhost:8080/House-2/#">北京青鸟房地产经纪公司</A></P>
<P>资质证书：有</P>
<P>内部编号:1000</P>
<P>联 系 人：警察叔叔</P>
<P>联系电话：<SPAN>110</SPAN></P>
<P>手机号码：<SPAN>110</SPAN></P></DIV>
<DIV class=clear></DIV>
<DIV class=introduction>
<H2><SPAN><STRONG>房源详细信息</STRONG></SPAN></H2>
<DIV class=content>
<P>${house.description}</P></DIV></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
</BODY>
</HTML>
