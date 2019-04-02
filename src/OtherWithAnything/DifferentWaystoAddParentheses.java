package OtherWithAnything;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    public static void main(String[] args){}
    public List<Integer> diffWaysToCompute(String input){
        List<Integer> ways=new ArrayList<>();
        //注意：这里每次的递归一定要新建ways的List<integer>，每次都要新建，
        //对于2-1-1；当二分到最小的问题，比如只有一个2时，不会进入for循环
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if (c=='-'||c=='+'||c=='*'){
                List<Integer> left=diffWaysToCompute(input.substring(0,i));
                List<Integer> right=diffWaysToCompute(input.substring(i+1));
                for (int l:left){
                    for (int r:right){
                        switch (c){
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
