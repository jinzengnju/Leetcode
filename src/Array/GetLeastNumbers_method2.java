package Array;

import java.util.ArrayList;
import java.util.PriorityQueue;

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class GetLeastNumbers_method2 {
    public static void main(String[] args){

    }
    //维护一个大顶堆即可
    public ArrayList<Integer> getRes(int[] nums,int K){
        if (K>nums.length||K<=0)
            return new ArrayList<>();
        PriorityQueue<Integer> myres=new PriorityQueue<>((o1,o2)->(o2-o1));
        for (int val:nums){
            myres.add(val);
            if (myres.size()>K)
                myres.poll();
        }
        return new ArrayList<>(myres);//这里是用到了优先队列来创建了一个链表
    }

}
