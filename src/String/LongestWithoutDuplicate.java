package String;

import java.util.Arrays;

public class LongestWithoutDuplicate {
    public static void main(String[] args){}
    public int getRes(String str){
        int[] prePos=new int[26];
        int curLen=0;
        int max=0;
        Arrays.fill(prePos,-1);
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            int preI=prePos[c-'0'];
            if (preI==-1||i-preI>curLen)
                curLen++;
            else{
                max=Math.max(curLen,max);
                curLen=i-preI;//curLen的长度更新为i-preI
            }
            prePos[c-'0']=i;
        }
        max=Math.max(max,curLen);
        return max;
    }
}
