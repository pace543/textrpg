package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.map.Map;
import io.github.pace543.textrpg.map.Tile;

import java.io.Console;

class UI {
    private static Console c;

    static void init() {
        c = System.console();
        if (c == null) {
            System.err.println("TextRPG cannot be run on this console!");
            System.exit(0);
        }
    }

    static void cls() {
        for (int i = 0; i < 50; i++) {
            println();
        }
    }

    static void print(String str) {
        c.printf(str);
    }

    static void print(String str, Object... args) {
        c.printf(str, args);
    }

    static void println(String str) {
        print(str + "\n");
    }

    static void println(String str, Object... args) {
        print(str + "\n", args);
    }

    static void println() {
        print("\n");
    }

    static void printLine() {
        println("____________________________________________________________");
    }

    static void printSpaces(int num) {
        for (int i = 0; i < num; i++) {
            print(" ");
        }
    }

    static String readStr(String prompt) {
        return c.readLine(prompt);
    }

    static int readValidInt(String prompt, int min, int max) {
        while (true) {
            try {
                int input = Integer.valueOf(readStr(prompt));
                if (input >= min && input <= max) {
                    return input;
                } else {
                    println("Invalid input!");
                }
            } catch (NumberFormatException ex) {
                println("Invalid input!");
            }
        }
    }

    static void printMap(Map map) {
        Tile[][] tileset = map.getMap();
        for (Tile[] aTileset : tileset) {
            for (Tile anATileset : aTileset) {
                print(anATileset.toString());
            }
            println();
        }
    }


}
