package io.github.pace543.textrpg.map;

import io.github.pace543.textrpg.controller.RNG;

import java.util.ArrayList;

public class Map {
    private ArrayList<Room> rooms = new ArrayList<>();
    private static final int MAX_ROOMS = 10;
    private static final int HEIGHT = 30;
    private static final int WIDTH = 60;
    private Tile[][] map = new Tile[HEIGHT][WIDTH];

    private Map(){}

    private Map(Tile[][] tiles) {
        map = tiles;
    }

    public static Map getInstance() {
        Map map = new Map();
        map.placeRooms();
        map.fillEmptySpaces();
        return map;
    }

    public static Map getInstance(Tile[][] tileset) {
        Map map = new Map(tileset);
        return map;
    }

    private void clear() {
        map = new Tile[HEIGHT][WIDTH];
    }

    private void placeRooms() {
        Point newCenter = null;

        for (int i = 0; i < MAX_ROOMS; i++) {
            int w = Room.MIN_ROOM_SIZE + RNG.getRInt(Room.MAX_ROOM_SIZE - Room.MIN_ROOM_SIZE + 1);
            int h = Room.MIN_ROOM_SIZE + RNG.getRInt(Room.MAX_ROOM_SIZE - Room.MIN_ROOM_SIZE + 1);
            int x = RNG.getRInt(HEIGHT - h + 1);
            int y = RNG.getRInt(WIDTH - w + 1);

            Room newRoom = new Room(x, y, w, h);

            boolean canBePlaced = true;
            for (Room r : rooms) {
                if (newRoom.intersects(r)) {
                    canBePlaced = false;
                }
            }

            if (canBePlaced) {
                createRoom(newRoom);

                newCenter = newRoom.getCenter();
                if (rooms.size() != 0) {
                    Point prevCenter = rooms.get(rooms.size() - 1).getCenter();
                    if (RNG.getRInt(2) == 1) {
                        createHorizontalCorridor(prevCenter.getX(), newCenter.getX(), prevCenter.getY());
                        createVerticalCorridor(prevCenter.getY(), newCenter.getY(), newCenter.getX());
                    } else {
                        createVerticalCorridor(prevCenter.getY(), newCenter.getY(), prevCenter.getX());
                        createHorizontalCorridor(prevCenter.getX(), newCenter.getX(), newCenter.getY());
                    }
                }

                rooms.add(newRoom);
            }
        }
    }

    private void createRoom(Room r) {
        for (int x = r.getX1(); x < r.getX2(); x++) {
            for (int y = r.getY1(); y < r.getY2(); y++) {
                map[x][y] = new RoomTile(x, y);
            }
        }
    }

    private void createHorizontalCorridor(int x1, int x2, int y) {
        for (int a = Math.min(x1, x2); a < Math.max(x1, x2) + 1; a++) {
            map[a][y] = new RoomTile(a, y);
        }
    }

    private void createVerticalCorridor(int y1, int y2, int x) {
        for (int b = Math.min(y1, y2); b < Math.max(y1, y2) + 1; b++) {
            map[x][b] = new RoomTile(x, b);
        }
    }

    private void fillEmptySpaces() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if (map[x][y] == null) {
                    map[x][y] = new WallTile(x, y);
                }
            }
        }
    }

    public Tile[][] getMap() {
        return map;
    }
}
