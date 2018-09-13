package TwoPointers;

public class MergeSortedArray {
    public static void main(String[] args){

    }
    public void merge(int[] nums1,int m,int[] nums2,int n){
        int index1=m-1;
        int index2=n-1;
        int mergeindex=m+n-1;
        for(int i=mergeindex;i<=0;i--){
            if(index1<0) {
                nums1[mergeindex--] = nums2[index2--];
            }else if(index2<0){
                nums1[mergeindex--]=nums1[index1--];

            }else if(nums1[index1]<nums2[index2]){
                nums1[mergeindex--]=nums2[index2--];
            }else
                nums1[mergeindex--]=nums1[index1--];
        }

    }
}
