<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/11
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="marry" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>showStudent</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.3.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jqPaginator.js"></script>
</head>
<body>
<div class="container">
    <table class="table">
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>地址</td>
        </tr>
    <marry:forEach var="s" items="${pageInfo.list}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>${s.sex}</td>
            <td>${s.address}</td>
            <td>
                <button class="btn btn-warning" data-toggle="modal" onclick="updateStu(${s.id})">修改</button>
                <button class="btn btn-danger" onclick="del(${s.id})">删除</button>
            </td>
        </tr>
    </marry:forEach>
    </table>
    <a href="addStu">新增学生</a>
</div>

<!-- 分页的导航栏 -->
<div class="pagination-layout">
    <div class="pagination">
        <ul class="pagination">

        </ul>
    </div>
</div>

</div>

</body>
<script>

    window.onload = function() {
        var if_fistime = true;
        $(".pagination")
            .jqPaginator(
                {
                    totalPages : ${pageInfo.pages},
                    visiblePages : 2,
                    currentPage : ${pageInfo.pageNum},
                    first : '<li class="first"><a href="javascript:void(0);">第一页</a></li>',
                    prev : '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
                    next : '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
                    last : '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
                    page : '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',

                    onPageChange : function(num) {

                        /* alert(num); */
                        if (if_fistime) {
                            if_fistime = false;
                        } else {
                            changePage(num);
                        }

                    }

                })

    }

    function changePage(num) {
        window.location.href = "getStu?pageNum=" + num;
    }

</script>


<script type="text/javascript">

    /*删除*/
    function del(id) {

        location.href="deleteStudent?id="+id

    }
    function updateStu(id) {
      /*  alert(id)*/
      location.href="/getStuById?id="+id
    }








</script>
</html>
