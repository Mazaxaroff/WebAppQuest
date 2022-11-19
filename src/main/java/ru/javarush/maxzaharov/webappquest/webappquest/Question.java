package ru.javarush.maxzaharov.webappquest.webappquest;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Question {
    String text;
    List<Answer> answers;
    boolean isWin;
    boolean isLoose;
}
