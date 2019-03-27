package OtherWithAnything;

//在一个有重复元素的数组中查找 key 的最左位置的实现如下：
public class binarySearch_v2 {
    public static void main(String[] args){}
    public int getRes(int[] nums,int key){
        int l=0;
        int h=nums.length-1;
        int m;
        while(l<h){
            m=l+(h-l)/2;
            if (nums[m]>=key)
                h=m;//如果赋值表达式为h=m,那么判断条件为l<h，不能是小于等于
            else
                l=m+1;
        }
        return l;

    }

}
