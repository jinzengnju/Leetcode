package BFS;


import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
//        可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么这两个整数所在的节点就有一条边。
//
//        要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
//
//        本题也可以用动态规划求解，在之后动态规划部分中会再次出现。
public class PerfectSquares {
    public static void main(String[] args){


    }
    public int numSquares(int n){
        List<Integer> squares=generateSquares(n);
        Queue<Integer> queue=new LinkedList<>();//队列的创建用的是LinkedList
        boolean[] marked=new boolean[n+1];

        ((LinkedList<Integer>) queue).add(n);
        marked[n]=true;
        int level=0;

        while(!queue.isEmpty()){//BFS循环体条件为判断队列是否为空,内部是三层循环,最外层判断队列是否为空,第二层处理当前层的所有节点
            int size=queue.size();
            level++;
            while(size-->0){
                int cur=queue.poll();
                for(int s:squares){
                    int next=cur-s;
                    if(next<0)
                        break;
                    if(next==0)
                        return level;
                    if(marked[next])
                        continue;
                    marked[next]=true;
                    //因为每次减了一个平方数后的数据肯定是唯一的,记录这个next节点已经被遍历,且现在遍历到next的路径是最短的
                    ((LinkedList<Integer>) queue).add(next);
                }

            }
        }
        return n;

    }
    //生成小于 n 的平方数序列
    private List<Integer> generateSquares(int n){
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }


    //动态规划解决:
    //dp[n]表示数字n最少可以由多少个完全平方数组成
    public int numSquares2(int n){
        List<Integer> squares=new ArrayList<>();
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int min=Integer.MIN_VALUE;
            for(int s:squares){
                if(s>i)
                    break;
                min=Math.min(min,dp[i-s]+1);//这里为什么要取最小值,原因是从当前的i值往外发散时,有多条路径,选择最短的那条
                //比如12往外发散可以是8,也可以是9,具体是哪条选择最小值.
            }
            dp[i]=min;
        }
        return dp[n];
    }


}
