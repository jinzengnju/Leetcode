package FenZhi;

public class InversePairs {
    public static void main(String[] args){
    }
    private int cnt=0;
    private int[] temp;
    public int getRes(int[] arr){
        temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1);
        return cnt;
    }
    private void mergeSort(int[] arr,int l,int h){
        if (l>=h)//当现在的数组只有两个数值的时候，不用再对这个小数组进行归并排序
            return;
        int m=l+(h-l)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,h);
        merge(arr,l,m,h);
    }
    private void merge(int[] arr,int l,int m,int h){
        int i=l;
        int j=m+1;
        int new_index=l;
        while (i<=m||j<=h){
            if (i>m)
                temp[new_index++]=arr[j++];
            else if (j>h)
                temp[new_index++]=arr[i++];
            else if (arr[i]<arr[j]){
                temp[new_index++]=arr[i++];
            }
            else{
                this.cnt+=m-i+1;
                temp[new_index++]=arr[j++];
            }
        }
        for (int x=l;x<=h;x++){
            arr[x]=temp[x];
        }
    }
}
