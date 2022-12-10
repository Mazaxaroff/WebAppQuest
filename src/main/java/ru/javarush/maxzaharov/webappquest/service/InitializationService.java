package ru.javarush.maxzaharov.webappquest.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.maxzaharov.webappquest.Player;
import ru.javarush.maxzaharov.webappquest.Players;

public class InitializationService {
    private static final Logger LOGGER = LogManager.getLogger(InitializationService.class);
    private final Players players;

    public InitializationService(Players players) {
        this.players = players;
    }

    public Player initOrCreatePlayer(String nameOfPlayer, String ip) {
        if (players.isContains(nameOfPlayer)) {
            return players.getPlayer(nameOfPlayer);
        } else {
            Player player = Player.builder()
                    .name(nameOfPlayer)
                    .ip(ip)
                    .games(0)
                    .build();
            players.save(player);
            LOGGER.info("Player " + player.getName() + " was created");
            return player;
        }
    }
}
