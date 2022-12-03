package ru.javarush.maxzaharov.webappquest;

import lombok.Data;

import java.util.Map;

@Data
public class Players {
    private Map<String, Player> allPlayers;

    public Players(Map<String, Player> map) {
        this.allPlayers = map;
    }

    public void save(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("player can't be null");
        }
        allPlayers.put(player.getName(), player);
    }

    public Player getPlayer(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name of player can't be null");
        }
        return allPlayers.get(name);
    }

    public boolean isContains(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name of player can't be null");
        }
        return allPlayers.containsKey(name);
    }
}

