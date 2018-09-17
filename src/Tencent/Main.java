package Tencent;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int k=scan.nextInt();
            String A=scan.next();
            String B=scan.next();
            System.out.println(getRes(k,A,B));
        }
    }
    private static int getRes(int k,String A,String B){
        int count=0;
        Set<String> myset=new HashSet<>();
        for (int i=0;i<A.length();i++){
            if((i+k)>=A.length()+1){
                break;
            }
            String str=A.substring(i,i+k);
            //System.out.println(str);
            if (!myset.contains(str)){
                myset.add(str);
                count+=stringCount(B,str);
            }else
                continue;
        }
        return count;
    }
    public static int stringCount(String str,String key){
        int index=0;
        int count=0;
        while((index=str.indexOf(key))!=-1){
            str=str.substring(index+key.length());
            count++;
        }
        return count;
    }
}
