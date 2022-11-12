package ru.javarush.maxzaharov.webappquest.webappquest;

import lombok.Builder;

@Builder
public class Answer {
    String text;
    Question nextQuestion;
}
