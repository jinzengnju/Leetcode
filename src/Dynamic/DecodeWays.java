package Dynamic;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        Given a non-empty string containing only digits, determine the total number of ways to decode it.
//
//        Example 1:
//
//        Input: "12"
//        Output: 2
//        Explanation: It could be decoded as "AB" (1 2) or "L" (12).

//122508
//当我们遍历到元素0的时候，如果前一位元素不为0，那么前一位元素的翻译方法数可以累加到当前位置。如果前一位是0，那么这个位置不能单独翻译，会与第i-2位组成两位数字进行翻译
//那么如果第i-2位置还是为0，那么这个位置的翻译方法不存在为0.
//再加上dp[i-2]的时候，会首先判断两位数字是否有超过26

public class DecodeWays {
    public static void main(String[] args){}
    public int getRes(String s){
        if (s==null||s.length()==0)
            return 0;
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for (int i=2;i<n;i++){
            int one=Integer.valueOf(s.substring(i-1,i));
            if (one!=0){
                dp[i]+=dp[i-1];
            }
            if (s.charAt(i-2)=='0')
                continue;
            int two=Integer.valueOf(s.substring(i-2,i));
            if (two<=26)
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }
}
