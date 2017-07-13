package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.entity.Entity;
import io.github.pace543.textrpg.entity.Player;
import io.github.pace543.textrpg.item.*;
import io.github.pace543.textrpg.map.*;

import java.util.ArrayList;

class Dungeon {
    private Map map;
    private Player player;
    private boolean exit;

    Dungeon(Player p) {
        this.player = p;
    }

    void loop() {
        UI.cls();
        while (true) {
            floor();
            if (exit) {
                return;
            }
        }
    }

    private void floor() {
        map = Map.getInstance();
        setPlayerOnFloor();
        setStaircaseOnFloor();
        while (!exit) {
            if (map.getPlayerTile().equals(map.getStaircaseTile())) {
                UI.println("You found the staircase to the next floor!");
                UI.println("Moving to the next floor...");
                return;
            }
            menu();
            Entity e = map.getPlayerTile().spawn();
            if (e != null && !exit && !map.getPlayerTile().equals(map.getStaircaseTile())) {
                battle(e);
            }
        }
    }

    private void setStaircaseOnFloor() {
        Tile staircaseTile;
        do {
            int roomnum = RNG.getRInt(map.getRooms().size());
            Point center = map.getRooms().get(roomnum).getCenter();
            staircaseTile = map.getMap()[center.getX()][center.getY()];
        } while (map.getPlayerTile().equals(staircaseTile));
        ((RoomTile) staircaseTile).setStaircase(true);
        map.setStaircaseTile(staircaseTile);
    }

    private void battle(Entity enemy) {

    }

    private void menu() {
        Menu tileMenu = new Menu("Infinite Dungeon");
        if (canMoveNorth()) {
            tileMenu.addMenuItem("Move North.", () -> movePlayer(Direction.NORTH));
        }
        if (canMoveSouth()) {
            tileMenu.addMenuItem("Move South.", () -> movePlayer(Direction.SOUTH));
        }
        if (canMoveEast()) {
            tileMenu.addMenuItem("Move East.", () -> movePlayer(Direction.EAST));
        }
        if (canMoveWest()) {
            tileMenu.addMenuItem("Move West.", () -> movePlayer(Direction.WEST));
        }
        tileMenu.addMenuItem("Player Info.", Controller::playerInfo);
        tileMenu.addMenuItem("Equip/Use Items.", this::equipUseItems);
        tileMenu.addMenuItem("Exit Dungeon.", () -> exit = true);
        tileMenu.printMenu();
        tileMenu.getAndExecuteChoice();
    }

    private void equipUseItems() {
        ArrayList<Item> inventory = player.getInventory();
        Menu inventoryMenu = new Menu("Inventory");
        for (Item i : inventory) {
            inventoryMenu.addMenuItem(i.toString(), () -> {
                Menu choiceMenu = new Menu(i.getThing().getName());
                if (i.getThing() instanceof Armor) {
                    choiceMenu.addMenuItem("Equip", () -> {
                        Item armor = player.getArmor();
                        if (armor != null) {
                            inventory.add(armor);
                        }
                        player.setArmor(i);
                        inventory.remove(i);
                        UI.println("Equipped %s.", i.toString());
                        UI.readStr("Press enter to continue...");
                        equipUseItems();
                    });
                } else if (i.getThing() instanceof Shield) {
                    choiceMenu.addMenuItem("Equip", () -> {
                        Item shield = player.getShield();
                        if (shield != null) {
                            inventory.add(shield);
                        }
                        player.setShield(i);
                        inventory.remove(i);
                        UI.println("Equipped %s.", i.toString());
                        UI.readStr("Press enter to continue...");
                        equipUseItems();
                    });
                } else if (i.getThing() instanceof Weapon) {
                    choiceMenu.addMenuItem("Equip", () -> {
                        Item weapon = player.getWeapon();
                        if (weapon != null) {
                            inventory.add(weapon);
                        }
                        player.setWeapon(i);
                        inventory.remove(i);
                        UI.println("Equipped %s.", i.toString());
                        UI.readStr("Press enter to continue...");
                        equipUseItems();
                    });
                } else if (i.getThing() instanceof Healing) {
                    choiceMenu.addMenuItem("Use", () -> {
                        player.setHealth(player.getHealth() + ((Healing) i.getThing()).getHealthBack());
                        player.setMagic(player.getMagic() + ((Healing) i.getThing()).getMagicBack());
                        inventory.remove(i);
                        UI.println("Restored HP and MP.");
                        UI.readStr("Press enter to continue...");
                        equipUseItems();
                    });
                }
                choiceMenu.addMenuItem("Drop", () -> {
                    inventory.remove(i);
                    UI.println("Dropped %s.", i.toString());
                    UI.readStr("Press enter to continue...");
                });
                choiceMenu.addMenuItem("Previous", this::equipUseItems);
                choiceMenu.printMenu();
                choiceMenu.getAndExecuteChoice();
            });
        }
        inventoryMenu.addMenuItem("Previous", () -> {});
        inventoryMenu.printMenu();
        inventoryMenu.getAndExecuteChoice();
    }

    private boolean canMoveWest() {
        int newY = map.getPlayerTile().getY() - 1;
        return newY >= 0 && !(map.getMap()[map.getPlayerTile().getX()][newY] instanceof WallTile);
    }

    private boolean canMoveEast() {
        int newY = map.getPlayerTile().getY() + 1;
        return newY <= Map.WIDTH - 1 && !(map.getMap()[map.getPlayerTile().getX()][newY] instanceof WallTile);
    }

    private boolean canMoveSouth() {
        int newX = map.getPlayerTile().getX() + 1;
        return newX <= Map.HEIGHT - 1 && !(map.getMap()[newX][map.getPlayerTile().getY()] instanceof WallTile);
    }

    private boolean canMoveNorth() {
        int newX = map.getPlayerTile().getX() - 1;
        return newX >= 0 && !(map.getMap()[newX][map.getPlayerTile().getY()] instanceof WallTile);
    }

    private void setPlayerOnFloor() {
        int roomnum = RNG.getRInt(map.getRooms().size());
        Point center = map.getRooms().get(roomnum).getCenter();
        Tile playerTile = map.getMap()[center.getX()][center.getY()];
        playerTile.setPlayerHere(true);
        map.setPlayerTile(playerTile);
    }

    private void movePlayer(Direction dir) {
        Tile oldTile = map.getPlayerTile();
        Tile newTile = null;
        switch (dir) {
            case NORTH:
                newTile = map.getMap()[oldTile.getX() - 1][oldTile.getY()];
                break;
            case SOUTH:
                newTile = map.getMap()[oldTile.getX() + 1][oldTile.getY()];
                break;
            case EAST:
                newTile = map.getMap()[oldTile.getX()][oldTile.getY() + 1];
                break;
            case WEST:
                newTile = map.getMap()[oldTile.getX()][oldTile.getY() - 1];
                break;
        }
        oldTile.setPlayerHere(false);
        map.setPlayerTile(newTile);
        newTile.setPlayerHere(true);
    }
}
