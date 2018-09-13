package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
//
//        Input:
//        {2, 3, 1, 0, 2, 5}
//
//        Output:
//        2
//
//要求复杂度为 O(N) + O(1)，也就是时间复杂度 O(N)，空间复杂度 O(1)
//        这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上。
public class DuplicateNumber {
    public static void main(String[] args) throws Exception{
        //从控制台输入字符串
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String query=br.readLine();
        String title=br.readLine();
        System.out.println(query);
        System.out.println(title);

    }
    public boolean duplicate(int[] nums,int length,int[] duplications){
        if(nums==null||length<=0){
            return false;
        }
        for(int i=0;i<length;i++){
            while(i!=nums[i]){
                if(nums[i]==nums[nums[i]]){
                    duplications[0]=nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);
            }
        }
        return false;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
