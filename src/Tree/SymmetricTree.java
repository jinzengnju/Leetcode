package Tree;


public class SymmetricTree {
    public static void main(String[] args){

    }

    public boolean isSymmetricTree(TreeNode root){
        if (root==null){
            return true;
        }
        return isSymmetricTreeHelper(root.left,root.right);

    }
    private boolean isSymmetricTreeHelper(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if (root1==null||root2==null){
            return false;
        }
        if(root1.val!=root2.val)
            return false;
        return isSymmetricTreeHelper(root1.left,root2.right)&&isSymmetricTreeHelper(root1.right,root2.left);
    }

}
