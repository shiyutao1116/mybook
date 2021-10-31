<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../../script/jquery-1.7.2.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
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
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
				<td>是否发货</td>
			</tr>
			<c:forEach items="${requestScope.orders}" var="order">
			<tr>
				<td>${order.createtime}</td>
				<td>${order.price}</td>
				<td><a href="orderservlet?action=showorderdetail&id=${order.orderid}">查看详情</a></td>
				<td><c:if test="${order.status==1}">已经发货</c:if>
					<c:if test="${order.status==0}">尚未发货</c:if>
					<c:if test="${order.status==2}">已经签收</c:if>
				</td>
				<td>
					<c:if test="${order.status==1}">
						点击发货
					</c:if>
					<c:if test="${order.status==0}">
					<a id="submit1" href="orderservlet?action=sendorder&id=${order.orderid}">点击发货
					</c:if>

				</td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>