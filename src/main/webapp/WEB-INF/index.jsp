<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String prolog = "Ты стоишь в космическом порту и готов подняться на борт своего корабля.\n " +
            "Разве не об этом ты мечтал? Стать капитаном галактического судна с экипажем, который будет совершать " +
            "подвиги под твоим командованием.\n Так что вперед!";
%>
<%
    String introduce = "Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:\n" +
            " - Здравствуйте, командир! Я Зинаида - ваша помощница. Видите? Там в углу пьет кофе наш штурман - " +
            "сержант Перегарный Шлейф, под штурвалом спит наш бормеханик - Черный Богдан, а фотографирует его " +
            "Сегрей Стальтная Пятка- наш навигатор. \n" +
            "А как обращаться к вам?";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: "Comic Sans MS";
            background: rgb(2, 0, 36);
            background: linear-gradient(225deg, rgba(2, 0, 36, 1) 0%, rgba(10, 58, 144, 1) 33%, rgba(0, 212, 255, 1) 100%);
            min-height: 100vh;
        }

        .content {
            padding: 1rem
        }

        .form {
            padding-left: 2rem;
        }

        .text {
            padding-left: 2rem;
            width: 60%;
            white-space: pre-wrap
        }
    </style>
</head>
<body>
<div class="content">
    <h1><%= "Пролог" %>
    </h1>
    <h4 class=" text"><%= prolog%>
    </h4>
    <h2><%= "Знакомство с экипажем"%>
    </h2>
    <h4 class=" text"><%= introduce%>
    </h4>
    <form class="form" action="${pageContext.request.contextPath}/index" name="registration" method="post">
        <input type="text" name="name" required size="20" maxlength="20">
        <input class="btn btn-info" type="submit" value="Присоединиться">
    </form>
</div>
</body>
</html>