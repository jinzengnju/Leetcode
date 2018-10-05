package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
//例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
//用一个堆的数据结构
public class MaxInWindows {
    public static void main(String[] args){
    }
    public List<Integer> getRes(int[] num,int size){
        List<Integer> res=new ArrayList<>();
        PriorityQueue<Integer> MaxHeap=new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i=0;i<size;i++){
            MaxHeap.add(num[i]);
        }
        res.add(MaxHeap.peek());
        for (int i=1;i+size-1<num.length;i++){
            MaxHeap.remove(num[i-1]);
            MaxHeap.add(num[i+size-1]);
            res.add(MaxHeap.peek());
        }
        return res;
    }
}
