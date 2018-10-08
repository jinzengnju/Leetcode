package Tree;
//求树的深度
public class Depth {
    public int getRes(TreeNode root){
        if (root==null)
            return 0;
        return 1+Math.max(getRes(root.left),getRes(root.right));
    }
}
