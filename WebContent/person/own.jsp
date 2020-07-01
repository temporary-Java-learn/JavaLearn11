<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./person.css"/>
    <title>通讯录</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/allpeople" class="back1"><i></i></a>
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
                <p class="fenzu" style="font-size:20px;">${User.group}</p>
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
           
        </div>
    </div>
    
    </div>
</body>
</html>
