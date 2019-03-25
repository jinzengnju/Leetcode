package Array;

//从右上角开始查找。矩阵中的一个数，它左边的数都比它小，下边的数都比它大。因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间。
//
//        复杂度：O(M + N) + O(1)

public class FindInMatrix {
    public static void main(String[] args){

    }
    public boolean Find(int target, int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row=0;
        int col=matrix[0].length;
        for(;row<matrix.length&&col>=0;){
            if (matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target)
                col--;
            else
                row++;
        }
        return false;
    }
}
