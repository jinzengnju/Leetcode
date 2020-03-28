package String;
//注意：只可能出现26个英文字符

public class HospoolAlgorithm {
    public static void main(String[] args){
        System.out.println('c'-'a');
    }

    private int getRes(String text,String pattern){
        int[] shift=new int[26];
        char[] textArray=text.toCharArray();
        char[] patternArray=pattern.toCharArray();
        int m=pattern.length();
        int n=text.length();
        for (int i=0;i<shift.length;i++){
            shift[i]=m;
        }
        for (int i=0;i<pattern.length()-2;i++){
            int index=pattern.charAt(i)-'a';
            shift[index]=m-1-i;
        }

        //因为是从字符串的最右端开始匹配
        int index=m-1;
        while (index<=n-1){
            int k=0;
            for (int j=0;j<m;j++){
                if (textArray[index-j]==patternArray[m-1-j]){
                    k++;
                }

            }
            if (k==m){
                return index-m+1;
            }else {
                index=index+shift[textArray[index]];
            }
        }
        return -1;
    }
}
