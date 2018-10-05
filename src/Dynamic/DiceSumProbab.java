package Dynamic;

import java.util.HashMap;
import java.util.Map;

//把 n 个骰子仍在地上，求点数和为 s 的概率。
//使用一个二维数组 dp 存储点数出现的次数，其中 dp[i][j] 表示前 i 个骰子产生点数 j 的次数。
public class DiceSumProbab {
    public static void main(String[] args){

    }
    public Map<Integer,Double> getRes(int n){
        int face=6;
        int pointNum=n*6;
        int[][] dp=new int[n+1][pointNum+1];
        for (int i=1;i<=n;i++){
            dp[1][i]=1;
        }
        for (int i=2;i<=n;i++)  //对骰子进行遍历
            for (int j=i;j<pointNum;j++)//使用i个骰子的最小点数为i
                for (int k=1;k<=face&&k<=j;k++)//对于骰子点数为j的情况，最后一个骰子投的点数有6种情况，应该对6种情况进行求和
                    dp[i][j]+=dp[i-1][j-k];
        Map<Integer,Double> res=new HashMap<>();
        double totalNum=Math.pow(6,n);
        for (int i=n;i<=pointNum;i++){
            res.put(i,dp[n][i]/totalNum);
        }
        return res;
    }
}
