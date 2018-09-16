package Huawei;

import java.util.*;
public class Main3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();//空汽水瓶数
            int count=0;//能喝汽水瓶数
            if(n>0){
                while(n>1){
                    count+=n/3;
                    n=n%3+n/3;
                    if(n==2){
                        n++;
                    }
                }
                System.out.println(count);
            }
        }
        sc.close();
    }
}