package io.github.pace543.textrpg.controller;

import java.util.Random;

public class RNG {
    private static Random rand = new Random();

    public static int getRInt(int bound) {
        return rand.nextInt(bound);
    }
}
