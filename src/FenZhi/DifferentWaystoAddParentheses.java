package FenZhi;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses{
    public static void main(){}

    public List<Integer> getRes(String input){
        //递归停止条件
        List<Integer> ways=new ArrayList<>();
        for (int i=0;i<input.length();i++){
            char s=input.charAt(i);
            if (s=='+'||s=='-'||s=='*'){
                List<Integer> left=getRes(input.substring(0,i-1));
                List<Integer> right=getRes(input.substring(i+1));
                for (int l:left){
                    for (int r:right){
                        switch (s){
                            case '+':
                                ways.add(l+r);
                                break;
                            case '-':
                                ways.add(l-r);
                                break;
                            case '*':
                                ways.add(l*r);
                                break;
                        }
                    }
                }
            }

        }
        if (ways.size()==0){
            ways.add(Integer.parseInt(input));
        }
        return ways;
    }
}