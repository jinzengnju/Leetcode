package Palindrome;

import java.util.ArrayList;
import java.util.List;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//        Return all possible palindrome partitioning of s.
//
//        Example:
//
//        Input: "aab"
//        Output:
//        [
//        ["aa","b"],
//        ["a","a","b"]
//        ]
//a -> a -> b -> c -> bc -> ab -> abc -> aa -> b -> c -> bc -> aab -> aabc
//按照a a b c遍历后，倒数第二层是对bc，单个b遍历了，接下来就是遍历bc了
//bc都遍历完后，倒数第二层for循环结束，对倒数第三层本来是abc的子字符串遍历，第一次已经遍历了单个a，接下俩i=2，也就是遍历ab了
public class PalindromePartitioning {
    public static void main(String[] args){
    }
    public List<List<String>> getRes(String str){
        List<List<String>> res=new ArrayList<>();
        List<String> tempList=new ArrayList<>();
        doPatition(str,res,tempList);
        return res;
    }
    private void doPatition(String str,List<List<String>> res,List<String> tempList){
        if (str.length()==0){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i=0;i<str.length();i++){
            if (isPalindrome(str,0,i)){
                tempList.add(str.substring(0,i+1));
                doPatition(str.substring(i+1),res,tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    private boolean isPalindrome(String str,int l,int h){
        for (int i=l,j=h;i<=j;i++,j--){
            if (str.charAt(i)!=str.charAt(j))
                return false;
        }
        return true;

    }

}
