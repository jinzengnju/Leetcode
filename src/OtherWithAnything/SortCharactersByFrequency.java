package OtherWithAnything;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args){
        String str="tree";
        System.out.println(new SortCharactersByFrequency().getRes(str));
    }
    public String getRes(String str){
        StringBuffer res=new StringBuffer();
        char[] chartemp=str.toCharArray();
        Map<Character,Integer> mymap=new HashMap<>();
        for (char c:chartemp){
            if (mymap.containsKey(c))
                mymap.put(c,mymap.get(c)+1);
            else
                mymap.put(c,1);
        }
        List<Map.Entry<Character,Integer>> mylist=new ArrayList<Map.Entry<Character, Integer>>(mymap.entrySet());
        Collections.sort(mylist,new SortByValueCharactor());
        for (Map.Entry<Character,Integer> mapping:mylist){
            char c=mapping.getKey();
            for (int i=0;i<mapping.getValue();i++){
                res.append(c);
            }
        }
        return res.toString();
    }
}

class SortByValueCharactor implements Comparator<Map.Entry<Character,Integer>>{
    @Override
    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        return o2.getValue()-o1.getValue();
    }
}
