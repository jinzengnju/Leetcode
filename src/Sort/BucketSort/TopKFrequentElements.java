package Sort.BucketSort;
//桶排序
//出现频率最多的 k 个数
//347. Top K Frequent Elements (Medium)
//
//        Given [1,1,1,2,2,3] and k = 2, return [1,2].
//        设置若干个桶，每个桶存储出现频率相同的数，并且桶的下标代表桶中数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
//
//        把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args){}
    public List<Integer> getRes(int[] nums,int K){
        Map<Integer,Integer> mymap=new HashMap<>();
        for (int val:nums){
            mymap.put(val,mymap.getOrDefault(val,0)+1);
        }

        List<Integer>[] bucket=new ArrayList[nums.length+1];//这里是nums的length，比如每个数据都只出现了一次。不能是mymap的length
        for (int key:mymap.keySet()){
            int frequency=mymap.get(key);
            if (bucket[frequency]==null){
                bucket[frequency]=new ArrayList<Integer>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res=new ArrayList<>();
        for (int i=bucket.length-1;i>=0&&res.size()<K;i--){
            if (bucket[i]!=null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
