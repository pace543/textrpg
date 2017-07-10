package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.battle.MagAttack;
import io.github.pace543.textrpg.item.*;
import io.github.pace543.textrpg.entity.Player;

import java.util.ArrayList;

class Controller {
    public enum GameType { NEW, LOAD }

    private static Player player;
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
        town.addMenuItem("Go to Armor Store", Controller::armorStore);
        town.addMenuItem("Go to Shield Store", Controller::shieldStore);
        town.addMenuItem("Go to Weapon Store", Controller::weaponStore);
        town.addMenuItem("Go to Healing Store", Controller::healingStore);
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

    private static void healingStore() {
        UI.cls();
        Menu healingStore = new Menu("Healing Store");
        healingStore.addMenuItem("Buy Healing", Controller::buyHealing);
        healingStore.addMenuItem("Sell Healing", Controller::sellHealing);
        healingStore.addMenuItem("Return to Town", () -> {});
        healingStore.printMenu();
        healingStore.getAndExecuteChoice();
    }

    private static void weaponStore() {
        UI.cls();
        Menu weaponStore = new Menu("Weapon Store");
        weaponStore.addMenuItem("Buy Weapons", Controller::buyWeapons);
        weaponStore.addMenuItem("Sell Weapons", Controller::sellWeapons);
        weaponStore.addMenuItem("Return to Town", () -> {});
        weaponStore.printMenu();
        weaponStore.getAndExecuteChoice();
    }

    private static void shieldStore() {
        UI.cls();
        Menu shieldStore = new Menu("Shield Store");
        shieldStore.addMenuItem("Buy Shields", Controller::buyShields);
        shieldStore.addMenuItem("Sell Shields", Controller::sellShields);
        shieldStore.addMenuItem("Return to Town", () -> {});
        shieldStore.printMenu();
        shieldStore.getAndExecuteChoice();
    }

    private static void armorStore() {
        UI.cls();
        Menu armorStore = new Menu("Armor Store");
        armorStore.addMenuItem("Buy Armor", Controller::buyArmor);
        armorStore.addMenuItem("Sell Armor", Controller::sellArmor);
        armorStore.addMenuItem("Return to Town", () -> {});
        armorStore.printMenu();
        armorStore.getAndExecuteChoice();
    }

    private static void dungeon() {

    }

    private static void sellHealing() {
        UI.cls();
        Menu sellHealing = new Menu("Sell Healing");
        for (Item i : player.getInventory()) {
            if (i.getThing() instanceof Healing) {
                sellHealing.addMenuItem(i.toString() + " COST: " + i.getThing().getCost(), () -> {
                    sell(i, i.getThing().getCost());
                    sellHealing();
                });
            }
        }
        sellHealing.addMenuItem("Previous", Controller::healingStore);
        sellHealing.printMenu();
        sellHealing.getAndExecuteChoice();
    }

    private static void buyHealing() {
        UI.cls();
        Menu buyHealing = new Menu("Buy Healing");
        for (Healing h : Healing.values()) {
            buyHealing.addMenuItem(h.getName() + " <" + h.getElement().name() + "> HBACK: " + h.getHealthBack()
                    + " MBACK: " + h.getMagicBack() + " COST: " + h.getCost(), () -> {
                buy(h);
                buyHealing();
            });
        }
        buyHealing.addMenuItem("Previous", Controller::healingStore);
        buyHealing.printMenu();
        buyHealing.getAndExecuteChoice();
    }

    private static void sellArmor() {
        UI.cls();
        Menu sellArmor = new Menu("Sell Armor");
        for (Item i : player.getInventory()) {
            if (i.getThing() instanceof Armor) {
                int sellValue = (int) (i.getThing().getCost() * i.getHealth());
                sellArmor.addMenuItem(i.toString() + " COST: " + sellValue, () -> {
                    sell(i, sellValue);
                    sellArmor();
                });
            }
        }
        sellArmor.addMenuItem("Previous", Controller::armorStore);
        sellArmor.printMenu();
        sellArmor.getAndExecuteChoice();
    }

    private static void buyArmor() {
        UI.cls();
        Menu buyArmor = new Menu("Buy Armor");
        for (Armor a : Armor.values()) {
            buyArmor.addMenuItem(a.getName() + " <" + a.getElement().name() + "> PDEF: " + a.getpDef()
                    + " MDEF: " + a.getmDef() + " COST: " + a.getCost(), () -> {
                buy(a);
                buyArmor();
            });
        }
        buyArmor.addMenuItem("Previous", Controller::armorStore);
        buyArmor.printMenu();
        buyArmor.getAndExecuteChoice();
    }

    private static void sellWeapons() {
        UI.cls();
        Menu sellWeapons = new Menu("Sell Weapons");
        for (Item i : player.getInventory()) {
            if (i.getThing() instanceof Weapon) {
                int sellValue = (int) (i.getThing().getCost() * i.getHealth());
                sellWeapons.addMenuItem(i.toString() + " COST: " + sellValue, () -> {
                    sell(i, sellValue);
                    sellWeapons();
                });
            }
        }
        sellWeapons.addMenuItem("Previous", Controller::weaponStore);
        sellWeapons.printMenu();
        sellWeapons.getAndExecuteChoice();
    }

    private static void buyWeapons() {
        UI.cls();
        Menu buyWeapons = new Menu("Buy Weapons");
        for (Weapon w : Weapon.values()) {
            buyWeapons.addMenuItem(w.getName() + " <" + w.getElement().name() + "> ATK: " + w.getpDamage()
                    + " COST: " + w.getCost(), () -> {
                buy(w);
                buyWeapons();
            });
        }
        buyWeapons.addMenuItem("Previous", Controller::weaponStore);
        buyWeapons.printMenu();
        buyWeapons.getAndExecuteChoice();
    }

    private static void sellShields() {
        UI.cls();
        Menu sellShields = new Menu("Sell Shields");
        for (Item i : player.getInventory()) {
            if (i.getThing() instanceof Shield) {
                int sellValue = (int) (i.getThing().getCost() * i.getHealth());
                sellShields.addMenuItem(i.toString() + " COST: " + sellValue, () -> {
                    sell(i, sellValue);
                    sellShields();
                });
            }
        }
        sellShields.addMenuItem("Previous", Controller::shieldStore);
        sellShields.printMenu();
        sellShields.getAndExecuteChoice();
    }

    private static void buyShields() {
        UI.cls();
        Menu buyShields = new Menu("Buy Shields");
        for (Shield s : Shield.values()) {
            buyShields.addMenuItem(s.getName() + " <" + s.getElement().name() + "> PDEF: " + s.getpDef()
                    + " MDEF: " + s.getmDef() + " COST: " + s.getCost(), () -> {
                buy(s);
                buyShields();
            });
        }
        buyShields.addMenuItem("Previous", Controller::shieldStore);
        buyShields.printMenu();
        buyShields.getAndExecuteChoice();
    }

    private static void buy(ItemType item) {
        if (player.getMoney() >= item.getCost()) {
            player.setMoney(player.getMoney() - item.getCost());
            player.addToInventory(new Item(item));
            UI.println("Bought %s.", item.getName());
            UI.readStr("Press enter to continue...");
        } else {
            UI.println("Cannot afford %s.", item.getName());
            UI.readStr("Press enter to continue...");
        }
    }

    private static void sell(Item item, int sellValue) {
        player.setMoney(player.getMoney() + sellValue);
        player.removeFromInventory(item);
        UI.println("Sold %s.", item.toString());
        UI.readStr("Press enter to continue...");
    }
}
