package Array;

import java.util.ArrayList;

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class GetLeastNumbers {
    public static void main(String[] args){}

    public ArrayList<Integer> getRes(int[] nums,int k){
        ArrayList<Integer> res=new ArrayList<>();
        if (k>nums.length||k<=0)
            return res;
        QuicjSort(nums,k);
        for (int i=0;i<k;i++){
            res.add(nums[i]);
        }
        return res;

    }
    public void QuicjSort(int[] arr,int K){
        int l=0;
        int h=arr.length-1;
        while (l<h){
            int j=Partition(arr,l,h);
            if (j==K)
                return;
            if (j>K)
                h=j-1;
            if (j<K)
                l=j+1;
        }
    }

    private int Partition(int[] arr,int l,int h){
        int p=arr[l];
        int i=l;
        int j=h+1;
        while(true){
            while(arr[++i]<p);
            while (arr[--j]>p);
            if (i>=j)
                break;
            swap(arr,i,j);
        }
        swap(arr,l,j);
        return j;
    }

    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}