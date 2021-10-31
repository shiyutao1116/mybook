<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@ include file="/pages/common/login_success_menu.jsp"%>
<script type="text/javascript">
	$(function () {
		$("a.deleteitemclass").click(function () {
			return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()  +"】吗？")

        });
        $("a.cleanclass").click(function () {
            return confirm("你确定要清空购物车吗？")

        })

        $(".updatecount").change(function () {
            var id=$(this).attr("bookid");
           if (confirm("你确定要将【" +$(this).parent().parent().find("td:first").text() +"】" +
                   "的数量修改为"+this.value  +"吗？")){
				location.href="http://localhost:8080/mybook/cartservlet?action=updatecount&count="+this.value+"&id="+id;


		   }else
		   {
		       this.value=this.defaultValue;
		   }

        });



    });



</script>



	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<C:forEach items="${sessionScope.cart.items}" var="entry">
				<C:if test="${not empty sessionScope.cart.items}">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input class="updatecount" type="text" value="${entry.value.count}" bookid="${entry.value.id}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalprice}</td>
						<td><a class="deleteitemclass" href="cartservlet?action=deleteitem&id=${entry.value.id}">删除</a></td>
					</tr>
				</C:if>
			</C:forEach>
			<C:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5">看什么看还不去买东西？</td>
				</tr>
			</C:if>
		</table>
		<C:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalcount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalprice}</span>元</span>
			<span class="cart_span"><a class="cleanclass" href="cartservlet?action=clean">清空购物车</a></span>
			<span class="cart_span"><a href="orderservlet?action=createorder">去结账</a></span>
		</div>
		</C:if>
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>