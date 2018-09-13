package Tree;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args){
        String str="[3,9,20,null,null,15,7]";
        TreeNode_v2 node=TreeNode_v2.mkTree(str);
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(node));


    }
//    public static class TreeNode{
//        int val;
//        TreeNode left;
//        TreeNode right;
//        public TreeNode(int k){
//            val=k;
//        }
//    }
    public int maxDepth(TreeNode_v2 root){
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
