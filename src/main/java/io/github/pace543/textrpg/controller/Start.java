package io.github.pace543.textrpg.controller;

public class Start {
    public static void main(String[] args) {
        UI.init();
        UI.cls();
        introMenu();
    }

    public static void introMenu() {
        UI.cls();
        Menu startMenu = new Menu("Welcome to TextRPG!");
        startMenu.addMenuItem("New Game", () -> Controller.start(Controller.GameType.NEW));
        startMenu.addMenuItem("Load Game", () -> Controller.start(Controller.GameType.LOAD));
        startMenu.addMenuItem("About TextRPG", Start::aboutGame);
        startMenu.addMenuItem("Exit TextRPG", () -> System.exit(0));
        startMenu.printMenu();
        startMenu.getAndExecuteChoice();
    }

    private static void aboutGame() {
        UI.cls();
        UI.printLine();
        UI.print("| About TextRPG");
        UI.printSpaces(44);
        UI.println("|");
        UI.println("| ======================================================== |");
        UI.println("| As the name suggests, TextRPG is a text-based role-      |");
        UI.println("| playing game, conducted mostly through numerical input.  |");
        UI.println("| I created TextRPG as a side project to experience        |");
        UI.println("| creating and building on a moderately-sized Java         |");
        UI.println("| program and to practically use OOP principles.           |");
        UI.println("| I hope the game is fun and works well! :)                |");
        UI.println("|                                                          |");
        UI.println("| Created in 2017.                                         |");
        UI.println("|__________________________________________________________|");
        UI.readStr("Press enter to continue...");
        introMenu();
    }
}
