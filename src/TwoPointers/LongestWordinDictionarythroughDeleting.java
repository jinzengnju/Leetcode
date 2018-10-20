package TwoPointers;

import java.util.List;

//Input:
//        s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//        Output:
//        "apple"
//        题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最大字符串。
public class LongestWordinDictionarythroughDeleting {
    public static void main(String[] args){
        int res="bc".compareTo("a");
        System.out.println(res);
    }
    public String getRes(String s, List<String> list){
        String longestStr="";
        for (String target:list){
            int l1=longestStr.length();
            int l2=target.length();
            if (l1>l2||(l1==l2&&longestStr.compareTo(target)>0))
                continue;
            if (isVaild(s,target)){
                longestStr=target;
            }
        }
        return longestStr;
    }
    private boolean isVaild(String s,String target){
        int i=0;
        int j=0;
        while (i<s.length()&&j<target.length()){
            if (s.charAt(i)==target.charAt(j))
                j++;
        }
        i++;
        if (j==target.length())
            return true;
        return false;
    }


}
