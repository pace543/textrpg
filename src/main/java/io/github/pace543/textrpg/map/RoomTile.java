package io.github.pace543.textrpg.map;

import io.github.pace543.textrpg.entity.Enemy;
import io.github.pace543.textrpg.entity.Entity;

public class RoomTile extends Tile {
    RoomTile(int x, int y) {
        super(x, y);
    }

    private boolean isStaircase;

    @Override
    public boolean canPlayerMoveHere() {
        return true;
    }

    public Enemy spawn(int floorNum) {
        return null;
    }

    @Override
    public String toString() {
        if (this.isPlayerHere()) {
            return "P";
        } else if (this.isStaircase()) {
            return "S";
        } else {
            return "o";
        }
    }

    public boolean isStaircase() {
        return isStaircase;
    }

    public void setStaircase(boolean staircase) {
        isStaircase = staircase;
    }
}
