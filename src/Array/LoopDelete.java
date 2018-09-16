package Array;

//约瑟夫环，设置一个索引变量一直递增，如果超出数组长度，取余即可


import java.util.Scanner;

//有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:
//｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
public class LoopDelete {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int n=scan.nextInt();
            int res=getNum(n);
            System.out.println(res);
        }

    }
    public static int getNum(int n){
        if(n>1000)
            return getNum(999);
        if(n<=0)
            return -1;
        int[] nums=new int[n];
        for (int h=0;h<n;h++){
            nums[h]=h;
        }

        final int DeleteFlag=n+1;//删除标志
        int currentLen=n;
        int i=0;//循环下标
        int lastindex=0;
        int step=2;//步长
        int count=0;//移动计数
        while(currentLen!=0){
            if (nums[i]!=DeleteFlag){
                if (count++==step){
                    nums[i]=DeleteFlag;
                    lastindex=i;
                    currentLen--;
                    count=0;
                }

            }
            i=(i+1)%n;
        }
        return lastindex;
    }
}
