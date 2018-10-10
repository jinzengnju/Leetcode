package Palindrome;

//马拉车算法
//求解最长回文子串
public class ManacherAlgorithm {
    public static void main(String[] args){
        String str="noon";
        System.out.println(Manacher(str));
    }
    public static String Manacher(String s){
        String t="$#";
        for (int i=0;i<s.length();i++){
            t+=s.charAt(i)+"#";
        }
        t+="@";
        int[] p=new int[t.length()];
        int mx=0;
        int id=0;
        int resLen=0;
        int resCenter=0;
        for (int i=1;i<t.length()-1;i++){//这里为什么从1开始，原因是因为第一个开始的符号$不应该去搜索
            p[i]=mx>i?Math.min(mx-i,p[2*id-i]):1;
            //后面需要接着匹配，但匹配起始点为中心左右的p[i]位置开始
            while(((i-p[i])>=0)&&((i+p[i])<=t.length()-1)&&(t.charAt(i-p[i])==t.charAt(i+p[i]))){
                ++p[i];
            }
            if (mx<i+p[i]){
                mx=i+p[i];
                id=i;
            }
            if (resLen<p[i]){
                resLen=p[i];
                resCenter=i;
            }
        }
        System.out.println("resCenter"+resCenter);
        System.out.println("resLen:"+resLen);
        return s.substring((resCenter - resLen) / 2, (resCenter - resLen) / 2 + resLen-1);
    }
}
