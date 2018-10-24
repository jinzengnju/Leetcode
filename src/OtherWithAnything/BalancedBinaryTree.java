package OtherWithAnything;

import Tree.TreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args){}
    private boolean res=true;
    public boolean isBalanced(TreeNode root){
        Depth(root);
        return res;
    }
    private int Depth(TreeNode root){
        if (root==null)
            return 0;
        int left=Depth(root.left);
        int right=Depth(root.right);
        if (Math.abs(left-right)>1)
            res=false;
        return Math.max(left,right)+1;

    }
}
