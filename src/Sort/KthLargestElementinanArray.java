package Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums,int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //利用堆排序,建立堆的语句为优先队列PriorityQueue
    public int findKthLargest2(int[] nums,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();//建立了最小值堆结构
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
        //最后剩下的堆中有k个元素,这K个元素是数组中最大的几个.堆顶元素是K个数中最小的一个,返回堆顶元素即可.
        //访问堆顶元素但不删除
    }

    public int findKthLargest3(int[] nums,int k){
        k=nums.length-k;
        int l=0;
        int h=nums.length-1;
        while(l<h){
            int j=Partition(nums,l,h);
            if(j==k)
                break;
            else if(j<k){
                l=j+1;
            }else {
                h=j-1;
            }
        }
        return nums[k];
    }
    private int Partition(int[] a,int l,int h){
        int i=l;
        int j=h+1;
        while(true){
            while (a[++i]<a[l]&&i<h);
            while(a[--j]>a[l]&&j>l);
            if(i>=j){
                break;
            }
            swap(a,i,j);
        }
        swap(a,l,j);
        return j;
    }
    private void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
