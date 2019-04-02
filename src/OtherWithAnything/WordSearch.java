package OtherWithAnything;

import com.sun.org.apache.regexp.internal.RE;

public class WordSearch {
    public static void main(String[] args){
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        System.out.println(new WordSearch().exist(board,word));
    }

    private int rows=0;
    private int cols=0;
    private static int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if (word==null||word.length()==0){
            return true;
        }
        if (board==null||board.length==0||board[0].length==0)
            return false;
        this.rows=board.length;
        this.cols=board[0].length;
        boolean[][] hasVisited=new boolean[this.rows][this.cols];
        for (int i=0;i<this.rows;i++){
            for (int j=0;j<this.cols;j++){
                if (backtracking(0,board,i,j,word,hasVisited))
                    return true;
            }
        }
        return false;

    }
    private boolean backtracking(int curLen,char[][] board,int i,int j,String word,boolean[][] visited){
        if (curLen==word.length()){
            return true;
        }
        if (i<0||i>=this.rows||j<0||j>=this.cols||visited[i][j]||board[i][j]!=word.charAt(curLen)){
            return false;
        }
        visited[i][j]=true;
        for (int[] d:direction){
            int cr=i+d[0],cl=j+d[1];
            if (backtracking(curLen+1,board,cr,cl,word,visited)){
                return true;
            }
        }
        visited[i][j]=false;
        return false;
    }

}
