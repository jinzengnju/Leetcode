package OtherWithAnything;


import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int[] arr={2,1,5,4,8,7,9,3};
        new QuickSort().QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public void QuickSort(int[] arr,int i,int j){
        if (i>=j)
            return;
        int k=Partition(arr,i,j);
        QuickSort(arr,i,k-1);
        QuickSort(arr,k+1,j);
    }
    private int Partition(int[] arr,int l ,int r){
        int i=l+1;
        int j=r;
        while(true){
            while(arr[i]<arr[l]&&i<r) i++;//这里arr[++i]<arr[l]不取等号，如果取等，那么1，2，2，2，2，2最后规模只会减少1
            while (arr[j]>arr[l]&&j>l) j--;
            if(i>=j)
                break;
            swap(arr,i,j);

        }
        swap(arr,j,l);
        return j;
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
