package Huawei;

import java.util.Scanner;
public class Main6 {
    public static String multiply(String num1, String num2){
        char a[] = num1.toCharArray();
        char b[] = num2.toCharArray();
        int result[] = new int[a.length + b.length];

        int n1[] = new int[a.length];
        int n2[] = new int[b.length];
        for(int i = 0; i < a.length;i++)
            n1[i] = a[i]-'0';
        for(int i = 0; i < b.length;i++)
            n2[i] = b[i]-'0';

        for(int i =0 ; i < a.length; i++){
            for(int j =0; j < b.length; j++){
                result[i+j]+=n1[i]*n2[j];
            }
        }
        for(int i =result.length-1; i > 0 ;i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        String resultStr = "";
        for(int i = 0; i < result.length-1; i++){
            resultStr+=""+result[i];
        }
        return resultStr;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String str1=scan.next();
            String str2=scan.next();
            String result = multiply(str1, str2);
            System.out.println(result);
        }
    }
}
