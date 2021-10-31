<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../../script/jquery-1.7.2.js"></script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单细节</title>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">


    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif" >
    <span class="wel_word">订单管理系统</span>
    <%@include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <table>
        <tr>
            <td>编号</td>
            <td>书名</td>
            <td>数量</td>
            <td>价格</td>
            <td>总价</td>
        </tr>
        <c:forEach items="${requestScope.items}" var="items">
            <tr>
                <td>${items.id}</td>
                <td>${items.name}</td>
                <td>${items.count}</td>
                <td>${items.price}</td>
                <td>${items.totalprice}</td>
            </tr>
        </c:forEach>
    </table>
</div>



<%@include file="/pages/common/foot.jsp"%>
</body>
</html>