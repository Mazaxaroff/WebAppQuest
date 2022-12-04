package ru.javarush.maxzaharov.webappquest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.javarush.maxzaharov.webappquest.Player;
import ru.javarush.maxzaharov.webappquest.Question;

import static org.junit.jupiter.api.Assertions.*;

class QuestServiceTest {
    private QuestService questService;

    @Mock
    Question currentQuestion;

    @Mock
    Player player;

    @BeforeEach
    void setup() {
        questService = new QuestService();
    }

    @Test
    void test_answers_whenPlayerIsNull() {
        assertThrows(IllegalArgumentException.class, () -> questService.answers(false, null, currentQuestion));
    }

    @Test
    void test_answers_whenQuestionIsNull() {
        assertThrows(IllegalArgumentException.class, () -> questService.answers(false, player, null));
    }
}
