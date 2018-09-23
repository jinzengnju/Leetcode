package FenZhi;
//https://www.cnblogs.com/kyyblabla/p/3412257.html

//大整数的加减乘除
public class BigDataCompute {
    public static void main(String[] args){

    }
    // 基本思想是把多项式A(x)与B(x)写成
// A(x)=a*x^m+b
// B(x)=c*x^m+d
// 其中a,b,c,d为x的多项式。
// 则A(x)*B(x)=(ac)*x^2m+(ad+bc)*x^m+bd
// 由ad+bc=(a+b)(c+d)-ac-bd
// 字符串模拟乘法操作
    public static String mut(String x,String y){
        String negetive="";
        if ((x.startsWith("-")&&y.startsWith("-"))
        ||(!x.startsWith("-"))&&!y.startsWith("-")){
            x=x.replaceAll("-","");
            y=y.replaceAll("-","");
            negetive="";
        }else if ((x.startsWith("-")&&!y.startsWith("-"))
        ||(!x.startsWith("-")&&y.startsWith("-"))){
            x=x.replaceAll("-","");
            y=y.replaceAll("-","");
            negetive="-";
        }
        // 如果长度都等于于1，直接相乘，返回就行了。
        if (x.length()==1&&y.length()==1){
            int temp=(Integer.parseInt(x)*Integer.parseInt(y));
            if (temp==0){
                return temp+"";
            }
            else {
                return negetive+temp;
            }
        }
        String a,b,c,d;
        if (x.length()==1){
            a="0";
            b=x;
        }else {
            if (x.length()%2!=0){
                x="0"+x;
            }
            a=x.substring(0,x.length()/2);
            b=x.substring(x.length()/2);
        }
        if (y.length()==1){
            c="0";
            d=y;
        }else{
            if (y.length()%2!=0){
                y="0"+y;
            }
            c=y.substring(0,y.length()/2);
            d=y.substring(y.length()/2);
        }

        // 按最大位数取值，以确定补零数目
        String t1,t2,t3;
        int n=x.length()>=y.length()?x.length():y.length();
        String ac=mut(a,c);
        String bd=mut(b,d);
        t1=mut(sub(a,b),sub(d,c));
        t2=add(add(t1,ac),bd);
        t3=add(add(Power10(ac,n),Power10(t2,n/2)),bd).replaceAll("^0+","");
        if (t3=="")
            return "0";
        return negetive+t3;
    }

    private static String add(String x,String y){
        if (x.startsWith("-")&&!y.startsWith("-"))
            return sub(y,x.replaceAll("^-",""));
        else if (!x.startsWith("-")&&y.startsWith("-"))
            return sub(x,y.replaceAll("^-",""));
        else if (x.startsWith("-")&&y.startsWith("-"))
            return "-"+add(x.replaceAll("^-",""),
                    y.replaceAll("^-",""));
        if (x.length()>y.length()){
            y=format(y,x.length(),"0");
        }else
            x=format(x,y.length(),"0");

        int[] sum=new int[x.length()+1];
        for (int i=x.length()-1;i>=0;i--){
            int tempsum=Integer.parseInt(x.charAt(i)+"")+Integer.parseInt(y.charAt(i)+"")+sum[i+1];
            if (tempsum>=10){
                sum[i+1]=tempsum-10;
                sum[i]=1;
            }else {
                sum[i+1]=tempsum;
            }
        }
        StringBuilder res=new StringBuilder();
        for (int i:sum)
            res.append(i);
        if (sum[0]==1)
            return res.toString();
        else
            return res.replace(0,1,"").toString();

    }
    private static String format(String str,int len,String fu){
        len=len-str.length();
        for (int i=0;i<len;i++){
            str=fu+str;
        }
        return str;
    }
    private static String Power10(String num,int n){
        for (int i=0;i<n;i++){
            num+="0";
        }
        return num;
    }

    private static int CheckBigger(String x,String y){
        if (x.length()>y.length()){
            return 1;
        } else if (x.length()<y.length()){
            return -1;
        }else {
            for (int i=0;i<x.length();i++){
                if (x.charAt(i)>y.charAt(i)){
                    return 1;
                } else if (x.charAt(i)<y.charAt(i)){
                    return -1;
                }
            }
            return 0;
        }
    }
    private static String sub(String x,String y) {
        // x是正数，y也是正数
        int flag = CheckBigger(x, y);
        if (flag == 0) {
            return "0";
        }else if (flag == -1) {
            String tmp = y;
            y = x;
            x = tmp;
        }
        y = format(y, x.length(), "0");// y补0与x对齐
        int[] difference = new int[x.length()];
        for (int i = x.length() - 1; i >= 0; i--) {
            int tmpdifference;
            tmpdifference = Integer.parseInt(x.charAt(i) + "")
                    - Integer.parseInt(y.charAt(i) + "") + difference[i];
            if (tmpdifference < 0) {
                tmpdifference += 10;
                difference[i - 1] = -1;// 表示进位

            }
            difference[i] = tmpdifference;
        }
        StringBuilder returnvalue = new StringBuilder();
        for (int i : difference) {
            returnvalue.append(i);
        }
        String rv = returnvalue.toString().replaceAll("^0+", "");
        if ("".equals(rv)) {
            return "0";
        }
        if (flag==-1){
            rv="-"+rv;
        }
        return rv;
    }

























}
