package Palindrome;

//给出一个整数，判断这个整数是否是回文数字，不能使用额外的存储空间，意思是不能将他变为字符串。
//
//        　　题目分析：第一想到的就是将他变成一个字符串然后对他进行判断是否是回文串。但是题目不能变为字符
//        串。这里我们就可以变换一种方法。比如对数字“12321”，12321/10000=1,首位为1, 12321%10=1，
//        尾部为1，然后继续判断232这个数字，按照相同的方法（这里的关键是剩余数字的位数需要确定）

public class PalindromNumber {
    public static void main(String[] args){

    }
    public boolean getRes(int num){
        if (num==0)
            return true;
        if (num<0||num%10==0)
            return false;
        int right=0;
        //循环的时候，num一直在减小，right一直增大
        //当num与right位数相等，num可能会小于right，此时会将数字分成两半
        //或者num的位数比right小，对应着原来数据可能是奇数位
        while(num>right){
            right=right*10+num%10;
            num/=num/10;
        }
        return num==right||num==right/10;


    }
}
