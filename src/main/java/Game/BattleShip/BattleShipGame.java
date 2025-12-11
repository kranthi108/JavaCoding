package Game.BattleShip;

import java.util.Arrays;
import java.util.Random;

public class BattleShipGame {
    int N;
    Player A;
    Player B;
    Random random;
    public BattleShipGame() {
        this.random = new Random();
    }
    public void initialize(int N) {
        this.N = N;
        int halfSize = N/2;
        A = new Player("kranthi", 0, halfSize);
        B = new Player("pushpa", halfSize, N);

    }
    public void addShip(String id, int size, int ax, int ay, int bx, int by) {
        Ship shipA = new Ship(id, size, ax, ay);
        Ship shipB = new Ship(id, size, bx, by);
        A.ships.add(shipA);
        B.ships.add(shipB);
    }
    public void viewBattleField() {
        String[][] grid = new String[N][N];
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, "."));
        fillGrid(A, grid, "A");
        fillGrid(B, grid, "B");
        System.out.println("\n--- Battlefield ---");
        System.out.print("   ");
        for(int i=0; i<N; i++) System.out.printf("%4d", i);
        System.out.println();
        for (int x = 0; x < N; x++) {
            System.out.printf("%2d ", x);
            for (int y = 0; y < N; y++) {
                System.out.printf("%4s", grid[x][y]);
            }
            System.out.println();
        }
        System.out.println("-------------------\n");
    }
    public void fillGrid(Player A, String[][] grid, String name) {
        for(Ship s: A.ships) {
            if(!s.hit) {
                for (int x = s.x1; x <= s.x2; x++) {
                    for (int y = s.y1; y <= s.y2; y++) {
                        if (x >= 0 && x < N && y >= 0 && y < N) {
                            grid[y][x] = name + "-" + s.id;
                        }
                    }
                }
            }
        }
    }
    public void startGame() {
        Player defender = A;
        Player attacker = B;
        while(true) {
            String shot;
            int targetX, targetY;
            do {
                targetX = random.nextInt(defender.maxX - defender.minX) + defender.minX;
                targetY = random.nextInt(N);
                shot = targetX + "," + targetY;
            }while (attacker.firedShots.contains(shot));
            attacker.firedShots.add(shot);
            Ship hitShip = null;
            for(Ship s: defender.ships) {
                if(!s.hit && s.presentInCell(targetX, targetY)) {
                    hitShip = s;
                    break;
                }
            }
            if (hitShip != null) {
                hitShip.hit = true;
                System.out.printf("%s's turn: Missile fired at (%d, %d). \"Hit\". %s's ship with id \"%s\" destroyed.\n",
                        attacker.name, targetX, targetY, defender.name, hitShip.id);

                // Check Win
                if (defender.hasLost()) {
                    System.out.println("\nGAME OVER. " + attacker.name + " wins!");
                    break;
                }
            } else {
                System.out.printf("%s's turn: Missile fired at (%d, %d). \"Miss\"\n",
                        attacker.name, targetX, targetY);
            }
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }
    public static void main(String[] args) {
        BattleShipGame game = new BattleShipGame();

        // 1. Initialize Game with Grid Size 10
        // Player A: 0-4, Player B: 5-9
        game.initialize(10);

        // 2. Add Ships
        // Ship 1: Size 4. Center (2,2) -> Range [0-4]. Fits in A.
        // Ship 1: Size 4. Center (7,2) -> Range [5-9]. Fits in B.
        //game.addShip("SH1", 4, 2, 2, 7, 2);

        // Ship 2: Size 2.
        game.addShip("SH2", 2, 2, 7, 7, 7);

        // Optional: View Grid
        game.viewBattleField();

        // 3. Start Simulation
        game.startGame();
    }
}
