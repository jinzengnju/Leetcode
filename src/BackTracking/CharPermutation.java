package BackTracking;

//输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串
// abc, acb, bac, bca, cab 和 cba。
//注意：字符可能有重复

import java.util.ArrayList;
import java.util.Arrays;

public class CharPermutation {
    public  static void main(){

    }
    private ArrayList<String> res=new ArrayList<>();
    public ArrayList<String> getRes(String str){
        if(str.length()==0){
            return res;
        }
        char[] temp=str.toCharArray();
        Arrays.sort(temp);
        backtracking(temp,new boolean[temp.length],new StringBuilder());
        return res;
    }
    private void backtracking(char[] temp,boolean[] hasUsed,StringBuilder s){
        //递归停止条件：s的长度与temp长度相等即可停止
        if(s.length()==temp.length){
            res.add(s.toString());
            return;//这里一定要返回
        }
        for (int i=0;i<temp.length;i++){
            if (hasUsed[i])
                continue;
            //abc，这里是为了第一个字母选了a后，第二个字母不能再次选择在第一位的字母a。即每个字母只能用一次
            if (i!=0&&temp[i]==temp[i-1]&&!hasUsed[i-1])
                continue;
                //假如我们只看刚进来的第一层回溯，若str为aabbcde；当我们遍历了第三个字母b时，回溯后再设置第三位的b为false。
                // 假设我们第三个字母为第四个的b，会与前面的结果重复
            hasUsed[i]=true;
            s.append(temp[i]);
            backtracking(temp,hasUsed,s);
            s.deleteCharAt(s.length()-1);
            hasUsed[i]=false;
        }

    }
}
