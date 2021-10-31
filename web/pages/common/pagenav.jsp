<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2021/10/24
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <C:if test="${requestScope.page.pageno>1}">
        <a href="${requestScope.page.url}&pageno=1">首页</a>
        <a href="${requestScope.page.url}&pageno=${requestScope.page.pageno-1}">上一页</a>
        <a href="${requestScope.page.url}&pageno=${requestScope.page.pageno-1}">${requestScope.page.pageno-1}</a>
    </C:if>
    【${requestScope.page.pageno}】
    <C:if test="${requestScope.page.pageno<requestScope.page.pagetotal}">
        <a href="${requestScope.page.url}&pageno=${requestScope.page.pageno+1}">${requestScope.page.pageno+1}</a>
        <a href="${requestScope.page.url}&pageno=${requestScope.page.pageno+1}">下一页</a>
        <a href="${requestScope.page.url}&pageno=${requestScope.page.pagetotal}">末页</a>
    </C:if>
    共${requestScope.page.pagetotal}页，${requestScope.page.pagetotalcount}条记录
    到第<input value="${param.pageno}" name="pn" id="pn_input"/>页
    <input id="searchpagebtn" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#searchpagebtn").click(function () {
                var pagenumber=$("#pn_input").val();
                if(pagenumber>1&&pagenumber<${requestScope.page.pagetotal}){
                    location.href= "${pageScope.basepath}${requestScope.page.url}&pageno="+pagenumber;
                }

            })


        })
    </script>


</div>