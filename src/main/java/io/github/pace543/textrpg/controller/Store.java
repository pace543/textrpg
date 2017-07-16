package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.item.*;
import static io.github.pace543.textrpg.controller.Controller.player;

class Store<T extends ItemType> {
    private Class<T> clazz;

    Store(Class<T> clazz) {
        this.clazz = clazz;
    }

    void start() {
        UI.cls();
        Menu store;
        if (clazz.isAssignableFrom(Armor.class)) {
            store = new Menu("Armor Store");
            store.addMenuItem("Buy Armor", () -> this.buy("Buy Armor"));
            store.addMenuItem("Sell Armor", () -> this.sell("Sell Armor"));
            store.addMenuItem("Return to Town", () -> {});
        } else if (clazz.isAssignableFrom(Healing.class)) {
            store = new Menu("Healing Store");
            store.addMenuItem("Buy Healing", () -> this.buy("Buy Healing"));
            store.addMenuItem("Sell Healing", () -> this.sell("Sell Healing"));
            store.addMenuItem("Return to Town", () -> {});
        } else if (clazz.isAssignableFrom(Shield.class)) {
            store = new Menu("Shield Store");
            store.addMenuItem("Buy Shields", () -> this.buy("Buy Shields"));
            store.addMenuItem("Sell Shields", () -> this.sell("Sell Shields"));
            store.addMenuItem("Return to Town", () -> {});
        } else {
            store = new Menu("Weapon Store");
            store.addMenuItem("Buy Weapons", () -> this.buy("Buy Weapons"));
            store.addMenuItem("Sell Weapons", () -> this.sell("Sell Weapons"));
            store.addMenuItem("Return to Town", () -> {});
        }
        store.printMenu();
        store.getAndExecuteChoice();
    }

    private void buy(String name) {
        UI.cls();
        Menu buyMenu = new Menu(name);
        for (T item : clazz.getEnumConstants()) {
            buyMenu.addMenuItem(item.toString(), () -> {
                if (player.getMoney() >= item.getCost()) {
                    player.setMoney(player.getMoney() - item.getCost());
                    player.getInventory().add(new Item(item));
                    UI.println("Bought %s.", item.getName());
                    UI.readStr("Press enter to continue...");
                } else {
                    UI.println("Cannot afford %s.", item.getName());
                    UI.readStr("Press enter to continue...");
                }
                buy(name);
            });
        }
        buyMenu.addMenuItem("Previous", this::start);
        buyMenu.printMenu();
        buyMenu.getAndExecuteChoice();
    }

    private void sell(String name) {
        UI.cls();
        Menu sellMenu = new Menu(name);
        for (Item i : player.getInventory()) {
            if (clazz.isInstance(i.getThing())) {
                int sellValue = (int) (i.getThing().getCost() * i.getHealth());
                sellMenu.addMenuItem(i.toString() + " COST: " + sellValue, () -> {
                    player.setMoney(player.getMoney() + sellValue);
                    player.getInventory().remove(i);
                    UI.println("Sold %s.", i.toString());
                    UI.readStr("Press enter to continue...");
                    sell(name);
                });
            }
        }
        sellMenu.addMenuItem("Previous", this::start);
        sellMenu.printMenu();
        sellMenu.getAndExecuteChoice();
    }
}
