package String;

//[]  ： 字符集合
//        ()  ： 分组
//        ?   ： 重复 0 ~ 1
//        +   ： 重复 1 ~ n
//        *   ： 重复 0 ~ n
//        .   ： 任意字符
//        \\. ： 转义后的 .
//        \\d ： 数字
//true
//
//        "+100"
//        "5e2"
//        "-123"
//        "3.1416"
//        "-1E-16"
//
//        false
//
//        "12e"
//        "1a3.14"
//        "1.2.3"
//        "+-5"
//        "12e+4.3"
public class RegularMatch {
    //如何用字符数组建立字符串，new String(str)
    public boolean isMatch(char[] str){
        if(str.length==0||str==null)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
