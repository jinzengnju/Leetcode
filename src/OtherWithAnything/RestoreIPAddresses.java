package OtherWithAnything;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args){

    }

    private List<String> res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        List<Integer> prefix=new ArrayList<>();
        backtracking(prefix,this.res,s);
        return this.res;
    }
    private void backtracking(List<Integer> prefix,List<String> res,String newsequence){
        if (prefix.size()==4||newsequence.length()==0){
            if (prefix.size()==4&&newsequence.length()==0){
                res.add(convertToString(prefix));
            }
        }
        for(int i=0;i<newsequence.length()&&i<3;i++){
            if (i!=0&&newsequence.charAt(0)==0)
                break;
            int digits=Integer.parseInt(newsequence.substring(0,i+1));
            if (digits<=255){
                prefix.add(digits);
                backtracking(prefix,res,newsequence.substring(i+1));
                prefix.remove(prefix.size()-1);
            }
        }
    }
    private String convertToString(List<Integer> prefix){
        StringBuilder sb=new StringBuilder();
        for(int e:prefix){
            sb.append(e);
            sb.append('.');
        }
        String temp=sb.toString();
        return temp.substring(0,temp.length()-1);
    }


}
