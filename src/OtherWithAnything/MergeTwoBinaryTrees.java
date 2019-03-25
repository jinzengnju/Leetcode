package OtherWithAnything;

import Tree.TreeNode;

public class MergeTwoBinaryTrees {
    public static void main(String[] args){}
    public TreeNode merge(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null)
            return null;
        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }
        TreeNode root=new TreeNode(root1.val+root2.val);
        root.left=merge(root1.left,root2.left);
        root.right=merge(root1.right,root2.right);
        return root;
    }
    //先merge左子树，再merge右子数

}
