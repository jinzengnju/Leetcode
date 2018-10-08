package TwoPointers;

//题目描述
//        输出所有和为 S 的连续正数序列。
//
//        例如和为 100 的连续序列有：
//
//        [9, 10, 11, 12, 13, 14, 15, 16]
//        [18, 19, 20, 21, 22]。

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    public static void main(String[] args){

    }
    public List<List<Integer>> getRes(int sum){
        List<List<Integer>> mylist=new ArrayList<>();
        int start=1;
        int end=2;
        int cursum=3;
        while(end<=sum){
            if (cursum>sum){
                cursum-=start;
                start++;
            }else if (cursum<sum){
                end++;
                cursum+=end;
            }else {
                List<Integer> tempList=new ArrayList<>();
                for (int i=start;i<=end;i++){
                    tempList.add(i);
                }
                mylist.add(tempList);
                cursum-=start;
                start++;
                end++;
                cursum+=end;
            }
        }
        return mylist;
    }
}
