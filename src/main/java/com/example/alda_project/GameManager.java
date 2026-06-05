package com.example.alda_project;
import static com.almasb.fxgl.core.math.FXGLMath.random;

public class GameManager {
    Map map;
    PlayerCharacter playerCharacter;
    Enemy[] enemies = new Enemy[3];



    public void StartGame()
    {
        Map map = new Map(50,50);
        map.addRoomsToMap();
        map.spawnStairs();

        PlayerCharacter playerCharacter;
        playerCharacter = new PlayerCharacter(map.rooms.get(0).x + 1, map.rooms.get(0).y + 1);
        map.mapTiles[playerCharacter.gridPosition.x][playerCharacter.gridPosition.y] = 'C';

        enemies[0] = new Enemy(map.rooms.get(1).x + 2, map.rooms.get(1).y + 2, 1,'G');
        enemies[1] = new Enemy(map.rooms.get(3).x + 1, map.rooms.get(1).y + 1, 6,'Z');
        enemies[2] = new Enemy(map.rooms.get(5).x + 1, map.rooms.get(1).y + 1, 3,'M');

        map.mapTiles[enemies[0].gridPosition.x][enemies[0].gridPosition.y] = enemies[0].symbol;

        map.printMap();
        this.playerCharacter = playerCharacter;
        this.map = map;

    }



    public void playerMove(Direction direction)
    {
        GridPosition newPos = playerCharacter.movePlayer(direction);
        //System.out.println("newPos:" + newPos.x +"/"+ newPos.y +" stairs:"+map.stairsPos.x +"/"+ map.stairsPos.y);
        if(!map.isTileBlocked(newPos))
        {
            GridPosition oldPos = playerCharacter.gridPosition;
            Character oldSymbol = map.mapTiles[oldPos.x][oldPos.y];
            map.mapTiles[newPos.x][newPos.y] = 'C';
            map.mapTiles[oldPos.x][oldPos.y] = '.';
            playerCharacter.gridPosition = newPos;
        }
        else if(newPos.equals(map.stairsPos))
        {
            System.out.println("WonTon Soup");
        }
        else if(map.mapTiles[newPos.x][newPos.y] > 'A' && map.mapTiles[newPos.x][newPos.y] < 'Z')
        {

            System.out.println("ded");
        }
        else
        {
            System.out.println("Wallchicken");
        }




        map.printMap();

    }



}
