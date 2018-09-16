package Huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SixteenToTen {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        SixteenToTen model=new SixteenToTen();
        while(scan.hasNext()){
            String str=scan.next();
            int res=model.getNum(str);
            System.out.println(res);
        }
    }
    private Map<Character,Integer> mymap=new HashMap<>();
    public SixteenToTen(){
        mymap.put('A',10);
        mymap.put('B',11);
        mymap.put('C',12);
        mymap.put('D',13);
        mymap.put('E',14);
        mymap.put('F',15);
    }

    public int getNum(String str){
        int res=0;
        for (int i=2;i<str.length();i++){
            char c=str.charAt(i);
            if (mymap.containsKey(c))
                res=res*16+mymap.get(c);
            else
                res=res*16+(c-'0');
        }
        return res;
    }

}
