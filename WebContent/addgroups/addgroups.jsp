<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>新建分组</title>
	<link rel="stylesheet" href="./css/Add-groups.css">
</head>
<body>
	
	<div class="w">
	<!-- Title -->
		<div class="title">
			<p>----- 新 建 分 组 -----</p>
	    </div>
	<form action="${pageContext.request.contextPath}/addgroup">
		<!-- content -->
		<div class="content">

			<!-- 信息部分 -->
			<div class="text">
				<div  class="name">请输入群组名称</div>
			</div>
			
			<div class="form">
				<div class="formc"><input type="text" class="f1"name="group"></div>
			</div>
			
			<!-- 添加退出 -->
			<div class="in-out">
				<div class="in">
					<a class="l" href="${pageContext.request.contextPath}/findgroup">
                </a>
                	<a class="l-in" href="${pageContext.request.contextPath}/findgroup">返回</a>
				</div>
				<div class="out">
					<a class="r" href="${pageContext.request.contextPath}/addgroup">
                </a>
                <input type = "submit" class="r-out" value = "添加">
                	<%-- <a class="r-out" href="${pageContext.request.contextPath}/addgroup">添加</a> --%>
				</div>
			</div>
		</div>
		</form>
	</div>
</body>
</html>