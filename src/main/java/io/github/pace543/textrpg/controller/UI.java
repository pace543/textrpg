package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.map.Map;
import io.github.pace543.textrpg.map.Tile;

import java.io.Console;

public class UI {
    private static Console c;

    public static void init() {
        c = System.console();
        if (c == null) {
            System.err.println("TextRPG cannot be run on this console!");
            System.exit(0);
        }
    }

    public static void cls() {
        for (int i = 0; i < 50; i++) {
            println();
        }
    }

    public static void print(String str) {
        c.printf(str);
    }

    public static void print(String str, Object...args) {
        c.printf(str, args);
    }

    public static void println(String str) {
        print(str + "\n");
    }

    public static void println(String str, Object...args) {
        print(str + "\n", args);
    }

    public static void println() {
        print("\n");
    }

    public static void printLine() {
        println("____________________________________________________________");
    }

    public static void printSpaces(int num) {
        for (int i = 0; i < num; i++) {
            print(" ");
        }
    }

    public static String readStr(String prompt) {
        return c.readLine(prompt);
    }

    public static int readValidInt(String prompt, int min, int max) {
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

    public static void printMap(Map map) {
        Tile[][] tileset = map.getMap();
        for (int x = 0; x < tileset.length; x++) {
            for (int y = 0; y < tileset[x].length; y++) {
                print(tileset[x][y].toString());
            }
            println();
        }
    }
}
