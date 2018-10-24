package DFS;

//Input:
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//
//Output: 2
//
//Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
//The 2nd student himself is in a friend circle. So return 2.
//题目描述：好友关系可以看成是一个无向图，例如第 0 个人与第 1 个人是好友，那么 M[0][1] 和 M[1][0] 的值都为 1。


public class FriendCircles {
    public static void main(String[] args){}

    private int n;
    public int getRes(int[][] M){
        this.n=M.length;
        int cnt=0;
        boolean[] hasVisited=new boolean[n];
        for (int i=0;i<n;i++){
            if (!hasVisited[i]){
                dfs(M,i,hasVisited);
                cnt++;
            }
        }
        return cnt;
    }
    private void dfs(int[][] M,int i,boolean[] hasVisited){
        hasVisited[i]=true;
        for (int h=0;h<n;h++){
            if (M[i][h]==1&&!hasVisited[h]){
                dfs(M,h,hasVisited);

            }
        }

    }
}