package String;


//将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，要求不能使用字符串转换整数的库函数。
public class StrToInteger {
    public static void main(String[] args){

    }
    public int StrToInt(String str){
        if (str==null||str.length()==0)
            return 0;
        int ret=0;
        char isNegetive=str.charAt(0)=='-'?'-':'+';
        str=str.charAt(0)=='-'?str.substring(1):str;
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if (c<'0'||c>'9')
                return 0;
            ret=ret*10+(c-'0');
        }
        return ret;
    }

    public int StrToInt2(String str){
        if (str==null||str.length()==0)
            return 0;
        boolean isNegetive=str.charAt(0)=='-';
        int ret=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if (i==0&&(c=='+'||c=='-'))
                continue;
            if (c<'0'||c>'9')
                return 0;
            ret=ret*10+(c-'0');
        }
        return isNegetive==true?-ret:ret;


    }

}
