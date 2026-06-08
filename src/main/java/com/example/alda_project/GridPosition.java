package com.example.alda_project;

import org.controlsfx.control.spreadsheet.Grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GridPosition implements  Comparable<GridPosition>{

    public int x;
    public int y;

    //variables for A* search
    int g,f,h = 0;
    GridPosition parent;

    public GridPosition(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public int compareTo(GridPosition other)
    {
        return Integer.compare(this.f, other.f);
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

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }




}