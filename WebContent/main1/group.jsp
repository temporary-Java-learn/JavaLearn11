<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>通讯录</title>
	<link rel="stylesheet" href="./css/group.css">
</head>
<body>
	<div class="main">
		<div class="w">
			<div class="top">
				<p><a href="${pageContext.request.contextPath}/allpeople"><i></i></a><span>群组</span></p>
			</div>
			<div class="center">
				<c:forEach items="${groups}" var="n">
					<p><a href="${pageContext.request.contextPath}/entergroup?group=${n.group}"><div class="radius">${n.group}</div></a></p>
				</c:forEach>
			</div>
			<div class="bottom">
				<div class="new">
					<a href="/Address/addgroups/addgroups.jsp">
						<i></i>
						<p>新建</p>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>