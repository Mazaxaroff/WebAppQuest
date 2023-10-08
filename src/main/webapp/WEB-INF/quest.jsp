<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <title>Quest</title>
    <style>
        body {
            font-family: "Comic Sans MS";
            background: rgb(2, 0, 36);
            background: linear-gradient(342deg, rgba(2, 0, 36, 1) 0%, rgba(10, 144, 44, 1) 33%, rgba(0, 212, 255, 1) 100%);
            min-height: 100vh;
        }

        .form {
            padding-left: 2rem;
        }

        .text {
            padding-left: 2rem;
            width: 60%;
            white-space: pre-wrap
        }

        .statistic-block {
            margin: 1rem;
            padding-left: 1rem;
            position: absolute;
            bottom: 0;
        }
    </style>
</head>
<body>
<h1 class="text">${currentQuestion}</h1>
<c:if test="${finish == false}">
    <form class="form" action="${pageContext.request.contextPath}/quest" method="post">
        <c:forEach items="${answers}" var="answer" varStatus="loop">
            <div>
                <input required type="radio" name="nextQuestion" value="${loop.index}">
                    ${answer}
            </div>
        </c:forEach>
        <button class="btn btn-primary" type="submit">Далее</button>
    </form>
</c:if>
<c:if test="${finish == true}">
    <h2 class="text">Игра окончена!</h2>
    <form class="form" action="${pageContext.request.contextPath}/quest" method="post">
        <button class="btn btn-primary" type="submit">Сыграть еще</button>
    </form>
</c:if>


<div class="statistic-block alert alert-dark">
    <p>Статистика:</p>
    <p>IP address: ${ip}</p>
    <p>Имя в игре: ${nameOfPlayer}</p>
    <p>Количество игр: ${countOfGames}</p>
</div>
</body>
</html>
