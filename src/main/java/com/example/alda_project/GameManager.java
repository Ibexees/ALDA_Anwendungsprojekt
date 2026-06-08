package com.example.alda_project;
import java.util.ArrayList;
import java.util.List;

import static com.almasb.fxgl.core.math.FXGLMath.random;

public class GameManager {
    GameMap map;
    PlayerCharacter playerCharacter;
    List<Enemy> enemies = new ArrayList<>();



    public void StartGame()
    {
        GameMap map = new GameMap(50,50);
        map.addRoomsToMap();
        map.spawnStairs();

        PlayerCharacter playerCharacter;
        playerCharacter = new PlayerCharacter(map.rooms.get(0).x + 1, map.rooms.get(0).y + 1);
        map.mapTiles[playerCharacter.gridPosition.x][playerCharacter.gridPosition.y] = 'C';

        enemies.add(new Enemy(map.rooms.get(1).x + 3, map.rooms.get(1).y + 3, 1,'G'));
        enemies.add(new Enemy(map.rooms.get(3).x + 1, map.rooms.get(3).y + 1, 6,'Z'));
        enemies.add(new Enemy(map.rooms.get(5).x + 1, map.rooms.get(5).y + 1, 3,'M'));

        for(Enemy enemy : enemies) {
            map.mapTiles[enemy.gridPosition.x][enemy.gridPosition.y] = enemy.symbol;
        }

        map.printMap();
        this.playerCharacter = playerCharacter;
        this.map = map;

    }

    public void moveEnemiesTowardsPlayer(GridPosition playerPosition)
    {
        List<Enemy> toRemove = new ArrayList<>();

        for(Enemy enemy : enemies) {
            System.out.println("Name:" + enemy.symbol + " Gridposition:" +enemy.gridPosition);
            GridPosition nextMove = map.findPath(new GridPosition(enemy.gridPosition.x,enemy.gridPosition.y), new GridPosition(playerPosition.x,playerPosition.y)).get(1);

            GridPosition oldPos = enemy.gridPosition;
            Character swapSymbol = map.mapTiles[nextMove.x][nextMove.y];

           if(nextMove.equals(playerPosition))
            {
                toRemove.add(enemy);
                map.mapTiles[oldPos.x][oldPos.y] = '.';
                triggerBattle();
            }
            else
            {
                map.mapTiles[nextMove.x][nextMove.y] = enemy.symbol;
                map.mapTiles[oldPos.x][oldPos.y] = swapSymbol;
                enemy.gridPosition = nextMove;
                System.out.println("Name:" + enemy.symbol + " Gridposition:" +enemy.gridPosition);
            }


        }
        for(Enemy enemy : toRemove)
        {
            enemies.remove(enemy);
        }
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
            triggerBattle();
        }

        moveEnemiesTowardsPlayer(playerCharacter.gridPosition);


        map.printMap();

    }

    public void triggerBattle()
    {

        System.out.println("Trigger Battle");

    }


}
