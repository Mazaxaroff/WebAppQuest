<%--
  Created by IntelliJ IDEA.
  User: Model
  Date: 18.11.2022
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Quest</title>
    <style>
        .form {padding-left: 2rem; }
        .text {padding-left: 2rem; width: 60%; white-space: pre-wrap}
    </style>
</head>
<body>
<h1 class="text">${currentQuestion}</h1>
<c:if test="${finish == false}">
    <form class="form" action="${pageContext.request.contextPath}/quest" method="post">
        <c:forEach items="${answers}" var="answer" varStatus="loop">
            <div>
                <input type="radio" name="nextQuestion" value="${loop.index}">
                    ${answer}
            </div>
        </c:forEach>
        <button type="submit">Далее</button>
    </form>
</c:if>
<c:if test="${finish == true}">
    <h2 class="text">Игра окончена!</h2>
</c:if>
</body>
</html>
