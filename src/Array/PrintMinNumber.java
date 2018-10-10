package Array;

//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
// 例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。

import java.util.Arrays;

public class PrintMinNumber {
    public static void main(String[] args){}
    public String getRes(int[] nums){
        String[] temp=new String[nums.length];
        for (int i=0;i<nums.length;i++){
            temp[i]=nums[i]+"";
        }
        Arrays.sort(temp,(s1,s2)->(s1+s2).compareTo(s2+s1));
        //这里是什么意思？如果s1+s2比s2+s1小，那么compareTo的返回值为-1.传入的s1放在前面，s2放在后面。否则s1放在后面，s2放在前面
        String ret="";
        for (String s:temp){
            ret+=s;
        }
        return ret;

    }
}
