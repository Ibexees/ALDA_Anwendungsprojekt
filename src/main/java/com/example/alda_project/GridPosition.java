package com.example.alda_project;

import org.controlsfx.control.spreadsheet.Grid;

public class GridPosition {

    public int x;
    public int y;

    public GridPosition(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof GridPosition) {
            GridPosition gridPosition = (GridPosition) o;
            if (x == gridPosition.x && y == gridPosition.y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString()
    {
        return this.x + "/" + this.y;
    }

}