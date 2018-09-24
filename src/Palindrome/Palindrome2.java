package Palindrome;

//思路：这个就是简答的判断字符串是否是回文的情况。碰到不是字母或者是数字的情况直接跳转到下一个字符串，头尾依次进行比较。
//        这里需要考虑大小写的问题，所以比较是否相同直接利用assic的值进行比较比较合适。s[left] +32 -'a')%32 !=
//        (s[right] +32 -'a')%32  ->>这里%32表示大小写的assic 32是一个循环。

//题目要求大写和小写的A与a是相同的，所以需要处理让A和a是相等的。
public class Palindrome2 {
    public static void main(String[] args){

    }
    public boolean getRes(String str){
        int i=0;
        int j=str.length();
        while (i<j){
            if (!isValid(str.charAt(i)))
                i++;
            if (!isValid(str.charAt(j)))
                j--;
            if ((str.charAt(i)+32-'a')%32!=(str.charAt(j)+32-'a')%32){
                return false;
            }
        }
        return true;

    }
    private boolean isValid(char ch){
        if (ch>='a'&&ch<='z')
            return true;
        if (ch>='A'&&ch<='Z')
            return true;
        if (ch>='0'&&ch<='9')
            return true;
        return false;

    }

}
