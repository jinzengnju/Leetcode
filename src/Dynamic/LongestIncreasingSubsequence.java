package Dynamic;

import java.util.Arrays;

//最长递增子序列
public class LongestIncreasingSubsequence {
    public static void main(String[] args){}
    public int getRes(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        for (int i=0;i<n;i++){
            int max=0;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    max=Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
        }
        return Arrays.stream(dp).max().orElse(0);
    }


}
