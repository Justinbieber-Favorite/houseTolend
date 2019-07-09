<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
<script language="JavaScript">
  $(function(){  //加载事件
    //使用异步加载类型
    $.post("getAllType",null,function(data){
      for(var i=0;i<data.length;i++){
        //创建option
        var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
        $("#typeid").append(node);
      }
      //设置选中项
      $("#typeid").val(${condition.typeid});
    },"json");

    //使用异步加载区域
    $.post("getAllDistrict",null,function(data){
      for(var i=0;i<data.length;i++){
        //创建option
        var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
        $("#district_id").append(node);
      }
      //设置区域的选中项
      $("#district_id").val(${condition.districtid});
      //加载街道
      //alert($("#district_id").val());
      loadStreet( $("#district_id").val());
    },"json");
    //给区域列表添加改变事件
    $("#district_id").change(function(){
      loadStreet($(this).val());  //重新加载街道
    });
  });

  function loadStreet(did){
    //发送异步请求获取区域下的街道
    $.post("getStreetByDid",{"id":did},function (data) {
      //清空原有数据
      $("#street_id>option:gt(0)").remove();
      for(var i=0;i<data.length;i++){
        //使用$()工厂函数创建标签
        var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
        //将创建的标签添加下拉列表
        $("#street_id").append(node);
      }
      $("#street_id").val(${condition.streetid});  //设置街道的选中项
    },"json");
  }
  
  function do_page(pno) {
    $("#pagege").val(pno);
    $("#sform").submit();
  }
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action=getBrowiseHouse>
  <div>
      <input type="hidden" name="page" value="1" id="pagege">
    标题:<input type="text" name="title" value="${condition.title}" style="width:100px">
    房屋类型:<select id="typeid" name="typeid">
    <option selected value="">不限</option>
  </select>
    区域:<select name="districtid" id="district_id">
    <option selected  value="-1">不限</option>
  </select>
街道:<select name="streetid" id="street_id">
    <option selected value="">不限</option>
  </select>
    租金:<input type="text" name="min_price" value="${condition.min_price}" style="width: 100px">--<input type="text" name="max_price" value="${condition.max_price}" style="width: 100px">元  <LABEL class=ui-blue><INPUT value=搜索房屋 type=submit name=search></LABEL>  <LABEL class=ui-blue><INPUT value=用户登录 type=button onclick="location.href='login.jsp'"></LABEL>

  </div>
  </FORM></DL></DIV>

<%--private String  title;
private Integer typeid;
private Integer districtid;
private  Integer streetid;
private  Integer min_price;
private  Integer max_price;--%>

<DIV class="main wrap">
    <c:if test="${pageInfo.list!=null}">
        <c:forEach items="${pageInfo.list}" var="h">
    <TABLE class=house-list>
  <TBODY>
        <TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="http://localhost:80/${h.path}" width="100" height="75" alt=""></a></span></TD>
        <TD>
          <DL>
            <DT><A href="housedetail?id=${h.id}" target="_blank">查看详情</A></DT>
            <DD>地区:${h.dname}==街道:${h.sname} 面积:${h.floorage}平米<BR>联系方式：${h.contact}</DD></DL></TD>
        <TD class=house-type>${h.tname}</TD>
        <TD class=house-price><SPAN>${h.price}</SPAN>元/月</TD>
      </c:forEach>
</TBODY>
      </TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:do_page(1)">首页</A></LI>
  <LI><A href="javascript:do_page(${pageInfo.prePage==0?1:pageInfo.prePage})">上一页</A></LI>
  <LI><A href="javascript:do_page(${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage})">下一页</A></LI>
  <LI><A href="javascript:do_page(${pageInfo.pages})">末页</A></LI></UL><SPAN
class=total>${pageInfo.pageNum}/${pageInfo.pages}页</SPAN> </DIV>
      </c:if>
  <c:if test="${empty pageInfo.list}">
      <center  style="color: red; font-size: 24px;">暂无出租房信息</center>
      </c:if>
      </DIV>
<DIV id=footer class=wrap>

<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
