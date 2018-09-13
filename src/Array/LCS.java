package Array;

public class LCS {
    //最长公共子序列
    public int lengthOfLCS(int[] nums1,int[] nums2){
        int n1= nums1.length;
        int n2=nums2.length;
        int[][] dp=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(nums1[j-1]==nums2[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n1][n2];
    }

    //最长公共子串
    public int lengthOfLCS2(int[] nums1,int[] nums2){
        int n1=nums1.length;
        int max=0;
        int n2=nums2.length;
        int[][] dp=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(dp[i][j],max);
                }
                else
                    dp[i][j]=0;
            }
        }
        return  max;
    }
    //最长公共子串
    public int findLength(int[] A,int[] B){
        int max=0;
        int[][] samecount=new int[A.length][B.length];
        for(int i=0;i<A.length;i++){
            if(A[i]==B[0]){
                samecount[i][0]=1;
            }
        }
        for(int i=0;i<B.length;i++){
            if(A[0]==B[i]){
                samecount[0][i]=1;

            }
        }
        for(int row=1;row<A.length;row++){
            for(int col=1;col<B.length;col++){
                if(A[row]==B[col]){
                    samecount[row][col]=samecount[row-1][col-1]+1;
                    max=Math.max(max,samecount[row][col]);
                }
            }
        }
        return max;
    }

//    上面的方式非常容易理解，时间复杂度是O(m*n)，空间复杂度也是O（m*n）。如果还想进一步压缩，其实也是可以的，可以做到时间复杂度是O(min(m,n))，空间复杂度是O(max(m,n))。
//    具体方法就是，我们把二位矩阵改成一维矩阵，然后通过迭代的方式来不断的进行匹配，例如固定第二个字符串，然后使用第一个字符串的每一个字符都在第二个字符串中匹配，把匹配结果迭
//    代到下一次的匹配中即可。
    public int findLength2(int[] A, int[] B){
        if(A.length<B.length)
            return findLength2(B,A);
        int max=0;
        int[] samecount=new int[A.length];
        for(int i=0;i<A.length;i++){
            if(B[0]==A[i]){
                samecount[i]=1;
            }
        }
        //初始化最后一行
        for(int i=1;i<B.length;i++){
            int[] tempsamcount=new int[A.length];
            for(int j=0;j<A.length;j++){
                if(A[j]==B[i]){
                    if(j==0){
                        tempsamcount[j]=1;
                    }
                    else{
                        //状态转移
                        tempsamcount[j]=samecount[j-1]+1;
                    }
                    //全局比较
                    max=max>tempsamcount[j]?max:tempsamcount[j];
                }
            }
            //下一次迭代
            samecount=tempsamcount;
        }
        return max;

    }

}
