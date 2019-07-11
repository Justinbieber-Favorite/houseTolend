<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HEAD><TITLE>青鸟租房 - 用户登录</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK
            rel=stylesheet type=text/css href="../css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
</HEAD>
<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
<script language="JavaScript">
    var number;
    $(function () {
        $("#button").click(function () {
            $.post("getCode", {"telphone": $("#smsMob").val()}, function (data) {
                if (data.result > 0) {
                    number = setInterval("backTime()", 1000);
                } else {
                    alert("系统错误!,请稍后重试");
                }
            }, "json");

        });
    });
    var time = 120;
    function backTime() {
        if (time != 0) {
            time--;
            $("#button")[0].disabled = true;//设置样式不可点击了
            $("#button").val(time + "秒");
        } else {
            clearInterval(number);//清除倒数
            $("#button")[0].disabled = false;
            $("#button").val("获取验证码");
        }
    }


</script>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV>
</DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DIV class=box>
            <H4>用户登录</H4>
            <FORM method=post action=LoginAction>
                <DIV class=infos>
                    <TABLE class=field>
                        <TBODY>
                        <TR>
                            <TD colSpan=2 style="color: red">${info}</TD>
                        </TR>
                        <TR>
                            <TD class=field>用 户 名：</TD>
                            <TD><!-- <input type="text" class="text" name="name" /> --><INPUT
                                    id=user_name class=text type=text name=name></TD>
                        </TR>
                        <TR>
                            <TD class=field>密　 码：</TD>
                            <TD><!-- <input type="password" class="text" name="password" /> --><INPUT
                                    id=user_password class=text type=password name=password></TD>
                        </TR>

                        <!--以下功能是短信验证,需购买短信服务-->
            <%--            <TR>
                            <TD class=field>手 机 号：</TD>
                            <TD><!-- <input type="text" class="text" name="name" /> --><INPUT
                                    id=smsMob class=text type=text name=smsMob><input type="button" value="获取验证码"
                                                                                      id="button"></TD>
                        </TR>
                        <TR>
                            <TD class=field>验 证 码：</TD>
                            <TD><!-- <input type="text" class="text" name="name" /> --><INPUT
                                    id=smstext class=text type=text name=smstext></TD>
                        </TR>--%>
                        <%--	<tr>
                                <td class="field">验 证 码：</td>
                                <td><input type="text" class="text verycode" name="veryCode" /></td>
                            </tr>--%>
                        </TBODY>
                    </TABLE>
                    <DIV class=buttons>
                        <INPUT value=登陆 type=submit> <INPUT onclick='document.location="regs.jsp"' value=注册 type=button>
                    </DIV>
                </DIV>
            </FORM>
        </DIV>
    </DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
</BODY>
</HTML>
