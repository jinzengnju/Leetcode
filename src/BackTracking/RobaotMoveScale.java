package BackTracking;

//地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
//
//        例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,37)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？

public class RobaotMoveScale {
    public static  void main(String[] args){

    }
    private int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
    private int rows;
    private int cnt=0;
    private int cols;
    private int[][] digitSum;

    public int getNum(int m,int n,int k){
        this.rows=m;
        this.cols=n;
        boolean[][] marked=new boolean[m][n];
        makeMatrix(rows,cols);
        dfs(0,0,marked,k);
        return  cnt;
    }
    private void dfs(int r,int c,boolean[][] marked,int k){
        //停止条件：超过边界值
        //
        if (r<0||r>rows||c<0||c>=cols||marked[r][c])
            return;
        marked[r][c]=true;
        if (digitSum[r][c]>k)
            return;
        cnt++;
        for (int[] d:directions){
            dfs(r+d[0],c+d[1],marked,k);
        }
    }
    private void makeMatrix(int rows,int cols){
        int[] digitSumOne=new int[Math.max(rows,cols)];
        for (int i=0;i<digitSumOne.length;i++){
            int num=i;
            while (num>0){
                digitSumOne[i]+=num%10;
                num=i/10;
            }
        }
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                digitSum[i][j]=digitSumOne[i]+digitSumOne[j];
            }
        }
    }
}
