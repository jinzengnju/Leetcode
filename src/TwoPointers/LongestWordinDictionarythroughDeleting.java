package TwoPointers;

public class LongestWordinDictionarythroughDeleting {
    private boolean isValid(String s,String target){
        int i=0;
        int j=0;
        while(i<s.length()&&j<target.length()){
            if(s.charAt(i)==target.charAt(j)){
                j++;
            }
            i++;
        }
        return j==target.length();
    }


}
