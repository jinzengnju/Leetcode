package OtherWithAnything;

import Tree.TreeNode;

public class SymmetricTree {
    public static void main(String[] args){}
    public boolean isSymmetric(TreeNode root){
        if (root==null)
            return true;
        return isSymmetricWith_root(root.left,root.right);

    }
    public boolean isSymmetricWith_root(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null)
            return true;
        if (root1==null||root2==null)
            return false;
        if (root1.val!=root2.val)
            return false;
        return isSymmetricWith_root(root1.right,root2.left)||isSymmetricWith_root(root1.left,root2.right);

    }
}
