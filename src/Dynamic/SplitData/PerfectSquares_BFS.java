package Dynamic.SplitData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么这两个整数所在的节点就有一条边。
//
//要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
public class PerfectSquares_BFS {
    public static void main(String[] args){}

    public int getRes(int n){
        List<Integer> squareList=getSquareList(n);
        boolean[] hasVisited=new boolean[n+1];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(n);
        hasVisited[n]=true;
        int path=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            path++;
            while(size-->0){
                int cur=queue.poll();
                for (int square:squareList){
                    int next=cur-square;
                    if (next<0)
                        break;
                    if (next==0)
                        return path;
                    if (hasVisited[next])
                        continue;
                    hasVisited[next]=true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    private List<Integer> getSquareList(int n){
        List<Integer> squareList=new ArrayList<>();
        int i=1;
        while (true){
            int temp=i*i;
            if (temp>=n)
                break;
            squareList.add(temp);
            i++;

        }
        return squareList;
    }

}
