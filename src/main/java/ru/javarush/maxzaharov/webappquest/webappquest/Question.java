package ru.javarush.maxzaharov.webappquest.webappquest;

import lombok.Builder;

import java.util.List;

@Builder
public class Question {
    String text;
    List<Answer> answers;
    boolean isWin;
    boolean isLoose;
}
