package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.battle.MagAttack;
import io.github.pace543.textrpg.item.*;
import io.github.pace543.textrpg.entity.Player;

import java.util.ArrayList;

class Controller {
    public enum GameType { NEW, LOAD }

    static Player player;
    private static String filename;

    static void start(GameType gt) {
        if (gt == GameType.NEW) {
            UI.cls();
            String name = UI.readStr("Enter your name: ");
            player = new Player(name);
            filename = UI.readStr("What do you want to name the save file (a single word)?: ");
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
        town.addMenuItem("Go to Infinite Dungeon", Controller::dungeon);
        town.addMenuItem("Go to Armor Store", Store::armorStore);
        town.addMenuItem("Go to Shield Store", Store::shieldStore);
        town.addMenuItem("Go to Weapon Store", Store::weaponStore);
        town.addMenuItem("Go to Healing Store", Store::healingStore);
        town.addMenuItem("Player Info", Controller::playerInfo);
        town.addMenuItem("Save and Exit", () -> {
            try {
                UI.println("Saving game...");
                Save.save(player, filename);
            } catch (java.io.IOException ex) {
                UI.println("There was an error saving the game.");
            }
            UI.println("Exiting...");
            System.exit(0);
        });
        town.printMenu();
        town.getAndExecuteChoice();
    }

    private static void playerInfo() {
        UI.cls();
        Menu initial = new Menu("Player Info");
        initial.addMenuItem("See Player Stats", () -> {
            UI.cls();
            String playerName = "Name: " + player.getName();
            UI.println(playerName);
            for (int i = 0; i <= playerName.length(); i++) {
                UI.print("=");
            }
            UI.println();
            UI.println("HP            : %d", player.getHealth());
            UI.println("Max HP        : %d", player.getMaxHealth());
            UI.println("MP            : %d", player.getMagic());
            UI.println("Max MP        : %d", player.getMaxMagic());
            UI.println("Phys. Attack  : %d", player.getpAttack());
            UI.println("Phys. Defense : %d", player.getpDefense());
            UI.println("Mag. Attack   : %d", player.getmAttack());
            UI.println("Mag. Defense  : %d", player.getmDefense());
            UI.println("Speed         : %d", player.getSpeed());
            UI.readStr("Press enter to continue...");
            playerInfo();
        });
        initial.addMenuItem("See Player Magic Attacks", () -> {
            UI.cls();
            ArrayList<MagAttack> magAttacks = player.getMagAttacks();
            for (MagAttack ma : magAttacks) {
                UI.println(ma.toString());
            }
            UI.readStr("Press enter to continue...");
            playerInfo();
        });
        initial.addMenuItem("See Player Inventory", () -> {
            UI.cls();
            ArrayList<Item> inventory = player.getInventory();
            for (Item i : inventory) {
                UI.println(i.toString());
            }
            UI.readStr("Press enter to continue...");
            playerInfo();
        });
        initial.addMenuItem("Return to Town", () -> { });
        initial.printMenu();
        initial.getAndExecuteChoice();
    }

    private static void dungeon() {

    }


}
