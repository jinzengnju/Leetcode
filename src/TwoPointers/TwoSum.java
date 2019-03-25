package TwoPointers;

//注意：输入的数组是有序的
//Input: numbers={2, 7, 11, 15}, target=9
//        Output: index1=1, index2=2
//        题目描述：在有序数组中找出两个数，使它们的和为 target。

public class TwoSum {
    public static void main(String[] args){

    }
    public int[] getRes(int[] arr,int target){
        int[] res=new int[2];
        int l=0;
        int r=arr.length-1;
        while(l<r){
            if ((arr[l]+arr[r])>target){
                r--;
                continue;
            }
            if ((arr[l]+arr[r])<target){
                l++;
                continue;
            }
            else {
                res[0]=l;
                res[1]=r;
                break;
            }
        }
        return res;
    }
}
