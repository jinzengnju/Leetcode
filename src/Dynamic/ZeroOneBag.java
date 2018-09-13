package Dynamic;
//
//有一个容量为 N 的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积 w 和价值 v。
//
//        定义一个二维数组 dp 存储最大价值，其中 dp[i][j] 表示前 i 件物品体积不超过 j 的情况下能达到的最大价值。设第 i 件物品体积为 w，价值为 v，根据第 i 件物品是否添加到背包中，可以分两种情况讨论：
//
//        第 i 件物品没添加到背包，总体积不超过 j 的前 i 件物品的最大价值就是总体积不超过 j 的前 i-1 件物品的最大价值，dp[i][j] = dp[i-1][j]。
//        第 i 件物品添加到背包中，dp[i][j] = dp[i-1][j-w] + v。
//        第 i 件物品可添加也可以不添加，取决于哪种情况下最大价值更大。因此，0-1 背包的状态转移方程为：
public class ZeroOneBag {
    public static void main(String[] args){

    }
    //动态规划矩阵dp[i][j]表示前i件物品体积不超过j的情况下的最大价值
    public int knapsack(int W,int N,int[] weights,int[] values){
        int[][] dp=new int[N+1][W+1];
        for(int i=1;i<=N;i++){
            int w=weights[i-1];
            int v=values[i-1];
            for(int j=1;j<=W;j++){
                if(j>w){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }

        }
        return dp[N][W];

    }
//    无法使用贪心算法的解释
//
//0-1 背包问题无法使用贪心算法来求解，也就是说不能按照先添加性价比最高的物品来达到最优，这是因为这种方式可能造成背包空间的浪费，从而无法达到最优。考虑下面的物品和一个容量为 5
//    的背包，如果先添加物品 0 再添加物品 1，那么只能存放的价值为 16，浪费了大小为 2 的空间。最优的方式是存放物品 1 和物品 2，价值为 22.


}
