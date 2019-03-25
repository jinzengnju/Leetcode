package OtherWithAnything;

import Tree.TreeNode;

//其中路径可以经过根节点，也可以不经过根节点
public class DiameterofBinaryTree {
    public static void main(String[] args){}
    private int max=0;
    public int getRes(TreeNode root){
        DepthWithRoot(root);
        return this.max;
    }
    public int DepthWithRoot(TreeNode root){
        if (root==null)
            return 0;
        int l=DepthWithRoot(root.left);
        int r=DepthWithRoot(root.right);
        if ((l+r)>this.max){
            this.max=l+r;
        }
        return 1+Math.max(l,r);
    }
}
