package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.entity.Player;
import io.github.pace543.textrpg.map.Map;
import io.github.pace543.textrpg.map.Point;

public class Dungeon {
    private Map map;
    private Player player;

    public Dungeon(Player p) {
        this.player = p;
        map = Map.getInstance();
    }

    public void start() {
        int roomnum = RNG.getRInt(Map.MAX_ROOMS);
        Point center = map.getRooms().get(roomnum).getCenter();
        map.getMap()[center.getX()][center.getY()].setPlayerHere(true);
    }


}
