package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c
// 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
//如果输入字符串是aabc，那么一种组合可以是aabc，abac等等

//问题1：如何解决输入字符可能有重复
//问题2：回溯的时候的迭代变量
public class Permutation {
    public static void main(String[] args){}
    private List<String> res=new ArrayList<>();
    public List<String> getRes(String str){
        if (str.length()==0)
            return res;
        char[] temp=str.toCharArray();
        Arrays.sort(temp);
        backtracking(temp,new boolean[str.length()],new StringBuilder());
        return res;

    }
    private void backtracking(char[] temp,boolean[] hasVisited,StringBuilder s){
        if (s.length()==temp.length){
            res.add(s.toString());
            return;//这里一定要返回
        }
        for (int i=0;i<temp.length;i++){
            if (hasVisited[i])
                continue;
            if (i!=0&&temp[i]==temp[i-1]&&!hasVisited[i])
                continue;
            hasVisited[i]=true;
            s.append(temp[i]);
            backtracking(temp,hasVisited,s);
            s.deleteCharAt(s.length()-1);
            hasVisited[i]=false;
        }


    }
}
