package GP;

//        [[“1”,”1”,”1”,”1”,”0”],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        [“0”,”0”,”0”,”0”,”0”]]
//
//        “1” —> island
//“0” represent water
//Find the number of island present in the given array

//
//        [[“1”,”1”,”1”,”1”,”0”],
//        [“0”,”1”,”0”,”1”,”0”],
//        ["1","1","0","0","0"],
//        [“0”,”0”,”0”,”1”,”0”]]
public class Rakuten {
//    public static void main(String[] args) {
//        char[][] grid = {{'0','0','1','1','0'},
//                        {'0','1','0','1','0'},
//                        {'1','1','0','0','1'},
//                        {'0','0','0','0','0'}};
//        System.out.printf("numboer of islands " + numIslands(grid));
//    }
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int count =0;
        int rows = grid.length , cols = grid[0].length;
        for(int i = 0; i< rows; i++) {
            for(int j = 0; j<cols ; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

    }




//      [-1,0,3,5,9,12,20,24,30]

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        int target = 9;
        int left = 0, right = array.length -1;
        while (left <= right) {
            int mid = (left + right)/2;
            if(array[mid] == target) {
                System.out.printf("number " + mid);
            }
            else if(array[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println();

    }
}









