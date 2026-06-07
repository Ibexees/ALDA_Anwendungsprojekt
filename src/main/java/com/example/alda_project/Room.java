package com.example.alda_project;

import static com.almasb.fxgl.core.math.FXGLMath.random;

public class Room {

    int x;
    int y;
    int width;
    int height;
    static int roomCount = 0;
    int id;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static int getRoomCount() {
        return roomCount;
    }

    public int getId() {
        return id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void setRoomCount(int roomCount) {
        Room.roomCount = roomCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room(int mapWidth, int mapHeight)
    {

        width = random(7, 13);
        height = random(7, 13);

        x = random(0, mapWidth - width);
        y = random(0, mapHeight - height);
        id = roomCount;
        roomCount = roomCount +1;
    }

    public double distanceTo(Room other) {
        // TODO: euklidische Distanz berechnen
        return .0;
    }

    public Room(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}
