package WangYi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    static class Cost{
        int index;
        int cost;
        public Cost(int i,int c){
            index = i;
            cost = c;
        }
    }
    static int get_point_alloc(ArrayList<Cost> cost, int sum, int pos){

        int ncost = cost.get(pos).cost;
        int max_c = sum/ncost;
        int sum_count = 0;
        for (int i=0;i<=max_c;i++){
            int nsum = sum-i*ncost;
            if (nsum == 0)
            {
                sum_count+=1;
                continue;
            }
            else
            {
                if(pos>=cost.size()-1){
                    continue;
                }
            }
            sum_count += get_point_alloc(cost,sum-ncost*i,pos+1);
        }
        return sum_count;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int[] cost = new int[N];
        ArrayList<Cost> c_index = new ArrayList<>();
        for (int i=0;i<N;i++){
            int c = s.nextInt();
            c_index.add(new Cost(i,c));
        }
        Collections.sort(c_index, new Comparator<Cost>() {
            @Override
            public int compare(Cost o1, Cost o2) {
                if (o1.cost>o2.cost)
                    return 1;
                else if (o1.cost < o2.cost)
                    return -1;
                else
                    return 0;
            }
        });
        int res = get_point_alloc(c_index,M,0);
        System.out.println(res);
    }
}
