<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@include file="/pages/common/head.jsp"%>
<script type="text/javascript" src="../../script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function () {
		$("a.deleteclass").click(function () {
			return confirm("你确定要删除【"+ $(this).parent().parent().find("td:first").text() + "】？");

        })


    })
</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

			<C:forEach items="${requestScope.page.items}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
				<td>${book.sales}</td>
				<td>${book.stock}</td>
				<td><a href="manager/bookservlet?action=getbook&id=${book.id}&method=update&pageno=${requestScope.page.pageno}">修改</a></td>
				<td><a class="deleteclass" href="manager/bookservlet?action=delete&id=${book.id}&pageno=${requestScope.page.pageno}">删除</a></td>
			</tr>
			</C:forEach>

			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?method=add&pageno=${requestScope.page.pagetotal}">添加图书</a></td>
			</tr>	
		</table>
		<%@include file="/pages/common/pagenav.jsp"%>
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>