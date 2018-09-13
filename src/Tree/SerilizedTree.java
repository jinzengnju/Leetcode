package Tree;

//请实现两个函数，分别用来序列化和反序列化二叉树。
//二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
//序列化可以基于 先序、中序、后序、按层 的二叉树遍历方式来进行修改。原理都是一样的（即遍历顺序不同而已，对每个结点的处理都是一样的），序列化的结果是一个字符串，序列化时通过  某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
//
//这里以先序遍历的方式进行序列化举例：
//
//先序序列化二叉树==定义一个stringbuilder保存序列过程中的结果：按照先序遍历方式遍历二叉树，若结点非空则把 "结点值!" append到builder中；若结点空则把  "#!" append到builder中；最后用builder生成字符串就是序列化结果。
//本题通过前序进行序列化与反序列化
public class SerilizedTree {
    public static void main(String[] args){

    }
    public String SerilizedTree(TreeNode root){
        if(root==null)
            return "#";
        return root.val+" "+SerilizedTree(root.left)+" "+SerilizedTree(root.right);
    }
    private String deserilizedStr;
    public TreeNode DeserilizedToTree(String str){
        deserilizedStr=str;
        TreeNode root=DeSerilizedToTreeHelper();
        return root;

    }
    private TreeNode DeSerilizedToTreeHelper(){
        if(deserilizedStr.length()==0)
            return null;
        int index=deserilizedStr.indexOf(" ");
        String node=index==-1?deserilizedStr:deserilizedStr.substring(0,index);
        deserilizedStr=index==-1?"":deserilizedStr.substring(index+1);

        if(node=="#")
            return null;
        int value=Integer.valueOf(node);
        TreeNode root=new TreeNode(value);
        root.left=DeSerilizedToTreeHelper();
        root.right=DeSerilizedToTreeHelper();
        return root;

    }
}
