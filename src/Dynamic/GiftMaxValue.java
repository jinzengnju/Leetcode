package Dynamic;
//在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
// 给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
//
//        1    10   3    8
//        12   2    9    6
//        5    7    4    11
//        3    7    16   5
//        礼物的最大价值为 1+12+5+7+7+16+5=53。
public class GiftMaxValue {
    public static void main(String[] args){}
    public int gerRes(int[][] values){
        if (values==null||values.length==0||values[0].length==0)
            return 0;
        int m=values.length;
        int n=values[0].length;
        int[] dp=new int[n];
        //dp[i]表示从到达第i列时的最大收益
        for (int[] value:values){
            dp[0]+=value[0];
            for (int j=1;j<n;j++){
                dp[j]=Math.max(dp[j-1],dp[j])+value[j];
            }
        }
        return dp[n-1];

    }
}
