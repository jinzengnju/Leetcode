package OtherWithAnything;
//
//Kth Element
//        215. Kth Largest Element in an Array (Medium)
//
//        题目描述：找到第 k 大的元素。

import java.util.PriorityQueue;

//普通快速排序的时间复杂度为O(nlogn)，而堆排序的时间复杂度为O(NlogK)
public class KthElement {
    public static void main(String[] args){}
    public int findKthElement(int[] nums,int k){
        PriorityQueue<Integer> heap=new PriorityQueue<>();//建立最小值堆
        for (int e:nums){
            if (heap.size()>k){
                heap.poll();
            }
            heap.add(e);
        }
        return heap.peek();
    }


    public int FindK_by_quicksort(int[] nums,int k){
        int l=0;
        int h=nums.length-1;
        while(l<h){
            int index=partition(nums,l,h);
            if (index==k)
                return index;
            if (index<k){
                l=index+1;
            }
            else {
                h=index-1;
            }
        }
        return 0;
    }
    private int partition(int[] nums,int l,int h){
        int i=l+1;
        int j=h;
        while(true){
            while(nums[i]<nums[l]&&i<h)
                i++;
            while (nums[j]>nums[l]&&j>l)
                j--;
            if (i>=j)
                break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
