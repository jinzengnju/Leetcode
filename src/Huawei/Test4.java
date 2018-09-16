package Huawei;


import java.util.Map;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()) {
            int N=scan.nextInt();
            int M=scan.nextInt();
            int[] score=new int[N];
            for (int i=0;i<N;i++){
                score[i]=scan.nextInt();
            }
            String c=null;
            for (int i=0;i<M;i++){
                c=scan.next();
                int A=scan.nextInt();
                int B=scan.nextInt();
                process(c,A,B,score);
            }


        }
    }
    private static void process(String c,int a,int b,int[] score){
        int begin,end;
        if (c.equals("Q")){
            end= Math.max(a,b);
            begin=Math.min(a,b)-1;
            int max=score[begin];
            for (int i=begin;i<end;i++){
                if(max<score[i])
                    max=score[i];
            }
            System.out.println(max);

        } else{
            score[a-1]=b;
        }
    }

}
