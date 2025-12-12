package Game.BattleShip;

import java.util.HashSet;
import java.util.Set;

public class Ship {
    String id;
    int size;
    int xCenter, yCenter;
    int x1, x2, y1, y2;
    Set<String> cellsOccupied;
    boolean hit;
    public Ship(String id, int size, int xCenter, int yCenter) {
        this.id = id;
        this.size = size;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        int halfSize = size/2;
        this.x1 = xCenter - halfSize;
        this.x2 = xCenter + halfSize;
        this.y1 = yCenter - halfSize;
        this.y2 = yCenter + halfSize;
        cellsOccupied = new HashSet<>();
        for(int i = x1; i<=x2; i++) {
            for (int j = y1; j <= y2; j++) {
                cellsOccupied.add(i + "," + j);
            }
        }
    }
    public boolean presentInCell(int x, int y) {
        return cellsOccupied.contains(x + "," + y);
    }
}
