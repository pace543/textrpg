package io.github.pace543.textrpg.controller;

import java.util.ArrayList;

final class Menu {
    private static class MenuItem {
        private String name;
        private Command command;

        MenuItem(String name, Command command) {
            this.name = name;
            this.command = command;
        }

        public Command getCommand() {
            return command;
        }

        public String getName() {
            return name;
        }
    }

    private final ArrayList<MenuItem> menu;
    private final String name;

    Menu(String name) {
        menu = new ArrayList<>();
        this.name = name;
    }

    void addMenuItem(String name, Command command) {
        menu.add(new MenuItem(name, command));
    }

    void printMenu() {
        UI.printLine();
        UI.print("| %s", name);
        UI.printSpaces(57 - name.length());
        UI.println("|");
        UI.println("| ======================================================== |");
        for (int j = 0; j < menu.size(); j++) {
            UI.print("| %d) %s", j + 1, menu.get(j).getName());
            int numLength = Integer.toString(j + 1).length();
            UI.printSpaces(55 - numLength - menu.get(j).getName().length());
            UI.println("|");
        }
        UI.println("|__________________________________________________________|");
    }

    void getAndExecuteChoice() {
        int choice = UI.readValidInt("Enter your choice: ", 1, menu.size());
        int iter = 1;

        for (MenuItem mi : menu) {
            if (iter == choice) {
                mi.getCommand().execute();
                break;
            } else {
                iter++;
            }
        }
    }
}
