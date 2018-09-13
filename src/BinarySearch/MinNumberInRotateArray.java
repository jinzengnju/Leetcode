package BinarySearch;
//题目描述
//        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//
//        例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1。
public class MinNumberInRotateArray {
    public static void main(String[] args){

    }
    //3 4 5 6 7 2 2
    public int getMin(int[] arr){
        int l=0;
        int h=arr.length-1;
        while(l<h){
            //这里判断条件不能取等号，因为h的赋值语句为h=mid，取等号会导致死循环。
            int mid=l+(h-l)/2;
            if(arr[mid]<=arr[h])
                h=mid;
            else
                h=mid+1;
        }
        return arr[l];
    }

//    如果数组元素允许重复的话，那么就会出现一个特殊的情况：nums[l] == nums[m] == nums[h]，那么此时无法确定解在哪个区间，需要切换到顺序查找。
//    例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间。
    public int getMin2(int[] arr){
        int l=0;
        int h=arr.length-1;
        while(l<h){
            int mid=l+(h-l)/2;
            if (arr[mid]==arr[l]&&arr[mid]==arr[h])
                return getMinHelper(arr,l,h);
            if(arr[mid]<=arr[h])
                h=mid;
            else
                l=mid+1;
        }
        return arr[l];
    }
    private int getMinHelper(int[] arr,int l,int h){
        for(int i=l;i<h;i++){
            if(arr[i]>arr[i+1])
                return arr[i+1];
        }
        return arr[l];

    }
}
