<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String prolog = "Ты стоишь в космическом порту и готов подняться на борт своего корабля.\n Разве не об этом ты мечтал?" +
            " Стать капитаном галактического судна с экипажем, который будет совершать подвиги под твоим командованием. " +
            "Так что вперед!";
%>
<%
    String introduce = "Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:" +
            " - Здравствуйте, комндир! Я Зинаида - ваша помощница. Видите? Там в углу пьет кофе наш штурман - " +
            "сержант Перегарный Шлейф, под штурвалом спит наш бормеханик - Черный Богдан, а фотографирует его " +
            "Сегрей Стальтная Пятка- наш навигатор. " +
            "А как обращаться к вам?";
%>
<!DOCTYPE html>
<html>
<head>
    <title>WebApp Quest</title>
</head>
<body>
<h1><%= "Пролог" %>
</h1>
<h4><%= prolog%>
</h4>
<h1><%= "Знакомство с экипажем"%>
</h1>
<h4><%= introduce%>
</h4>
<form action="/" name="registration">
    <input type="text" id="input_name" name="name" required size="20" maxlength="20">
    <input type="button" value="Присоединиться" onclick='location.href ="hello-servlet"'>
   </form>
<br>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>