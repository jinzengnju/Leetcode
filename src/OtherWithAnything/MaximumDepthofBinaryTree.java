package OtherWithAnything;

import Tree.TreeNode;

public class MaximumDepthofBinaryTree {
    public static void main(String[] args){

    }
    public int getRes(TreeNode root){
        if (root==null){//注意这里的判断条件是节点是否为空而不是节点是否为叶子节点
            return 0;
        }
        return Math.max(getRes(root.left),getRes(root.right))+1;
    }
}
