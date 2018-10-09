package MeiTuan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int T=scan.nextInt();
            for (int i=0;i<T;i++){
                int n=scan.nextInt();
                int[] values=new int[n];
                for (int j=0;j<n;j++){
                    values[j]=scan.nextInt();
                }
                boolean res=getRes(values,n);
                if (res==true)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }
    public static boolean getRes(int[] values,int K){
        int sum=0;
        for (int i=0;i<values.length;i++){
            sum+=values[i];
        }
        if (sum==(2*K-2))
            return true;
        return false;
    }
}
