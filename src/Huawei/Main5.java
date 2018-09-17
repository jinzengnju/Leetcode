package Huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.next();
            char res=getRes(str);
            if (res==' '){
                System.out.println("NULL");
            }
            else
                System.out.println(res);
        }

    }
    public static char getRes(String str){
        Map<Character,Integer> mymap=new HashMap<>();
        char[] temp=str.toCharArray();
        for (int i=0;i<temp.length;i++){
            char c=temp[i];
            if (!mymap.containsKey(c)){
                mymap.put(c,1);
            }
            else
                mymap.put(c,mymap.get(c)+1);
        }

        char res=' ';
        for (int i=0;i<temp.length;i++){
            if (mymap.get(temp[i])==1){
                res=temp[i];
            }
        }
        return res;
    }

}
