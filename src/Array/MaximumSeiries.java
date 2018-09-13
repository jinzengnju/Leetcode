package Array;

//最大子序列是要找出由数组成的一维数组中和最大的连续子序列。比如{5,-3,4,2}的最大子序列就是 {5,-3,4,2}，它的和是8,达到最大；而 {5,-6,4,2}的最大子序列是{4,2}，
//        它的和是6。你已经看出来了，找最大子序列的方法很简单，只要前i项的和还没有小于0那么子序列就一直向后扩展，否则丢弃之前的子序列开始新的子序列，同时我们要记下各个
//        子序列的和，最后找到和最大的子序列。

//思路:
//维护maxSum存储最大和的值,currSum存储begin到当前位置的和
//每遍历一个i,累加到currsum并按照情况更新maxSum
//如果某一不currSum<0,currSum置0并更新起始位置begin
public class MaximumSeiries {
    public static void main(String[] args){

    }
    public int maxSubSum(int[] arr,int begin,int end){
        int maxSum=0;
        int currSum=0;
        int newBegin=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum>maxSum){
                maxSum=currSum;
                begin=newBegin;
                end=i;
            }
            if(currSum<0){
                currSum=0;
                newBegin=i+1;
            }

        }
        return maxSum;
    }
}
