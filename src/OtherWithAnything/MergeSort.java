package OtherWithAnything;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int num=scan.nextInt();
            int[] input=new int[num];
            for (int i=0;i<num;i++){
                input[i]=scan.nextInt();
            }
            mergeSort(input,0,input.length-1);//右区间必须是input.length-1
            System.out.println(Arrays.toString(input));

        }
    }
    private static void mergeSort(int[] arr,int l,int h){
        int mid=l+(h-l)/2;
        if(l<h){
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,h);
            merge(arr,l,mid,h);
        }

    }
    private static void merge(int[] arr,int l,int mid,int h){
        int i=l;
        int j=mid+1;
        int[] temp=new int[h-l+1];
        int k=0;
        while(i<=mid&&j<=h){
            if (arr[i]<arr[j])
                temp[k++]=arr[i++];
            else
                temp[k++]=arr[j++];
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=h){
            temp[k++]=arr[i++];
        }
        for (int x=0;x<temp.length;x++){
            arr[l+x]=temp[x];
        }
    }
}
