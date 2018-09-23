package Palindrome;


//Input: "aaa"
//        Output: 6
//        Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//从字符串的某一位开始，尝试着去扩展子字符串。
//The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
//相同的内容，但是来源于不同的位置索引默认是不同的字串
public class PalindromicSubstrings {
    public static void main(String[] args){

    }

    private int cnt=0;
    public int getRes(String str){
        for (int i=0;i<str.length();i++){
            //以选定i的位置位回文串的中心往两边扩展，不会出现重复的
            //因为索引肯定是不同的
            entendPalindrome(str,i,i);
            entendPalindrome(str,i,i+1);
        }
        return cnt;
    }
    private void entendPalindrome(String str,int l,int h){
        while(l>=0&&h<=str.length()&&str.charAt(l)==str.charAt(h)){
            l++;h--;
            cnt++;
        }
    }
}
