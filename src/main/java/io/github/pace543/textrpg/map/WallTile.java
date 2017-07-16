package io.github.pace543.textrpg.map;

public class WallTile extends Tile {
    WallTile(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canPlayerMoveHere() {
        return false;
    }

    @Override
    public String toString() {
        return ".";
    }
}
