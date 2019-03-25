package OtherWithAnything;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_shortestPath {
    public static void main(String[] args){}

    private int m;
    private int n;
    private int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    public int getRes(int[][] grid,int tr,int tc){
        this.m=grid.length;
        this.n=grid[0].length;
        Queue<Pair<Integer,Integer>> queue=new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int res=0;
        while (!queue.isEmpty()){
            res++;
            int size=queue.size();
            while (size-->0){
                Pair<Integer,Integer> cur=queue.poll();
                int curRow=cur.getKey();
                int curCol=cur.getValue();
                grid[curRow][curCol]=0;
                for (int[] d:direction){
                    int nr=curRow+d[0],nc=curCol+d[1];
                    if (nr<0||nr>=m||nc<0||nc>=n||grid[nr][nc]==0)
                        continue;
                    if (nr==tr&&nc==tc)
                        return res;
                    queue.add(new Pair<>(nr,nc));
                }
            }
        }
        return res;
    }
}
