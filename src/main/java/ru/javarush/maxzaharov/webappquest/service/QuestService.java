package ru.javarush.maxzaharov.webappquest.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.maxzaharov.webappquest.Answer;
import ru.javarush.maxzaharov.webappquest.Player;
import ru.javarush.maxzaharov.webappquest.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestService {
    private static final Logger LOGGER = LogManager.getLogger(QuestService.class);

    public List<String> answers(boolean finish, Player player, Question currentQuestion) {
        if (player == null) {
            LOGGER.error("player is null.");
            throw new IllegalArgumentException("player can't be null.");
        }
        if (currentQuestion == null) {
            LOGGER.error("currentQuestion of player is null.");
            throw new IllegalArgumentException("currentQuestion can't be null.");
        }
        List<String> answers = new ArrayList<>();
        if (currentQuestion.isWin() || currentQuestion.isLoose()) {
            finish = true;
            player.incrementGames();
        } else {
            for (Answer answer : currentQuestion.getAnswers()) {
                answers.add(answer.getText());
            }
        }
        return answers;
    }
}
