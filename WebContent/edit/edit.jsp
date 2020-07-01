<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <html>

<head>
    <meta charset="UTF-8">
    <title>修改联系人</title>
    <link rel="stylesheet" href="./css/Revise-contacts.css">
</head>

<body>
   
    <div class="w">
     <!-- Title -->
    <div class="title">
        <p>----- 修 改 联 系 人 -----</p>
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
		<form action="${pageContext.request.contextPath}/editpeople">
            <!-- 信息部分 -->
            <div class="form-1">
            	<input type="hidden" name="id" value=${user.id}>
                <div class="forma-1"> <img src="./images/6.png" alt="" style="width: 50px;height: 50px;">姓名：</div>
                <div class="formc-1"><input type="text" class="f1" name="name" value=${user.name}></div>
            </div>

            <div class="form-2">
                <div class="forma-2"> <img src="./images/3.png" alt="" style="width: 50px;height: 50px;">邮箱：</div>
                <div class="formc-2"><input type="text" class="f1" name="email" value=${user.email}></div>
            </div>

            <div class="form-3">
                <div class="forma-3"> <img src="./images/2.png" alt="" style="width: 50px;height: 50px;">电话号码：</div>
                <div class="formc-3"><input type="text" class="f1" name="pnumber" value=${user.pnumber}></div>
            </div>

            <div class="form-4">
                <div class="forma-4"><img src="./images/5.png" alt="" style="width: 50px;height: 50px;">所在单位：</div>
                <div class="formc-4"><input type="text" class="f1" name="work" value=${user.work}></div>
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

            <!-- 添加退出 -->
            <div class="in-out">
                <div class="in">
                    <a class="l" href="${pageContext.request.contextPath}/findbyid?id=${user.id}"></a>
                    <a class="l-in" href="${pageContext.request.contextPath}/findbyid?id=${user.id}">返回</a>
                </div>
                <div class="out">
                    <a class="r" href="${pageContext.request.contextPath}/editpeople?id=${user.id}">
                    </a>
                    <input class="r-out" type="submit" value="完成">
                </div>
            </div>
        </form>
        </div>

    </div>
</body>

</html>