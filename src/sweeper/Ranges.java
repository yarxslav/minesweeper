package sweeper;

import java.util.ArrayList;
import java.util.List;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoords;

    public static void setSize(Coord newSize) {
        size = newSize;
        allCoords = new ArrayList<Coord>();
        for (int y = 0; y < size.getY(); y++) {
            for (int x = 0; x < size.getX(); x++) {
                allCoords.add(new Coord(x, y));
            }
        }
    }

    public static Coord getSize() {
        return size;
    }

    public static List<Coord> getAllCords() {
        return allCoords;
    }
}
