package Dynamic.Other;

import java.util.List;

public class Leetcode120 {
    public static void main(String[] args){
    }
    public int getRes(List<List<Integer>> triangle){
        int len=triangle.size();
        int[][] dp=new int[len][len];
        for (int j=0;j<len;j++){
            dp[len-1][j]=triangle.get(len-1).get(j);
        }

        for (int i=len-2;i>=0;i--){
            List<Integer> row=triangle.get(i);
            //第i行对应最多只有i+1个元素
            for (int j=0;j<i+1;j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+row.get(j);
            }
        }
        return dp[0][0];
    }

}
