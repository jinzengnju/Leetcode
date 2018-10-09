package BinarySearch;

//数字在排序数组中出现的次数
//Input:
//        nums = 1, 2, 3, 3, 3, 3, 4, 6
//        K = 3
//
//        Output:
//        4
public class getNumberOfK {
    public static void main(String[] args){
    }
    public int getRes(int[] arr,int K){
        int l=getFirstPos(arr,K);
        int h=getFirstPos(arr,K+1);
        return h-l;

    }
    //得到第一个大于或者等于K 的元素位置
    private int getFirstPos(int[] arr,int K){
        int l=0;
        int h=arr.length;//注意这里的h初始化为arr的length，而不是length-1
        while(l<h){
            int m=l+(h-l)/2;
            if (arr[m]>=K)
                h=m;
            else
                l=m+1;
        }
        return l;
    }
    //这里是另一种写法，这种写法对应所以都是闭区间
    private int firstGreatOrEqual(int[] arr,int n,int key){
        int left=0;
        int right=n;//注意：这里传过来的n是最后一个元素的下标，即我们的length-1
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(arr[mid]>=key){
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return left<=n?left:-1;
    }



}
