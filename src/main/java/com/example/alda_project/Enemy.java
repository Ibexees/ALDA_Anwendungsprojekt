package com.example.alda_project;

public class Enemy {

    GridPosition gridPosition;
    int speed;
    Character symbol;

    public Enemy(int x, int y, Character symbol)
    {
        this.symbol = symbol;
        this.gridPosition = new GridPosition(x,y);

    }

}
