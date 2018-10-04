package Array;
//连续子数组的最大和
//比如：{6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
public class MaximumOfContinueArray {
    public static void main(String[] args){

    }
    public static int getRes(int[] arr){
        if (arr.length==0)
            return 0;
        int max=arr[0];
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum=sum<0?arr[i]:arr[i]+sum;
            max=Math.max(sum,max);
        }
        return max;
    }
}
