package OtherWithAnything;

public class MaxAreaofIsland {

    public static void main(String[] args){}

    private int rows;
    private int cols;
    private int res=0;
    private static int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};

    public int getMaxArea(int[][] grid){
        this.rows=grid.length;
        this.cols=grid[0].length;
        for (int i=0;i<this.rows;i++){
            for(int j=0;j<this.cols;j++){
                this.res=Math.max(this.res,dfs(grid,i,j));
            }
        }
        return this.res;
    }


    private int dfs(int[][] grid,int r,int l){
        if (r<0||r>this.rows||l<0||l>this.cols||grid[r][l]==0)
            return 0;
        int area=1;//这里的area相当于一个统计量的作用
        grid[r][l]=0;
        for (int[] d:direction){
            area=+dfs(grid,r+d[0],l+d[1]);
        }
        return area;
    }

}
