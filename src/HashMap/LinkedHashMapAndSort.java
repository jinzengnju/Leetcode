package HashMap;

import java.util.*;

//https://www.nowcoder.com/test/question/done?tid=18688502&qid=25368#summary
//https://www.nowcoder.com/question/next?pid=260145&qid=25367&tid=18690790
public class LinkedHashMapAndSort {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        Map<String,Integer> map=new LinkedHashMap<>();
        ////LinkedHashMap而不是hashmap！！！！！因为题目规定如果值相同
        //按照第一次插入的顺序排序，因为LinkedHashMap是用链表实现的，保存着插入的顺序
        String key;
        String filename;
        String path;
        while(scan.hasNext()){
            path=scan.next();
            int id=path.lastIndexOf("\\");
            //如果找不到说明只有文件名没有路径
            filename=id<0?path:path.substring(id+1);
            int linenum=scan.nextInt();
            key=filename+" "+linenum;
            if (map.containsKey(key))
                map.put(key,map.get(key)+1);
            else
                map.put(key,1);
        }
        //对记录进行排序
        //value相等按照插入顺序排序，否则降序
        List<Map.Entry<String,Integer>> list=new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()-o2.getValue())==0?(o1.getValue()-o2.getValue()):(o2.getValue()-o1.getValue());
            }
        });

        int m=0;
        for (Map.Entry<String,Integer> mapping:list){
            m++;
            if(m<=8){
                String[] str=mapping.getKey().split(" ");
                String k=str[0].length()>16?str[0].substring(str[0].length()-16):str[0];
                String n=str[1];
                System.out.println(k+" "+n+" "+mapping.getValue());
            }else
                break;
        }



    }
}
