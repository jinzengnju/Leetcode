package OtherWithAnything;

public class KthLargestElementinanArray {
    public static void main(String[] args){}

    //快速排序
//    public int getRes(int[] nums,int K){
//        int j=Partition(nums,0,nums.length);
//        int res=QuickSort(nums,0,nums.length,K);
//        return res;
//    }
//    private int QuickSort(int[] nums,int l,int h,int K){
//        int j=Partition(nums,l,h);
//        if (j==K)
//            return nums[j];
//        else if (j<K)
//           return QuickSort(nums,l+1,h,K);
//        else
//            return QuickSort(nums,l,j-1,K);
//    }
    public int getRes(int[] nums,int K){
        int l=0;
        int h=nums.length-1;
        while (l<h){
            int j=Partition(nums,l,h);
            if (j==K)
                return nums[j];
            else if (j<K)
                l=j+1;
            else
                h=j-1;
        }
        return 0;

    }
    private int Partition(int[] nums,int l,int h){
        int i=l+1;
        int j=h;
        while(i<j){//注意这里的循环退出条件是i>=j
            while (nums[i++]<nums[l]);
            while(nums[j--]>nums[l]);
            swap(nums,i,j);
        }
        swap(nums,j,l);
        return j;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
