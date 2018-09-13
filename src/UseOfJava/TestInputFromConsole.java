package UseOfJava;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestInputFromConsole {
    public static void main(String[] args) throws Exception{
        test5();
    }
    public static void test1(){
        Scanner scan=new Scanner(System.in);
        System.out.print("输入数据：");
        String str=scan.next();
        do{
            System.out.println("输入的数据为："+str);
        }while((str=scan.next())!=null);
    }
    public static void test2() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String query=br.readLine();
        String title=br.readLine();
        System.out.println(query);
    }
    public static void test3() throws IOException {
        InputStream is=System.in;
        OutputStream os=System.out;
        byte[] buffer=new byte[10];
        int len =0;
        while((len=is.read(buffer,0,4))!=-1){
            System.out.println("读取的实际长度--------------------------" + len);
            os.write(buffer,0,4);
            System.out.println("--------------------------");
        }
    }

    public static void test4(){
        //从控制台输入数组
        Scanner scan=new Scanner(System.in);
        int[] array=new int[10];
        for(int i=0;i<array.length;i++){
            System.out.println("请输入一个数");
            array[i]=scan.nextInt();
        }
        System.out.println(Arrays.toString(array));
    }

//    Java编程中有的时候我们会在控制台输入长度可变的数组数据（分隔符一致），例如：
//
//            1 2 3 4 5 6
//            1
//    或者
//
//1,2,3,4,5,6,7
//        1
//    然后对这串未知长度的数据进行处理，得到对应类型的数组。
//    1.由于长度可变，所以不能直接用数组去接受，可以用ArrayList存储。
//            2.控制台输入，可以用Scanner对象的标记读取next()方法进行处理。
//            3.这里要提一下，默认情况下，Scanner对象的分隔符是空格，如果是“，”等其他类型的分隔符需要使用userDelimiter(String regex)方法设置新的分隔符模式。
//            4.next()方法读取一个由分隔符分隔的字符串，nextLine()读取一个以换行符结束的行。

//处理空格为分隔符的数据(以0作为结束标识)
    public static void test5(){
        Scanner scan=new Scanner(System.in);
        ArrayList<Integer> array=new ArrayList<>();
        while(!scan.hasNext("0")){//结束标识符
            array.add(Integer.valueOf(scan.next()));
        }
        System.out.println(array);
    }

    public static void test6(){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        String s = input.nextLine();
        String[] s1 = s.split(",");//此处修改分隔符类型
        for (int i = 0; i < s1.length; i++) {
            array.add(Integer.valueOf(s1[i]));
        }
        for (Integer e : array) {
            System.out.print(e + " ");
        }
    }


}
