<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./person.css"/>
    <title>通讯录</title>
</head>
<body>
 <a href="${pageContext.request.contextPath}/entergroup?group=${User.group}" class="back2"><i></i></a> 
<%-- 	<input class="button_ok" type="button" href="${pageContext.request.contextPath}/allpeople" value="返回" /> --%>
    <div class="main">
        <div class="toubu">
            <h3 class="a1">${xingshi}</h3>
            <p class="hui"></p>
            <p class="ming">${User.name}</p>
        </div>
    <div class="xia">
        <div class="mid">
    	   <ul>
            <li>
                <p class="haoma">${User.pnumber}</p>
            </li>
            
            <li>
                <p class="fenzu">${User.group}</p>
            </li>
            <li>
                <p class="youxiang">${User.email}</p>
            </li>
            <li>
                <p class="gongzuo">${User.work}</p>
            </li>
    	   </ul>
        </div>
        <div class="in-out">
                <div class="in">
                    <a class="l-in" href="${pageContext.request.contextPath}/fixtopage?id=${User.id}">编辑</a>
                </div>
                <div class="out">
                    <a class="r-out" href="${pageContext.request.contextPath}/deleteperson?id=${User.id}">删除</a>
                </div>
        </div>
    </div>
    
    </div>
</body>
</html>
