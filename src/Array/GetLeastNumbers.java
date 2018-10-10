package Array;
//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class GetLeastNumbers {
    public static void main(String[] args){}
    public void QuicjSort(int[] arr,int l,int h){
        if(l>=h){
            return;
        }
        int j=Partition(arr,l,h);
        QuicjSort(arr,l,j);
        QuicjSort(arr,j+1,h);
    }

    private int Partition(int[] arr,int l,int h){
        int i=l+1;
        int j=h;
        while(i<=j){
            while(arr[i++]<arr[l]);
            while (arr[j--]>arr[l]);
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