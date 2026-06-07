import com.example.alda_project.GameMap;
import com.example.alda_project.GridPosition;
import com.example.alda_project.Room;
import org.junit.jupiter.api.Test;

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

}
