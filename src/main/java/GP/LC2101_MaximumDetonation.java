package GP;

public class LC2101_MaximumDetonation {
    // Google question somewhat modified
    private double distance(Router r1, Router r2) {
        return Math.sqrt((r1.x - r2.x) * (r1.x - r2.x) + (r1.y - r2.y) * (r1.y - r2.y));
    }
    private boolean inRange(Router r1, Router r2) {
        return distance(r1, r2) <= 10.0;
    }
    private class Router {
        int x,y;
        String name;
        public Router(int x, int y, String name) {
            this.x = x;
            this.y = y;
            this.name = name;
        }
        public boolean equals(Object r) {
            Router router = (Router) r;
            return x == router.x && y == router.y && name.equals(router.name);
        }
    }
    boolean maximumDetonation(int[][] bombs) {
        return true;
    }


    public static void main(String[] args) {
        LC2101_MaximumDetonation l = new LC2101_MaximumDetonation();
        Router b1 = l.new Router(0, 0, "a");
        Router b2 = l.new Router(0, 8, "b");
        Router b3 = l.new Router(0, 17, "c");
        Router b4 = l.new Router(11, 0, "d");
        System.out.println(l.maximumDetonation(new int[][]{{2,1,3},{6,1,4}}));
    }
}




// LC Solution


//    public int maximumDetonation(int[][] bombs) {
//        int n = bombs.length;
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            ans = Math.max(ans, dfs(bombs, i, new boolean[n]));
//        }
//        return ans;
//    }
//
//    boolean inRange(int[] bomb1, int[] bomb2) {
//        int dx = bomb1[0] - bomb2[0];
//        int dy = bomb1[1] - bomb2[1];
//        return dx * dx + dy * dy <= bomb1[2] * bomb1[2];
//    }
//
//    int dfs(int[][] bombs, int idx, boolean[] visited) {
//        int count = 1;
//        visited[idx] = true;
//        int n = bombs.length;
//        for(int i = 0; i<n; i++) {
//            if(!visited[i] && inRange(bombs[idx], bombs[i])) {
//                count += dfs(bombs, i, visited);
//            }
//        }
//        return count;
//    }









