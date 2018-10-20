package Sort.BucketSort;

//Input:
//        "tree"
//
//        Output:
//        "eert"
//
//        Explanation:
//        'e' appears twice while 'r' and 't' both appear once.
//        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void  main(String[] args){}
    public String getRes(String s){
        Map<Character,Integer> mymap=new HashMap<>();
        for (char c:s.toCharArray()){
            mymap.put(c,mymap.getOrDefault(c,0)+1);
        }

        List<Character>[] buckets=new ArrayList[s.length()+1];
        for (char key:mymap.keySet()){
            int frequency=mymap.get(key);
            if (buckets[frequency]==null){
                buckets[frequency]=new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        StringBuilder sb=new StringBuilder();
        for (int i=buckets.length-1;i>=0;i--){
            if (buckets[i]==null)
                continue;
            for (char c:buckets[i]){
                for (int h=0;h<i;h++)
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
