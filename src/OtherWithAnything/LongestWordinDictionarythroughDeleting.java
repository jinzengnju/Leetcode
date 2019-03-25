package OtherWithAnything;

import java.util.Arrays;

public class LongestWordinDictionarythroughDeleting {
    public static void main(String[] args){
        String[] arr={"aa","ab","abc","db","f","ce"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public String getRes(String s,String[] d){
        String res="";
        for (String dx:d){
            int l1=res.length();int l2=dx.length();
            if (l1>l2||(l1==l2&&res.compareTo(dx)<0)){
                continue;
            }
            if (helper(s,dx))
                res=dx;
        }
        return res;
    }
    private boolean helper(String s,String dx){
        for (int i=0,j=0;i<s.length()&&j<dx.length();i++){
            if (s.charAt(i)==dx.charAt(j)){
                j++;
            }
            if (j==dx.length()){return true;}

        }
        return false;

    }
}
