package OtherWithAnything;

import java.util.Map;

public class DFS1 {
    public static void main(String[][] args){}

    private static int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};
    private int m;
    private int n;
    public int getRes(int[][] band){

        int m=band.length;
        int n=band[0].length;
        int res=0;
        boolean[][] visited =new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                res= Math.max(res,dfs(0,i,j,visited,band));
            }
        }
        return res;

    }
    private int dfs(int tempRes,int r,int c,boolean[][] visited,int[][] band){
        if (r>m||r<0||c>n||c<0||visited[r][c]||band[r][c]==0){
            return 0;
        }
        visited[r][c]=true;
        tempRes+=1;
        for (int[] d:direction){
            dfs(tempRes,r,c,visited,band);
        }
        return tempRes;
    }

}
