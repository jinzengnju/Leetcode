package BinarySearch;

//Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
//Output: 2
//题目描述：一个有序数组只有一个数不出现两次，找出这个数。要求以 O(logN) 时间复杂度进行求解。

//令 index 为 Single Element 在数组中的位置。如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
//
//从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
//
//因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式。
public class SingleElementinaSortedArray {
    public static void main(String[] args){

    }
    public int getRes(int[] nums){
        int l=0;
        int h=nums.length-1;
        while (l<h){
            int mid=l+(h-l)/2;
            if (mid%2!=0)
                mid--;
            if (nums[mid]!=nums[mid+1])
                h=mid;
            else if (nums[mid]==nums[mid+1])
                l=mid+2;

        }
        return nums[l];
    }
}
