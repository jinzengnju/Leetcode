package OtherWithAnything;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args){
        int[] nums={1,1,1,2,2,3,5,6,5,5,5,7,7};
        int k=2;
        new TopKFrequentElements().getTopK(nums,k);

    }
    public void getTopK(int[] nums,int k){
        Map<Integer,Integer> mymap=new HashMap<>();
        for (int e:nums){
            if (mymap.containsKey(e)){
                mymap.put(e,mymap.get(e)+1);
            }else {
                mymap.put(e,1);
            }
        }
        List<Map.Entry<Integer,Integer>> mylist=new ArrayList<Map.Entry<Integer,Integer>>(mymap.entrySet());
        Collections.sort(mylist,new SortByValue());
        int flag=0;
        for (Map.Entry<Integer,Integer> e:mylist){
            if (flag>=k){
                break;
            }
            flag++;
            System.out.println("数字："+e.getKey()+" 出现次数:"+e.getValue());
        }


    }

}

class SortByValue implements Comparator<Map.Entry<Integer,Integer>>{
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue()-o1.getValue();
    }
}
