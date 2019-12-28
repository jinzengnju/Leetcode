package Dynamic;

import java.util.Arrays;

//最长递增子序列
public class LongestIncreasingSubsequence {
    public static void main(String[] args){}
    public int getRes(int[] nums){
        if (nums.length==0 || nums==null)
            return 0;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int res=0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            res=Math.max(res,dp[i]);
        }
        return res;

    }


}
