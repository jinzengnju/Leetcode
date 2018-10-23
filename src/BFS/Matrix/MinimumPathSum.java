package BFS.Matrix;

//[[1,3,1],
// [1,5,1],
// [4,2,1]]
//Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
//这道题不是用广度优先搜索，而是用动态规划

public class MinimumPathSum {
    public static void main(String[] args){}

    public int getRes(int[][] grid){
        if (grid==null||grid.length==0){
            return 0;
        }
        int m=grid[0].length;
        int[] dp=new int[m];
        for (int i=0;i<m;i++){
            dp[i]=grid[0][i];
        }
        for (int i=1;i<grid.length;i++){
            dp[0]=grid[i][0];
            for (int j=1;j<m;j++){
                dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
            }
        }
        return dp[m-1];
    }

//    public int minPathSum(int[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int m = grid.length, n = grid[0].length;
//        int[] dp = new int[n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0) {
//                    dp[j] = dp[j - 1];
//                } else {
//                    dp[j] = Math.min(dp[j - 1], dp[j]);
//                }
//                dp[j] += grid[i][j];
//            }
//        }
//        return dp[n - 1];
//    }

}
