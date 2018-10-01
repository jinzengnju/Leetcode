package DataStream;

import java.util.LinkedList;
import java.util.Queue;

//请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
// 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
public class CharStreamFisrstNoDuplicate {
    public static void main(String[] args){
        
    }
    //字符可能发的个数一共有256种，所以创建256维度的数组
    private int[] cnts=new int[256];
    private Queue<Character> myqueue=new LinkedList<>();
    //如何创建queue，通过创建LinkedList即可
    private void insert(char ch){
        cnts[ch]++;
        myqueue.add(ch);
        while(!myqueue.isEmpty()&&cnts[myqueue.peek()]>1){
            myqueue.poll();
        }
    }
    private char FirstAppearingOnce(){
        return myqueue.isEmpty()?'#':myqueue.peek();
    }
}
