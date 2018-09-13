package String;
//程序员代码面试指南
//
//        s = "I am a student"
//        Return "student a am I"

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

//将每个单词翻转，然后将整个字符串翻转。
public class WordReverse {
    public static void main(String[] args){
        System.out.println(new WordReverse().reverse_string("I am a student"));

    }
    //Java数组的翻转.法一:使用Collections.reverse.法二:使用ArrayList翻转.法三:使用原数组翻转

    public String reverse_string(String s){
        StringBuffer sb=new StringBuffer();
        String[] temp=s.split(" ");

        System.out.println(Arrays.toString(temp));
        ArrayList<String> arrlist=new ArrayList(Arrays.asList(temp));

        //注意:这里的reverse方法只针对ArrayLIst有效,不能直接传String[]
        Collections.reverse(arrlist);
        System.out.println(arrlist.toString());
        for(int i=0;i<arrlist.size();i++){
            sb.append(arrlist.get(i)+" ");
        }
        return sb.toString();
    }

    public String reverse_string_with_stack(String s){
        StringBuffer sb=new StringBuffer();
        Stack<Character> sstack=new Stack<>();
        for(int i=0;i<s.length();i++){
            sstack.add(s.charAt(i));
        }
        for(int i=0;i<s.length();i++){
            sb.append(sstack.pop());
        }
        return sb.toString();
    }


    //Java实现数组反转翻转的方法
    // 使用集合ArrayList实现反转
    public String[] reverse_array(String[] arr){
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[arr.length-i-1]);
        }
        return list.toArray(arr);

    }
}


