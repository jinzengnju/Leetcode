package DiDi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int x1=0,y1=0,x2=0,y2=0;
            x1=scan.nextInt();
            y1=scan.nextInt();
            x2=scan.nextInt();
            y2=scan.nextInt();
            System.out.println(x1);

        }
        scan.close();

    }
    public static int getRes(int x1,int y1,int x2,int y2){
        if (y1<x1||y2<x2)
            return 0;
        int cnt=1;
//        for (int row=x1;row<=x2;row++){
//            for (int col=y1;col<=y2;col++){
//                if (row==x1||row==x2||col==y1||col==y2)
//                    continue;
//                else
//                    cnt++;
//            }
//        }
        return cnt;
    }
}
