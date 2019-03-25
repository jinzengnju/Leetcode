package Array;

//最长递增子序列
// 比如arr={1,5,8,2,3,4}的最长递增子序列是1,2,3,4
//
//动态规划的思想，考虑{arr[0],...,arr[i]}的最长递增子序列时需要找到所有比arr[i]小的arr[j]，且j<i，
//结果应该是所有{arr[0],...,arr[j]}的最长递增子序列中
//最长的那一个再加1。即我们需要一个辅助的数组aid_arr，aid_arr[i]的值是{arr[0],...,arr[i]}的最长递增子序列的长度，aid_arr[0]=1。

//动态规划,已知一个序列 {S1, S2,...,Sn}
//核心是找到递推关系和建立dp数组,设dp数组dp[n]表示以 Sn 结尾的序列的最长递增子序列长度
//dp[n] = max{ dp[i]+1 | Si < Sn && i < n} 。

//因为在求 dp[n] 时可能无法找到一个满足条件的递增子序列，此时 {Sn} 就构成了递增子序列，需要对前面的求解方程做修改，令 dp[n] 最小为 1，
//即：dp[n] = max{1,dp[i]+1 | Si < Sn && i < n} 。
//比如整个序列都是递减
//最后求出dp[n]数组的最大值即可

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] arr={4,3,6,57,9,10};
        System.out.print(new LongestIncreasingSubsequence().lengthOfLis2(arr));

    }
    public int lengthOfLis(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    max=Math.max(max,dp[j]+1);
                    //对于dp[i]的求解，其前面的一个数有很多种情况，有i种情况，所以需要对j进行遍历，遍历前面的一个数的所有i种可能性。
                }
            }
            dp[i]=max;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
//    以上解法的时间复杂度为 O(N2)，可以使用二分查找将时间复杂度降低为 O(NlogN)。
//
//    定义一个 tails 数组，其中 tails[i] 存储长度为 i + 1 的最长递增子序列的最后一个元素。对于一个元素 x，
//
//    如果它大于 tails 数组所有的值，那么把它添加到 tails 后面，表示最长递增子序列长度加 1；
//    如果 tails[i-1] < x <= tails[i]，那么更新 tails[i] = x。
    //也就是这里我们要找到大于等于key的第一个元素
//    例如对于数组 [4,3,6,5]，有：
//
//    tails      len      num
//            []         0        4
//            [4]        1        3
//            [3]        1        6
//            [3,6]      2        5
//            [3,5]      2        null
//    可以看出 tails 数组保持有序，因此在查找 Si 位于 tails 数组的位置时就可以使用二分查找。
    public int lengthOfLis2(int[] arr){
        int n=arr.length;
        int[] tails=new int[n];
        int len=0;
        for(int num:arr){
            int index=binarySearch(tails,len,num);
            tails[index]=num;
            if(index==len)
                len++;
        }
        return len;
    }
    //找到第一个大于等于key的元素
    private int binarySearch(int[] tails,int len,int key){
        int left=0;
        int right=len-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(tails[mid]>key)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }
}
