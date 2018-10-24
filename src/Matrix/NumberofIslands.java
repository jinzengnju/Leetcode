package Matrix;

public class NumberofIslands {
    public static void main(String[] args){}
    private int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    private int res=0;
    private int m;
    private int n;
    public int getRes(int[][] grid){
        this.m=grid.length;
        this.n=grid[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==1){
                    dfs(grid,i,j);
                    res++;
                }

            }
        }
        return res;

    }
    private void dfs(int[][] grids,int row,int col){
        if (row<0||row>=m||col<0||col>=n||grids[row][col]==0)
            return;
        grids[row][col]=0;
        for (int[] d:direction){
            dfs(grids,row+d[0],col+d[1]);
        }
    }

}
