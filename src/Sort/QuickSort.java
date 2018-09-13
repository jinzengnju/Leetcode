package Sort;

public class QuickSort {
    public void sort(int[] nums,int l,int h){
        if(l<h){
            int j=Partition(nums,l,h);
            sort(nums,l,j-1);
            sort(nums,j-1,h);
        }
    }
    private int Partition(int[] nums,int l,int h){
        int i=l;
        int j=h+1;
        while(true){
            while(nums[++i]<nums[l]&&i<h);
            while(nums[--j]>nums[l]&&j>l);
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
