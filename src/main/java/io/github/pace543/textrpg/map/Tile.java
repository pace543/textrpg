package io.github.pace543.textrpg.map;

import io.github.pace543.textrpg.entity.Entity;

public abstract class Tile {
    private int x;
    private int y;
    private boolean player;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isPlayerHere() {
        return player;
    }

    public void setPlayerHere(boolean p) {
        player = p;
    }

    public abstract boolean canPlayerMoveHere();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
