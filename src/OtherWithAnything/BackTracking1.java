package OtherWithAnything;

import java.util.ArrayList;
import java.util.List;

//25525511135
public class BackTracking1 {
    public static void main(String[] args){}
    private int m;
    private int n;
    private int[][] direction={{0,1},{1,0},{-1,0},{0,-1}};
    private boolean getRes(char[][] input,String str){
        m=input.length;
        n=input[0].length;
        boolean[][] visitied=new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (backtracking(0,i,j,visitied,input,str)){
                    return true;
                }
            }
        }
        return false;



    }
    private boolean backtracking(int curLen,int r,int c,boolean[][] visited,char[][] board,String str){
        if (curLen==str.length()){
            return true;
        }

        if (r<0||r>m||c<0||c>n||(board[r][c]!=str.charAt(curLen))||visited[r][c]){
            return false;
        }
        visited[r][c]=true;
        for (int[] d:direction){
            if (backtracking(curLen+1,r+d[0],c+d[1],visited,board,str)){
                return true;
            }
        }
        visited[r][c]=false;
        return false;




    }
}
