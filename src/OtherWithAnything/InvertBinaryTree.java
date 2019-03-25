package OtherWithAnything;

import Tree.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args){}
    public TreeNode reverse(TreeNode root){
        if (root==null)
            return root;
        TreeNode left=reverse(root.left);
        root.left=reverse(root.right);
        root.right=left;
        return root;

    }
}
