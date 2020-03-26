package OtherWithAnything;

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
// 你需要让组成和的完全平方数的个数最少。
//有这样一个图，图中的每个节点是一个整数，若两个整数之间相差一个平方数，则两数存在一条边

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode279 {
    public static void main(String[] args){}
    private int getRes(int n){
        int res=0;
        List<Integer> squares=getSquares(n);
        boolean[] marked=new boolean[n+1];
        Queue<Integer> queue=new LinkedList<>();
        ((LinkedList<Integer>) queue).add(n);
        marked[n]=true;
        while (!queue.isEmpty()){
            res+=1;
            int size=queue.size();
            while(size-->0){
                int cur=queue.poll();
                for (int e:squares){
                    int next=cur-e;
                    if (next<0)
                        break;
                    if (next==0)
                        return res;
                    if (marked[next])
                        continue;
                    marked[next]=true;
                    ((LinkedList<Integer>) queue).add(next);
                }
            }
        }
        return res;
    }


    //动态规划解法
    private int getRes2(int n){
        List<Integer> squares=getSquares(n);
        int[] dp=new int[n];
        for (int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for (int e:squares){
                if (e>i)
                    break;
                min=Math.min(min,dp[i-e]+1);
            }
            dp[i]=min;
        }
        return dp[n];

    }


    private List<Integer> getSquares(int n){
        List<Integer> res=new ArrayList<>();
        for(int i=0;i*i<=n;i++){
            res.add(i*i);
        }
        return res;
    }
}
