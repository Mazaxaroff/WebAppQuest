package ru.javarush.maxzaharov.webappquest;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Answer {
    String text;
    Question nextQuestion;
}
