package Dynamic;

//定义一个一维的dp数组，其中dp[i]表示数字i是否是原数组的任意个子集合之和，那么我们我们最后只需要返回dp[target]就行了。我们初始化dp[0]为true，由于题目中限制了所有数
//        字为正数，那么我们就不用担心会出现和为0或者负数的情况。那么关键问题就是要找出状态转移方程了，我们需要遍历原数组中的数字，对于遍历到的每个数字nums[i]，我们需
//        要更新dp数组，要更新[nums[i], target]之间的值，那么对于这个区间中的任意一个数字j，如果dp[j - nums[i]]为true的话，那么dp[j]就一定为true，于是状态转
//        移方程如下：
//
//        dp[j] = dp[j] || dp[j - nums[i]]         (nums[i] <= j <= target)

//这里有一个地方需要注意的是
//dp[j-numx]与dp[j]的关系,按照常理,我们可以认为dp[j-numx]可以表示为多个子集的和,那么dp[j]在这些子集的基础上加上一个{numx}子集即可
//问题是假如我在形成dp[j-numx]的时候就已经用了numsx,那么一定会有替代nums的多个数(这些数的和为numx)被挤出来,这些数可以用于形成dp[j],结果是不变的

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args){

    }
    public boolean canPartition(int[] nums){
        int sum=countSum(nums);
        if(sum%2!=0)
            return false;
        int W=sum/2;
        boolean[] dp=new boolean[W+1];
        dp[0]=true;
        Arrays.sort(nums);
        for(int num:nums){
            for(int i=W;i>=num;i--){
                dp[i]=dp[i]||dp[i-num];
            }
        }

        return dp[W];

    }
    private int countSum(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return  sum;
    }

}
