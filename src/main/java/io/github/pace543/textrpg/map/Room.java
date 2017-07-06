package io.github.pace543.textrpg.map;

public class Room {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public static final int MIN_ROOM_SIZE = 5;
    public static final int MAX_ROOM_SIZE = 20;

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Point getCenter() {
        return center;
    }

    private int height;
    private int width;

    private Point center;

    public Room(int x, int y, int h, int w) {
        this.x1 = x;
        this.x2 = x + w;
        this.y1 = y;
        this.y2 = y + h;
        this.height = h;
        this.width = w;
        this.center = new Point((int) Math.floor((x1 + x2) / 2), (int) Math.floor((y1 + y2) / 2));
    }

    public boolean intersects(Room r) {
        return (x1 <= r.getX2() && x2 >= r.getX1() && y1 <= r.getY2() && y2 >= r.getY1());
    }
}
