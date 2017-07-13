package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.item.*;

import static io.github.pace543.textrpg.controller.Controller.player;

class Store {
    static void healingStore() {
        UI.cls();
        Menu healingStore = new Menu("Healing Store");
        healingStore.addMenuItem("Buy Healing", Store::buyHealing);
        healingStore.addMenuItem("Sell Healing", Store::sellHealing);
        healingStore.addMenuItem("Return to Town", () -> {});
        healingStore.printMenu();
        healingStore.getAndExecuteChoice();
    }

    static void weaponStore() {
        UI.cls();
        Menu weaponStore = new Menu("Weapon Store");
        weaponStore.addMenuItem("Buy Weapons", Store::buyWeapons);
        weaponStore.addMenuItem("Sell Weapons", Store::sellWeapons);
        weaponStore.addMenuItem("Return to Town", () -> {});
        weaponStore.printMenu();
        weaponStore.getAndExecuteChoice();
    }

    static void shieldStore() {
        UI.cls();
        Menu shieldStore = new Menu("Shield Store");
        shieldStore.addMenuItem("Buy Shields", Store::buyShields);
        shieldStore.addMenuItem("Sell Shields", Store::sellShields);
        shieldStore.addMenuItem("Return to Town", () -> {});
        shieldStore.printMenu();
        shieldStore.getAndExecuteChoice();
    }

    static void armorStore() {
        UI.cls();
        Menu armorStore = new Menu("Armor Store");
        armorStore.addMenuItem("Buy Armor", Store::buyArmor);
        armorStore.addMenuItem("Sell Armor", Store::sellArmor);
        armorStore.addMenuItem("Return to Town", () -> {});
        armorStore.printMenu();
        armorStore.getAndExecuteChoice();
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
        sellHealing.addMenuItem("Previous", Store::healingStore);
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
        buyHealing.addMenuItem("Previous", Store::healingStore);
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
        sellArmor.addMenuItem("Previous", Store::armorStore);
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
        buyArmor.addMenuItem("Previous", Store::armorStore);
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
        sellWeapons.addMenuItem("Previous", Store::weaponStore);
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
        buyWeapons.addMenuItem("Previous", Store::weaponStore);
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
        sellShields.addMenuItem("Previous", Store::shieldStore);
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
        buyShields.addMenuItem("Previous", Store::shieldStore);
        buyShields.printMenu();
        buyShields.getAndExecuteChoice();
    }

    private static void buy(ItemType item) {
        if (player.getMoney() >= item.getCost()) {
            player.setMoney(player.getMoney() - item.getCost());
            player.getInventory().add(new Item(item));
            UI.println("Bought %s.", item.getName());
            UI.readStr("Press enter to continue...");
        } else {
            UI.println("Cannot afford %s.", item.getName());
            UI.readStr("Press enter to continue...");
        }
    }

    private static void sell(Item item, int sellValue) {
        player.setMoney(player.getMoney() + sellValue);
        player.getInventory().remove(item);
        UI.println("Sold %s.", item.toString());
        UI.readStr("Press enter to continue...");
    }
}
