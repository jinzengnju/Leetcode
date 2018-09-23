package Palindrome;

//Input : "abccccdd"
//        Output : 7
//        Explanation : One longest palindrome that can be built is "dccaccd", whose length is 7.
//使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。
public class LongestPalindrome {
    public static void main(String[] args){

    }
    public int getRes(String str){
        char[] temp=str.toCharArray();
        int[] cnt=new int[256];
        for (int i=0;i<temp.length;i++){
            cnt[temp[i]]++;
        }
        int palindrome=0;
        for (int i=0;i<cnt.length;i++){
            palindrome+=cnt[i]/2;
        }
        if (palindrome<str.length())
            palindrome+=1;
        return palindrome;
    }
}
