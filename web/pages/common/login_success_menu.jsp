<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2021/10/20
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="orderservlet?action=showmyorders&id=${sessionScope.user.id}">我的订单</a>
    <a href="userservlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>