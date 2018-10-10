package Array;

import java.util.PriorityQueue;

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
public class GetMedianFromDataStream {
    public static void main(String[] args){

    }
    private static PriorityQueue<Integer> left=new PriorityQueue<>((o1,o2)->(o2-o1));//大顶堆，如果o2-o1小于0，那么o1放在前面，也就是大的放在前面。大顶堆
    private static PriorityQueue<Integer> right=new PriorityQueue<>();//小顶堆
    private static int cnt=0;
    public static void getRes(int val){
        if (cnt%2==0){
            left.add(val);
            right.add(left.peek());
        }else {
            right.add(val);
            left.add(right.poll());
        }
        cnt++;
    }
    public Double getMedian(){
        if (cnt%2==0){
            return (left.peek()+right.peek())/2.0;
        }
        else
            return (double)right.peek();
    }

}
