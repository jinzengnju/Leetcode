package Tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        m=Integer.valueOf(input.nextLine());
        input.close();
        arr=new int[m];
        for (int i = 1; i <= m; i++) {
            computer(0,i);
        }

    }
    public static void computer(int time,int n){
        if(time>=n){
            if(getSum(n)==m){
                printf(n);
            }
            return;
        }

        for (int i = 0; i < m; i++) {
            arr[time]=i+1;
            if(time>0&&arr[time]<arr[time-1]){
            }else{
                computer(time+1,n);
            }

        }
    }
    public static void printf(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
    public static int getSum(int n){
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
        }
        return sum;
    }

}
