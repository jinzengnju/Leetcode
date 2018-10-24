package OtherWithAnything;

import Tree.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args){}
    public TreeNode inverse(TreeNode root){
        if (root==null)
            return null;
        TreeNode left=root.left;
        root.left=inverse(root.right);
        root.right=inverse(left);
        return root;

    }
}
