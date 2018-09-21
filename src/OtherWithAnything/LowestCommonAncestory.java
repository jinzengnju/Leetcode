package OtherWithAnything;

import Tree.TreeNode;

public class LowestCommonAncestory {
    public static void main(String[] args){

    }
    //如果是二叉查找树
    public TreeNode getRes1(TreeNode root,TreeNode t1,TreeNode t2){
        //递归停止：t1与t2的val在root.val两边或者有一个相等
        //划分子问题：递归查找左右子树
        if (root==null)
            return null;
        if (root.val>t1.val&&root.val>t2.val)
            return getRes1(root.left,t1,t2);
        if (root.val<t1.val&&root.val<t2.val)
            return getRes1(root.right,t1,t2);
        return root;
    }
    //非二叉查找树
//        3
//        / \
//        4   5
//        / \   \
//       11  20   7
//      /
//     50
    //假设查找目标为50和20
    //遍历节点11的时候，返回的值为50的指针
    //遍历节点4的时候，right值为20的指针不多解释，那么left的值是多少呢？
    //遍历节点4的left的值是遍历节点11即getRes2（11，t1，t2）时函数的返回值即为50的指针
    public TreeNode getRes2(TreeNode root,TreeNode t1,TreeNode t2){
        if (root==null||root==t1||root==t2)
            return null;
        TreeNode left=getRes2(root.left,t1,t2);
        TreeNode right=getRes2(root.right,t1,t2);
        return left==null?right:right==null?left:root;

    }
}
