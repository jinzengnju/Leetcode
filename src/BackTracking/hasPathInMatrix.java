package BackTracking;

//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
//        如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。

public class hasPathInMatrix {
    public static void main(String[] args){

    }
    private int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    private int row;
    private int col;
    private boolean result=false;


    public boolean hasPath(char[] arr,int row,int col,char[] str){
        if (row==0||col==0)
            return  false;
        this.row=row;
        this.col=col;
        char[][] matrix=buildMatrix(arr,row,col);
        boolean[][] marked=new boolean[row][col];
        for (int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(backtracking(matrix,marked,str,i,j,0))//查看以位置（i，j）开始是否又满足的情况,并且匹配的其实len长度为0
                    return true;
            }
        }
        return false;

    }

    private boolean backtracking(char[][] matrix,boolean[][] marked,char[] str,int i,int j,int pathLen){
        //停止条件
        if(pathLen==str.length)
            return true;
        if(i<0||i>=row||j<0||j>=col||matrix[i][j]!=str[pathLen]||marked[i][j]==true)
            return false;
        marked[i][j]=true;
        for (int[] d:directions){
            if(backtracking(matrix,marked,str,i+d[0],j+d[1],pathLen+1))
                //如果最后一步返回true，往前回溯，那么最开始的那步也将返回为true
                return true;
        }
        marked[i][j]=false;
        return false;
    }


    private char[][] buildMatrix(char[] arr,int row,int col){
        char[][] res=new char[row][col];
        int index=0;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                res[i][j]=arr[index++];
            }
        }
        return res;
    }
}
