package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.map.Map;
import io.github.pace543.textrpg.entity.Player;

public class Controller {
    public enum GameType { NEW, LOAD; }

    private static Game game;

    public static void start(GameType gt) {
        if (gt == GameType.NEW) {
            // some exposition about the game...

            String name = UI.readStr("Enter your name: ");
            Player player = Player.getInstance(name);
            Map map = Map.getInstance();

        } else {
            game = Save.loadSave();
        }
    }

    private static void loop() {
        while (true) {

        }
    }
}
