package Dynamic.SplitData;

//题目描述：Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//注意：subString是左闭右开的

import java.util.LinkedList;
import java.util.Queue;

//因为dp数组是比str的长度大1。所以当对i=2进行遍历的时候，对应到字符串中应该是第一个字符，所以有subString(i，i-2)
// 即subString(1，2)取出第一个字符
public class DecodeWays {
    public static void main(String[] args){
        String str="adasfsd";
        System.out.println(str.substring(0,3));

    }

    public int getRes(String str){
        int n=str.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=str.charAt(0)=='0'?0:1;
        for (int i=2;i<str.length();i++){
            int one=Integer.valueOf(str.substring(i-1,i));
            if (one!=0)
                dp[i]+=dp[i-1];
            if (str.charAt(i-2)=='0')
                continue;
            int two=Integer.valueOf(str.substring(i-2,i));
            if (two<=26)
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }

}
