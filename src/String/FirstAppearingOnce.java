package String;

//请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
// 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。

import java.util.LinkedList;
import java.util.Queue;

public class FirstAppearingOnce {
    private int[] cnts=new int[256];
    private Queue<Character> queue=new LinkedList<>();
    public static void main(String[] args){}
    public char getRes(){
        return queue.isEmpty()?'#':queue.peek();

    }
    private void Helper(char ch){
        cnts[ch]++;
        queue.add(ch);
        while (cnts[queue.peek()]>1&&!queue.isEmpty()){
            queue.poll();
        }
    }
}
