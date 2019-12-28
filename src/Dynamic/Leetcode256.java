package Dynamic;

public class Leetcode256 {
    public static void main(String[] args){

    }
    private int getRes(int[][] array){
        int[][] dp=new int[array.length][array[0].length];

        for(int i=0;i<array.length;i++){
            for (int k=0;k<array[0].length;k++){
                for (int it=0;it<array[0].length;it++){
                    int temp=Integer.MAX_VALUE;
                    if (it!=k){
                        temp=Math.min(dp[i-1][it],temp);
                    }
                    dp[i][k]=temp+array[i][k];
                }
            }
        }

        return 0;
    }
}
