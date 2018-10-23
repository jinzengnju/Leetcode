package Dynamic.SplitData;

//题目描述：For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
//要求平方数的个数最小

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args){
    }
    public int getRes(int n){
        List<Integer> squareList=getSquareList(n);
        int[] dp=new int[n+1];
        for (int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for (int square:squareList){
                if (square>i){
                    break;
                }
                min=Math.min(min,dp[i-square]+1);
            }
            dp[i]=min;
        }
        return dp[n];

    }
    private List<Integer> getSquareList(int n){
        List<Integer> squareList=new ArrayList<>();
        int diff=3;
        int square=1;
        while(square<=n){
            squareList.add(square);
            square+=diff;
            diff+=2;
        }
        return squareList;

    }
}
