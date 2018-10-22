package BinarySearch;

//在一个有重复元素的数组中查找 key 的最左位置的实现如下
public class TheLeftPosOfNumber {
    public static void main(String[] args){}
    public int getRes(int[] nums,int K){
        int l=0;
        int h=nums.length-1;
        while (l<h){
            int mid=l+(h-l)/2;
            if (nums[mid]>=K)
                h=mid;
            else
                l=mid+1;
        }
        return l;
    }
}
