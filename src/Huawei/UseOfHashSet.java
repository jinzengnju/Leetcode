package Huawei;

import Tree.TreeNode;

import java.util.*;

public class UseOfHashSet {
    private static ArrayList<Integer> res=new ArrayList<>();

//    public static void main(String[] args){
//        Scanner scan=new Scanner(System.in);
//        int num=scan.nextInt();
//        Set<Integer> myset=new HashSet<Integer>();
//        for (int i=0;i<num;i++){
//            myset.add(scan.nextInt());
//
//        }
//        Object[] temp=myset.toArray();
//        Arrays.sort(temp);
//        for (int i=0;i<temp.length;i++){
//            System.out.println(temp[i]);
//        }
//    }

    //在牛客网中测试测试用例所有数据可能都连续输入，如果采用上面的方法，那么该程序只会跑一个测试用例。而下面的while(scan.hasNext())只要
    //有一连串的数据流，那么我可以测试多个测试用例
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int num=scan.nextInt();
            Set<Integer> myset=new HashSet<>();
            for (int i=0;i<num;i++){
                myset.add(scan.nextInt());
            }
            Object[] temp=myset.toArray();
            Arrays.sort(temp);
            for (int i=0;i<temp.length;i++){
                System.out.println(temp[i]);
            }

        }
    }
//数组排序：Arrays。sort（）


    //方法二
//    使用java的collection实现排序，去重功能，排序交给Tree(树，Java中的tree统一为红黑树，拥有自排序属性)，去重交给Set，
//    所以使用TreeSet实现。
    public void method2(){
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int n=scan.nextInt();
            TreeSet<Integer> ts=new TreeSet<>();
            for (int i=0;i<n;i++){
                ts.add(scan.nextInt());
            }
            Iterator it =ts.iterator();
            while (it.hasNext()){
                System.out.println(it.next());

            }
        }
    }









    //HashSet转为整形数组,采用toArray(new Integer[] {})方法直接转为Integer数组，然后再转为整型数组；
    private static int[] SetToInt(Set<Integer> allset){
        //先将set集合转为Integer型数组
        Integer[] temp=allset.toArray(new Integer[] {});
        //再将Integer型数组转为int数组
        int[] intArray=new int[temp.length];
        for (int i=0;i<temp.length;i++){
            intArray[i]=temp[i].intValue();
        }
        return intArray;
    }

    //也可以使用toArray()方法直接转为Object对象数组，然后再逐个转为整型数组：
    public static int[] SetToInt2(Set<Integer> allset){
        Object[] obj=allset.toArray();//先讲set集合转为Object对象数组（向上转型）
        int[] temp=new int[obj.length];
        for (int i=0;i<obj.length;i++){
            temp[i]=(int)obj[i];//将Object对象数组转为整型数组（强制向下转型）
        }
        return temp;
    }

}

