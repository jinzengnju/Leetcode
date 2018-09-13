package String;

//s1 = AABCD, s2 = CDAA
//        Return : true
//        给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
public class LoopContain {
    public boolean isLoopContain(String s1,String s2){
        String s=s1+s1;
        boolean res=s.contains(s2);
        return res;
    }
    public static void main(String[] args){
        boolean res=new LoopContain().isLoopContain("AABCD","CDAA");
        System.out.println(res);
    }

}
