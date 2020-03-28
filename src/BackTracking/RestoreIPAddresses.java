package BackTracking;
//IP地址划分
//Given "25525511135",
//return ["255.255.11.135", "255.255.111.35"].
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args){}


    public List<String> getRes(String input){
        List<String> res=new ArrayList<>();
        StringBuilder tempAddress=new StringBuilder();
        backtracking(0,tempAddress,res,input);
        return res;

    }
    //确定递归停止条件，非常重要
    private void backtracking(int k,StringBuilder tempAddress,List<String> res,String str){
        if(k==4||str.length()==0){
            if(k==4&&str.length()==0){
                res.add(tempAddress.toString());
            }
            return;
        }
        for (int i=0;i< str.length()&&i<3;i++){
            if (i!=0&&str.charAt(0)=='0'){
                break;
            }
            String temp=str.substring(0,i);
            if (Integer.valueOf(temp)<=255){
                temp="."+temp;
                tempAddress.append(temp);
                backtracking(k+1,tempAddress,res,str.substring(i+1));
                tempAddress.delete(tempAddress.length()-temp.length(),tempAddress.length());
            }

        }
    }
}
