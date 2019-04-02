package OtherWithAnything;


//Input: n = 12
//        Output: 3
//        Explanation: 12 = 4 + 4 + 4.
//问题转化为从12搜索到0的最短路径，路径只能通过完全平方数

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquares {
    private List<Integer> squares=new ArrayList<>();
    private int res=0;
    public int numSquares(int n){
        generateSquare(n);
        Queue<Integer> myqueue=new LinkedList<>();
        ((LinkedList<Integer>) myqueue).add(n);
        boolean[] marked=new boolean[n+1];
        marked[n]=true;
        while(!myqueue.isEmpty()){
            int size=myqueue.size();
            this.res++;
            while(size-->0){
                int cur=myqueue.poll();
                for (int e:this.squares){
                    if (cur-e<0)
                        break;
                    if (cur-e==0)
                        return this.res;
                    if (marked[cur-e])
                        continue;
                    marked[cur-e]=true;
                    ((LinkedList<Integer>) myqueue).add(cur-e);
                }
            }
        }
        return 0;
    }

    private void generateSquare(int num){
        for (int i=1;i*i<num;i++){
            this.squares.add(i*i);
        }
    }

}
