package BinarySearch;

//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]

public class SearchforaRange {
    public static void main(String[] args){}

    public int[] getRes(int[] nums,int K){
        int first=getPos(nums,K);
        int last=getPos(nums,K+1)-1;
        if (first==nums.length||nums[last]!=K)
            return new int[]{-1,-1};
        else
            return new int[]{first,Math.max(first,last)};
    }
    //找到第一个大于等于K的数，返回最左侧的下标
    private int getPos(int nums[],int K){
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
