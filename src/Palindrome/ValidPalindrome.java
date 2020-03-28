//题目描述：可以删除一个字符，判断是否能构成回文字符串。
package Palindrome;

public class ValidPalindrome {
    public static void main(String[] args){

    }

    public boolean getRes(String str){
        int i=0;
        int j=str.length()-1;
        while (i<=j){
            if (str.charAt(i)!=str.charAt(j)){
                return getResHelp(str.substring(i+1,j))||getResHelp(str.substring(i,j-1));
            }else {
                continue;
            }
        }
        return true;

    }
    public boolean getResHelp(String str){
        for (int i=0,j=0;i<=j;i++,j--){
            if (str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
