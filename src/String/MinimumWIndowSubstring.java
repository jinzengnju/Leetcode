package String;

import java.util.HashMap;
import java.util.Map;

public class MinimumWIndowSubstring {
    public static void main(String[] args){
        String res=new MinimumWIndowSubstring().minWindow("ADOBECODEBANC","ABC");
        System.out.println(res);

    }
    //解题思路:算法时间复杂度O(n)
    //首先维护一个哈希表,键是T中的字符,值为该字符在T中出现的次数.意思为了完成匹配,我们还差多少字符的匹配
    //最开始扫描字符串T,把对应的字符和其出现次数存储在哈希表中
    //遍历S,遇到T中的字符时,将哈希表中对应字符的value-1,直到包含了T中所有的字符(用count来判定),记录一个字串并更新字串长度的最小值
    //当找到这样的窗口时,这时我们应该试图移动左边界,以看看是否有较小的长度,略掉不在T中的字符.如果某个在T中的字符出现的次数大于哈希标中的value,跳过该字符

    public String minWindow(String S,String T){
        if(T.length()>S.length())
            return  "";
        String res="";
        int left=0,count=0,minLen=S.length()+1;
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<T.length();++i){
            if(m.containsKey(T.charAt(i))){
                int t=m.get(T.charAt(i));
                m.put(T.charAt(i),t+1);
            }
            else{
                m.put(T.charAt(i),1);
            }
        }
        for(int right=0;right<S.length();right++){
            if(m.containsKey(S.charAt(right))){
                int t=m.get(S.charAt(right));
                m.put(S.charAt(right),t-1);
                //处理掉在S中和在T中,字符A的个数S大于T
                if(m.get(S.charAt(right))>=0)
                    count++;
                while(count==T.length()){
                    if(right-left+1<minLen){
                        minLen=right-left+1;
                        res=S.substring(left,right+1);
                    }
                    if(m.containsKey(S.charAt(left))){
                        int h=m.get(S.charAt(left));
                        //这里的值如果原来是负的,说明我left移动的是多余重复的字符,count不需减,
                        //如果某个在T中的字符出现的次数大于哈希表中的value,跳过该字符
                        m.put(S.charAt(left),h+1);
                        if(m.get(S.charAt(left))>0)
                            --count;
                    }
                    ++left;
                }
            }

        }
        return res;
    }


    //法二:https://blog.csdn.net/sinat_35261315/article/details/78730717
    public String minWindow2(String S,String T){
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<T.length();i++){
            if(map.containsKey(T.charAt(i))){
                int t=map.get(T.charAt(i));
                map.put(T.charAt(i),t+1);
            }
            else
                map.put(T.charAt(i),1);
        }
        int counter=T.length();
        int begin=0,end=0;
        int head=0;
        int len=Integer.MAX_VALUE;
        while(end<S.length()){
            int t=map.get(S.charAt(end));
            if(t>0){
                map.put(S.charAt(end),t-1);
                end++;
                counter--;
            }
            while(counter==0){
                if(end-begin<len){
                    len=end-begin;
                    head=begin;
                }
                int h=map.get(S.charAt(begin));
                if(h==0){
                    map.put(S.charAt(begin),h+1);
                    ++begin;
                    ++counter;
                }
            }
        }
        return len==Integer.MAX_VALUE?"": S.substring(head,head+len);

    }
}
