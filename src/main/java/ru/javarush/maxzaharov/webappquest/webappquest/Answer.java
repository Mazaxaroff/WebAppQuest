package ru.javarush.maxzaharov.webappquest.webappquest;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Answer {
    String text;
    Question nextQuestion;
}
