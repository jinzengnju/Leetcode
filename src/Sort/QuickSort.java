package Sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args){
        int[] arr={2,1,5,4,8,7,9,3};
        new QuickSort().sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public void sort(int[] nums,int l,int h){
        if(l<h){
            int index=Partition(nums,l,h);
            sort(nums,l,index-1);
            sort(nums,index+1,h);
        }
    }
//    private int Partition(int[] nums,int l,int h){
//        int i=l;
//        int j=h+1;
//        while(true){
//            while(nums[++i]<nums[l]&&i<h) ;
//            while(nums[--j]>nums[l]&&j>l) ;
//            if(i>=j)
//                break;
//            swap(nums,i,j);
//        }
//        swap(nums,l,j);
//        return j;
//    }
    private int Partition(int[] nums,int l,int h){
        int i=l+1;
        int j=h;
        while(true){
            while(nums[i]<nums[l]&&i<h) i++;
            while(nums[j]>nums[l]&&j>l) j--;
            if(i>=j)
                break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    private void swap(int[] nums,int l,int h){
        int t=nums[l];
        nums[l]=nums[h];
        nums[h]=t;
    }
}
