package com.example.alda_project;

import java.util.ArrayList;
import java.util.List;

public class Enemy {

    GridPosition gridPosition;
    int speed;
    Character symbol;

    public Enemy(int x, int y,int speed, Character symbol)
    {
        this.symbol = symbol;
        this.gridPosition = new GridPosition(x,y);
        this.speed = speed;
    }

    public static void selectionSort(Enemy[] enemies) {

        int indexSmallestUnsorted;
        for (int i = 0; i < enemies.length; i++)
        {
            //leftmost counts as sorted initially
            indexSmallestUnsorted = i;

            for (int j = i+1; j < enemies.length; j++)
            {
                if(enemies[indexSmallestUnsorted].speed > enemies[j].speed)
                {
                    indexSmallestUnsorted = j;
                }
            }
            if(indexSmallestUnsorted > i)
            {
                Enemy placeholder = enemies[indexSmallestUnsorted];
                enemies[indexSmallestUnsorted] = enemies[i];
                enemies[i] = placeholder;
            }

        }

    }

    public static void selectionSort(List<Enemy> enemies) {

        int indexSmallestUnsorted;
        for (int i = 0; i < enemies.size(); i++)
        {
            // Das am weitesten links stehende Element gilt anfangs als sortiert
            indexSmallestUnsorted = i;

            for (int j = i + 1; j < enemies.size(); j++)
            {
                // Nutzen von .get(index), um auf die Elemente der Liste zuzugreifen
                if (enemies.get(indexSmallestUnsorted).speed > enemies.get(j).speed)
                {
                    indexSmallestUnsorted = j;
                }
            }

            if (indexSmallestUnsorted > i)
            {
                // Tauschen der Elemente mithilfe von .get() und .set()
                Enemy placeholder = enemies.get(indexSmallestUnsorted);
                enemies.set(indexSmallestUnsorted, enemies.get(i));
                enemies.set(i, placeholder);
            }
        }
    }



}
