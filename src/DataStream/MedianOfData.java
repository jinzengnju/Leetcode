package DataStream;

import java.util.PriorityQueue;

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
// 那么中位数就是所有数值排序之后中间两个数的平均值。
public class MedianOfData {
    public static void main(String[] args){

    }
    private PriorityQueue<Integer> left=new PriorityQueue<Integer>((o1, o2) -> o2-o1);//大顶堆
    private PriorityQueue<Integer> right=new PriorityQueue<Integer>();//小顶堆

    private int N=0;
    private void insert(Integer val){
        if (N%2==0){
            left.add(val);
            right.add(left.poll());
        }else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }
    public Double getMedian(){
        if (N%2==0)
            return (left.peek()+right.peek())/2.0;
        else
            return (double)right.peek();
    }
}
