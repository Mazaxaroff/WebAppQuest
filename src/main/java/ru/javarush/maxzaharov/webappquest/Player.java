package ru.javarush.maxzaharov.webappquest;

import lombok.Builder;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
@Builder
public class Player {
    private static final Logger LOGGER = LogManager.getLogger(Player.class);
    String name;
    String ip;
    int games;


    public void incrementGames() {
        games++;
        LOGGER.info("Player " + this.name + " is finished the game");
    }
}
