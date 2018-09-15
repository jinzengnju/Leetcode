package Sort;

public class MergeSort {
    public static void main(String[] args){

    }
    public static int[] sort(int[] a,int low,int high){
        int mid=low+(high-low)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            merge(a,low,mid,high);
        }
        return a;
    }
    private static void merge(int[] a,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int mergeindex=0;
        while(i<=mid&&j<=high){
            if(a[i]<a[j]){
                temp[mergeindex++]=a[i++];
            }
            else
                temp[mergeindex++]=a[j++];
        }
        while(i<=mid)
            temp[mergeindex++]=a[i++];
        while(j<high)
            temp[mergeindex++]=a[j++];
        //这里非常重要，将归并后的结果融入原数组
        for(int m=0;m<temp.length;m++){
            a[low+m]=temp[m];
        }
    }


}
