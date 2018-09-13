package String;

//s = "abcd123" k = 3
//        Return "123abcd"
//        将字符串向右循环移动 k 位。

//方法:将 abcd123 中的 abcd 和 123 单独翻转，得到 dcba321，然后对整个字符串进行翻转，得到 123abcd。
//字符串翻转:新建StringBuffer调用自带方法,reversel方法.法二是利用栈的后入先出实现(先入站后出战)

import java.util.Stack;

public class LoopMove {
    public String get_loop(String s,int k){
        String s1=s.substring(0,k+1);
        String s2=s.substring(k+1,s.length());
        s1=new StringBuffer(s1).reverse().toString();
        s2=new StringBuffer(s2).reverse().toString();
        s1=s1+s2;
        return new StringBuffer(s1).reverse().toString();
    }
    public String reverse_string_with_stack(String s){
        StringBuffer sb=new StringBuffer();
        Stack<Character> s_stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            s_stack.add(s.charAt(i));
        }
        for(int i=0;i<s.length();i++){
            sb.append(s_stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String s=new LoopMove().get_loop("abcd123",3);
        System.out.println(s);
    }

}
