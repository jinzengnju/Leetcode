package DFS;

//查找最大的连通面积
//
//695. Max Area of Island (Easy)
//
//[[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]

public class MaxAreaofIsland {
    public static void main(String[] args){}

    private int m;
    private int n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int getRes(int[][] grids,int m,int n){
        if (grids==null||grids.length==0){
            return 0;
        }
        m=grids.length;
        n=grids[0].length;
        int maxArea=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                maxArea=Math.max(maxArea,dfs(grids,i,j));
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grids,int row,int col){
        if (row<0||row>=m||col<0||col>=m||grids[row][col]==0){
            return 0;
        }
        grids[row][col]=0;//注意是递归，不是回溯
        int area=1;//为什么每次递归函数都要设置area=1，因为下面的for循环中会有area累加
        for (int[] d:direction){
            area+=dfs(grids,row+d[0],col+d[1]);
        }
        return area;
    }


}
