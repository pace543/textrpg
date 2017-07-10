package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.map.Map;
import io.github.pace543.textrpg.entity.Player;

class Controller {
    public enum GameType { NEW, LOAD }

    private static Player player;
    private static String filename;

    static void start(GameType gt) {
        if (gt == GameType.NEW) {
            UI.cls();
            String name = UI.readStr("Enter your name: ");
            player = new Player(name);
            String filename = UI.readStr("What do you want to name the save file (a single word)?: ");
            UI.println("Saving game...");
            try {
                Save.save(player, filename);
            } catch (java.io.IOException ex) {
                UI.println("An error occurred and we could not create a save file.");
                UI.println("Exiting...");
                System.exit(0);
            }
            UI.cls();
        } else {
            UI.println("The save file must be in the same directory as the JAR file.");
            do {
                filename = UI.readStr("What is the name of the save file (a single word/no file extension)?: ");
                player = Save.loadSave(filename);
            } while (player == null);
        }

        while (true) {
            UI.cls();
            townMenu();
        }
    }

    private static void townMenu() {
        Menu town = new Menu("Welcome to Town!");
        town.addMenuItem("Go to Infinite Dungeon", () -> dungeon());
        town.addMenuItem("Go to Bank", () -> bank());
        town.addMenuItem("Go to Armor Store", () -> armorStore());
        town.addMenuItem("Go to Shield Store", () -> shieldStore());
        town.addMenuItem("Go to Sword Store", () -> swordStore());
        town.addMenuItem("Player Info", () -> playerInfo());
        town.addMenuItem("Save and Exit", () -> {
            try {
                UI.println("Saving game...");
                Save.save(player, filename);
            } catch (java.io.IOException ex) {
                UI.println("There was an error saving the game.");
            }
            System.exit(0);
        });
        town.printMenu();
        town.getAndExecuteChoice();
    }

    private static void playerInfo() {
    }

    private static void swordStore() {
    }

    private static void shieldStore() {
    }

    private static void armorStore() {
    }

    private static void bank() {
    }

    private static void dungeon() {
    }
}
