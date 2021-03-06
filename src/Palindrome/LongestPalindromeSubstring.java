package Palindrome;

//最长连续回文子串
public class LongestPalindromeSubstring {
    public static void main(String[] args){

    }
    public String getRes(String str){
        int maxlen=0;
        int left=0;
        int right=0;
        for (int i=0;i<str.length();i++){
            for (int j=i+1;j< str.length();j++){
                int temp1,temp2;
                for (temp1=i,temp2=j;temp1<temp2;temp1++,temp2--){
                    //这里的判断条件不能有等号，这个for循环是判断i到j之间的字符串是否为回文串
                    if (str.charAt(temp1)!=str.charAt(temp2)){
                        break;
                    }
                }
                //i为左边界，j为右边界
                if ((temp1>=temp2)&&j-i>maxlen){
                    maxlen=j-i+1;
                    left=i;
                    right=j;
                }
            }
        }
        if (maxlen>0)
            str.substring(left,right);
        return null;
    }

    //动态规划解法
    //若一个字符串是回文串，那么这个字符串串去掉首尾形成的字符串仍然是回文串
    //1个字母的肯定是回文串
    //2个字母的必须相同才是回文串

//    设置一个int二维数组DP[i][j]用来存储从i到j的串是否回文，1表示是，0表示否。
//    这里有三种情况需要考虑：①：当只有一个字符的时候，i=j，肯定回文   DP[i][j] = 1；
//            　　                                               ②：当两个两个字符相邻的时候，如果他们相等，那么他们也是回文的，i-j<2 && s[i]==s[j]  -> DP[i][j] = 1
//            ③：当超过两个字符的时候，如果他们首尾是相同的并且除去首尾字符的剩余字符也是回文的话，那么这个串也是回文的。
//    s[i] == s[j] && DP[i+1][j-1] = 1  ->DP[i][j] = 1
//    考虑完这三种情况，就设置两个指针记录最长回文子串的左右位置，然后直接提取出来即可。DP[i][j] = 1 并且最长字符长度小于当前字符长度。
    public String getRes2(String str){
        int size=str.length();
        int maxlen=0;
        boolean[][] dp=new boolean[size][size];
        int left=0;
        int right=0;
        //dp[i][j]表示从i到j是否为回文串
        //我们遍历的时候i设置为待查询字符串的右边界
        for(int i=0;i<str.length();i++){
            for (int j=0;j<i;j++){
                //判断（j,i）之间是否为回文串
                dp[j][i]=str.charAt(i)==str.charAt(j)&&(i-j<2||dp[j+1][i-1]);
                if (dp[j][i]==true&&i-j+1>maxlen){
                    maxlen=i-j;
                    left=j;
                    right=i;
                }
            }
            dp[i][i]=true;
        }
        return str.substring(left,right+1);
    }

    //马拉车算法，针对回文字符串
    //https://blog.csdn.net/u014771464/article/details/79120964
    //首先因为字符串可以为奇数也可以为偶数，为了避免分情况讨论，统一插入#
    //# 1 # 2 # 2 # 1 # 2 # 2 #
    //1 2 1 2 5 2 1 6 1 2 3 2 1
    //将下面的数组求出即可
    //需给开头加上个非#号字符'$'，结尾加一个'@'。
    //需要新增两个辅助变量mx和id，其中id为最大回文子串中心的位置，mx是回文串能延伸到的最右端的位置（很多文章都这样说，其实并不是，根据下面的代码就能看出来，mx应该是已找到的
    // 回文子串所能到达的最右端，而id是最右端回文子串对应的中心），这个算法的最核心的一行如下：
    //马拉车核心转换思想
    //已知在j点处的回文子串和id处的回文字串，求关于id对称的i点的的回文子串的长度
    //在另一个文件实现
}
