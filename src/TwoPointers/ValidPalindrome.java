package TwoPointers;

//Input: "abca"
//        Output: True
//        Explanation: You could delete the character 'c'.
//        题目描述：可以删除一个字符，判断是否能构成回文字符串。

public class ValidPalindrome {
    public static void main(String[] args){
    }
    public boolean validrome(String str){
        char[] arr=str.toCharArray();
        int l=0;
        int r=arr.length-1;
        while (l<r){
            if (arr[l]!=arr[r]){
                return isPalidrome(arr,l+1,r)||isPalidrome(arr,l,r-1);
            }
            l++;
            r++;
        }
        return true;

    }




    private boolean isPalidrome(char[] arr,int l,int r){
        while(l<r){
            if (arr[l]!=arr[r])
                return false;
        }
        return true;

    }

}
