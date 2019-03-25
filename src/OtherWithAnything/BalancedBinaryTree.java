package OtherWithAnything;

import Tree.TreeNode;

public class BalancedBinaryTree{
    public static void main(String[] args){}
    private boolean result=true;
    public boolean getRes(TreeNode root){
        maxDepth(root);
        return this.result;
    }
    private int maxDepth(TreeNode root){
        if (root==null)
            return 0;
        int l=maxDepth(root.left);
        int r=maxDepth(root.right);
        if (Math.abs(l-r)>1) this.result=false;
        return 1+Math.max(l,r);
    }

}