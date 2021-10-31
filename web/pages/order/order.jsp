<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../../script/jquery-1.7.2.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<%@ include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
				<td>发货情况</td>
			</tr>
			<c:forEach items="${requestScope.orders}" var="order">
				<tr>
					<td>${order.createtime}</td>
					<td>${order.price}</td>
					<td>
						<c:if test="${order.status==1}">已经发货</c:if>
						<c:if test="${order.status==0}">尚未发货</c:if>
						<c:if test="${order.status==2}">已经签收</c:if>
					</td>
					<td><a href="orderservlet?action=showorderdetail&id=${order.orderid}">查看详情</a></td>
					<td>
						<c:if test="${order.status==0}">
							尚未发货
						</c:if>
						<c:if test="${order.status==1}">
						<a  href="orderservlet?action=receiverorder&id=${order.orderid}&personid=${sessionScope.user.id}">确认收货
							</c:if>
							<c:if test="${order.status==2}">
							已确认收货
							</c:if>

					</td>
				</tr>
			</c:forEach>
		</table>
		
	
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>