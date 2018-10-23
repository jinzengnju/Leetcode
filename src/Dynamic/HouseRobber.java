package Dynamic;

import java.util.Map;

//题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
//
//        定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
//
//        由于不能抢劫邻近住户，因此如果抢劫了第 i 个住户那么只能抢劫 i - 2 或者 i - 3 的住户
//dp[i]=max(dp[i-2],dp[i-3])+nums[i]
public class HouseRobber {
    public int rob(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<n;i++){
            dp[i]= Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n];
    }
}
