package GP;


//nxn

// each cell is water or land  water = o , land = 1
// group of land makes an island
// exactly 2 islands , need to find minimum distandce between them, only vertical and horzontal is avalilabel shifts


import java.util.LinkedList;
import java.util.Queue;

public class Tekion1 {
    static int[][] directions = {{1,0},{-1,0},{0,1}, {0,-1}};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) {
        int[][] grid = {
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0},
                {0,0,0,1}
        };
        shortestDistance(grid);
    }
    public static int shortestDistance(int[][] grid) {
        int n = grid.length;
        boolean found = false;
        for(int i=0;i<n; i++) {
            if(found) break;
            for (int j =0; j<n; j++) {
                if(grid[i][j] ==1) {
                    dfs(grid, i,j,n);
                    found = true;
                    break;
                }
            }
        }
        int flag = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0){
                int[] cell = queue.poll();
                for(int[] dir: directions) {
                    int n1 = cell[0] + dir[0];
                    int n2 = cell[1] + dir[1];
                    if(n1 >= 0 && n2>= 0 && n1 < n &&n2 <n) {
                        if(grid[n1][n2] == 1) {
                            return flag;
                        }
                    }
                    if(grid[n1][n2] == 0) {
                        grid[n1][n2] = -1;
                        queue.offer(new int[]{n1,n2});
                    }
                }
            }
            flag++;
        }
     return -1;
    }
    public static void dfs(int[][] grid, int i, int j,int n) {
        if(i<0 || j<0 || i>= n || j>=n || grid[i][j]  != 1){
            return;
        }
        grid[i][j] = -1;
        queue.offer(new int[]{i,j});
        for(int[] dir: directions) {
            dfs(grid, i+dir[0], j+dir[1],n);;
        }
    }
}
