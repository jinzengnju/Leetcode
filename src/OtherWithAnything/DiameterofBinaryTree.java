package OtherWithAnything;

import Tree.TreeNode;

//其中路径可以经过根节点，也可以不经过根节点
public class DiameterofBinaryTree {
    public static void main(String[] args){}

    private int max=0;
    public int getMax(TreeNode root){
        MaxDepthWithRoot(root);
        return max;
    }

    private int MaxDepthWithRoot(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=MaxDepthWithRoot(root.left);
        int right=MaxDepthWithRoot(root.right);
        max=Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}
