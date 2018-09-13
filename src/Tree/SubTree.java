package Tree;

public class SubTree {
    public static void main(String[] args){

    }
    public boolean hasSubtree(TreeNode root1,TreeNode root2){
        if(root1==null||root2==null)
            return false;
        return hasSubTreeWithRoot(root1,root2)||hasSubtree(root1.left,root2)||hasSubtree(root1.right,root2);
    }
    public boolean hasSubTreeWithRoot(TreeNode root1,TreeNode root2){
        if(root1==null){
            return false;
        }
        if(root2==null){
            return true;
        }
        if (root1.val!=root2.val){
            return false;
        }
        return hasSubTreeWithRoot(root1.left,root2.left)&&hasSubTreeWithRoot(root1.right,root2.right);

    }

}
