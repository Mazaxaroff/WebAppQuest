package ru.javarush.maxzaharov.webappquest;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

@Data
public class Players {
    private static final Logger LOGGER = LogManager.getLogger(Players.class);
    private Map<String, Player> allPlayers;

    public Players(Map<String, Player> map) {
        this.allPlayers = map;
    }

    public void save(Player player) {
        if (player == null) {
            LOGGER.error("player is null");
            throw new IllegalArgumentException("player can't be null");
        }
        allPlayers.put(player.getName(), player);
    }

    public Player getPlayer(String name) {
        if (name == null) {
            LOGGER.error("name of player is null");
            throw new IllegalArgumentException("name of player can't be null");
        }
        return allPlayers.get(name);
    }

    public boolean isContains(String name) {
        if (name == null) {
            LOGGER.error("name of player is null");
            throw new IllegalArgumentException("name of player can't be null");
        }
        return allPlayers.containsKey(name);
    }
}

