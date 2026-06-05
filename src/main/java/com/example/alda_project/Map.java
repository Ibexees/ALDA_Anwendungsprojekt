package com.example.alda_project;

import com.almasb.fxgl.core.math.Vec2;

import java.util.ArrayList;
import java.util.List;

import static com.almasb.fxgl.core.math.FXGLMath.random;

public class Map {

    Character[][] mapTiles;
    int mapWidth;
    int mapHeight;
    List<Room> rooms = new ArrayList<Room>();
    static final int ROOMCOUNT = 7;
    GridPosition stairsPos;





    public Map(int mapWidth, int mapHeight)
    {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        mapTiles = new Character[mapWidth][mapHeight];

    }

    public Boolean isTileBlocked(GridPosition pos)
    {
        if(mapTiles[pos.x][pos.y] != '.')
        {
            return true;
        }
        else {return false;}

    }

    public void spawnStairs()
    {
        Room stairRoom = rooms.get(6);

        int randomX = random(stairRoom.x+1,stairRoom.x + stairRoom.width-2);
        int randomY = random(stairRoom.y+1,stairRoom.y + stairRoom.height-2);
        System.out.println("StairroomX: "+ stairRoom.x +" StairroomY:" +stairRoom.y + " RandomX:"+ randomX + " randomY:" + randomY);
        this.stairsPos = new GridPosition(randomX, randomY);
        mapTiles[randomX][randomY] = 'S';

    }

    public Boolean isInRoom(GridPosition pos)
    {


        for(Room room : rooms)
        {
            int roomLeft = room.x + 1;
            int roomRight = room.x - room.width + 1;
            int roomTop = room.y + 1;
            int roomBottom = room.y - room.height + 1;

            boolean inRoom = pos.x < roomRight &&
                             pos.x > roomLeft &&
                             pos.y < roomTop &&
                             pos.y > roomBottom;

            if(inRoom)
            {
                return true;
            }

        }
        return false;
    }


    public void addRoomsToMap()
    {
        while(rooms.size() < ROOMCOUNT) {

            Room room = new Room(mapWidth,mapHeight);
            if(!checkIfRoomOverlaps(room))
            {
                addRoom(room);
            }
        }

    }

    private Boolean checkIfRoomOverlaps(Room newRoom)
    {
        for(Room room : rooms)
        {
            // Ein Abstand damit Rooms nicht zusammenkleben.
            int roomLeft = room.x - 1;
            int roomRight = room.x + room.width + 1;
            int roomTop = room.y - 1;
            int roomBottom = room.y + room.height + 1;

            int newLeft = newRoom.x;
            int newRight = newRoom.x + newRoom.width;
            int newTop = newRoom.y;
            int newBottom = newRoom.y + newRoom.height;

            boolean overlap =
                            newLeft <= roomRight &&
                            newRight >= roomLeft &&
                            newTop <= roomBottom &&
                            newBottom >= roomTop;

            if (overlap)
            {
                return true;
            }
        }

        return false;

    }

    private void addRoom(Room room)
    {
        rooms.add(room);
        for (int i = room.x; i < room.x + room.width; i++) {
            for (int j = room.y; j < room.y + room.height; j++) {
                if (i == room.x || j == room.y || i == room.x + room.width-1 || j == room.y + room.height-1) {
                    mapTiles[i][j] = '#';
                } else {
                    mapTiles[i][j] = '.';
                }

            }

        }

    }

    public void printMap()
    {

        for(int i = 0; i < mapWidth; i++)
        {
            for(int j = 0; j < mapHeight; j++)
            {
                if(mapTiles[i][j] != null)
                {
                    System.out.print(mapTiles[i][j]);
                }
                else
                {
                    System.out.print('-');
                }

            }
            System.out.println();

        }

    }



}
