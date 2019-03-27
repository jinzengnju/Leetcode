package OtherWithAnything;

import Tree.TreeNode;

public class SubtreeofAnotherTree {
    public static void main(String[] args){}
    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if (root1==null)
            return false;
        return isSubTree(root1.right,root2)||isSubTreeWith_root(root1,root2)||isSubTree(root1.left,root2);
    }
    public boolean isSubTreeWith_root(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null)
            return true;
        if (root1==null||root2==null)
            return false;
        if (root1.val!=root2.val)
            return false;
        return isSubTreeWith_root(root1.left,root2.left)&&isSubTreeWith_root(root1.right,root2.right);
    }
}
