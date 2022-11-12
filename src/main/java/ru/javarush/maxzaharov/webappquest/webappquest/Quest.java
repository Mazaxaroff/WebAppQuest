package ru.javarush.maxzaharov.webappquest.webappquest;

import java.util.List;

public class Quest {
    Question winQuestion = Question.builder()
            .text("Тебя вернули домой! Победа!")
            .isWin(true)
            .build();
    Question lossQuestion1 = Question.builder()
            .text("Ты отклонил вызов! Поражение!")
            .isLoose(true)
            .build();
    Question lossQuestion2 = Question.builder()
            .text("Ты не пошел на переговоры! Поражение!")
            .isLoose(true)
            .build();
    Question lossQuestion3 = Question.builder()
            .text("Твою ложь разоблачили! Поражение!")
            .isLoose(true)
            .build();
    Question whoAreYou = Question.builder()
            .text("Ты поднялся на мостик. Ты кто?")
            .answers(List.of(
                    Answer.builder()
                            .text("Рассказать правду о себе")
                            .nextQuestion(winQuestion)
                            .build(),
                    Answer.builder()
                            .text("Солгать о себе")
                            .nextQuestion(lossQuestion3)
                            .build()
            ))
            .build();
    Question doYouUpToCapitan = Question.builder()
            .text("Ты принял вызов. Поднимаешься на мостик к капитану?")
            .answers(List.of(
                    Answer.builder()
                            .text("Подняться на мостик")
                            .nextQuestion(whoAreYou)
                            .build(),
                    Answer.builder()
                            .text("Отказаться подниматься на мостик")
                            .nextQuestion(lossQuestion2)
                            .build()
            ))
            .build();
    Question startQuestion = Question.builder()
            .text("Ты потерял память. Принять вызов НЛО?")
            .answers(List.of(
                    Answer.builder()
                            .text("Принять вызов")
                            .nextQuestion(doYouUpToCapitan)
                            .build(),
                    Answer.builder()
                            .text("Отклонить вызов")
                            .nextQuestion(lossQuestion1)
                            .build()
            ))
            .build();
}
