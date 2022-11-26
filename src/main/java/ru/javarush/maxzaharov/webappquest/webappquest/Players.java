package ru.javarush.maxzaharov.webappquest.webappquest;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Players {
    public static final Map<String, Player> ALL = new HashMap<>();
}
