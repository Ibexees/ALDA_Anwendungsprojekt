package com.example.alda_project;

import static com.almasb.fxgl.core.math.FXGLMath.random;

public class Room {

    int x;
    int y;
    int width;
    int height;
    static int roomCount = 0;
    int id;

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
