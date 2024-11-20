package GP;

public class CountWaysToReachNthFloor {
    public static void main(String[] args) {
        int floor = 8;
        System.out.println("number of ways to reach nth floor are " + countWays(floor));
    }
    public static int countWays(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        return countWays(n-1) + countWays(n-2) + countWays(n-3);
    }
}
