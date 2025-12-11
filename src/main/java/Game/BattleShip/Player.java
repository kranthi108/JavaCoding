package Game.BattleShip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    String name;
    List<Ship> ships;
    Set<String> firedShots;
    int minX, maxX;
    public Player(String name, int minX, int maxX) {
        this.name = name;
        this.maxX = maxX;
        this.minX = minX;
        this.ships = new ArrayList<>();
        this.firedShots = new HashSet<>();
    }
    public void addShip(Ship s) {
        this.ships.add(s);
    }
    public boolean hasLost() {
        for(Ship s: ships) {
            if(s.hit) return true;
        }
        return false;
    }
}
