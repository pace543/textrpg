package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.map.Map;
import io.github.pace543.textrpg.entity.Player;

public class Controller {
    public enum GameType { NEW, LOAD; }

    private static Game game;

    public static void start(GameType gt) {
        if (gt == GameType.NEW) {
            UI.cls();
            String name = UI.readStr("Enter your name: ");
            Player player = Player.getInstance(name);
            UI.println("Generating map...");
            Map map = Map.getInstance();
            game = new Game(player, map);
            UI.println("Saving game...");
            Save.save(game);
            UI.cls();
        } else {
            game = Save.loadSave();
        }

        loop();
    }

    private static void loop() {
        while (true) {

        }
    }
}
