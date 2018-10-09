package MeiTuan;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int M=scan.nextInt();
            int K=scan.nextInt();
            int[] values=new int[M];
            for (int i=0;i<M;i++){
                values[i]=scan.nextInt();
            }
            int res=getRes(values,K);
            System.out.println(res);
        }
    }
    public static int getRes(int[] arr,int K){
        Arrays.sort(arr);
        int minValue=Integer.MAX_VALUE;
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum=arr[i];
            if (sum>minValue)
                continue;
            for (int j=0;j<i;j++){
                if (sum<K){
                    sum+=arr[j];
                }else {
                    //System.out.println(sum);
                    minValue=Math.min(minValue,sum);
                    break;
                }
            }
        }
        return minValue;
    }
}
