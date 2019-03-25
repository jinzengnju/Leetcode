package OtherWithAnything;

import Tree.TreeNode;
//    String str = "[3,9,20,null,null,15,7]";
//    TreeNode node = TreeNode.mkTree(str);
public class MaximumDepthOfBinaryTree1 {
    public static void main(String[] args){
        String str = "[3,9,20,null,null,15,7]";
        TreeNode node=TreeNode.mkTree(str);
        System.out.println(new MaximumDepthOfBinaryTree1().getDepth(node));
    }
    private int getDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        return 1+Math.max(getDepth(root.left),getDepth(root.right));
    }
}
