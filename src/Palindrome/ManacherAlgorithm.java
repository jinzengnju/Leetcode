package Palindrome;

//马拉车算法
//求解最长回文子串
public class ManacherAlgorithm {
    public static void main(String[] args){

    }
    public String Manacher(String s){
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
        for (int i=1;i<t.length()-1;i++){
            p[i]=mx>i?Math.min(mx-i,p[2*id-i]):1;
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
        return s.substring((resCenter - resLen) / 2, (resCenter - resLen) / 2 + resLen-1);
    }
}
