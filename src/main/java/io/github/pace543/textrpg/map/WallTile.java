package io.github.pace543.textrpg.map;

import io.github.pace543.textrpg.entity.Entity;

public class WallTile extends Tile {
    WallTile(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canPlayerMoveHere() {
        return false;
    }

    @Override
    public Entity spawn() {
        return null;
    }

    @Override
    public String toString() {
        return ".";
    }
}
