package Tree;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
//利用二叉搜索树的特殊性：左子树小于等于根节点，右子树大于根节点
public class VerifySquenceOfBST {
    public static void main(String[] args){}
    private boolean res;
    public boolean getRes(int[] arr){
        if (arr==null||arr.length==0)
            return false;
        return verify(arr,0,arr.length-1);

    }

    private boolean verify(int[] sequence,int first,int last){
        //停止条件:last-first<=1
        //划分子问题：检查左右子树是否满足左子树小于等于根节点，右子树大于根节点
        //合并到结果中：最后一步
        //因为只有两个节点时，最后一个节点为根节点，前面大小无要求，可以是左子节点，也可以是右子节点
        if (last-first<=1)
            return true;
        int root_val=sequence[last];//这里的索引last不能改为sequence.length-1，因为sequence的长度永远都是固定的
        int index=first;
        while(index<last&&sequence[index++]<=root_val);
        while (index<sequence.length){
            if (sequence[index]<root_val)
                return false;
        }
        return verify(sequence,first,index-1)&&verify(sequence,index,last-1);//注意左边的索引为index-1，右边是last-1
    }


}
