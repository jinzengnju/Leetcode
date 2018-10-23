package Dynamic.SplitData;

//题目描述：For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
//分割整数的最大乘积

public class IntegerBreak {
    public static void main(String[] args){}
    public int getRes(int n){
        int[] dp=new int[n+1];
        dp[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i-1;j++){
                dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,j*(i-j)));
            }
        }
        return dp[n];

    }

}
