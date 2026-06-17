import com.example.alda_project.Enemy;
import com.example.alda_project.GameMap;
import com.example.alda_project.GridPosition;
import com.example.alda_project.Room;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.example.alda_project.Enemy.selectionSort;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest {


    @Test
    void findRoomMiddlepoint_returnsCorrectMiddlepoint() {

        GameMap map = new GameMap(50, 50);

        Room room = new Room(map.getMapWidth(), map.getMapHeight());
        room.setX(10);
        room.setY(20);
        room.setWidth(6);
        room.setHeight(4);

        GridPosition middlePoint = map.findRoomMiddlepoint(room);

        assertEquals(13, middlePoint.x);
        assertEquals(22, middlePoint.y);
    }



        @Test
        public void testSelectionSortBySpeed() {
            // 1. Arrange: Testdaten vorbereiten (Gegner unsortiert erstellen)
            Enemy slowEnemy = new Enemy(1,1,10, 'A');   // speed = 10
            Enemy mediumEnemy = new Enemy(2,2 ,25,'B'); // speed = 25
            Enemy fastEnemy = new Enemy(3,3, 50, 'C');   // speed = 50

            // Eine veränderbare Liste erstellen (wichtig, da wir sie sortieren wollen)
            List<Enemy> enemies = new ArrayList<>();
            enemies.add(fastEnemy);   // Index 0
            enemies.add(slowEnemy);   // Index 1
            enemies.add(mediumEnemy); // Index 2

            // 2. Act: Die Methode ausführen
            // (Falls deine Methode in einer bestimmten Klasse liegt, z.B. EnemySorter,
            // musst du "EnemySorter.selectionSort(enemies);" schreiben)
            selectionSort(enemies);

            // 3. Assert: Überprüfen, ob die Liste korrekt aufsteigend sortiert wurde
            assertEquals(slowEnemy, enemies.get(0), "Das langsamste Element sollte an erster Stelle stehen.");
            assertEquals(mediumEnemy, enemies.get(1), "Das mittelschnelle Element sollte an zweiter Stelle stehen.");
            assertEquals(fastEnemy, enemies.get(2), "Das schnellste Element sollte an letzter Stelle stehen.");
        }
    }


