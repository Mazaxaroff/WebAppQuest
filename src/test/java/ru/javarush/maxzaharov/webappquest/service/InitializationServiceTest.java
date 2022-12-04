package ru.javarush.maxzaharov.webappquest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.javarush.maxzaharov.webappquest.Players;

import static org.junit.jupiter.api.Assertions.*;


class InitializationServiceTest {
    @Mock
    private Players players;
    private InitializationService initializationService;

    @BeforeEach
    void setup() {
        initializationService = new InitializationService(players);
    }

    @Test
    void test_initOrCreatePlayer_whenNameOfPlayerIsNull() {
        assertThrows(IllegalArgumentException.class, () -> initializationService.initOrCreatePlayer(null, "0.0.0.1"));
    }

    @Test
    void test_initOrCreatePlayer_whenIpOfPlayerIsNull() {
        assertThrows(IllegalArgumentException.class, () -> initializationService.initOrCreatePlayer("test", null));
    }

}
