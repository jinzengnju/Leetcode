package FenZhi;

import java.util.ArrayList;
import java.util.List;

//Input: "2-1-1".
//
//        ((2-1)-1) = 0
//        (2-(1-1)) = 2
//
//        Output : [0, 2]
public class DifferentWaystoAddParentheses {
    public static void main(String[] args){}

    public List<Integer> getRes(String input){
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if (c=='+'||c=='-'||c=='*'){
                List<Integer> left=getRes(input.substring(0,i));
                List<Integer> right=getRes(input.substring(i+1));
                for (int l:left){
                    for (int r:right){
                        switch (c){
                            case '+':
                                res.add(l+r);
                                break;
                            case '-':
                                res.add(l-r);
                                break;
                            case '*':
                                res.add(l*r);
                                break;

                        }
                    }
                }
            }
        }
        if (res.size()==0){
            res.add(Integer.valueOf(input));
        }
        return res;

    }

}
