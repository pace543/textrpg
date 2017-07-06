package io.github.pace543.textrpg.map;

import io.github.pace543.textrpg.entity.Entity;

public class RoomTile extends Tile {
    RoomTile(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canPlayerMoveHere() {
        return true;
    }

    @Override
    public Entity spawn() {
        return null;
    }

    @Override
    public String toString() {
        if (this.isPlayerHere()) {
            return "P";
        } else {
            return "o";
        }
    }
}
