<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../../script/jquery-1.7.2.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%@include file="/pages/common/head.jsp"%>
<script type="text/javascript">
$(function () {
	$("button.addtocart").click(function () {
	    var bookid=$(this).attr("bookid");
		location.href="http://localhost:8080/mybook/cartservlet?action=additem&id="+bookid;


        $().getJSON("http://localhost:8080/mybook/cartservlet","action=ajaxadditem&id="+bookid,function (data) {
				$("#totalcount").text("您的购物车中有"+data.totalcount +"件商品");
            	$("#lastid").text(data.lastname);
        });


    });


});





</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${empty sessionScope.user}">
					<a href="pages/user/login.jsp">登录</a> |
					<a href="userservlet?action=logout">注销</a>&nbsp;&nbsp;

				</c:if>
				<c:if test="${not empty sessionScope.user}">
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
					<a href="orderservlet?action=showmyorders&id=${sessionScope.user.id}">我的订单</a>
					<a href="index.jsp">注销</a>&nbsp;&nbsp;
				</c:if>

				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookservlet" method="get">
					<input type="hidden" name="action" value="pagebyprice">
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
						<input id="max" type="text" name="max" value="${param.max}"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">

				<c:if test="${not empty sessionScope.cart.items}">
					<span id="totalcount">您的购物车中有${sessionScope.cart.totalcount}件商品</span>
					<div>
						您刚刚将<span id="lastid" style="color: red">${sessionScope.lastname}</span>加入到了购物车中
					</div>
				</c:if>

				<c:if test="${empty sessionScope.cart.items}">
					<span > </span>
					<div>
						<span  style="color: red">当前购物车为空</span>
					</div>
				</c:if>

			</div>

			<c:forEach items="${requestScope.page.items}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${book.imgpath}" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">${book.price}.00</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button bookid="${book.id}" class="addtocart">加入购物车</button>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
<%@include file="/pages/common/pagenav.jsp"%>



	
	</div>
	
	<%@include file="/pages/common/foot.jsp"%>

</body>
</html>