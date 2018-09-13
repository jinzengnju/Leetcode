package String;


//Input : "abccccdd"
//        Output : 7
//        Explanation : One longest palindrome that can be built is "dccaccd", whose length is 7.
//
//        使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。
//
//        因为回文字符串最中间的那个字符可以单独出现，所以如果有单独的字符就把它放到最中间。



public class LongestPalidrome {
    public int longestPalidrome(String s){
        int[] cnts=new int[256];
        for(char c:s.toCharArray()){
            cnts[c]++;
        }
        int palidrome=0;
        for(int cnt:cnts){
            palidrome+=(cnt/2)*2;
        }
        //只要出现个数是偶数的都行,那么如果是三个,可以拿两个出来组成回文串一部分
        if(palidrome<s.length()){
            palidrome++;
        }
        // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
        return palidrome;
    }
}
