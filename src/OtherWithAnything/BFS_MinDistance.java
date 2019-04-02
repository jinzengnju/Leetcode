package OtherWithAnything;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;


//[[1,1,0,1],
//        [1,0,1,0],
//        [1,1,1,1],
//        [1,0,1,1]]
//        1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。

public class BFS_MinDistance {
    public static void main(String[] args){}

    private static int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
    private int res=0;
    private int rows;
    private int cols;
    public int getRes(int[][] grid,int tr,int tc){
        this.rows=grid.length;
        this.cols=grid[0].length;
        Queue<Pair<Integer,Integer>> myqueue=new LinkedList<>();
        ((LinkedList<Pair<Integer, Integer>>) myqueue).add(new Pair<>(0,0));
        while (!myqueue.isEmpty()){
            this.res++;
            int size=myqueue.size();
            while(size-->0){
                Pair<Integer,Integer> cur=myqueue.poll();
                int cr=cur.getKey();
                int cc=cur.getValue();
                grid[cr][cc]=0;
                for (int[] d:direction){
                    int nr=cr+d[0];
                    int nc=cc+d[1];
                    if (nr<0||nr>this.rows||nc<0||nc>this.cols||grid[nr][nc]==0)
                        continue;
                    if (nr==tr&&nc==tc)
                        return this.res;
                    ((LinkedList<Pair<Integer, Integer>>) myqueue).add(new Pair<>(nr,nc));
                }
            }
        }
        return 0;
    }
}
