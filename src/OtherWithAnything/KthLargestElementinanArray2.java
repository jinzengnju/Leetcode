package OtherWithAnything;

import java.util.PriorityQueue;

//使用堆排序的方法
//因为要找第K大的元素，那么建立最小堆，最后堆中的顶节点即为要求的值
public class KthLargestElementinanArray2 {
    public static void main(String[] args){}
    public int getRes(int[] nums,int K){
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        PriorityQueue<Integer> heap2=new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int val:nums){
            heap.add(val);
            if (heap.size()>K)
                heap.poll();
        }
        return heap.peek();
    }
}
