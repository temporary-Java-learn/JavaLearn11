<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>通讯录</title>
    <link rel="stylesheet" href="./css/members.css">
</head>

<body>
    <div class="members">
        <div class="w">
            <div class="top">
                <p><a href="${pageContext.request.contextPath}/findgroup"><i></i></a><span>${thisgroup}</span></p>
            </div>
            <div class="person"></div>
            <c:forEach items="${Users}" var="n">
                <p><a href="${pageContext.request.contextPath}/findbyid?id=${n.id}" class="fontsize"><div class="radius">${n.name}</div></a></p>
            </c:forEach>
            </div>
            <div class="bottom">
                <div class="delete">
                    <a href="${pageContext.request.contextPath}/deletegroup?group=${thisgroup}">
                        <i></i>
                        <p>删除</p>
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>

</html>