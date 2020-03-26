package BFS;

//给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），
//        请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。

//考察第二点，由点及面遍历图。首先需要知道的问题是，如何判断一个树是不是有效的？ 这里有两点，
// 第一就是树上是没有环的，怎样才能确定其无环呢？如果你画出一个树，你就会发现，不管怎么画，
// 其节点数和边的数量都是 n - 1 = edges 的关系，那么有这一点是不是就够了，并不是，
// 我们还需要判断连通性，也就是说从一个节点出发，可以遍历到所有的点，满足这两个条件的图才能算是树。

import java.util.*;

public class LeetCode261 {
    public static void main(String[] args){}
    private boolean getRes(int n,int[][] edges){
        if ((n-1)!=edges.length)
            return false;
        Map<Integer, Set<Integer>> allinfo=new HashMap<>();
        get_allinfo(allinfo,n,edges);
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();

        ((LinkedList<Integer>) queue).add(0);
        while (!queue.isEmpty()){
            int cur=queue.poll();

            if (!visited.add(cur)){
                return false;
            }

            for (int neibor:allinfo.get(cur)){
                ((LinkedList<Integer>) queue).add(neibor);
                allinfo.get(neibor).remove(cur);
            }
        }
        return visited.size()==n;


    }
    private void get_allinfo(Map<Integer,Set<Integer>> allinfo,int n,int[][] edges){
        for (int i=0;i<n;i++){
            allinfo.put(i,new HashSet<Integer>());
        }
        for (int i=0;i<edges.length;i++){
            for (int j=0;j<edges[0].length;j++){
                allinfo.get(i).add(edges[i][j]);
            }
        }
    }

}
