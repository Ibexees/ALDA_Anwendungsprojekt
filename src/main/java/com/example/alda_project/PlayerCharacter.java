package com.example.alda_project;



public class PlayerCharacter {

    GridPosition gridPosition;

    public PlayerCharacter(int x, int y)
    {
        this.gridPosition = new GridPosition(x,y);

    }



    public GridPosition movePlayer(Direction direction)
    {
        switch(direction)
        {
            case UP: return(new GridPosition(gridPosition.x-1, gridPosition.y));
            case DOWN:  return(new GridPosition(gridPosition.x+1, gridPosition.y));
            case LEFT: return(new GridPosition(gridPosition.x, gridPosition.y-1));
            case RIGHT: return(new GridPosition(gridPosition.x, gridPosition.y+1));

        }
        return(null);
    }


}
