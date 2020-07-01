<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>

<head>
    <meta charset="UTF-8">
    <title>通讯录</title>
    <link rel="stylesheet" href="./css/main.css">
</head>

<body>
    <div class="interface">
        <div class="w">
            <div class="header">
               <a href="${pageContext.request.contextPath}/allpeople"><h1><i></i></h1> </a>
                <a href="/Address/add/add.jsp"><span>+</span></a>
            </div>
            <form action="/Address/superfind">
            <div class="search" style="margin-left:20px;">
            
                <i></i>
                <input type="text" name="search" placeholder="搜索">
            </div>
            </form>
            <div class="center">
                <div class="group">
                    <a href="${pageContext.request.contextPath}/findgroup">
                        <i></i>
                        <span>群组</span>
                    </a>
                </div>
                <div class="my_card">
                    <a href="${pageContext.request.contextPath}/findbyid2">
                        <i></i>
                        <span>我的名片</span>
                    </a>
                </div>
            </div>
            <div class="members">
                <div class="word"><span>联系人</span></div>
                <div class="name">
            <c:forEach items="${superfindresults}" var="n">
            	<p><a href="${pageContext.request.contextPath}/findbyid?id=${n.id}"><div class="radius">${n.name}　${n.information}</div></a></p>
            </c:forEach>
                </div>

            </div>
            <div class="footer"></div>
        </div>
    </div>
</body>

</html>