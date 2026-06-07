package com.example.alda_project;

import com.almasb.fxgl.core.math.FXGLMath;

import java.util.*;

import static com.almasb.fxgl.core.math.FXGLMath.random;
import static com.almasb.fxgl.core.math.FXGLMath.sqrt;

public class GameMap {

    Character[][] mapTiles;
    int mapWidth;
    int mapHeight;
    List<Room> rooms = new ArrayList<Room>();
    static final int ROOMCOUNT = 7;
    GridPosition stairsPos;
    int[][] adjacencyMatrix;
    List<Edge> MST;


    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public GameMap(int mapWidth, int mapHeight)
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

    public Boolean isInAnyRoom(GridPosition pos)
    {


        for(Room room : rooms)
        {
            int roomLeft = room.x + 1;
            int roomRight = room.x + room.width - 1;
            int roomTop = room.y + 1;
            int roomBottom = room.y + room.height - 1;

            boolean inRoom = pos.x >= roomLeft &&
                            pos.x <= roomRight &&
                            pos.y >= roomTop &&
                            pos.y <= roomBottom;


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

        buildAdjecencyMatrix();

    }

    private void buildAdjecencyMatrix()
    {
        int size = rooms.size();
        adjacencyMatrix = new int[size][size];

        for(int i = 0; i < size; i++)
        {
            GridPosition p1 =
                    findRoomMiddlepoint(rooms.get(i));

            for(int j = 0; j < size; j++)
            {
                GridPosition p2 =
                        findRoomMiddlepoint(rooms.get(j));

                int dx = p1.x - p2.x;
                int dy = p1.y - p2.y;

                //Berechnung der Distanz zwischen zwei räumen mit Euklidischer Distanz
                adjacencyMatrix[i][j] =
                        (int)Math.sqrt(dx * dx + dy * dy);
            }
        }

        MST = Edge.computeMST(adjacencyMatrix, rooms.size());

        printAdjecencyMatrix();

        for(Edge edge : MST)
        {

            System.out.println(edge);

        }

        digCorridors();

    }

    public void digCorridors()
    {
        Random random = new Random();
        for(Edge edge : MST)
        {
            Room roomFrom = rooms.get(edge.from);
            Room roomTo = rooms.get(edge.to);

            GridPosition start = findRoomMiddlepoint(roomFrom);
            GridPosition end = findRoomMiddlepoint(roomTo);

            if(random.nextBoolean())
            {
                digHorizontal(start,end);
                digVertical(start, end);
            }
            else
            {
                digVertical(start, end);
                digHorizontal(start,end);
            }

        }
    }

    private void digHorizontal(GridPosition start, GridPosition end)
    {
        GridPosition current = start;

        while(current.x != end.x)
        {
            mapTiles[current.x][current.y] = '.';

            //Generate new Wall Tiles
            GridPosition wallAboveCurrent = new GridPosition(current.x, current.y-1);
            GridPosition wallBenethCurrent = new GridPosition(current.x, current.y +1);


            if(!isInAnyRoom(wallAboveCurrent))
            {
                mapTiles[wallAboveCurrent.x][wallAboveCurrent.y] = '#';
            }
            if(!isInAnyRoom(wallBenethCurrent))
            {
                mapTiles[wallAboveCurrent.x][wallAboveCurrent.y] = '#';
            }

            if(current.x < end.x)
            {
                current.x = current.x +1;
            }
            else
            {
                current.x = current.x -1;
            }
        }

    }

    private void digVertical(GridPosition start, GridPosition end)
    {

        GridPosition current = start;

        while(current.y != end.y)
        {
            mapTiles[current.x][current.y] = '.';

            //Generate new Wall Tiles
            GridPosition wallLeftOfCurrent = new GridPosition(current.x-1, current.y);
            GridPosition wallRightOfCurrent = new GridPosition(current.x+1, current.y);


            if(!isInAnyRoom(wallLeftOfCurrent))
            {
                mapTiles[wallLeftOfCurrent.x][wallLeftOfCurrent.y] = '#';
            }
            if(!isInAnyRoom(wallRightOfCurrent))
            {
                mapTiles[wallRightOfCurrent.x][wallRightOfCurrent.y] = '#';
            }

            if(current.y < end.y)
            {
                current.y = current.y +1;
            }
            else
            {
                current.y = current.y -1;
            }
        }

    }



    public void printAdjecencyMatrix()
    {
        for(int i = 0; i < rooms.size(); i++)
        {
            for(int j = 0; j < rooms.size(); j++)
            {
                System.out.print(adjacencyMatrix[i][j]+ " ");
            }
            System.out.println();
        }


    }

    public GridPosition findRoomMiddlepoint(Room room)
    {
        return new GridPosition(room.x + (room.width / 2), room.y + (room.height) / 2);
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
        System.out.println();
        System.out.println();
        System.out.println();
    }



}
