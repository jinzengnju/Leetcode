package HashSet;
//每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeleteDuplicateChar {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String str=scan.next();
            System.out.println(getRes(str));
        }

    }
    public static String getRes(String str){
        Set<Character> myset=new HashSet<>();
        StringBuffer res=new StringBuffer();
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if (!myset.contains(c)){
                myset.add(c);
                res.append(c);
            }else
                continue;

        }
        return res.toString();
    }
}
