package Array;

//https://blog.csdn.net/qcjabc/article/details/72954410
//如果满足下面两个条件:
//len(left_part) == len(right_part)
//max(left_part) <= min(right_part)
//那么我们就已经把{A,B}这个集合分成了两个相同长度的部分，而且右边始终大于左边。那么中位数就等于median = (max(left_part) + min(right_part))/2.

//i + j == m - i + n - j (or: m - i + n - j + 1)
//        if n >= m, 我们只需要确定i和j的关系: i = 0 ~ m, j = (m + n + 1)/2 - i
//B[j-1] <= A[i] and A[i-1] <= B[j]
//这里必须保证m<=n,这是为了保证在i在大于等于0小于等于m的取值中，一直保持有效。因为j=(m+n+1)/2-i，如果i=m且n<m，那么j<0,这会得到错误的答案。
//i在[0,m]中取值，找到满足B[j-1] <= A[i] and A[i-1] <= B[j]的情况，这个时候的i就是中间的位置。

//如果i和j满足B[j-1] <= A[i] and A[i-1] <= B[j]，意味当前ij已经就是我们要找的位置，停止查找。
//        如果B[j-1] > A[i]，那么意味A[i]太小了，我们需要调整i让条件B[j-1] <= A[i]满足。
//        我们可以增大i吗？
//        可以，因为当i增大，j势必会减小，那么对应B[j-1]会减少，A[i]会增大，经过调整B[j-1] <= A[i]可能刚好能够满足。
//        我们可以减少i吗？
//        不可以，与之前所述的相反，调整后条件B[j-1] <= A[i]依旧无法满足。
//        所以我们要增大i。就是调整当前的搜索范围到[i+1, imax]，即设置imin = i+1,然后回到第二步。


public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1,int[] nums2){
        int m= nums1.length;
        int n=nums2.length;
        if(m>n){
            m=n;
            n=nums1.length;
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int imin=0,imax=m,i,j,halfLen=(m+n+1)/2;
        while(imin<=imax){
            i = (imin+imax)/2;
            j = halfLen - i;
            if(i<m&&nums2[j-1]>nums1[i])
                imin=i+1;
            else if (i>0&&nums1[i-1]>nums2[j])
                imax=i-1;
            else{
                int left_max;
                if(j==0){
                    left_max=nums1[i-1];
                }
                else if(i==0)
                    left_max=nums2[j-1];
                else
                    left_max=Math.max(nums1[i-1],nums2[j-1]);
                if((m+n)%2 == 1){
                    return left_max;
                }
                int right_min;
                if (i == m) {
                    right_min = nums2[j];
                } else if ( j == n) {
                    right_min = nums1[i];
                } else {
                    right_min = Math.min(nums1[i],nums2[j]);
                }
                return (left_max+right_min)/2.0;
            }

        }
        return -1;

    }
}
