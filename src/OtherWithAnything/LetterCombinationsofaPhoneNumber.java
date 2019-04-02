package OtherWithAnything;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    //回溯法主要用来解决排列组合问题。且递归返回后要继续求解。
    public static void main(String[] args){}

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits){
        List<String> res=new ArrayList<>();
        if (digits.length()==0||digits==null)
            return res;
        backtracking(new StringBuilder(),res,digits);
        return res;
    }
    private void backtracking(StringBuilder prefix,List<String> res,String digits){
        if (prefix.length()==digits.length()){
            if (!res.contains(prefix.toString())){
                res.add(prefix.toString());
            }
            return;
        }
        char[] letters=KEYS[digits.charAt(prefix.length()-'0')].toCharArray();
        for(char c:letters){
            prefix.append(c);
            backtracking(prefix,res,digits);
            prefix.deleteCharAt(prefix.length()-1);//删除最后一个字符，换成另一种情况。
            //相当于adg，adh，adi遍历完后，将第二个字母换为e，形成aeg，aeh，aei
        }

    }

}
