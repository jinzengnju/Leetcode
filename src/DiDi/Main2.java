package DiDi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(){
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int[][] res=getRes();
            String str="";
            for (int i=0;i<4;i++){
                for (int j=0;j<4;j++){
                    System.out.println(res[i][j]);
                }
            }
        }
    }
    public static int[][] getRes(){
        int[] res={6,7,10,11,5,8,9,12,4,3,14,13,1,2,15,16};
        int[][] temp=new int[4][4];
        int index=0;
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                temp[i][j]=res[index++];
            }
        }
        return temp;
    }
}