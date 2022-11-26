package ru.javarush.maxzaharov.webappquest.webappquest;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Players {
    private final Map<String, Player> all = new HashMap<>();

    public void save(Player player){
        all.put(player.getName(), player);
    }

    public Player getPlayer(String name){
        return all.get(name);
    }

    public boolean isContains(String name){
        return all.containsKey(name);
    }
}

