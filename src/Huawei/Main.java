package Huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
//        while(scan.hasNext()){
//            int n=scan.nextInt();
//            if(n>0){
//                int res=new Main().getNum(n);
//                System.out.println(res);
//            }
//        }
//下面是错误写法
        int n;
        while((n=scan.nextInt())!=0){
            int res=new Main().getNum(n);
            System.out.println(res);
        }

    }

    public int getNum(int n){
        int cnt=0;
        while (n>=3){
            int new_full=n/3;
            cnt+=new_full;
            int old=n%3;
            n=new_full+old;
        }
        if (n==2)
            cnt++;
        return cnt;

    }
}
