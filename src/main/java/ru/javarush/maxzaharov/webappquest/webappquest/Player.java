package ru.javarush.maxzaharov.webappquest.webappquest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    String name;
    String ip;
    int games;
}
