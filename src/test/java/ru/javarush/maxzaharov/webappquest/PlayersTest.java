package ru.javarush.maxzaharov.webappquest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    private Map<String, Player> playerMap;
    private Players allPlayers;

    @BeforeEach
    void setup() {
        playerMap = new HashMap<>();
        allPlayers = new Players(playerMap);
    }

    @Test
    void test_save_newPlayer() {
        Player player1 = new Player("first", "0.0.0.1", 0);
        allPlayers.save(player1);

        assertEquals(1, playerMap.size());
        assertEquals(player1, playerMap.get(player1.getName()));
    }

    @Test
    void test_save_whenPlayerIsNull() {
        assertThrows(IllegalArgumentException.class, () -> allPlayers.save(null));
    }


    @Test
    void test_getPlayer() {
        Player player1 = new Player("first", "0.0.0.1", 0);
        playerMap.put(player1.getName(), player1);
        assertEquals(player1, allPlayers.getPlayer(player1.getName()));
    }

    @Test
    void test_getPlayer_whenNameOfPlayerIsNull() {
        assertThrows(IllegalArgumentException.class, () -> allPlayers.getPlayer(null));
    }

    @Test
    void test_isContains() {
        String name = "first";
        Player player1 = new Player(name, "0.0.0.1", 0);
        playerMap.put(player1.getName(), player1);
        assertEquals(true, allPlayers.isContains(name));
    }

    @Test
    void test_isContains_whenNameOfPlayerIsNull() {
        assertThrows(IllegalArgumentException.class, () -> allPlayers.isContains(null));
    }
}
