<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="UTF-8">
    <title>添加联系人</title>
    <link rel="stylesheet" href="./css/Add-contacts.css">
</head>

<body>
    <!-- Title -->
    
    <div class="w">
    <div class="title">
        <p>----- 新 建 联 系 人 -----</p>
    </div>
        <!-- 头像 -->
       <div class="head">
            <div class="cover">
                <a href="javascript:;">
                    <p>点击添加头像</p>
                </a>
            </div>
        </div> 

        <!-- content -->
        <div class="content">
        <form action="${pageContext.request.contextPath}/addperple" method="get">

            <!-- 信息部分 -->
            <div class="form-1">
                <div class="forma-1"> <img src="./images/6.png" alt="" style="width: 50px;height: 50px;">姓名：</div>
                <div class="formc-1"><input type="text" class="f1" name="name"></div>
            </div>

            <div class="form-2">
                <div class="forma-2"> <img src="./images/3.png" alt="" style="width: 50px;height: 50px;">邮箱：</div>
                <div class="formc-2"><input type="text" class="f1" name="email"></div>
            </div>

            <div class="form-3">
                <div class="forma-3"> <img src="./images/2.png" alt="" style="width: 50px;height: 50px;">电话号码：</div>
                <div class="formc-3"><input type="text" class="f1" name="pnumber"></div>
            </div>

            <div class="form-4">
                <div class="forma-4"><img src="./images/5.png" alt="" style="width: 50px;height: 50px;">所在单位：</div>
                <div class="formc-4"><input type="text" class="f1" name="work"></div>
            </div>

            <div class="form-5">
                <div class="forma-5"> <img src="./images/4.png" alt="" style="width: 50px;height: 50px;">加入群组：</div>
                <div class="formc-5">
            <select name="group" value="${user.group}"class="f2">
                    	<c:forEach items="${groups}" var="n">
                    	<option value="${n.group}">${n.group}</option>
                    	</c:forEach>
                    </select>
                    </div>
            </div>
            <input type="submit" value="提交" class="r-out">
		</form>
            <!-- 添加退出 -->
            <div class="in-out">
                <div class="in">
                    <a class="l" onclick="history.go(-1)">
                    </a>
                    <a class="l-in" onclick="history.go(-1)">返回</a>
                </div>
                <div class="out">
                    <a class="r" href="${pageContext.request.contextPath}/addperple">
                    </a>
                    
                </div>
            </div>
        </div>
	
    </div>
</body>

</html>