package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//桶排序
public class TopKFrequentElements {
    public List<Integer> findTopKFrequentElements(int[] nums,int k){
        Map<Integer,Integer>  frequencyForNum=new HashMap<>();
        for(int num:nums){
            if(!frequencyForNum.containsKey(num)){
                frequencyForNum.put(num,1);
            }else
                frequencyForNum.put(num,frequencyForNum.get(num)+1);
        }

        List<Integer>[] buckets=new ArrayList[nums.length+1];
        for(int key:frequencyForNum.keySet()){
            int frequency=frequencyForNum.get(key);
            if(buckets[frequency]==null){
                buckets[frequency]=new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        List<Integer> res=new ArrayList<>();
        for(int i=buckets.length-1;i>=0&&res.size()<k;i--){
            if(buckets[i]!=null)
                res.addAll(buckets[i]);
        }
        return res;

    }

}
