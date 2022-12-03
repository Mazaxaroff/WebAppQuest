package ru.javarush.maxzaharov.webappquest;

import lombok.Builder;
import lombok.Data;
import ru.javarush.maxzaharov.webappquest.Answer;

import java.util.List;

@Builder
@Data
public class Question {
    String text;
    List<Answer> answers;
    boolean isWin;
    boolean isLoose;
}
