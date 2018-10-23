package Dynamic;
//现在房子排成了一个圆圈，则如果抢了第一家，就不能抢最后一家，
// 因为首尾相连了，所以第一家和最后一家只能抢其中的一家，或者都不抢，那我们这里变通一下，如果我们把第一家和最后一家分别去掉，各算一遍能抢的最大值，
// 然后比较两个值取其中较大的一个即为所求
public class HouseRobberII {
    public static void main(String[] args){}
    public int getRes(int[] nums){
        if (nums==null||nums.length==0){
            return 0;
        }
        int n=nums.length;
        if (n==1){
            return nums[0];
        }
        return Math.max(getRob(nums,0,n-2),getRob(nums,1,n-1));

    }
    private int getRob(int[] temp,int first,int last){
        int len=temp.length;
        int[] dp=new int[len];
        dp[first]=temp[first];
        dp[first+1]=Math.max(dp[first],dp[first+1]);
        for (int i=first+2;i<last;i++){
            dp[i]=Math.max(dp[i-2]+temp[i],dp[i-1]);
        }
        return dp[len-1];
    }

}
