package Tree;

//操作给定的二叉树，将其变换为源二叉树的镜像。
//        输入描述:
//        二叉树的镜像定义：源二叉树
//        8
//        /  \
//        6   10
//        / \  / \
//        5  7 9 11
//        镜像二叉树
//        8
//        /  \
//        10   6
//        / \  / \
//        11 9 7  5
public class ImageOfTree {
    public TreeNode method1(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left=root.left;
        root.left=method1(root.right);
        root.right=method1(left);
        return root;
    }

    public TreeNode method2(TreeNode root){
        if(root==null){
            return null;
        }
        swap(root);
        method2(root.left);
        method2(root.right);
        return  root;
    }
    private void swap(TreeNode root){
        TreeNode left=root.left;
        root.left=root.right;
        root.right=left;
    }

}
