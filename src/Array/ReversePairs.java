package Array;

//数组逆序对
public class ReversePairs {
    public static void main(String[] args){

    }
    private int cnt;
    private int[] temp;//不要在merge函数中定义

    public int ReversePairNums(int[] nums){
        this.temp=new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return (int)(cnt%10000007);

    }
    private void mergeSort(int[] nums,int l,int h){
        //递归停止条件：l>=h
        //自问题划分：递归的归并排序左右子数组
        if(h-l<1)
            return;
        int mid=l+(h-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,h);
        merge(nums,l,mid,h);
    }
    private void merge(int[] nums,int l,int mid,int h){
        int i=l;
        int j=mid+1;
        int k=1;
        while(i<=mid||j<=h){
            if (i>mid)
                temp[k++]=nums[j++];
            if (j>h)
                temp[k++]=nums[i++];
            if (nums[i]<nums[j])
                temp[k++]=nums[i++];
            else {
                temp[k++]=nums[j++];
                this.cnt+=mid-i+1;
            }
        }
        for (int x=l;x<=h;x++){
            nums[x]=temp[x];
        }
    }

}
