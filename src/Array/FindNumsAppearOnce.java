package Array;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
//两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
//diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
public class FindNumsAppearOnce {
    public static void main(String[] args){

    }
    public void getRes(int[] nums,int[] nums1,int[] nums2){
        int res=0;
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
        }
        res&=-res;
        for (int i=0;i<nums.length;i++){
            if ((nums[i]&res)==0){
                nums1[0]^=nums[i];
            }
            else
                nums2[0]^=nums[i];
        }
    }
}
