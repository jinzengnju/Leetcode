package BFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

//计算在网格中从原点到特定点的最短路径长度
//[[1,1,0,1],
// [1,0,1,0],
// [1,1,1,1],
// [1,0,1,1]]
//1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
public class BFS1 {
    public static void main(String[] args){}

    public int getMinPath(int[][] grids,int tr,int tc){
        final int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
        final int m=grids.length;
        final int n=grids[0].length;

        Queue<Pair<Integer,Integer>> queue=new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int res=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            res++;
            while (size-->0){
                Pair<Integer,Integer> cur=queue.poll();
                int cr=cur.getKey(),cl=cur.getValue();
                grids[cr][cl]=0;
                for (int[] d:direction){
                    int nextr=cr+d[0],nextc=cl+d[1];
                    if (nextr<0||nextr>=m||nextc<0||nextc>=n||grids[nextr][nextc]==0)
                        continue;
                    if (nextr==tr&&nextc==tc)
                        return res;
                    queue.add(new Pair<>(nextr,nextc));
                }
            }
        }
        return -1;
    }
}
